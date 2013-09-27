package controller.ventas.solicitud;

import general.SimpleListModelCustom;
import general.ValidateZK;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.database.BasicData;
import model.database.Budget;
import model.database.BusinessPartner;
import model.database.Quotation;
import model.database.SecurityUser;
import model.service.ServiceBasicData;
import model.service.ServiceBudget;
import model.service.ServiceBusinessPartner;
import model.service.ServiceQuotation;
import model.service.ServiceSecurityUser;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.hibernate.HibernateException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.zkoss.bind.BindUtils;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.impl.InputElement;

import springBean.Emails;

/**
 * @author leyner.castillo
 * 
 */
public class FrmBudget {

	@WireVariable
	private ServiceBasicData serviceBasicData;
	@WireVariable
	private ServiceBudget serviceBudget;
	@WireVariable
	private ServiceSecurityUser serviceSecurityUser;
	@WireVariable
	private ServiceBusinessPartner serviceBusinessPartner;
	@WireVariable
	private ServiceQuotation serviceQuotation;
	@WireVariable
	private Emails emails;
	private String seleccione;
	private String modalMessage;
	private final String dash = new String("--");
	private List<BasicData> listBType;
	private List<BasicData> listElevatorType;
	private List<BasicData> listElevatorCapa;
	private List<BasicData> listMachineType;
	private List<BasicData> listMachineBase;
	private List<BasicData> listBEmbarque;
	private List<BasicData> listElectricityType;
	private List<BasicData> listSpeed;
	private List<BasicData> listFrequency;
	private List<BasicData> listVoltageLighting;
	private List<BasicData> listHourMachine;
	private List<BasicData> listManeuverType;
	private List<BasicData> listDesign;
	private List<BasicData> listRoofType;
	private List<BasicData> listButtonType;
	private List<BasicData> listRailing;
	private List<BasicData> listMirror;
	private List<BasicData> listFloorType;
	private List<BasicData> listFan;
	private List<BasicData> listDoorType;
	private List<BasicData> listDoorSystem;
	private List<BasicData> listDoorframeType;
	private List<BasicData> listDoorframeHammered;
	private List<BasicData> listFreeAdmission;
	private List<BasicData> listHeight;
	private List<BasicData> listControlType;
	private List<BasicData> listBoothButton;
	private List<BasicData> listBoothDisplay;
	private List<BasicData> listFloorDisplay;
	private List<BasicData> listMotorTraction;
	private List<BasicData> listCabinModel;
	private List<BasicData> listHallButton;
	private List<BasicData> listHallButtonType;
	private List<BasicData> listRifType;
	private ListModel<Object> listRifPartner;
	private ListModel<Object> listNumber;
	private ListModel<Object> listPartnerName;
	private ListModel<Object> listConstruction;
	private ListModel<Object> listSeller;
	private BasicData cabinModel;
	private Boolean stainlessSteel;
	private Boolean hammeredGray;
	private Boolean hammeredBrown;
	private Boolean disabledAll;
	private Boolean disableAfterSearch;
	private Boolean disabledNumber;
	private Boolean disableSeller;
	private Boolean disableSistelHall;
	private Boolean isSpecial;
	private Integer sistelWDisplayFloor;
	private Integer sistelWDisplayPB;
	private Integer sistelWArrowFloor;
	private Integer sistelWArrowPB;
	private Budget budget;
	private BusinessPartner businessPartner;

	public String getModalMessage() {
		return modalMessage;
	}

