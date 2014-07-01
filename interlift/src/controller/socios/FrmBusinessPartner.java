package controller.socios;

import general.ValidateZK;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.database.BusinessPartner;
import model.service.ServiceBasicData;
import model.service.ServiceBusinessPartner;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Window;
import org.zkoss.zul.impl.InputElement;

public class FrmBusinessPartner {

	@WireVariable
	private ServiceBusinessPartner serviceBusinessPartner;
	@WireVariable
	private ServiceBasicData serviceBasicData;

	private String minCombo = new String("-");
	private String windowType;
	private Boolean fromBudget;
	private BusinessPartner businessPartner;

	public String getMinCombo() {
		return minCombo;
	}

	public String getWindowType() {
		return windowType;
	}

	public void setWindowType(String windowType) {
		this.windowType = windowType;
	}

	public void setMinCombo(String minCombo) {
		this.minCombo = minCombo;
	}

	public BusinessPartner getBusinessPartner() {
		return businessPartner;
	}

	public void setBusinessPartner(BusinessPartner businessPartner) {
		this.businessPartner = businessPartner;
	}

	public Validator getNoDash() {
		return new ValidateZK().getNoDash();
	}

	public Validator getNoEmpty() {
		return new ValidateZK().getNoEmpty();
	}

	public Validator getNoRepeatNit() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				String string = inputElement.getText();
				BusinessPartner auxBusinessPartner = serviceBusinessPartner.findByNit(string);
				if (string.trim().isEmpty())
					throw new WrongValueException(inputElement, "Ingrese un dato valido.");
				if (auxBusinessPartner != null)
					throw new WrongValueException(inputElement, "Este nit ya se encuentra registrado en el sistema.");
			}
		};
	}

	@Init
	public void init(@ExecutionArgParam("fromBudget") Boolean fromBudget) {
		if (fromBudget != null) {
			this.fromBudget = fromBudget;
			windowType = "modal";
		} else {
			this.fromBudget = false;
			windowType = "embedded";
		}
		restartForm();
	}

	@NotifyChange({ "businessPartner" })
	@Command
	public void restartForm() {
		businessPartner = new BusinessPartner();
		businessPartner.setStatus('A');
	}

	@Command
	public void search() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<BusinessPartner> list = serviceBusinessPartner.listAll();
		map.put("listQuotations", list);
		Executions.createComponents("system/socios/frmBusinessPartnerList.zul", null, map);
	}

	@Command
	public void close(@BindingParam("win") Window win) {
		win.detach();
		Map<String, Object> map = new HashMap<String, Object>();
		if (fromBudget) {
			map.put("BusinessPartner", new BusinessPartner());
			BindUtils.postGlobalCommand(null, null, "selectedBusinessPartner", map);
		} else {
			map.put("page", "");
			BindUtils.postGlobalCommand(null, null, "selectedPage", map);
		}
	}

	@NotifyChange("businessPartner")
	@Command
	public void save(@BindingParam("win") Window win) {
		if (!serviceBusinessPartner.save(businessPartner)) {
			Clients.showNotification("No se pudo guardar Cliente", "error", null, "middle_center", 2000);
		} else {
			Clients.showNotification("Cliente guardado", "info", null, "middle_center", 2000);
			if (fromBudget) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("BusinessPartner", businessPartner);
				win.detach();
				BindUtils.postGlobalCommand(null, null, "selectedBusinessPartnerBudget", map);
			} else
				restartForm();
		}
	}

	@NotifyChange("businessPartner")
	@GlobalCommand
	public void selectedBusinessPartner(@BindingParam("businessPartner") BusinessPartner businessPartner) {
		this.businessPartner = businessPartner;
	}
}