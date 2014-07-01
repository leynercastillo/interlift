package controller.ventas.presupuesto;

import general.GenericReport;
import general.SimpleListModelCustom;
import general.ValidateZK;

import java.io.File;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.database.BasicData;
import model.database.Budget;
import model.database.Quotation;
import model.database.SaleSummary;
import model.database.TransactionSummary;
import model.service.ServiceBasicData;
import model.service.ServiceBudget;
import model.service.ServiceQuotation;
import model.service.ServiceSaleSummary;
import model.service.ServiceTransactionSummary;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.impl.InputElement;

import springBean.Emails;

public class FrmQuotation {

	@WireVariable
	private ServiceBasicData serviceBasicData;
	@WireVariable
	private ServiceQuotation serviceQuotation;
	@WireVariable
	private ServiceBudget serviceBudget;
	@WireVariable
	private ServiceSaleSummary serviceSaleSummary;
	@WireVariable
	private ServiceTransactionSummary serviceTransactionSummary;
	@WireVariable
	private Emails emails;

	private final String seleccione = new String("--Seleccione--");
	private final String dash = new String("-");

	private Quotation quotation;
	private Budget budget;
	private Boolean disableBeforeSearch;
	private Boolean disabledBudgetNumber;
	private Boolean disabledPrint;
	private Boolean disabledEdit;
	private String modalMessage;
	private String printMessage;
	private List<BasicData> listQuotationType;
	private ListModel<Object> listQuotationNumber;
	private ListModel<Object> listNitPartner;
	private ListModel<Object> listBudgetNumber;
	private ListModel<Object> listPartnerName;
	private ListModel<Object> listConstruction;
	private ListModel<Object> listSeller;

	public List<BasicData> getListQuotationType() {
		return listQuotationType;
	}

	public void setListQuotationType(List<BasicData> listQuotationType) {
		this.listQuotationType = listQuotationType;
	}

	public String getPrintMessage() {
		return printMessage;
	}

	public void setPrintMessage(String printMessage) {
		this.printMessage = printMessage;
	}

	public String getModalMessage() {
		return modalMessage;
	}

	public void setModalMessage(String modalMessage) {
		this.modalMessage = modalMessage;
	}

	public Boolean getDisabledEdit() {
		return disabledEdit;
	}

	public void setDisabledEdit(Boolean disabledEdit) {
		this.disabledEdit = disabledEdit;
	}

	public Boolean getDisabledPrint() {
		return disabledPrint;
	}

	public void setDisabledPrint(Boolean disabledPrint) {
		this.disabledPrint = disabledPrint;
	}

	public ListModel<Object> getListSeller() {
		return listSeller;
	}

	public void setListSeller(ListModel<Object> listSeller) {
		this.listSeller = listSeller;
	}

	public ListModel<Object> getListConstruction() {
		return listConstruction;
	}

	public void setListConstruction(ListModel<Object> listConstruction) {
		this.listConstruction = listConstruction;
	}

	public ListModel<Object> getListPartnerName() {
		return listPartnerName;
	}

	public void setListPartnerName(ListModel<Object> listPartnerName) {
		this.listPartnerName = listPartnerName;
	}

	public ListModel<Object> getListBudgetNumber() {
		return listBudgetNumber;
	}

	public void setListBudgetNumber(ListModel<Object> listBudgetNumber) {
		this.listBudgetNumber = listBudgetNumber;
	}

	public ListModel<Object> getListNitPartner() {
		return listNitPartner;
	}

	public void setListNitPartner(ListModel<Object> listNitPartner) {
		this.listNitPartner = listNitPartner;
	}

	public Boolean getDisabledBudgetNumber() {
		return disabledBudgetNumber;
	}

	public void setDisabledBudgetNumber(Boolean disabledBudgetNumber) {
		this.disabledBudgetNumber = disabledBudgetNumber;
	}

	public String getDash() {
		return dash;
	}

	public String getSeleccione() {
		return seleccione;
	}

	public ListModel<Object> getListQuotationNumber() {
		return listQuotationNumber;
	}

	public void setListQuotationNumber(ListModel<Object> listQuotationNumber) {
		this.listQuotationNumber = listQuotationNumber;
	}

	public Boolean getDisableBeforeSearch() {
		return disableBeforeSearch;
	}

	public void setDisableBeforeSearch(Boolean disableBeforeSearch) {
		this.disableBeforeSearch = disableBeforeSearch;
	}

	public Quotation getQuotation() {
		return quotation;
	}

	public void setQuotation(Quotation quotation) {
		this.quotation = quotation;
	}

	public Validator getNoSelect() {
		return new ValidateZK().getNoSelect();
	}

	public Validator getNoDash() {
		return new ValidateZK().getNoDash();
	}

	public Validator getNoEmpty() {
		return new ValidateZK().getNoEmpty();
	}