	public void setModalMessage(String modalMessage) {
		this.modalMessage = modalMessage;
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

	public ListModel<Object> getListNumber() {
		return listNumber;
	}

	public void setListNumber(ListModel<Object> listNumber) {
		this.listNumber = listNumber;
	}

	public String getDash() {
		return dash;
	}

	public List<BasicData> getListMachineBase() {
		return listMachineBase;
	}

	public void setListMachineBase(List<BasicData> listMachineBase) {
		this.listMachineBase = listMachineBase;
	}

	public ListModel<Object> getListRifPartner() {
		return listRifPartner;
	}

	public void setListRifPartner(ListModel<Object> listRifPartner) {
		this.listRifPartner = listRifPartner;
	}

	public List<BasicData> getListRifType() {
		return listRifType;
	}

	public void setListRifType(List<BasicData> listRifType) {
		this.listRifType = listRifType;
	}

	public Boolean getDisableSistelHall() {
		return disableSistelHall;
	}

	public void setDisableSistelHall(Boolean disableSistelHall) {
		this.disableSistelHall = disableSistelHall;
	}

	public Boolean getDisableSeller() {
		return disableSeller;
	}

	public void setDisableSeller(Boolean disableSeller) {
		this.disableSeller = disableSeller;
	}

	public List<BasicData> getListHallButton() {
		return listHallButton;
	}

	public void setListHallButton(List<BasicData> listHallButton) {
		this.listHallButton = listHallButton;
	}

	public List<BasicData> getListHallButtonType() {
		return listHallButtonType;
	}

	public void setListHallButtonType(List<BasicData> listHallButtonType) {
		this.listHallButtonType = listHallButtonType;
	}

	public List<BasicData> getListDoorframeHammered() {
		return listDoorframeHammered;
	}

	public void setListDoorframeHammered(List<BasicData> listDoorframeHammered) {
		this.listDoorframeHammered = listDoorframeHammered;
	}

	public Boolean getIsSpecial() {
		return isSpecial;
	}

	public void setIsSpecial(Boolean isSpecial) {
		this.isSpecial = isSpecial;
	}

	public List<BasicData> getListDesign() {
		return listDesign;
	}

	public void setListDesign(List<BasicData> listDesign) {
		this.listDesign = listDesign;
	}

	public BasicData getCabinModel() {
		return cabinModel;
	}

	public void setCabinModel(BasicData cabinModel) {
		this.cabinModel = cabinModel;
	}

	public List<BasicData> getListCabinModel() {
		return listCabinModel;
	}

	public void setListCabinModel(List<BasicData> listCabinModel) {
		this.listCabinModel = listCabinModel;
	}

	public Boolean getDisabledNumber() {
		return disabledNumber;
	}

	public void setDisabledNumber(Boolean disabledNumber) {
		this.disabledNumber = disabledNumber;
	}

	public Boolean getDisableAfterSearch() {
		return disableAfterSearch;
	}

	public void setDisableAfterSearch(Boolean disableAfterSearch) {
		this.disableAfterSearch = disableAfterSearch;
	}

	public Boolean getDisabledAll() {
		return disabledAll;
	}

	public void setDisabledAll(Boolean disabledAll) {
		this.disabledAll = disabledAll;
	}

	public String getSeleccione() {
		return seleccione;
	}

	public void setSeleccione(String seleccione) {
		this.seleccione = seleccione;
	}

	public Boolean getStainlessSteel() {
		return stainlessSteel;
	}

	public void setStainlessSteel(Boolean stainlessSteel) {
		this.stainlessSteel = stainlessSteel;
	}

	public Boolean getHammeredGray() {
		return hammeredGray;
	}

	public void setHammeredGray(Boolean hammeredGray) {
		this.hammeredGray = hammeredGray;
	}

	public Boolean getHammeredBrown() {
		return hammeredBrown;
	}

	public void setHammeredBrown(Boolean hammeredBrown) {
		this.hammeredBrown = hammeredBrown;
	}

	public Integer getSistelWDisplayFloor() {
		return sistelWDisplayFloor;
	}

	public void setSistelWDisplayFloor(Integer sistelWDisplayFloor) {
		this.sistelWDisplayFloor = sistelWDisplayFloor;
	}

	public Integer getSistelWDisplayPB() {
		return sistelWDisplayPB;
	}

	public void setSistelWDisplayPB(Integer sistelWDisplayPB) {
		this.sistelWDisplayPB = sistelWDisplayPB;
	}

	public Integer getSistelWArrowFloor() {
		return sistelWArrowFloor;
	}

	public void setSistelWArrowFloor(Integer sistelWArrowFloor) {
		this.sistelWArrowFloor = sistelWArrowFloor;
	}

	public Integer getSistelWArrowPB() {
		return sistelWArrowPB;
	}

	public void setSistelWArrowPB(Integer sistelWArrowPB) {
		this.sistelWArrowPB = sistelWArrowPB;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}

	public List<BasicData> getListMotorTraction() {
		return listMotorTraction;
	}

	public void setListMotorTraction(List<BasicData> listMotorTraction) {
		this.listMotorTraction = listMotorTraction;
	}

	public List<BasicData> getListFloorDisplay() {
		return listFloorDisplay;
	}

	public void setListFloorDisplay(List<BasicData> listFloorDisplay) {
		this.listFloorDisplay = listFloorDisplay;
	}

	public List<BasicData> getListBoothDisplay() {
		return listBoothDisplay;
	}

	public void setListBoothDisplay(List<BasicData> listBoothDisplay) {
		this.listBoothDisplay = listBoothDisplay;
	}

	public List<BasicData> getListBoothButton() {
		return listBoothButton;
	}

	public void setListBoothButton(List<BasicData> listBoothButton) {
		this.listBoothButton = listBoothButton;
	}

	public List<BasicData> getListControlType() {
		return listControlType;
	}

	public void setListControlType(List<BasicData> listControlType) {
		this.listControlType = listControlType;
	}

	public List<BasicData> getListHeight() {
		return listHeight;
	}

	public void setListHeight(List<BasicData> listHeight) {
		this.listHeight = listHeight;
	}

	public List<BasicData> getListFreeAdmission() {
		return listFreeAdmission;
	}

	public void setListFreeAdmission(List<BasicData> listFreeAdmission) {
		this.listFreeAdmission = listFreeAdmission;
	}

	public List<BasicData> getListDoorframeType() {
		return listDoorframeType;
	}

	public void setListDoorframeType(List<BasicData> listDoorframeType) {
		this.listDoorframeType = listDoorframeType;
	}

	public List<BasicData> getListDoorSystem() {
		return listDoorSystem;
	}

	public void setListDoorSystem(List<BasicData> listDoorSystem) {
		this.listDoorSystem = listDoorSystem;
	}

	public List<BasicData> getListDoorType() {
		return listDoorType;
	}

	public void setListDoorType(List<BasicData> listDoorType) {
		this.listDoorType = listDoorType;
	}

	public List<BasicData> getListFan() {
		return listFan;
	}

	public void setListFan(List<BasicData> listFan) {
		this.listFan = listFan;
	}

	public List<BasicData> getListFloorType() {
		return listFloorType;
	}

	public void setListFloorType(List<BasicData> listFloorType) {
		this.listFloorType = listFloorType;
	}

	public List<BasicData> getListMirror() {
		return listMirror;
	}

	public void setListMirror(List<BasicData> listMirror) {
		this.listMirror = listMirror;
	}

	public List<BasicData> getListRailing() {
		return listRailing;
	}

	public void setListRailing(List<BasicData> listRailing) {
		this.listRailing = listRailing;
	}

	public List<BasicData> getListButtonType() {
		return listButtonType;
	}

	public void setListButtonType(List<BasicData> listButtonType) {
		this.listButtonType = listButtonType;
	}

	public List<BasicData> getListRoofType() {
		return listRoofType;
	}

	public void setListRoofType(List<BasicData> listRoofType) {
		this.listRoofType = listRoofType;
	}

	public List<BasicData> getListManeuverType() {
		return listManeuverType;
	}

	public void setListManeuverType(List<BasicData> listManeuverType) {
		this.listManeuverType = listManeuverType;
	}

	public List<BasicData> getListHourMachine() {
		return listHourMachine;
	}

	public void setListHourMachine(List<BasicData> listHourMachine) {
		this.listHourMachine = listHourMachine;
	}

	public List<BasicData> getListVoltageLighting() {
		return listVoltageLighting;
	}

	public void setListVoltageLighting(List<BasicData> listVoltageLighting) {
		this.listVoltageLighting = listVoltageLighting;
	}

	public List<BasicData> getListFrequency() {
		return listFrequency;
	}

	public void setListFrequency(List<BasicData> listFrequency) {
		this.listFrequency = listFrequency;
	}

	public List<BasicData> getListSpeed() {
		return listSpeed;
	}

	public void setListSpeed(List<BasicData> listSpeed) {
		this.listSpeed = listSpeed;
	}

	public List<BasicData> getListElectricityType() {
		return listElectricityType;
	}

	public void setListElectricityType(List<BasicData> listElectricityType) {
		this.listElectricityType = listElectricityType;
	}

	public List<BasicData> getListBEmbarque() {
		return listBEmbarque;
	}

	public void setListBEmbarque(List<BasicData> listBEmbarque) {
		this.listBEmbarque = listBEmbarque;
	}

	public List<BasicData> getListMachineType() {
		return listMachineType;
	}

	public void setListMachineType(List<BasicData> listMachineType) {
		this.listMachineType = listMachineType;
	}

	public List<BasicData> getListElevatorCapa() {
		return listElevatorCapa;
	}

	public void setListElevatorCapa(List<BasicData> listElevatorCapa) {
		this.listElevatorCapa = listElevatorCapa;
	}

	public List<BasicData> getListElevatorType() {
		return listElevatorType;
	}

	public void setListElevatorType(List<BasicData> listElevatorType) {
		this.listElevatorType = listElevatorType;
	}

	public List<BasicData> getListBType() {
		return listBType;
	}

	public void setListBType(List<BasicData> listBType) {
		this.listBType = listBType;
	}

	@Init
	public void init() {
		restartForm();
	}

	@NotifyChange("*")
	@Command
	public void restartForm() {
		seleccione = new String("--Seleccione--");
		modalMessage = null;
		budget = new Budget();
		businessPartner = new BusinessPartner();
		List<Budget> listAllBudget = serviceBudget.listAll();
		if (listAllBudget.isEmpty())
			budget.setNumber(1);
		else
			budget.setNumber(listAllBudget.get(listAllBudget.size() - 1).getNumber() + 1);
		disabledAll = new Boolean(false);
		disableAfterSearch = new Boolean(false);
		disabledNumber = new Boolean(true);
		disableSeller = new Boolean(true);
		disableSistelHall = new Boolean(true);
		isSpecial = new Boolean(false);
		cabinModel = new BasicData();
		User auxUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		SecurityUser user = serviceSecurityUser.findUser(auxUser.getUsername());
		budget.setSeller(user.getName());
		budget.setSecurityUser(user);
		budget.setDate(new Date());
		budget.setType(true);
		budget.setPlaneC(false);
		budget.setPlaneP(false);
		budget.setLightCurtain(false);
		budget.setLoadLimiter(false);
		budget.setSpeechSynthesizer(false);
		budget.setGomSystem(false);
		budget.setIntercom(false);
		budget.setPhone(false);
		budget.setAccessSytem(false);
		budget.setFirefighterKeychain(false);
		budget.setDesignSpecial(false);
		budget.setMotorTraction(new String());
		budget.setHallButtonPlace(new String());
		budget.setDisplayPlaceFloor(new String());
		budget.setStatus('A');
		budget.setStopSequenceContinuous(false);
		budget.setStopSequenceEven(false);
		budget.setStopSequenceOdd(false);
		budget.setDoorFrameStainless(false);
		budget.setSistelWarrowFloor(0);
		budget.setElevatorQuantity(0);
		budget.setMotorQuantity(0);
		budget.setStopSequenceContinuousNumber(0);
		budget.setStopSequenceEvenNumber(0);
		budget.setStopSequenceOddNumber(0);
		budget.setSistelWdisplayPb(new Boolean(false));
		budget.setSistelWdisplayFloor(0);
		budget.setSistelWarrowPb(new Boolean(false));
		budget.setRifType('-');
		budget.setRifPartner(new String());
		budget.setLightCurtain(true);
		/* listDesign = new ArrayList<BasicData>(); */
		listDesign = serviceBasicData.listDesign();
		/* listFan = new ArrayList<BasicData>(); */
		listFan = serviceBasicData.listFan();
		/* listBoothDisplay = new ArrayList<BasicData>(); */
		listBoothDisplay = serviceBasicData.listBoothDisplay();
		/* listFloorDisplay = new ArrayList<BasicData>(); */
		listFloorDisplay = serviceBasicData.listFloorDisplay();
		/* listRoofType = new ArrayList<BasicData>(); */
		listRoofType = serviceBasicData.listRoofType();
		listRifPartner = new ListModelList<Object>();
		listNumber = new ListModelList<Object>();
		listPartnerName = new ListModelList<Object>();
		listConstruction = new ListModelList<Object>();
		listSeller = new ListModelList<Object>();
		listRifType = serviceBasicData.listRifType();
		listBType = serviceBasicData.listBuildingType();
		listElevatorType = serviceBasicData.listElevatorType();
		listElevatorCapa = serviceBasicData.listElevatorCapacitance();
		listMachineType = serviceBasicData.listMachineType();
		listMachineBase = serviceBasicData.listMachineBase();
		listBEmbarque = serviceBasicData.listAccess();
		listElectricityType = serviceBasicData.listElectricityType();
		listSpeed = serviceBasicData.listSpeed();
		listFrequency = serviceBasicData.listFrequency();
		listVoltageLighting = serviceBasicData.listVoltageLighting();
		listHourMachine = serviceBasicData.listHourMachine();
		listManeuverType = serviceBasicData.listManeuverType();
		listButtonType = serviceBasicData.listButtonType();
		listRailing = serviceBasicData.listRailing();
		listMirror = serviceBasicData.listMirror();
		listFloorType = serviceBasicData.listFloorType();
		listDoorType = serviceBasicData.listDoorType();
		listDoorSystem = serviceBasicData.listDoorSystem();
		listDoorframeType = serviceBasicData.listDoorframeType();
		listDoorframeHammered = serviceBasicData.listDoorframeHammered();
		listHallButton = serviceBasicData.listHallButton();
		listHallButtonType = serviceBasicData.listHallButtonType();
		listFreeAdmission = serviceBasicData.listFreeAdmission();
		listHeight = serviceBasicData.listHeight();
		listControlType = serviceBasicData.listControlType();
		listBoothButton = serviceBasicData.listBoothButton();
		listMotorTraction = serviceBasicData.listMotorTraction();
		listCabinModel = serviceBasicData.listCabinModel();
	}

	/**
	 * Metodo que valida que un componente ZK no este vacio.
	 * 
	 * @return {@link Validator}
	 */
	public Validator getNoEmpty() {
		return new ValidateZK().getNoEmpty();
	}

	/**
	 * Metodo que valida que un string sea un Email valido. Solo aplica para componentes ZK
	 * 
	 * @return {@link Validator}
	 */
	public Validator getNoEmail() {
		return new ValidateZK().getNoEmail();
	}

	/**
	 * Metodo que valida que la cantidad de Ascensores sea por lo menos uno, si la solicitud de presupuesto es
	 * Nueva. Solo aplica para componentes ZK
	 * 
	 * @return {@link Validator}
	 */
	public Validator getNoElevatorQuantity() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				Integer quantity = Integer.parseInt(inputElement.getText());
				if (budget.isType() && (quantity < 1))
					throw new WrongValueException(inputElement, "Debe ingresar al menos un ascensor.");
			}
		};
	}

	/**
	 * Metodo que valida que se anada una descripcion si se selecciona un diseno formica.
	 * 
	 * @return {@link Validator}
	 */
	public Validator getNoEmptyForFormica() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				String str = inputElement.getText();
				if (budget.getBasicDataByCabinDesign() != null && budget.getBasicDataByCabinDesign().getName().indexOf("FORMICA") != -1 && str.trim().isEmpty())
					throw new WrongValueException(inputElement, "Debe ingresar una descripcion para formica.");
				if (budget.getBasicDataByCabinDesign() != null && budget.getBasicDataByCabinDesign().getName().indexOf("OTRO") != -1 && str.trim().isEmpty())
					throw new WrongValueException(inputElement, "Debe ingresar una descripcion para otro.");
				if (budget.getBasicDataByFloorType() != null && budget.getBasicDataByFloorType().getName().indexOf("OTROS") != -1 && str.trim().isEmpty())
					throw new WrongValueException(inputElement, "Debe ingresar una descripcion acabados de piso OTROS.");
			}
		};
	}

	public Validator getNoZeroContinuous() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				Integer value = Integer.valueOf(inputElement.getText());
				if (budget.getStopSequenceContinuous() && value <= 0)
					throw new WrongValueException(inputElement, "Debe ingresar cantidad de paradas.");
			}
		};
	}

	public Validator getNoZeroEven() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				Integer value = Integer.valueOf(inputElement.getText());
				if (budget.getStopSequenceEven() && value <= 0)
					throw new WrongValueException(inputElement, "Debe ingresar cantidad de paradas.");
			}
		};
	}

	public Validator getNoZeroOdd() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				Integer value = Integer.valueOf(inputElement.getText());
				if (budget.getStopSequenceOdd() && value <= 0)
					throw new WrongValueException(inputElement, "Debe ingresar cantidad de paradas.");
			}
		};
	}

	public Validator getValidateDoorframeType() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				String str = inputElement.getText();
				if (budget.getBasicDataByDoorframeType() != null && (str.indexOf("RECTO - 30X150") != -1) && (budget.getHallButtonPlace().indexOf("MARCO") != -1))
					throw new WrongValueException(inputElement, "Este tipo no puede ser ubicado en el Marco.");
			}
		};
	}

	public Validator getNoSelect() {
		return new ValidateZK().getNoSelect();
	}

	public Validator getNoZero() {
		return new ValidateZK().getNoZero();
	}

	public Validator getNoZeroDouble() {
		return new ValidateZK().getNoZeroDouble();
	}

	public String mailMessage() {
		String seller = new String(budget.getSeller());
		String message = new String();
		message = "Solicitud de presupuesto enviada por " + seller + "\n\nCliente: " + budget.getPartnerName() + "\n\nCantidad ascensores: " + budget.getElevatorQuantity() + "\n\nCiudad: " + budget.getConstructionCity();
		return message;
	}

	public List<File> mailAttach() {
		List<File> listAttach = new ArrayList<File>();
		try {
			createPdf();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		File file = new File(Sessions.getCurrent().getWebApp().getRealPath("/resource/reports/ventas/solicitud/presupuesto" + budget.getNumber() + ".pdf"));
		listAttach.add(file);
		return listAttach;
	}

	public void sendMail() {
		List<String> listRecipient = new ArrayList<String>();
		listRecipient.add("ventas@ascensoresnardi.com");
		listRecipient.add("sistemas@ascensoresnardi.com");
		emails.sendMail("sistemas@ascensoresnardi.com", "Solicitud de presupuesto nro" + budget.getNumber(), listRecipient, mailMessage(), mailAttach());
	}

	@NotifyChange({ "*" })
	@Command
	public void save(@BindingParam("component") InputElement component) throws SQLException {
		if (businessPartner.getIdBusinessPartner() != 0)
			budget.setBusinessPartner(businessPartner);
		/* Cambiar if a metodo de validacion tradicional */
		if (!serviceBudget.save(budget)) {
			Clients.showNotification("No se pudo guardar.", "error", null, "bottom_center", 2000);
			return;
		}
		/* Se envia si se guarda. Si se modifica o no se guarda, no se envia */
		/* ACTIVAR DE NUEVO */
		/*
		 * if (budget.getIdBudget() == 0) sendMail();
		 */
		Clients.showNotification("Presupuesto enviado", "info", null, "bottom_center", 2000);
		print();
		restartForm();
	}

	@NotifyChange("modalMessage")
	@Command
	public void confirmSave() {
		modalMessage = "¿Esta seguro de guardar la solicitud?";
	}

	@NotifyChange("modalMessage")
	@Command
	public void cancelModal() {
		modalMessage = null;
	}

	@NotifyChange({ "disabledAll" })
	@Command
	public void edit(@BindingParam("component") Button button) {
		List<Quotation> list = serviceQuotation.listByBudget(budget.getNumber());
		for (Quotation q : list) {
			if (q.getStatus() == 'A') {
				disabledAll = new Boolean(false);
				return;
			}
		}
		throw new WrongValueException(button, "Esta solicitud no tiene ningun presupuesto aprobado. No puede ser editada.");
	}

	@NotifyChange({ "disabledAll", "budgetNumber", "budget", "disableAfterSearch", "disabledNumber" })
	@Command
	public void search() {
		restartForm();
		budget.setNumber(0);
		budget.setSeller(new String());
		disabledAll = new Boolean(true);
		disableAfterSearch = new Boolean(false);
		disabledNumber = new Boolean(false);
		disableSeller = new Boolean(false);
	}

	@NotifyChange({ "listRifPartner", "listNumber", "listPartnerName", "listConstruction", "listSeller" })
	@Command
	public void loadBudgetByField(@BindingParam("field") String field) {
		if (field.compareTo("rifPartner") == 0) {
			listRifPartner = new SimpleListModelCustom<Object>(serviceBudget.listRifPartner());
			return;
		} else if (field.compareTo("number") == 0) {
			listNumber = new SimpleListModelCustom<Object>(serviceBudget.listNumber());
			return;
		} else if (field.compareTo("partnerName") == 0) {
			listPartnerName = new SimpleListModelCustom<Object>(serviceBudget.listPartnerName());
			return;
		} else if (field.compareTo("construction") == 0) {
			listConstruction = new SimpleListModelCustom<Object>(serviceBudget.listConstruction());
			return;
		} else if (field.compareTo("seller") == 0) {
			listSeller = new SimpleListModelCustom<Object>(serviceBudget.listSeller());
			return;
		}
	}

	@NotifyChange({ "listRifPartner", "listPartnerName" })
	@Command
	public void loadBusinessPartnerByField(@BindingParam("field") String field) {
		if (field.compareTo("rifPartner") == 0) {
			listRifPartner = new SimpleListModelCustom<Object>(serviceBusinessPartner.listRif());
		} else {
			listPartnerName = new SimpleListModelCustom<Object>(serviceBusinessPartner.listName());
		}
	}

	@NotifyChange("*")
	@Command
	public void searchBudget(@BindingParam("field") String field, @BindingParam("val") String value) {
		List<Budget> listBudget2 = new ArrayList<Budget>();
		if (field.compareTo("partnerName") == 0)
			listBudget2 = serviceBudget.listByPartnerName(value);
		else if (field.compareTo("construction") == 0)
			listBudget2 = serviceBudget.listByConstruction(value);
		else if (field.compareTo("seller") == 0)
			listBudget2 = serviceBudget.listBySeller(value);
		else if (field.compareTo("number") == 0){
			for (int i = 0; i < value.length(); i++) {
				if (!Character.isDigit(value.charAt(i))) {
					value = "0";
					break;
				}
			}
			Integer budgetNumber = Integer.parseInt(value);
			Budget auxBudget = serviceBudget.findByNumber(budgetNumber);
			if (auxBudget != null)
				listBudget2.add(auxBudget);
		}
		else if (field.compareTo("rif") == 0){
			listBudget2 = serviceBudget.listByRifPartner(value);
		}
		searchGeneric(listBudget2);
	}

	public void searchGeneric(List<Budget> list) {
		int listSize = list.size();
		if (listSize == 1) {
			budget = list.get(0);
			disableAfterSearch = new Boolean(true);
			disabledNumber = new Boolean(true);
			disableSeller = new Boolean(true);
		} else if (listSize == 0) {
			Clients.showNotification("Ningun registro coincide", "info", null, "top_center", 2000);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("listBudget", list);
			Executions.createComponents("system/ventas/solicitud/frmWindowBudgets.zul", null, map);
		}
	}

	@NotifyChange({ "budget", "budgetNumber", "disableAfterSearch", "disabledNumber", "disableSeller", "listRoofType", "listBoothDisplay", "listFloorDisplay", "cabinModel", "listDesign" })
	@GlobalCommand
	public void selectedBudget(@BindingParam("Budget") Budget budget) {
		this.budget = serviceBudget.findByNumber(budget.getNumber());
		disableAfterSearch = new Boolean(true);
		disabledNumber = new Boolean(true);
		disableSeller = new Boolean(true);
		listRoofType.add(this.budget.getBasicDataByRoofType());
		listBoothDisplay.add(this.budget.getBasicDataByBoothDisplay());
		listFloorDisplay.add(this.budget.getBasicDataByFloorDisplay());
		if (this.budget.getBasicDataByCabinDesign() != null) {
			cabinModel = this.budget.getBasicDataByCabinDesign().getBasicData();
			listDesign.add(this.budget.getBasicDataByCabinDesign());
		}
	}	

	@Command
	public void close() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "");
		BindUtils.postGlobalCommand(null, null, "selectedPage", map);
	}

	@Command
	public void isStopSequenceContinuous() {
		budget.setStopSequenceEven(false);
		budget.setStopSequenceOdd(false);
		budget.setStopSequenceEvenNumber(0);
		budget.setStopSequenceOddNumber(0);
		budget.setStopSequenceEvenQ(new String());
		budget.setStopSequenceOddQ(new String());
		if (!budget.getStopSequenceContinuous()) {
			budget.setStopSequenceContinuousQ(new String());
			budget.setStopSequenceContinuousNumber(0);
		}
	}

	@Command
	public void createPdf() throws SQLException {
		/* Se debe tomar la sesion a partir de Hibernate CORREGIR */
		Integer number = budget.getNumber();
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ascensor_nardi", "ascensor_admin", "leyner.18654277");
		String string = Sessions.getCurrent().getWebApp().getRealPath("/resource/reports/ventas/solicitud");
		JasperReport jasperReport;
		try {
			jasperReport = (JasperReport) JRLoader.loadObjectFromFile(string + "/budget.jasper");
		} catch (JRException e) {
			jasperReport = null;
			System.out.println("budget.jasper didn't find");
		}
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("NUMBER", number);
		/*
		 * Enviamos por parametro a ireport la ruta de la ubicacion de los subreportes e imagenes.
		 */
		parameters.put("REPORT_TITLE", "Solicitud Presupuesto");
		parameters.put("IMAGES_DIR", "../../resource/images/system/reports/");
		parameters.put("SUBREPORT_DIR", "../../resource/reports/ventas/solicitud/");
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
		jrExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, string + "/presupuesto" + number + ".pdf");
		File file = new File(string + "/presupuesto" + number + ".pdf");
		/* Eliminamos el pdf si ya existia, puesto que no se sobreescribe. */
		if (file.isFile())
			file.delete();
		try {
			jrExporter.exportReport();
		} catch (JRException e) {
			System.out.println("Report wasn't export.");
		}
		connection.close();
	}

	@Command
	public void print() throws SQLException {
		createPdf();
		String report = new String("/resource/reports/ventas/solicitud/presupuesto" + budget.getNumber() + ".pdf");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reportPath", report);
		map.put("reportTitle", "Solicitud de presupuesto");
		map.put("absolutePath", Sessions.getCurrent().getWebApp().getRealPath("/resource/reports/ventas/solicitud/") + "/presupuesto" + budget.getNumber() + ".pdf");
		Executions.createComponents("system/frmReport.zul", null, map);
	}

	@NotifyChange({ "listDesign" })
	@Command
	public void loadCabinDesign() {
		listDesign = serviceBasicData.listDesignByModel(cabinModel);
		/*
		 * No asigno un nuevo OBJETO en lugar de "null" puesto que me da error al guardar el objeto budget
		 */
		budget.setBasicDataByCabinDesign(null);
	}

	@Command
	public void selectDoorType(@BindingParam("doorType") String doorType) {
		if (doorType.compareTo("BATIENTE IZQUIERDA") == 0 || doorType.compareTo("BATIENTE DERECHA") == 0 || doorType.compareTo("GUILLOTINA") == 0 || doorType.compareTo("SANTA MARIA") == 0)
			budget.setBasicDataByDoorSystem(serviceBasicData.findByDoorSystem("NO APLICA"));
		else
			budget.setBasicDataByDoorSystem(null);
		BindUtils.postNotifyChange(null, null, budget, "basicDataByDoorSystem");
	}

	@Command
	public void changeTour(@BindingParam("tour") Double tour) {
		if (tour >= 24)
			budget.setFirefighterKeychain(true);
		else
			budget.setFirefighterKeychain(false);
		BindUtils.postNotifyChange(null, null, budget, "firefighterKeychain");
	}

	@NotifyChange({ "listBoothDisplay", "listFloorDisplay" })
	@Command
	public void loadBoothFloorDisplay() {
		String controlType = budget.getBasicDataByControlType().getName();
		if (controlType.indexOf("SISTEL") != -1) {
			listBoothDisplay = serviceBasicData.listBoothDisplaySistel();
			listFloorDisplay = serviceBasicData.listFloorDisplaySistel();
		} else if (controlType.indexOf("CF CONTROL") != -1) {
			listBoothDisplay = serviceBasicData.listBoothDisplayCF();
			listFloorDisplay = serviceBasicData.listFloorDisplayCF();
		} else {
			listBoothDisplay = new ArrayList<BasicData>();
			listFloorDisplay = new ArrayList<BasicData>();
		}
		budget.setBasicDataByBoothDisplay(null);
		budget.setBasicDataByFloorDisplay(null);
	}

	@NotifyChange({ "isSpecial" })
	@Command
	public void isSpecial() {
		if (budget.getBasicDataByDoorframeType() != null)
			if (budget.getBasicDataByDoorframeType().getName().indexOf("ESPECIAL") != -1)
				isSpecial = new Boolean(true);
			else {
				isSpecial = new Boolean(false);
				budget.setDoorframeTypeComment(new String());
			}
	}

	@Command
	public void checkWidthDoorFrame(@BindingParam("component") InputElement component) {
		if (budget.getBasicDataByDoorframeType() != null && budget.getBasicDataByDoorframeType().getName().indexOf("RECTO - 30X150") != -1 && budget.getHallButtonPlace().indexOf("MARCO") != -1) {
			throw new WrongValueException(component, "Este tipo no puede ser ubicado en el Marco.");
		}
	}

	@NotifyChange("disableSistelHall")
	@Command
	public void disabledSistelsHall() {
		if (budget.getBasicDataByHallButtonType().getName().indexOf("SISTEL") != -1)
			disableSistelHall = false;
		else {
			disableSistelHall = true;
			budget.setSistelWarrowPb(false);
			budget.setSistelWarrowFloor(0);
			budget.setSistelWdisplayPb(false);
			budget.setSistelWdisplayFloor(0);
		}
	}

	@Command
	public void updateMotorQuantity(@ContextParam(ContextType.TRIGGER_EVENT) InputEvent event) {
		/*
		 * Con la linea superior enlazo el evento sobre el input con el controlador Ver: http://forum.zkoss
		 * .org/question/79590/textbox-onchanging-event-doesnt-work-properly/
		 */
		if (budget.isType()) {
			Integer value = new Integer(0);
			if (!event.getValue().isEmpty())
				value = Integer.parseInt(event.getValue());
			budget.setMotorQuantity(value);
			BindUtils.postNotifyChange(null, null, budget, "motorQuantity");
		}
	}

	@Command
	public void activeDesignComment() {
		String cabinDesign = new String();
		String floorType = new String();
		if (budget.getBasicDataByCabinDesign() != null)
			cabinDesign = budget.getBasicDataByCabinDesign().getName();
		if (budget.getBasicDataByFloorType() != null)
			floorType = budget.getBasicDataByFloorType().getName();
		if (cabinDesign.indexOf("FORMICA") != -1 || cabinDesign.indexOf("OTRO") != -1 || floorType.indexOf("OTROS") != -1)
			budget.setDesignSpecial(true);
		/*
		 * IMPORTANTE Solo actualizao una propiedad del objeto BUDGET, mas no todo el objeto
		 */
		BindUtils.postNotifyChange(null, null, budget, "designSpecial");
	}

	@Command
	public void isDesignSpecial() {
		budget.setDesignSpecialComment(" ");
	}

	@Command
	public void searchBusinessPartner(@BindingParam("val") String value, @BindingParam("field") String field) {
		if (field.equals("rif"))
			businessPartner = serviceBusinessPartner.findActiveByRif(value);
		else
			businessPartner = serviceBusinessPartner.findActiveByName(value);
		if (businessPartner == null) {
			Executions.createComponents("system/socios/frmBusinessPartner.zul", null, null);
		} else {
			budget.setPartnerName(businessPartner.getName());
			budget.setRifPartner(businessPartner.getRif());
			budget.setRifType(businessPartner.getBasicData().getName().charAt(0));
			BindUtils.postNotifyChange(null, null, budget, "partnerName");
			BindUtils.postNotifyChange(null, null, budget, "rifType");
			BindUtils.postNotifyChange(null, null, budget, "rifPartner");
		}
	}

	@GlobalCommand
	public void selectedBusinessPartner(@BindingParam("BusinessPartner") BusinessPartner businessPartner) {
		if (businessPartner != null) {
			this.businessPartner = serviceBusinessPartner.findById(businessPartner.getIdBusinessPartner());
			budget.setPartnerName(this.businessPartner.getName());
			budget.setRifPartner(this.businessPartner.getRif());
			budget.setRifType(this.businessPartner.getBasicData().getName().charAt(0));
		} else {
			budget.setPartnerName(null);
			budget.setRifPartner("");
			budget.setRifType('-');
		}
		BindUtils.postNotifyChange(null, null, budget, "partnerName");
		BindUtils.postNotifyChange(null, null, budget, "rifType");
		BindUtils.postNotifyChange(null, null, budget, "rifPartner");
	}

	@NotifyChange("*")
	@Command
	public void copy() {
		Budget auxBudget = this.budget;
		restartForm();
		this.budget = auxBudget;
		List<Budget> listAllBudget = serviceBudget.listAll();
		budget.setNumber(listAllBudget.get(listAllBudget.size() - 1).getNumber() + 1);
		budget.setDate(new Date());
		/* Recargamos todas las listas dependientes de lo seleccionado en el budget */
		if (this.budget.getBasicDataByCabinDesign() != null) {
			cabinModel = this.budget.getBasicDataByCabinDesign().getBasicData();
			listDesign = serviceBasicData.listDesignByModel(cabinModel);
		}
		String elevatorCapacitance = new String(budget.getBasicDataByElevatorCapacitance().getName());
		if (elevatorCapacitance.indexOf("320 Kg - 4 Pers") != -1 || elevatorCapacitance.indexOf("450 Kg - 6 Pers") != -1 || elevatorCapacitance.indexOf("600 Kg - 8 Pers") != -1) {
			listFan = serviceBasicData.listFan1();
			listRoofType = serviceBasicData.listRoofTypeByElevatorCapacitance(budget.getBasicDataByElevatorCapacitance());
		} else if (elevatorCapacitance.indexOf("OTRA") != -1) {
			listFan = serviceBasicData.listFan1();
			listFan.addAll(serviceBasicData.listFan2());
			/*
			 * Escogemos el basicdata con name "450-6" puesto que es el que tiene todos los roofType
			 * asignados. Esto se hace porque no se sabra que tipo de Capacidad se anadira.
			 */
			listRoofType = serviceBasicData.listRoofTypeByElevatorCapacitance(serviceBasicData.findByElevatorCapacitance("450 Kg - 6 Pers"));
		} else {
			listFan = serviceBasicData.listFan2();
			listRoofType = serviceBasicData.listRoofTypeByElevatorCapacitance(budget.getBasicDataByElevatorCapacitance());
		}
		String controlType = budget.getBasicDataByControlType().getName();
		if (controlType.indexOf("SISTEL") != -1) {
			listBoothDisplay = serviceBasicData.listBoothDisplaySistel();
			listFloorDisplay = serviceBasicData.listFloorDisplaySistel();
		} else if (controlType.indexOf("CF CONTROL") != -1) {
			listBoothDisplay = serviceBasicData.listBoothDisplayCF();
			listFloorDisplay = serviceBasicData.listFloorDisplayCF();
		} else {
			listBoothDisplay = new ArrayList<BasicData>();
			listFloorDisplay = new ArrayList<BasicData>();
		}
	}
}