package general;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;

public class GenericReport {

	private Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ascensor_nardi", "ascensor_admin", "leyner.18654277");
		} catch (SQLException e) {
			connection = null;
			e.printStackTrace();
		}
		return connection;
	}

	public void createPdf(String reportPath, String reportName, Map<String, Object> parameters, String pdfName) {
		Connection connection = getConnection();
		String path = Sessions.getCurrent().getWebApp().getRealPath(reportPath);
		JasperReport jasperReport;
		try {
			jasperReport = (JasperReport) JRLoader.loadObjectFromFile(path + "/" + reportName);
		} catch (JRException e1) {
			jasperReport = null;
			e1.printStackTrace();
		}
		JasperPrint jasperPrint;
		try {
			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
		} catch (JRException e1) {
			jasperPrint = null;
			e1.printStackTrace();
		}
		JRExporter jrExporter = new JRPdfExporter();
		jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		jrExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, path + "/" + pdfName);
		File file = new File(path + "/" + pdfName);
		/* Eliminamos el pdf si ya existia, puesto que no se sobreescribe. */
		if (file.isFile())
			file.delete();
		try {
			jrExporter.exportReport();
		} catch (JRException e) {
			System.out.println("Report wasn't export.");
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void viewPdf(String pdfFullPath, String reportTitle) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reportPath", pdfFullPath);
		map.put("reportTitle", reportTitle);
		map.put("absolutePath", Sessions.getCurrent().getWebApp().getRealPath(pdfFullPath));
		Executions.createComponents("system/frmReport.zul", null, map);
	}
}