	public Validator getnoZeroDouble() {
		return new ValidateZK().getNoZeroDouble();
	}

	public Validator getNoEmptyForFormica() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				String str = inputElement.getText();
				if (quotation.getBasicDataByCabinDesign() != null && quotation.getBasicDataByCabinDesign().getName().indexOf("FORMICA") != -1 && str.trim().isEmpty())
					throw new WrongValueException(inputElement, "Debe ingresar una descripción para fórmica.");
				if (quotation.getBasicDataByFloorType() != null && quotation.getBasicDataByFloorType().getName().indexOf("OTROS") != -1 && str.trim().isEmpty())
					throw new WrongValueException(inputElement, "Debe ingresar una descripción acabados de piso OTROS.");
			}
		};
	}

	public Validator getNoElevatorQuantity() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				Integer quantity = Integer.parseInt(inputElement.getText());
				if (quotation.isType() && (quantity < 1))
					throw new WrongValueException(inputElement, "Debe ingresar al menos un ascensor.");
			}
		};
	}

	public Validator getNoValidDate() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				Datebox datebox = (Datebox) ctx.getBindContext().getValidatorArg("datebox");
				if (quotation.getStatus() == 'A' && datebox.getValue() == null)
					throw new WrongValueException(datebox, "Ingrese una fecha valida.");
			}
		};
	}

	@Command
	public void selectStatus(@BindingParam("radioGroup") Radiogroup radiogroup) {
		if (radiogroup.getSelectedItem().getValue().charAt(0) == 'A') {
			List<Quotation> list = serviceQuotation.listByBudget(quotation.getBudgetNumber());
			for (Quotation q : list) {
				if (q.getStatus() == 'A') {
					quotation.setStatus('E');
					BindUtils.postNotifyChange(null, null, quotation, "status");
					throw new WrongValueException(radiogroup, "Esta solicitud ya tiene presupuesto aprobado.");
				}
			}
		}
	}

	@Init
	public void init() {
		restartForm();
	}

	@NotifyChange({ "quotation", "disableBeforeSearch", "disabledBudgetNumber", "disabledPrint", "disabledEdit", "listQuotationNumber", "listNitPartner", "listBudgetNumber", "listPartnerName", "listConstruction", "listSeller", "listQuotationType", "modalMessage", "printMessage" })
	@Command
	public void restartForm() {
		quotation = new Quotation();
		quotation.setDate(new Date());
		quotation.setType(true);
		quotation.setStopSequenceContinuous(false);
		quotation.setStopSequenceEven(false);
		quotation.setStopSequenceOdd(false);
		quotation.setType(true);
		quotation.setDesignSpecial(false);
		quotation.setDoorFrameStainless(false);
		quotation.setStatus('E');
		quotation.setLightCurtain(false);
		quotation.setLoadLimiter(false);
		quotation.setSpeechSynthesizer(false);
		quotation.setGomSystem(false);
		quotation.setIntercom(false);
		quotation.setPhone(false);
		quotation.setAccessSytem(false);
		quotation.setFirefighterKeychain(false);
		quotation.setTotalPrice(0);
		quotation.setVersionNumber(new Short("1"));
		/* Numero improbable */
		updateQuotationNumber(-1);
		budget = new Budget();
		disableBeforeSearch = new Boolean(true);
		disabledBudgetNumber = new Boolean(false);
		disabledPrint = new Boolean(true);
		disabledEdit = new Boolean(true);
		listQuotationNumber = new ListModelList<Object>();
		listNitPartner = new ListModelList<Object>();
		listBudgetNumber = new ListModelList<Object>();
		listPartnerName = new ListModelList<Object>();
		listConstruction = new ListModelList<Object>();
		listSeller = new ListModelList<Object>();
		listQuotationType = serviceBasicData.listQuotationTypeMoney();
		modalMessage = null;
		printMessage = null;
	}

	private void budgetToQuotation(Budget budget) {
		quotation.setBudget(budget);
		quotation.setBusinessPartner(budget.getBusinessPartner());
		quotation.setNitPartner(budget.getNitPartner());
		quotation.setBudgetNumber(budget.getNumber());
		quotation.setPartnerName(budget.getPartnerName());
		quotation.setConstruction(budget.getConstruction());
		quotation.setContactName(budget.getContactName());
		quotation.setSeller(budget.getSeller());
		quotation.setType(budget.isType());
		quotation.setElevatorQuantity(budget.getElevatorQuantity());
		quotation.setBasicDataByElevatorType(budget.getBasicDataByElevatorType());
		quotation.setBasicDataByElevatorCapacitance(budget.getBasicDataByElevatorCapacitance());
		quotation.setTour(budget.getTour());
		quotation.setBasicDataBySpeed(budget.getBasicDataBySpeed());
		quotation.setStopNumber(budget.getStopNumber());
		quotation.setStopSequenceContinuous(budget.getStopSequenceContinuous());
		quotation.setStopSequenceContinuousNumber(budget.getStopSequenceContinuousNumber());
		quotation.setStopSequenceContinuousQ(budget.getStopSequenceContinuousQ());
		quotation.setStopSequenceEven(budget.getStopSequenceEven());
		quotation.setStopSequenceEvenNumber(budget.getStopSequenceEvenNumber());
		quotation.setStopSequenceEvenQ(budget.getStopSequenceEvenQ());
		quotation.setStopSequenceOdd(budget.getStopSequenceOdd());
		quotation.setStopSequenceOddNumber(budget.getStopSequenceOddNumber());
		quotation.setStopSequenceOddQ(budget.getStopSequenceOddQ());
		quotation.setBasicDataByManeuverType(budget.getBasicDataByManeuverType());
		quotation.setBasicDataByControlType(budget.getBasicDataByControlType());
		quotation.setBasicDataByHallButton(budget.getBasicDataByHallButton());
		quotation.setBasicDataByMachineType(budget.getBasicDataByMachineType());
		quotation.setBasicDataByElectricityType(budget.getBasicDataByElectricityType());
		quotation.setWidthHole(budget.getWidthHole());
		quotation.setBottomHole(budget.getBottomHole());
		quotation.setOnTour(budget.getOnTour());
		quotation.setFossa(budget.getFossa());
		
		quotation.setBasicDataByCabinDesign(budget.getBasicDataByCabinDesign());
		quotation.setDesignSpecial(budget.getDesignSpecial());
		quotation.setDesignSpecialComment(budget.getDesignSpecialComment());
		quotation.setBasicDataByRoofType(budget.getBasicDataByRoofType());
		quotation.setBasicDataByRailing(budget.getBasicDataByRailing());
		quotation.setBasicDataByFloorType(budget.getBasicDataByFloorType());
		quotation.setCabinWidth(budget.getCabinWidth());
		quotation.setCabinHeight(budget.getCabinHeight());
		quotation.setCabinBackground(budget.getCabinBackground());
		quotation.setBasicDataByDoorType(budget.getBasicDataByDoorType());
		quotation.setBasicDataByFreeAdmission(budget.getBasicDataByFreeAdmission());
		quotation.setBasicDataByHeight(budget.getBasicDataByHeight());
		quotation.setDoorFrameStainless(budget.getDoorFrameStainless());
		quotation.setDoorFrameStainlessDescrip(budget.getDoorFrameStainlessDescrip());
		quotation.setBasicDataByDoorFrameHammered(budget.getBasicDataByDoorFrameHammered());
		quotation.setDoorFrameHammeredDesc(budget.getDoorFrameHammeredDesc());
		quotation.setBasicDataByBoothDisplay(budget.getBasicDataByBoothDisplay());
		quotation.setBasicDataByFloorDisplay(budget.getBasicDataByFloorDisplay());
		quotation.setLightCurtain(budget.getLightCurtain());
		quotation.setLoadLimiter(budget.getLoadLimiter());
		quotation.setSpeechSynthesizer(budget.getSpeechSynthesizer());
		quotation.setGomSystem(budget.getGomSystem());
		quotation.setIntercom(budget.getIntercom());
		quotation.setPhone(budget.getPhone());
		quotation.setAccessSytem(budget.getAccessSytem());
		quotation.setFirefighterKeychain(budget.getFirefighterKeychain());
		quotation.setComment(budget.getComment());
	}

	private SaleSummary quotationToSaleSummary(Quotation auxQuotation) {
		return new SaleSummary(0, auxQuotation.getBasicDataByElectricityType(), auxQuotation.getBudget().getBasicDataByHourMachine(), auxQuotation.getBasicDataByHallButton(), auxQuotation.getBasicDataByRoofType(), auxQuotation.getBasicDataBySpeed(), auxQuotation.getBudget().getBasicDataByVoltageLighting(), auxQuotation.getBasicDataByDoorframeType(), auxQuotation.getBasicDataByRailing(), auxQuotation.getBudget().getBasicDataByBoothButton(), auxQuotation.getBasicDataByMirror(), auxQuotation.getBasicDataByElevatorCapacitance(), auxQuotation.getBasicDataByBoothDisplay(), auxQuotation.getBasicDataByCabinModel(), auxQuotation.getBasicDataByElevatorType(), auxQuotation.getBudget().getBasicDataByDoorSystem(), auxQuotation.getBudget().getBasicDataByFrequency(), auxQuotation.getBudget().getBasicDataByFan(), auxQuotation.getBasicDataByCabinDesign(), auxQuotation.getBasicDataByMachineType(), auxQuotation.getBudget().getBasicDataByBuildingType(), auxQuotation.getBasicDataByManeuverType(), auxQuotation.getBasicDataByDoorFrameHammered(), auxQuotation.getBasicDataByFloorType(), auxQuotation.getBudget().getBasicDataByMachineBase(), auxQuotation, auxQuotation.getBasicDataByHeight(), auxQuotation.getBasicDataByDoorType(), auxQuotation.getBudget().getBasicDataByButtonType(), auxQuotation.getBasicDataByControlType(), auxQuotation.getBasicDataByFreeAdmission(), auxQuotation.getBasicDataByFloorDisplay(), auxQuotation.getBudget().getBasicDataByAccess(), 0, null, new Date(), auxQuotation.getDeliveryDate(), auxQuotation.getConstruction(), auxQuotation.getBudget().getConstructionCity(), auxQuotation.getBudget().getConstructionAddress(), auxQuotation.getContactName(), auxQuotation.getBudget().getContactPhone(), auxQuotation.getBudget().getEmail(), auxQuotation.getBudget().getPlaneC(), auxQuotation.getBudget().getPlaneP(), auxQuotation.isType(), auxQuotation.getElevatorQuantity(), auxQuotation.getBudget().getMotorQuantity(), auxQuotation.getBudget().getMotorTraction(), auxQuotation.getStopNumber(), auxQuotation.getTour(), auxQuotation.getOnTour(), auxQuotation.getWidthHole(), auxQuotation.getFossa(), auxQuotation.getBottomHole(), auxQuotation.getDesignSpecial(), auxQuotation.getDesignSpecialComment(), auxQuotation.getCabinWidth(), auxQuotation.getCabinBackground(), auxQuotation.getCabinHeight(), auxQuotation.getBudget().getDoorOfNumber(), auxQuotation.getDoorframeTypeComment(), auxQuotation.getBudget().getHallButtonPlace(), auxQuotation.getLightCurtain(), auxQuotation.getLoadLimiter(), auxQuotation.getSpeechSynthesizer(), auxQuotation.getGomSystem(), auxQuotation.getIntercom(), auxQuotation.getPhone(), auxQuotation.getAccessSytem(), auxQuotation.getFirefighterKeychain(), auxQuotation.getBudget().getDisplayPlaceFloor(), auxQuotation.getStopSequenceContinuous(), auxQuotation.getStopSequenceContinuousQ(), auxQuotation.getStopSequenceContinuousNumber(), auxQuotation.getStopSequenceEven(), auxQuotation.getStopSequenceEvenQ(), auxQuotation.getStopSequenceEvenNumber(), auxQuotation.getStopSequenceOdd(), auxQuotation.getStopSequenceOddQ(), auxQuotation.getStopSequenceOddNumber(), auxQuotation.getDoorFrameHammeredDesc(), auxQuotation.getDoorFrameStainless(), auxQuotation.getDoorFrameStainlessDescrip(), auxQuotation.getComment(), auxQuotation.getStatus());
	}

	@Command
	public void updateQuotationNumber(Integer num) {
		List<Quotation> lisQuotations = serviceQuotation.listByBudget(num);
		if (lisQuotations.size() == 0)
			if (quotation.isType()) {
				Integer number = serviceQuotation.findMaxNewNumber();
				quotation.setNewNumber(number + 1);
			} else {
				Integer number = serviceQuotation.findMaxModernizationNumber();
				quotation.setModernizationNumber(number + 1);
				BindUtils.postNotifyChange(null, null, quotation, "modernizationNumber");
			}
		else {
			quotation.setNewNumber(lisQuotations.get(0).getNewNumber());
			quotation.setModernizationNumber(lisQuotations.get(0).getModernizationNumber());
		}
	}

	@NotifyChange({ "disableBeforeSearch", "cabinModel", "quotation", "listBoothDisplay", "listFloorDisplay", "listDesign", "disabledBudgetNumber", "disabledEdit" })
	@Command
	public void loadBudgetId(@BindingParam("val") String value) {
		for (int i = 0; i < value.length(); i++) {
			if (!Character.isDigit(value.charAt(i))) {
				value = "0";
				break;
			}
		}
		Integer budgetNumber = Integer.parseInt(value);
		budget = serviceBudget.findByNumber(budgetNumber);
		if (budget != null) {
			disableBeforeSearch = new Boolean(true);
			disabledBudgetNumber = new Boolean(true);
			disabledEdit = new Boolean(false);
			budgetToQuotation(budget);
			updateQuotationNumber(budgetNumber);
		} else
			Clients.showNotification("Ningun registro coincide", "info", null, "top_center", 2000);
	}

	@NotifyChange({ "quotation" })
	@Command
	public void loadPayment() {
		if (quotation.isType() && quotation.getBasicDataByQuotationType().getName().contains("MONEDA NACIONAL")) {
			quotation.setPayment("80% de Inicial pagadera a la firma del contrato de venta.\n" + "20% a los 30 días.\n");
			quotation.setWarranty("3");
			quotation.setExtendedWarranty("12");
			quotation.setDeliveryEstimate("6");
			quotation.setQuotationValidity("07");
			quotation.setNotes("- Los precios señalados no incluyen el IVA.\n" + "- Este presupuesto NO incluye montaje, el mismo será presupuestado en el momento que se vaya a ejecutar.\n" + "- El equipo se comenzará a fabricar luego de cancelado el 80% del precio de venta.\n" + "- Las cuotas del material importado han sido calculadas al tipo de cambio oficial del momento, por lo tanto, cualquier variación que exista en el tipo de cambio sera calculado al momento de efectuarse el pago.\n" + "- El incumplimiento en el pago de las cuotas genera intereses de mora.\n" + "- La empresa no se hace responsable de la contribucion o pagos al sindicato de la construccion, ni a ningun otro sindicato.\n" + "- Este presupuesto no contempla gastos de fianzas de ninguna indole.");
			quotation.setPriceImportedMaterial(0);
			quotation.setPriceNationalMaterial(0);
			quotation.setTotalPrice(0);
		} else if (!quotation.isType() && quotation.getBasicDataByQuotationType().getName().contains("MONEDA NACIONAL")) {
			quotation.setPayment("60% de inicial al momento de la firma del contrato.\n" + "20% para el desarme  de los equipos en  la obra.\n" + "15% para el despacho de los equipos y comenzar el trabajo de armado.\n" + "5% para la entrega de los equipos funcionando.");
			quotation.setWarranty("3");
			quotation.setExtendedWarranty("6");
			quotation.setDeliveryEstimate("8");
			quotation.setQuotationValidity("07");
			quotation.setNotes("- Los precios señalados no incluyen el IVA.\n" + "- En caso de daño oculto será presupuestado el mismo al momento de ser detectado y por separado.\n" + "- Las cuotas del material importado han sido calculadas al tipo de cambio oficial del momento, por lo tanto, cualquier variación que exista en el tipo de cambio sera calculado al momento de efectuarse el pago.\n" + "-El precio por instalación del equipo, sera ajustado al momento de la ejecución y culminación del montaje.\n" + "- El incumplimiento en el pago de las cuotas genera intereses de mora.\n" + "- La empresa no se hace responsable de la contribucion o pagos al sindicato de la construccion, ni a ningun otro sindicato.\n" + "- Este presupuesto no contempla gastos de fianzas de ninguna indole.");
			quotation.setPriceImportedMaterial(0);
			quotation.setPriceNationalMaterial(0);
			quotation.setTotalPrice(0);
		} else if (quotation.isType() && quotation.getBasicDataByQuotationType().getName().contains("MONEDA EXTRANJERA")) {
			quotation.setPaymentForeign("100% para la orden produccion y firma del contrato.");
			quotation.setPayment("20% para la orden de produccion y firma del contrato.\n" + "80% para nacionalizar los equipos al llegar a puerto venezolano.\n");
			quotation.setWarranty("3");
			quotation.setExtendedWarranty("12");
			quotation.setDeliveryEstimate("6");
			quotation.setQuotationValidity("07");
			quotation.setNotes("- Los precios señalados no incluyen el IVA.\n" + "- El precio de (los) equipo(s) NO INCLUYE el valor por concepto de mano de obra de MONTAJE. Este precio sera estimado al momento del comienzo de la instalación del (los) equipo(s).\n" + "- La empresa no se hace responsable de la contribucion o pagos al sindicato de la construccion, ni a ningun otro sindicato.\n" + "- Este presupuesto no contempla gastos de fianzas de ninguna indole.");
			quotation.setPriceImportedMaterial(0);
			quotation.setPriceNationalMaterial(0);
			quotation.setTotalPrice(0);
		} else if (!quotation.isType() && quotation.getBasicDataByQuotationType().getName().contains("MONEDA EXTRANJERA")) {

		}
	}

	@NotifyChange({ "listNitPartner", "listBudgetNumber", "listPartnerName", "listQuotationNumber", "listSeller", "listConstruction" })
	@Command
	public void searchQuotationByField(@BindingParam("field") String field) {
		if (field.compareTo("nitPartner") == 0) {
			listNitPartner = new SimpleListModelCustom<Object>(serviceQuotation.listNitPartner());
		} else if (field.compareTo("number") == 0) {
			listBudgetNumber = new SimpleListModelCustom<Object>(serviceQuotation.listBudgetNumber());
		} else if (field.compareTo("partnerName") == 0) {
			listPartnerName = new SimpleListModelCustom<Object>(serviceQuotation.listPartnerName());
		} else if (field.compareTo("quotationNumber") == 0) {
			List<String> list = serviceQuotation.listNewNumber();
			list.addAll(serviceQuotation.listModernizationNumber());
			listQuotationNumber = new SimpleListModelCustom<Object>(list);
		} else if (field.compareTo("construction") == 0) {
			listConstruction = new SimpleListModelCustom<Object>(serviceQuotation.listConstruction());
		} else if (field.compareTo("seller") == 0) {
			listSeller = new SimpleListModelCustom<Object>(serviceQuotation.listSeller());
		}
	}

	@NotifyChange({ "disableBeforeSearch", "cabinModel", "quotation", "disabledBudgetNumber", "disabledPrint", "disabledEdit" })
	@Command
	public void loadQuotationByField(@BindingParam("field") String field, @BindingParam("val") String value) {
		List<Quotation> list = new ArrayList<Quotation>();
		if (field.compareTo("budgetNumber") == 0) {
			if (value.isEmpty())
				value = "0";
			for (int i = 0; i < value.length(); i++) {
				if (!Character.isDigit(value.charAt(i))) {
					value = "0";
					break;
				}
			}
			list = serviceQuotation.listByBudget(Integer.parseInt(value));
		} else if (field.compareTo("quotationNumber") == 0) {
			if (value.isEmpty())
				value = "0";
			for (int i = 0; i < value.length(); i++) {
				if (!Character.isDigit(value.charAt(i))) {
					value = "0";
					break;
				}
			}
			list = serviceQuotation.listByNewNumber(Integer.parseInt(value));
			list.addAll(serviceQuotation.listByModernizationNumber(Integer.parseInt(value)));
		} else if (field.compareTo("nitPartner") == 0) {
			list = serviceQuotation.listByNitPartner(value);
		} else if (field.compareTo("partnerName") == 0) {
			list = serviceQuotation.listByPartnerName(value);
		} else if (field.compareTo("construction") == 0) {
			list = serviceQuotation.listByConstruction(value);
		} else if (field.compareTo("seller") == 0) {
			list = serviceQuotation.listBySeller(value);
		}
		int listSize = list.size();
		if (listSize == 1) {
			quotation = list.get(0);
			disableBeforeSearch = new Boolean(true);
			disabledBudgetNumber = new Boolean(true);
			disabledPrint = new Boolean(false);
			disabledEdit = new Boolean(true);
		} else if (listSize == 0) {
			Clients.showNotification("Ningun registro coincide", "info", null, "top_center", 2000);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("listQuotations", list);
			Executions.createComponents("system/ventas/presupuesto/frmWindowQuotations.zul", null, map);
		}
	}

	@NotifyChange({ "listBudgetNumber" })
	@Command
	public void searchBudgetByField(@BindingParam("field") String field) {
		listBudgetNumber = new SimpleListModelCustom<Object>(serviceBudget.listNumber());
	}

	@Command
	public void isStopSequenceContinuous() {
		quotation.setStopSequenceEven(false);
		quotation.setStopSequenceOdd(false);
		quotation.setStopSequenceEvenNumber(0);
		quotation.setStopSequenceOddNumber(0);
		quotation.setStopSequenceEvenQ(new String());
		quotation.setStopSequenceOddQ(new String());
		if (!quotation.getStopSequenceContinuous()) {
			quotation.setStopSequenceContinuousQ(new String());
			quotation.setStopSequenceContinuousNumber(0);
		}
	}

	@Command
	public void priceUnit(@BindingParam("val") Double value) {
		quotation.setPriceImportedMaterial(value * 0.6);
		quotation.setPriceNationalMaterial(value * 0.4);
		quotation.setTotalPrice(value);
		BindUtils.postNotifyChange(null, null, quotation, "priceImportedMaterial");
		BindUtils.postNotifyChange(null, null, quotation, "priceNationalMaterial");
		BindUtils.postNotifyChange(null, null, quotation, "totalPrice");
	}

	@Command
	public void setPrice(@BindingParam("price") Double value, @BindingParam("type") String type) {
		if (type.contains("national")) {
			quotation.setPriceNationalMaterial(value);
			BindUtils.postNotifyChange(null, null, quotation, "priceNationalMaterial");
		} else if (type.contains("foreign")) {
			quotation.setPriceImportedMaterial(value);
			BindUtils.postNotifyChange(null, null, quotation, "priceImportedMaterial");
		}
	}

	@NotifyChange({ "quotation", "disabledPrint", "disableBeforeSearch", "disabledBudgetNumber", "cabinModel" })
	@GlobalCommand
	public void selectedQuotation(@BindingParam("quotation") Quotation quotation) {
		this.quotation = serviceQuotation.findById(quotation.getIdQuotation());
		disableBeforeSearch = new Boolean(true);
		disabledBudgetNumber = new Boolean(true);
		disabledPrint = new Boolean(false);
		disabledEdit = new Boolean(true);
	}

	@NotifyChange({ "quotation", "disableBeforeSearch", "disabledBudgetNumber", "disabledEdit" })
	@Command
	public void search() {
		restartForm();
		quotation.setNewNumber(0);
		quotation.setModernizationNumber(0);
		disableBeforeSearch = new Boolean(false);
		disabledBudgetNumber = new Boolean(false);
		disabledEdit = new Boolean(true);
	}

	public String getElevatorType(String str) {
		return (quotation.getElevatorQuantity() > 1 ? "ASCENSORES " : "ASCENSOR ") + str;
	}

	private List<File> mainMailAttach(SaleSummary saleSummary) {
		List<File> listAttach = new ArrayList<File>();
		GenericReport report = new GenericReport();
		// Creamos el pdf del resumen de ventas
		listAttach.add(createSaleSummaryPdf(report, saleSummary));
		String quotationNumber = new String();
		if (quotation.isType())
			quotationNumber = "1-" + quotation.getNewNumber() + "-" + quotation.getVersionNumber();
		else
			quotationNumber = "2-" + quotation.getModernizationNumber() + "-" + quotation.getVersionNumber();
		// Creamos el pdf del presupuesto
		createQuotationPdf("SI", quotationNumber, report);
		listAttach.add(report.getFile());
		// Creamos el pdf del resumen de negociacion
		TransactionSummary ts = serviceTransactionSummary.findByQuotation(quotation);
		if (ts != null) {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("IMAGES_DIR", "../../resource/images/system/reports/");
			parameters.put("ID", ts.getIdTransactionSummary());
			report.createPdf("/resource/reports/ventas/resumen_negociacion", "transaction_summary.jasper", parameters, "resumen_negociacion_" + ts.getIdTransactionSummary() + ".pdf");
			listAttach.add(report.getFile());
		}
		return listAttach;
	}

	public List<File> logisticMailAttach(SaleSummary saleSummary) {
		List<File> listAttach = new ArrayList<File>();
		GenericReport report = new GenericReport();
		listAttach.add(createSaleSummaryPdf(report, saleSummary));
		return listAttach;
	}

	private File createSaleSummaryPdf(GenericReport report, SaleSummary saleSummary) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("ID_SALE_SUMMARY", saleSummary.getIdSaleSummary());
		parameters.put("IMAGES_DIR", "../../resource/images/system/reports/");
		parameters.put("SUBREPORT_DIR", "../../resource/reports/ventas/resumen/");
		report.createPdf("/resource/reports/ventas/resumen", "sale_summary.jasper", parameters, "Resumen_venta_" + saleSummary.getNumber() + ".pdf");
		return report.getFile();
	}

	private String mainMailMessage() {
		Format formatter = new SimpleDateFormat("dd/MM/yyyy");
		return "Presupuesto aprobado el dia " + formatter.format(quotation.getApprovedDate()) + "\n\nPresupuesto nro:" + (quotation.isType() ? "1" : "2") + "-" + (quotation.isType() ? quotation.getNewNumber() : quotation.getModernizationNumber()) + "-" + quotation.getVersionNumber() + "\n\nCliente: " + quotation.getPartnerName() + "\n\nCantidad ascensores: " + quotation.getElevatorQuantity() + "\n\nCiudad: " + quotation.getConstruction();
	}

	private String logisticMailMessage(SaleSummary saleSummary) {
		Format formatter = new SimpleDateFormat("dd/MM/yyyy");
		return "Obra aprobada el día " + formatter.format(quotation.getApprovedDate()) + "\n\nNro Obra: " + saleSummary.getNumber() + "\n\nCliente: " + saleSummary.getQuotation().getPartnerName() + "\n\nObra: " + saleSummary.getConstruction() + "\n\nDirección de la obra: " + saleSummary.getConstructionAddress() + "\n\nCiudad: " + saleSummary.getConstructionCity();
	}

	private void sendMail(SaleSummary saleSummary) {
		List<String> listRecipient = new ArrayList<String>();
		/*
		 * listRecipient.add("ventas@ascensoresnardi.com");
		 * listRecipient.add("administracion@ascensoresnardi.com");
		 * listRecipient.add("cobranzas@ascensoresnardi.com");
		 */
		/*
		 * listRecipient.add(serviceBudget.findByNumber(saleSummary.getQuotation().getBudget().getNumber()).
		 * getSecurityUser().getEmail());
		 */
		listRecipient.add("sistemas@ascensoresnardi.com");
		emails.sendMail("sistemas@ascensoresnardi.com", "Presupuesto nro " + (quotation.isType() ? "1" : "2") + "-" + (quotation.isType() ? quotation.getNewNumber() : quotation.getModernizationNumber()) + "-" + quotation.getVersionNumber(), listRecipient, mainMailMessage(), mainMailAttach(saleSummary));
		listRecipient.clear();
		/* listRecipient.add("logistica@ascensoresnardi.com"); */
		listRecipient.add("sistemas@ascensoresnardi.com");
		emails.sendMail("sistemas@ascensoresnardi.com", "Obra Nro " + saleSummary.getNumber() + "-" + saleSummary.getVersion(), listRecipient, logisticMailMessage(saleSummary), logisticMailAttach(saleSummary));
	}

	@NotifyChange("printMessage")
	@Command
	public void save() {
		if (!serviceQuotation.save(quotation)) {
			Clients.showNotification("No se pudo guardar el presupuesto", "error", null, "bottom_center", 2000);
			return;
		}
		if (quotation.getStatus() == 'A') {
			SaleSummary saleSummary = quotationToSaleSummary(quotation);
			if (!serviceSaleSummary.save(saleSummary)) {
				Clients.showNotification("No se pudo guardar el presupuesto", "error", null, "bottom_center", 2000);
				return;
			}
			saleSummary = serviceSaleSummary.findByQuotation(quotation);
			sendMail(saleSummary);
		}
		Clients.showNotification("Presupuesto guardado", "info", null, "bottom_center", 2000);
		selectPrintTemplate();
	}

	@NotifyChange("modalMessage")
	@Command
	public void confirmSave(@BindingParam("radioGroup") Radiogroup radiogroup, @BindingParam("datebox") Datebox datebox) {
		modalMessage = "El proceso de guardado es irreversible. ¿Esta seguro de guardar el presupuesto?";
		selectStatus(radiogroup);
	}

	@NotifyChange("printMessage")
	@Command
	public void selectPrintTemplate() {
		printMessage = "Escoja el formato para la impresion.";
	}

	@NotifyChange({ "quotation", "disableBeforeSearch", "disabledBudgetNumber", "disabledPrint", "disabledEdit", "listQuotationNumber", "listNitPartner", "listBudgetNumber", "listPartnerName", "listConstruction", "listSeller", "listQuotationType", "modalMessage", "printMessage" })
	@Command
	public void cancelModal() {
		if (modalMessage != null)
			modalMessage = null;
		if (printMessage != null) {
			printMessage = null;
			restartForm();
		}
	}

	@NotifyChange({ "disabledEdit" })
	@Command
	public void edit() {
		disabledEdit = new Boolean(false);
	}

	/**
	 * @param template
	 *                If 'SI' the pdf will create print with head, else 'NO' the pdf will create
	 * @param quotationNumber
	 *                Quotations number.
	 * @param report
	 *                For to generate report.
	 */
	private void createQuotationPdf(String template, String quotationNumber, GenericReport report) {
		if (template == null || template.compareTo("SI") == 0) {
			if (quotation.getBasicDataByQuotationType().getName().contains("MONEDA NACIONAL"))
				template = "quotation.jasper";
			else if (quotation.getBasicDataByQuotationType().getName().contains("MONEDA EXTRANJERA"))
				template = "quotation_foreign.jasper";
		} else if (template.contains("NO"))
			if (quotation.getBasicDataByQuotationType().getName().contains("MONEDA NACIONAL"))
				template = "quotation_without.jasper";
			else if (quotation.getBasicDataByQuotationType().getName().contains("MONEDA EXTRANJERA"))
				template = "quotation_foreign_without.jasper";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("TYPE", quotation.isType());
		parameters.put("NEW", quotation.getNewNumber());
		parameters.put("MODERNIZATION", quotation.getModernizationNumber());
		parameters.put("VERSION", quotation.getVersionNumber());
		parameters.put("IMAGES_DIR", "../../resource/images/system/reports/");
		parameters.put("SUBREPORT_DIR", "../../resource/reports/ventas/presupuesto/");
		report.createPdf("/resource/reports/ventas/presupuesto", template, parameters, "ppto_" + quotationNumber + ".pdf");
	}

	@NotifyChange({ "quotation", "disableBeforeSearch", "disabledBudgetNumber", "disabledPrint", "disabledEdit", "listQuotationNumber", "listNitPartner", "listBudgetNumber", "listPartnerName", "listConstruction", "listSeller", "listQuotationType", "modalMessage", "printMessage" })
	@Command
	public void print(@BindingParam("template") String template) {
		GenericReport report = new GenericReport();
		String quotationNumber = new String();
		if (quotation.isType())
			quotationNumber = "1-" + quotation.getNewNumber() + "-" + quotation.getVersionNumber();
		else
			quotationNumber = "2-" + quotation.getModernizationNumber() + "-" + quotation.getVersionNumber();
		createQuotationPdf(template, quotationNumber, report);
		report.viewPdf("/resource/reports/ventas/presupuesto/ppto_" + quotationNumber + ".pdf", "Presupuesto");
		restartForm();
	}

	@Command
	public void close() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "");
		BindUtils.postGlobalCommand(null, null, "selectedPage", map);
	}
}