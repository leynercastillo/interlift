package model.service;

import java.util.List;

import model.dao.DaoBasicdata;
import model.database.BasicData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceBasicData {

	@Autowired
	private DaoBasicdata daoBasicdata;
	
	@Transactional
	public Boolean save(BasicData basicData) {
		
		if (basicData.getIdBasic() == 0)
			return daoBasicdata.save(basicData);
		else 
			return daoBasicdata.update(basicData);
		
	}

	public BasicData findById(int id){
		return daoBasicdata.findByField("idBasic", id);
	}
	
	@Transactional(readOnly = true)
	public BasicData findByDoorSystem(String doorSystem) {
		return daoBasicdata.findByName("BUDGET", "DOOR SYSTEM", doorSystem);
	}

	@Transactional(readOnly = true)
	public BasicData findByElevatorCapacitance(String capacitance) {
		return daoBasicdata.findByName("BUDGET", "ELEVATOR CAPACITANCE", capacitance);
	}

	@Transactional(readOnly = true)
	public List<BasicData> listPriceType() {
		return daoBasicdata.listByFieldTable("ITEM", "PRICE TYPE");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listNames(String name) {
		return daoBasicdata.listByFieldValue("name", name);
	}

	@Transactional(readOnly = true)
	public List<String> listNamesByBudgetComponent() {
		return daoBasicdata.listFieldByDataBase("BUDGET", "dataBaseName");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listRifType() {
		return daoBasicdata.listByFieldTable("BUSINESS PARTNER", "RIF TYPE");
	}
//ana
	@Transactional(readOnly = true)
	public List<BasicData> listNitType() {
		return daoBasicdata.listByFieldTable("BUSINESS PARTNER", "NIT TYPE");
	}
//ana
	@Transactional(readOnly = true)
	public List<BasicData> listRoofType() {
		return daoBasicdata.listByFieldTable("BUDGET", "ROOF TYPE");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listElevatorCapacitance() {
		return daoBasicdata.listByFieldTable("BUDGET", "ELEVATOR CAPACITANCE");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listSpeed() {
		return daoBasicdata.listByFieldTable("BUDGET", "SPEED");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listManeuverType() {
		return daoBasicdata.listByFieldTable("BUDGET", "MANEUVER TYPE");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listHallButton() {
		return daoBasicdata.listByFieldTable("BUDGET", "HALL BUTTON");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listMachineType() {
		return daoBasicdata.listByFieldTable("BUDGET", "MACHINE TYPE");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listElectricityType() {
		return daoBasicdata.listByFieldTable("BUDGET", "ELECTRICITY TYPE");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listCabinModel() {
		return daoBasicdata.listByFieldTable("BUDGET", "CABIN MODEL");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listRailing() {
		return daoBasicdata.listByFieldTable("BUDGET", "RAILING");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listFloorType() {
		return daoBasicdata.listByFieldTable("BUDGET", "FLOOR TYPE");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listDoorType() {
		return daoBasicdata.listByFieldTable("BUDGET", "DOOR TYPE");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listFreeAdmission() {
		return daoBasicdata.listByFieldTable("BUDGET", "FREE ADMISSION");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listHeight() {
		return daoBasicdata.listByFieldTable("BUDGET", "HEIGHT");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listDoorframeHammered() {
		return daoBasicdata.listByFieldTable("BUDGET", "DOOR FRAME HAMMERED");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listElevatorType() {
		return daoBasicdata.listByFieldTable("BUDGET", "ELEVATOR TYPE");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listHallButtonType() {
		return daoBasicdata.listByFieldTable("BUDGET", "HALL BUTTON TYPE");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listControlType() {
		return daoBasicdata.listByFieldTable("BUDGET", "CONTROL TYPE");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listBoothDisplay() {
		return daoBasicdata.listByFieldTable("BUDGET", "BOOTH DISPLAY");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listFloorDisplay() {
		return daoBasicdata.listByFieldTable("BUDGET", "FLOOR DISPLAY");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listBuildingType() {
		return daoBasicdata.listByFieldTable("BUDGET", "BUILDING TYPE");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listMachineBase() {
		return daoBasicdata.listByFieldTable("BUDGET", "MACHINE BASE");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listFrequency() {
		return daoBasicdata.listByFieldTable("BUDGET", "FREQUENCY");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listVoltageLighting() {
		return daoBasicdata.listByFieldTable("BUDGET", "VOLTAGE LIGHTING");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listAccess() {
		return daoBasicdata.listByFieldTable("BUDGET", "BUILDING EMBARQUE");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listHourMachine() {
		return daoBasicdata.listByFieldTable("BUDGET", "HOUR MACHINE");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listButtonType() {
		return daoBasicdata.listByFieldTable("BUDGET", "BUTTON TYPE");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listMirror() {
		return daoBasicdata.listByFieldTable("BUDGET", "MIRROR");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listDoorframeType() {
		return daoBasicdata.listByFieldTable("BUDGET", "DOOR FRAME TYPE");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listDoorSystem() {
		return daoBasicdata.listByFieldTable("BUDGET", "DOOR SYSTEM");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listBoothButton() {
		return daoBasicdata.listByFieldTable("BUDGET", "BOOTH BUTTON");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listMotorTraction() {
		return daoBasicdata.listByFieldTable("BUDGET", "MOTOR TRACTION");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listFan() {
		return daoBasicdata.listByFieldTable("BUDGET", "FAN");
	}


	@Transactional(readOnly = true)
	public List<BasicData> listRoofTypeByElevatorCapacitance(BasicData elevatorCapacitance) {
		if (elevatorCapacitance.getName().equals("OTRA"))
			return daoBasicdata.listByParent(findByElevatorCapacitance("450 Kg - 6 Pers"));
		else
			return daoBasicdata.listByParent(elevatorCapacitance);
	}

	@Transactional(readOnly = true)
	public List<BasicData> listDesign() {
		return daoBasicdata.listByFieldTable("BUDGET", "DESIGN");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listQuotationTypeMoney() {
		return daoBasicdata.listByFieldTable("QUOTATION", "QUOTATION TYPE MONEY");
	}
	
	@Transactional(readOnly = true)
	public BasicData findByQuotationTypeNotes() {
		return daoBasicdata.findByFieldTable("QUOTATION", "QUOTATION TYPE NOTES");
	}
	
	@Transactional(readOnly = true)
	public BasicData findByQuotationTypePayment() {
		return daoBasicdata.findByFieldTable("QUOTATION", "QUOTATION TYPE PAYMENT");
	}
	
	@Transactional(readOnly = true)
	public BasicData findByQuotationTypeWarranty() {
		return daoBasicdata.findByFieldTable("QUOTATION", "QUOTATION TYPE WARRANTY");
	}
	
	@Transactional(readOnly = true)
	public BasicData findByQuotationTypeExtendedWarranty() {
		return daoBasicdata.findByFieldTable("QUOTATION", "QUOTATION TYPE EXTENDED WARRANTY");
	}
	
	@Transactional(readOnly = true)
	public BasicData findByQuotationTypeDeliveryEstimate() {
		return daoBasicdata.findByFieldTable("QUOTATION", "QUOTATION TYPE DELIVERY ESTIMATE");
	}
	
	@Transactional(readOnly = true)
	public BasicData findByQuotationTypeValidity() {
		return daoBasicdata.findByFieldTable("QUOTATION", "QUOTATION TYPE VALIDITY");
	}
	
	@Transactional(readOnly = true)
	public List<BasicData> listQuotationTypePresupuesto() {
		return daoBasicdata.listByFieldTable("QUOTATION", "QUOTATION TYPE");
	}
	
	@Transactional(readOnly = true)
	public List<BasicData> listDesignByModel(BasicData model) {
		return daoBasicdata.listByParent(model);
	}

	@Transactional(readOnly = true)
	public List<BasicData> listFan1() {
		return daoBasicdata.listByFieldTable("BUDGET", "FAN 1");
	}

	@Transactional(readOnly = true)
	public List<BasicData> listFan2() {
		return daoBasicdata.listByFieldTable("BUDGET", "FAN 2");
	}
	
	
	
	
}