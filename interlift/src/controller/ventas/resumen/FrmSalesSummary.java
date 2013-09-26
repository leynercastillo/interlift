package controller.ventas.resumen;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.database.Quotation;
import model.service.ServiceQuotation;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.hibernate.HibernateException;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class FrmSalesSummary {

	@WireVariable
	private ServiceQuotation serviceQuotation;

	private List<Quotation> listQuotations;
	private Quotation quotation;

	public List<Quotation> getListQuotations() {
		return listQuotations;
	}

	public void setListQuotations(List<Quotation> listQuotations) {
		this.listQuotations = listQuotations;
	}

	public Quotation getQuotation() {
		return quotation;
	}

	public void setQuotation(Quotation quotation) {
		this.quotation = quotation;
	}

	@Init
	public void init() {
		restartForm();
	}

	@NotifyChange({ "*" })
	public void restartForm() {
		listQuotations = serviceQuotation.listOrderedByDate();
	}

	public String getQuotationNumber(Quotation quotation) {
		if (quotation.isType())
			return "1 - " + quotation.getNewNumber() + " - " + quotation.getVersionNumber();
		else
			return "2 - " + quotation.getModernizationNumber() + " - " + quotation.getVersionNumber();
	}

	public String getTeam(Quotation quotation) {
		return quotation.getElevatorQuantity() + " - " + quotation.getBasicDataByElevatorType().getName();
	}

	public String getDateFormat(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(date);
	}

	@Command
	public void createPdf() throws SQLException {
		/* Se debe tomar la sesion a partir de Hibernate CORREGIR */
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ascensor_nardi", "ascensor_admin", "leyner.18654277");
		String string = Sessions.getCurrent().getWebApp().getRealPath("/resource/reports/ventas/resumen");
		JasperReport jasperReport;
		try {
			jasperReport = (JasperReport) JRLoader.loadObjectFromFile(string + "/sale_summary.jasper");
		} catch (JRException e) {
			jasperReport = null;
			System.out.println("sale_summary.jasper didn't find");
		}
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("REPORT_TITLE", "Resumen de Venta");
		parameters.put("NUMBER", quotation.getBudgetNumber());
		/*
		 * Enviamos por parametro a ireport la ruta de la ubicacion de los subreportes e imagenes.
		 */
		parameters.put("IMAGES_DIR", "../../resource/images/system/reports/");
		parameters.put("SUBREPORT_DIR", "../../resource/reports/ventas/resumen/");
		JasperPrint jasperPrint;
		try {
			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
		} catch (HibernateException e1) {
			jasperPrint = null;
			System.out.println("Connection wasn't obtained.");
		} catch (JRException e1) {
			jasperPrint = null;
			e1.printStackTrace();
		}
		JRExporter jrExporter = new JRPdfExporter();
		jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		jrExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, string + "/presupuesto" + quotation.getBudgetNumber() + ".pdf");
		File file = new File(string + "/presupuesto" + quotation.getBudgetNumber() + ".pdf");
		/* Eliminamos el pdf si ya existia, puesto que no se sobreescribe. */
		if (file.isFile())
			file.delete();
		try {
			jrExporter.exportReport();
		} catch (JRException e) {
			e.printStackTrace();
		}
		connection.close();
	}

	@Command
	public void pdfQuotation() throws SQLException {
		createPdf();
		String report = new String("/resource/reports/ventas/resumen/presupuesto" + quotation.getBudgetNumber() + ".pdf");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reportPath", report);
		map.put("reportTitle", "Resumen de Ventas");
		map.put("absolutePath", Sessions.getCurrent().getWebApp().getRealPath("/resource/reports/ventas/resumen") + "/presupuesto" + quotation.getBudgetNumber() + ".pdf");
		Executions.createComponents("system/frmReport.zul", null, map);
	}

	@Command
	public void close() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "");
		BindUtils.postGlobalCommand(null, null, "selectedPage", map);
	}
}