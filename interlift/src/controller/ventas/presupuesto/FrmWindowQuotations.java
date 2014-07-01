package controller.ventas.presupuesto;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.database.BasicData;
import model.database.Quotation;
import model.service.ServiceBasicData;
import model.service.ServiceQuotation;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Window;

public class FrmWindowQuotations {

	@WireVariable
	private ServiceQuotation serviceQuotation;
	@WireVariable
	private ServiceBasicData serviceBasicData;

	@Wire("#windowQuotations")
	private Window windowQuotations;

	private List<Quotation> listQuotations;
	private Quotation selectedQuotation;

	public Quotation getSelectedQuotation() {
		return selectedQuotation;
	}

	public void setSelectedQuotation(Quotation selectedQuotation) {
		this.selectedQuotation = selectedQuotation;
	}

	public List<Quotation> getListQuotations() {
		return listQuotations;
	}

	public void setListQuotations(List<Quotation> listQuotations) {
		this.listQuotations = listQuotations;
	}

	@Init
	public void init(@ExecutionArgParam("listQuotations") List<Quotation> listQuotations, @ContextParam(ContextType.VIEW) Component view) {
		this.listQuotations = listQuotations;
		Selectors.wireComponents(view, this, false);
	}

	@NotifyChange("selectedQuotation")
	@Command
	public void sendQuotation(@BindingParam("quotation") Quotation quotation) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("quotation", quotation);
		windowQuotations.detach();
		BindUtils.postGlobalCommand(null, null, "selectedQuotation", map);
	}

	public String getTeam(Quotation quotation) {
		/* sustituir por recargar toda la lista */
		Quotation q = serviceQuotation.findById(quotation.getIdQuotation());
		return q.getElevatorQuantity() + " - " + q.getBasicDataByElevatorType().getName();
	}

	public String getValorComercial(Quotation quotation) {
		Double a = (quotation.getPriceNationalMaterial()*1.16);
		DecimalFormat num = new DecimalFormat("#,###.00");
		String conversionComercial = num.format(a);
			return conversionComercial + "$";
	}
	
	public String getValorMercantil(Quotation quotation) {
		Double a1 = (quotation.getPriceImportedMaterial());
		DecimalFormat num1 = new DecimalFormat("#,###.00");
		String conversionMercantil = num1.format(a1);
			return conversionMercantil + "$";
}

	public String getQuotationNumber(Quotation quotation) {
		if (quotation.isType())
			return "1 - " + quotation.getNewNumber() + " - " + quotation.getVersionNumber();
		else
			return "2 - " + quotation.getModernizationNumber() + " - " + quotation.getVersionNumber();
	}
}