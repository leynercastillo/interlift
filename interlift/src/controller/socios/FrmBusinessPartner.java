package controller.socios;

import general.ValidateZK;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.database.BasicData;
import model.database.BusinessPartner;
import model.service.ServiceBasicData;
import model.service.ServiceBusinessPartner;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Window;
import org.zkoss.zul.impl.InputElement;

public class FrmBusinessPartner {

	@WireVariable
	private ServiceBusinessPartner serviceBusinessPartner;
	@WireVariable
	private ServiceBasicData serviceBasicData;
	@Wire("#win")
	private Window win;

	private String minCombo = new String("-");
	private BusinessPartner businessPartner;
	private List<BasicData> listNitType;

	public String getMinCombo() {
		return minCombo;
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

	public List<BasicData> getListNitType() {
		return listNitType;
	}

	public void setListNitType(List<BasicData> listNitType) {
		this.listNitType = listNitType;
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
	public void init(@ContextParam(ContextType.VIEW) Component view) {
		Selectors.wireComponents(view, this, false);
		Clients.showNotification("Agregar el cliente si no existe en el sistema.", "info", win, "middle_right", 3500);
		restartForm();
	}

	@Command
	public void restartForm() {
		businessPartner = new BusinessPartner();
		businessPartner.setStatus('A');
	}

	@Command
	public void cancel() {
		win.detach();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("BusinessPartner", null);
		BindUtils.postGlobalCommand(null, null, "selectedBusinessPartner", map);
	}

	@Command
	public void save() {
		if (!serviceBusinessPartner.save(businessPartner)) {
			Clients.showNotification("No se pudo guardar Cliente", "error", win, "middle_center", 2000);
		} else {
			Clients.showNotification("Cliente guardado", "info", win, "middle_center", 2000);

			Map<String, Object> map = new HashMap<String, Object>();
			map.put("BusinessPartner", businessPartner);
			restartForm();
			win.detach();
			BindUtils.postGlobalCommand(null, null, "selectedBusinessPartner", map);
		}
	}
}