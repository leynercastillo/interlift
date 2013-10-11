package model.database;

// Generated 11-oct-2013 10:33:55 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * BasicData generated by hbm2java
 */
@Entity
@Table(name = "basic_data", schema = "public")
public class BasicData implements java.io.Serializable {

	private static final long serialVersionUID = -3178387161743077228L;
	private int idBasic;
	private BasicData basicData;
	private String dataBaseName;
	private String name;
	private String field;
	private boolean editable;
	private int priority;
	private String imageurl;
	private char status;
	private Set<Quotation> quotationsForElectricityType = new HashSet<Quotation>(0);
	private Set<Quotation> quotationsForRailing = new HashSet<Quotation>(0);
	private Set<Quotation> quotationsForRoofType = new HashSet<Quotation>(0);
	private Set<Quotation> quotationsForFloorType = new HashSet<Quotation>(0);
	private Set<Quotation> quotationsForDoorType = new HashSet<Quotation>(0);
	private Set<Budget> budgetsForHeight = new HashSet<Budget>(0);
	private Set<Budget> budgetsForFreeAdmission = new HashSet<Budget>(0);
	private Set<Quotation> quotationsForElevatorType = new HashSet<Quotation>(0);
	private Set<Budget> budgetsForSpeed = new HashSet<Budget>(0);
	private Set<Item> items = new HashSet<Item>(0);
	private Set<Item> items_1 = new HashSet<Item>(0);
	private Set<Quotation> quotationsForCabinDesign = new HashSet<Quotation>(0);
	private Set<Budget> budgetsForFloorType = new HashSet<Budget>(0);
	private Set<Quotation> quotationsForMirror = new HashSet<Quotation>(0);
	private Set<Budget> budgetsForDoorSystem = new HashSet<Budget>(0);
	private Set<Quotation> quotationsForDoorFrameHammered = new HashSet<Quotation>(0);
	private Set<Budget> budgetsForDoorframeType = new HashSet<Budget>(0);
	private Set<Quotation> quotationsForHeight = new HashSet<Quotation>(0);
	private Set<Budget> budgetsForControlType = new HashSet<Budget>(0);
	private Set<Budget> budgetsForBoothButton = new HashSet<Budget>(0);
	private Set<Quotation> quotationsForFreeAdmission = new HashSet<Quotation>(0);
	private Set<Budget> budgetsForBoothDisplay = new HashSet<Budget>(0);
	private Set<Budget> budgetsForFloorDisplay = new HashSet<Budget>(0);
	private Set<Quotation> quotationsForDoorframeType = new HashSet<Quotation>(0);
	private Set<Budget> budgetsForFan = new HashSet<Budget>(0);
	private Set<Budget> budgetsForDoorType = new HashSet<Budget>(0);
	private Set<Budget> budgetsForVoltageLighting = new HashSet<Budget>(0);
	private Set<Budget> budgetsForFrequency = new HashSet<Budget>(0);
	private Set<Budget> budgetsForHourMachine = new HashSet<Budget>(0);
	private Set<Budget> budgetsForMirror = new HashSet<Budget>(0);
	private Set<Budget> budgetsForRailing = new HashSet<Budget>(0);
	private Set<Budget> budgetsForButtonType = new HashSet<Budget>(0);
	private Set<Budget> budgetsForRoofType = new HashSet<Budget>(0);
	private Set<Budget> budgetsForHallButtonType = new HashSet<Budget>(0);
	private Set<Budget> budgetsForCabinDesign = new HashSet<Budget>(0);
	private Set<Budget> budgetsForManeuverType = new HashSet<Budget>(0);
	private Set<Budget> budgetsForHallButton = new HashSet<Budget>(0);
	private Set<BasicData> basicDatas = new HashSet<BasicData>(0);
	private Set<Quotation> quotationsForHallButtonType = new HashSet<Quotation>(0);
	private Set<Budget> budgetsForBuildingType = new HashSet<Budget>(0);
	private Set<Quotation> quotationsForFloorDisplay = new HashSet<Quotation>(0);
	private Set<Budget> budgetsForElevatorType = new HashSet<Budget>(0);
	private Set<Quotation> quotationsForBoothDisplay = new HashSet<Quotation>(0);
	private Set<Budget> budgetsForElevatorCapacitance = new HashSet<Budget>(0);
	private Set<Quotation> quotationsForControlType = new HashSet<Quotation>(0);
	private Set<Budget> budgetsForDoorFrameHammered = new HashSet<Budget>(0);
	private Set<Budget> budgetsForMachineType = new HashSet<Budget>(0);
	private Set<Budget> budgetsForAccess = new HashSet<Budget>(0);
	private Set<Quotation> quotationsForMachineType = new HashSet<Quotation>(0);
	private Set<Budget> budgetsForElectricityType = new HashSet<Budget>(0);
	private Set<Budget> budgetsForCabinModel = new HashSet<Budget>(0);
	private Set<Quotation> quotationsForHallButton = new HashSet<Quotation>(0);
	private Set<Quotation> quotationsForManeuverType = new HashSet<Quotation>(0);
	private Set<Quotation> quotationsForSpeed = new HashSet<Quotation>(0);
	private Set<Budget> budgetsForMachineBase = new HashSet<Budget>(0);
	private Set<Quotation> quotationsForElevatorCapacitance = new HashSet<Quotation>(0);

	public BasicData() {
	}

	public BasicData(int idBasic, String dataBaseName, String name, String field, boolean editable, int priority, char status) {
		this.idBasic = idBasic;
		this.dataBaseName = dataBaseName;
		this.name = name;
		this.field = field;
		this.editable = editable;
		this.priority = priority;
		this.status = status;
	}

	public BasicData(int idBasic, BasicData basicData, String dataBaseName, String name, String field, boolean editable, int priority, String imageurl, char status, Set<Quotation> quotationsForElectricityType, Set<Quotation> quotationsForRailing, Set<Quotation> quotationsForRoofType, Set<Quotation> quotationsForFloorType, Set<Quotation> quotationsForDoorType, Set<Budget> budgetsForHeight, Set<Budget> budgetsForFreeAdmission, Set<Quotation> quotationsForElevatorType, Set<Budget> budgetsForSpeed, Set<Item> items, Set<Item> items_1, Set<Quotation> quotationsForCabinDesign, Set<Budget> budgetsForFloorType, Set<Quotation> quotationsForMirror, Set<Budget> budgetsForDoorSystem, Set<Quotation> quotationsForDoorFrameHammered, Set<Budget> budgetsForDoorframeType, Set<Quotation> quotationsForHeight, Set<Budget> budgetsForControlType, Set<Budget> budgetsForBoothButton, Set<Quotation> quotationsForFreeAdmission, Set<Budget> budgetsForBoothDisplay, Set<Budget> budgetsForFloorDisplay, Set<Quotation> quotationsForDoorframeType, Set<Budget> budgetsForFan, Set<Budget> budgetsForDoorType, Set<Budget> budgetsForVoltageLighting, Set<Budget> budgetsForFrequency, Set<Budget> budgetsForHourMachine, Set<Budget> budgetsForMirror, Set<Budget> budgetsForRailing, Set<Budget> budgetsForButtonType, Set<Budget> budgetsForRoofType, Set<Budget> budgetsForHallButtonType, Set<Budget> budgetsForCabinDesign, Set<Budget> budgetsForManeuverType, Set<Budget> budgetsForHallButton, Set<BasicData> basicDatas, Set<Quotation> quotationsForHallButtonType, Set<Budget> budgetsForBuildingType, Set<Quotation> quotationsForFloorDisplay, Set<Budget> budgetsForElevatorType, Set<Quotation> quotationsForBoothDisplay, Set<Budget> budgetsForElevatorCapacitance, Set<Quotation> quotationsForControlType, Set<Budget> budgetsForDoorFrameHammered, Set<Budget> budgetsForMachineType, Set<Budget> budgetsForAccess, Set<Quotation> quotationsForMachineType, Set<Budget> budgetsForElectricityType, Set<Budget> budgetsForCabinModel, Set<Quotation> quotationsForHallButton, Set<Quotation> quotationsForManeuverType, Set<Quotation> quotationsForSpeed, Set<Budget> budgetsForMachineBase, Set<Quotation> quotationsForElevatorCapacitance) {
		this.idBasic = idBasic;
		this.basicData = basicData;
		this.dataBaseName = dataBaseName;
		this.name = name;
		this.field = field;
		this.editable = editable;
		this.priority = priority;
		this.imageurl = imageurl;
		this.status = status;
		this.quotationsForElectricityType = quotationsForElectricityType;
		this.quotationsForRailing = quotationsForRailing;
		this.quotationsForRoofType = quotationsForRoofType;
		this.quotationsForFloorType = quotationsForFloorType;
		this.quotationsForDoorType = quotationsForDoorType;
		this.budgetsForHeight = budgetsForHeight;
		this.budgetsForFreeAdmission = budgetsForFreeAdmission;
		this.quotationsForElevatorType = quotationsForElevatorType;
		this.budgetsForSpeed = budgetsForSpeed;
		this.items = items;
		this.items_1 = items_1;
		this.quotationsForCabinDesign = quotationsForCabinDesign;
		this.budgetsForFloorType = budgetsForFloorType;
		this.quotationsForMirror = quotationsForMirror;
		this.budgetsForDoorSystem = budgetsForDoorSystem;
		this.quotationsForDoorFrameHammered = quotationsForDoorFrameHammered;
		this.budgetsForDoorframeType = budgetsForDoorframeType;
		this.quotationsForHeight = quotationsForHeight;
		this.budgetsForControlType = budgetsForControlType;
		this.budgetsForBoothButton = budgetsForBoothButton;
		this.quotationsForFreeAdmission = quotationsForFreeAdmission;
		this.budgetsForBoothDisplay = budgetsForBoothDisplay;
		this.budgetsForFloorDisplay = budgetsForFloorDisplay;
		this.quotationsForDoorframeType = quotationsForDoorframeType;
		this.budgetsForFan = budgetsForFan;
		this.budgetsForDoorType = budgetsForDoorType;
		this.budgetsForVoltageLighting = budgetsForVoltageLighting;
		this.budgetsForFrequency = budgetsForFrequency;
		this.budgetsForHourMachine = budgetsForHourMachine;
		this.budgetsForMirror = budgetsForMirror;
		this.budgetsForRailing = budgetsForRailing;
		this.budgetsForButtonType = budgetsForButtonType;
		this.budgetsForRoofType = budgetsForRoofType;
		this.budgetsForHallButtonType = budgetsForHallButtonType;
		this.budgetsForCabinDesign = budgetsForCabinDesign;
		this.budgetsForManeuverType = budgetsForManeuverType;
		this.budgetsForHallButton = budgetsForHallButton;
		this.basicDatas = basicDatas;
		this.quotationsForHallButtonType = quotationsForHallButtonType;
		this.budgetsForBuildingType = budgetsForBuildingType;
		this.quotationsForFloorDisplay = quotationsForFloorDisplay;
		this.budgetsForElevatorType = budgetsForElevatorType;
		this.quotationsForBoothDisplay = quotationsForBoothDisplay;
		this.budgetsForElevatorCapacitance = budgetsForElevatorCapacitance;
		this.quotationsForControlType = quotationsForControlType;
		this.budgetsForDoorFrameHammered = budgetsForDoorFrameHammered;
		this.budgetsForMachineType = budgetsForMachineType;
		this.budgetsForAccess = budgetsForAccess;
		this.quotationsForMachineType = quotationsForMachineType;
		this.budgetsForElectricityType = budgetsForElectricityType;
		this.budgetsForCabinModel = budgetsForCabinModel;
		this.quotationsForHallButton = quotationsForHallButton;
		this.quotationsForManeuverType = quotationsForManeuverType;
		this.quotationsForSpeed = quotationsForSpeed;
		this.budgetsForMachineBase = budgetsForMachineBase;
		this.quotationsForElevatorCapacitance = quotationsForElevatorCapacitance;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "basic_seq")
	@SequenceGenerator(name = "basic_seq", sequenceName = "basic_data_idbasic_seq")
	@Column(name = "id_basic", unique = true, nullable = false)
	public int getIdBasic() {
		return this.idBasic;
	}

	public void setIdBasic(int idBasic) {
		this.idBasic = idBasic;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id_basic")
	public BasicData getBasicData() {
		return this.basicData;
	}

	public void setBasicData(BasicData basicData) {
		this.basicData = basicData;
	}

	@Column(name = "data_base_name", nullable = false, length = 50)
	public String getDataBaseName() {
		return this.dataBaseName;
	}

	public void setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
	}

	@Column(name = "name", nullable = false, length = 150)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "field", nullable = false, length = 300)
	public String getField() {
		return this.field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Column(name = "editable", nullable = false)
	public boolean isEditable() {
		return this.editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	@Column(name = "priority", nullable = false)
	public int getPriority() {
		return this.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Column(name = "imageurl", length = 150)
	public String getImageurl() {
		return this.imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	@Column(name = "status", nullable = false, length = 1)
	public char getStatus() {
		return this.status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByElectricityType")
	public Set<Quotation> getQuotationsForElectricityType() {
		return this.quotationsForElectricityType;
	}

	public void setQuotationsForElectricityType(Set<Quotation> quotationsForElectricityType) {
		this.quotationsForElectricityType = quotationsForElectricityType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByRailing")
	public Set<Quotation> getQuotationsForRailing() {
		return this.quotationsForRailing;
	}

	public void setQuotationsForRailing(Set<Quotation> quotationsForRailing) {
		this.quotationsForRailing = quotationsForRailing;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByRoofType")
	public Set<Quotation> getQuotationsForRoofType() {
		return this.quotationsForRoofType;
	}

	public void setQuotationsForRoofType(Set<Quotation> quotationsForRoofType) {
		this.quotationsForRoofType = quotationsForRoofType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByFloorType")
	public Set<Quotation> getQuotationsForFloorType() {
		return this.quotationsForFloorType;
	}

	public void setQuotationsForFloorType(Set<Quotation> quotationsForFloorType) {
		this.quotationsForFloorType = quotationsForFloorType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByDoorType")
	public Set<Quotation> getQuotationsForDoorType() {
		return this.quotationsForDoorType;
	}

	public void setQuotationsForDoorType(Set<Quotation> quotationsForDoorType) {
		this.quotationsForDoorType = quotationsForDoorType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByHeight")
	public Set<Budget> getBudgetsForHeight() {
		return this.budgetsForHeight;
	}

	public void setBudgetsForHeight(Set<Budget> budgetsForHeight) {
		this.budgetsForHeight = budgetsForHeight;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByFreeAdmission")
	public Set<Budget> getBudgetsForFreeAdmission() {
		return this.budgetsForFreeAdmission;
	}

	public void setBudgetsForFreeAdmission(Set<Budget> budgetsForFreeAdmission) {
		this.budgetsForFreeAdmission = budgetsForFreeAdmission;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByElevatorType")
	public Set<Quotation> getQuotationsForElevatorType() {
		return this.quotationsForElevatorType;
	}

	public void setQuotationsForElevatorType(Set<Quotation> quotationsForElevatorType) {
		this.quotationsForElevatorType = quotationsForElevatorType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataBySpeed")
	public Set<Budget> getBudgetsForSpeed() {
		return this.budgetsForSpeed;
	}

	public void setBudgetsForSpeed(Set<Budget> budgetsForSpeed) {
		this.budgetsForSpeed = budgetsForSpeed;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicData")
	public Set<Item> getItems() {
		return this.items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "basicDatas")
	public Set<Item> getItems_1() {
		return this.items_1;
	}

	public void setItems_1(Set<Item> items_1) {
		this.items_1 = items_1;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByCabinDesign")
	public Set<Quotation> getQuotationsForCabinDesign() {
		return this.quotationsForCabinDesign;
	}

	public void setQuotationsForCabinDesign(Set<Quotation> quotationsForCabinDesign) {
		this.quotationsForCabinDesign = quotationsForCabinDesign;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByFloorType")
	public Set<Budget> getBudgetsForFloorType() {
		return this.budgetsForFloorType;
	}

	public void setBudgetsForFloorType(Set<Budget> budgetsForFloorType) {
		this.budgetsForFloorType = budgetsForFloorType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByMirror")
	public Set<Quotation> getQuotationsForMirror() {
		return this.quotationsForMirror;
	}

	public void setQuotationsForMirror(Set<Quotation> quotationsForMirror) {
		this.quotationsForMirror = quotationsForMirror;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByDoorSystem")
	public Set<Budget> getBudgetsForDoorSystem() {
		return this.budgetsForDoorSystem;
	}

	public void setBudgetsForDoorSystem(Set<Budget> budgetsForDoorSystem) {
		this.budgetsForDoorSystem = budgetsForDoorSystem;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByDoorFrameHammered")
	public Set<Quotation> getQuotationsForDoorFrameHammered() {
		return this.quotationsForDoorFrameHammered;
	}

	public void setQuotationsForDoorFrameHammered(Set<Quotation> quotationsForDoorFrameHammered) {
		this.quotationsForDoorFrameHammered = quotationsForDoorFrameHammered;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByDoorframeType")
	public Set<Budget> getBudgetsForDoorframeType() {
		return this.budgetsForDoorframeType;
	}

	public void setBudgetsForDoorframeType(Set<Budget> budgetsForDoorframeType) {
		this.budgetsForDoorframeType = budgetsForDoorframeType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByHeight")
	public Set<Quotation> getQuotationsForHeight() {
		return this.quotationsForHeight;
	}

	public void setQuotationsForHeight(Set<Quotation> quotationsForHeight) {
		this.quotationsForHeight = quotationsForHeight;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByControlType")
	public Set<Budget> getBudgetsForControlType() {
		return this.budgetsForControlType;
	}

	public void setBudgetsForControlType(Set<Budget> budgetsForControlType) {
		this.budgetsForControlType = budgetsForControlType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByBoothButton")
	public Set<Budget> getBudgetsForBoothButton() {
		return this.budgetsForBoothButton;
	}

	public void setBudgetsForBoothButton(Set<Budget> budgetsForBoothButton) {
		this.budgetsForBoothButton = budgetsForBoothButton;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByFreeAdmission")
	public Set<Quotation> getQuotationsForFreeAdmission() {
		return this.quotationsForFreeAdmission;
	}

	public void setQuotationsForFreeAdmission(Set<Quotation> quotationsForFreeAdmission) {
		this.quotationsForFreeAdmission = quotationsForFreeAdmission;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByBoothDisplay")
	public Set<Budget> getBudgetsForBoothDisplay() {
		return this.budgetsForBoothDisplay;
	}

	public void setBudgetsForBoothDisplay(Set<Budget> budgetsForBoothDisplay) {
		this.budgetsForBoothDisplay = budgetsForBoothDisplay;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByFloorDisplay")
	public Set<Budget> getBudgetsForFloorDisplay() {
		return this.budgetsForFloorDisplay;
	}

	public void setBudgetsForFloorDisplay(Set<Budget> budgetsForFloorDisplay) {
		this.budgetsForFloorDisplay = budgetsForFloorDisplay;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByDoorframeType")
	public Set<Quotation> getQuotationsForDoorframeType() {
		return this.quotationsForDoorframeType;
	}

	public void setQuotationsForDoorframeType(Set<Quotation> quotationsForDoorframeType) {
		this.quotationsForDoorframeType = quotationsForDoorframeType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByFan")
	public Set<Budget> getBudgetsForFan() {
		return this.budgetsForFan;
	}

	public void setBudgetsForFan(Set<Budget> budgetsForFan) {
		this.budgetsForFan = budgetsForFan;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByDoorType")
	public Set<Budget> getBudgetsForDoorType() {
		return this.budgetsForDoorType;
	}

	public void setBudgetsForDoorType(Set<Budget> budgetsForDoorType) {
		this.budgetsForDoorType = budgetsForDoorType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByVoltageLighting")
	public Set<Budget> getBudgetsForVoltageLighting() {
		return this.budgetsForVoltageLighting;
	}

	public void setBudgetsForVoltageLighting(Set<Budget> budgetsForVoltageLighting) {
		this.budgetsForVoltageLighting = budgetsForVoltageLighting;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByFrequency")
	public Set<Budget> getBudgetsForFrequency() {
		return this.budgetsForFrequency;
	}

	public void setBudgetsForFrequency(Set<Budget> budgetsForFrequency) {
		this.budgetsForFrequency = budgetsForFrequency;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByHourMachine")
	public Set<Budget> getBudgetsForHourMachine() {
		return this.budgetsForHourMachine;
	}

	public void setBudgetsForHourMachine(Set<Budget> budgetsForHourMachine) {
		this.budgetsForHourMachine = budgetsForHourMachine;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByMirror")
	public Set<Budget> getBudgetsForMirror() {
		return this.budgetsForMirror;
	}

	public void setBudgetsForMirror(Set<Budget> budgetsForMirror) {
		this.budgetsForMirror = budgetsForMirror;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByRailing")
	public Set<Budget> getBudgetsForRailing() {
		return this.budgetsForRailing;
	}

	public void setBudgetsForRailing(Set<Budget> budgetsForRailing) {
		this.budgetsForRailing = budgetsForRailing;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByButtonType")
	public Set<Budget> getBudgetsForButtonType() {
		return this.budgetsForButtonType;
	}

	public void setBudgetsForButtonType(Set<Budget> budgetsForButtonType) {
		this.budgetsForButtonType = budgetsForButtonType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByRoofType")
	public Set<Budget> getBudgetsForRoofType() {
		return this.budgetsForRoofType;
	}

	public void setBudgetsForRoofType(Set<Budget> budgetsForRoofType) {
		this.budgetsForRoofType = budgetsForRoofType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByHallButtonType")
	public Set<Budget> getBudgetsForHallButtonType() {
		return this.budgetsForHallButtonType;
	}

	public void setBudgetsForHallButtonType(Set<Budget> budgetsForHallButtonType) {
		this.budgetsForHallButtonType = budgetsForHallButtonType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByCabinDesign")
	public Set<Budget> getBudgetsForCabinDesign() {
		return this.budgetsForCabinDesign;
	}

	public void setBudgetsForCabinDesign(Set<Budget> budgetsForCabinDesign) {
		this.budgetsForCabinDesign = budgetsForCabinDesign;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByManeuverType")
	public Set<Budget> getBudgetsForManeuverType() {
		return this.budgetsForManeuverType;
	}

	public void setBudgetsForManeuverType(Set<Budget> budgetsForManeuverType) {
		this.budgetsForManeuverType = budgetsForManeuverType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByHallButton")
	public Set<Budget> getBudgetsForHallButton() {
		return this.budgetsForHallButton;
	}

	public void setBudgetsForHallButton(Set<Budget> budgetsForHallButton) {
		this.budgetsForHallButton = budgetsForHallButton;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicData")
	public Set<BasicData> getBasicDatas() {
		return this.basicDatas;
	}

	public void setBasicDatas(Set<BasicData> basicDatas) {
		this.basicDatas = basicDatas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByHallButtonType")
	public Set<Quotation> getQuotationsForHallButtonType() {
		return this.quotationsForHallButtonType;
	}

	public void setQuotationsForHallButtonType(Set<Quotation> quotationsForHallButtonType) {
		this.quotationsForHallButtonType = quotationsForHallButtonType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByBuildingType")
	public Set<Budget> getBudgetsForBuildingType() {
		return this.budgetsForBuildingType;
	}

	public void setBudgetsForBuildingType(Set<Budget> budgetsForBuildingType) {
		this.budgetsForBuildingType = budgetsForBuildingType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByFloorDisplay")
	public Set<Quotation> getQuotationsForFloorDisplay() {
		return this.quotationsForFloorDisplay;
	}

	public void setQuotationsForFloorDisplay(Set<Quotation> quotationsForFloorDisplay) {
		this.quotationsForFloorDisplay = quotationsForFloorDisplay;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByElevatorType")
	public Set<Budget> getBudgetsForElevatorType() {
		return this.budgetsForElevatorType;
	}

	public void setBudgetsForElevatorType(Set<Budget> budgetsForElevatorType) {
		this.budgetsForElevatorType = budgetsForElevatorType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByBoothDisplay")
	public Set<Quotation> getQuotationsForBoothDisplay() {
		return this.quotationsForBoothDisplay;
	}

	public void setQuotationsForBoothDisplay(Set<Quotation> quotationsForBoothDisplay) {
		this.quotationsForBoothDisplay = quotationsForBoothDisplay;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByElevatorCapacitance")
	public Set<Budget> getBudgetsForElevatorCapacitance() {
		return this.budgetsForElevatorCapacitance;
	}

	public void setBudgetsForElevatorCapacitance(Set<Budget> budgetsForElevatorCapacitance) {
		this.budgetsForElevatorCapacitance = budgetsForElevatorCapacitance;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByControlType")
	public Set<Quotation> getQuotationsForControlType() {
		return this.quotationsForControlType;
	}

	public void setQuotationsForControlType(Set<Quotation> quotationsForControlType) {
		this.quotationsForControlType = quotationsForControlType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByDoorFrameHammered")
	public Set<Budget> getBudgetsForDoorFrameHammered() {
		return this.budgetsForDoorFrameHammered;
	}

	public void setBudgetsForDoorFrameHammered(Set<Budget> budgetsForDoorFrameHammered) {
		this.budgetsForDoorFrameHammered = budgetsForDoorFrameHammered;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByMachineType")
	public Set<Budget> getBudgetsForMachineType() {
		return this.budgetsForMachineType;
	}

	public void setBudgetsForMachineType(Set<Budget> budgetsForMachineType) {
		this.budgetsForMachineType = budgetsForMachineType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByAccess")
	public Set<Budget> getBudgetsForAccess() {
		return this.budgetsForAccess;
	}

	public void setBudgetsForAccess(Set<Budget> budgetsForAccess) {
		this.budgetsForAccess = budgetsForAccess;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByMachineType")
	public Set<Quotation> getQuotationsForMachineType() {
		return this.quotationsForMachineType;
	}

	public void setQuotationsForMachineType(Set<Quotation> quotationsForMachineType) {
		this.quotationsForMachineType = quotationsForMachineType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByElectricityType")
	public Set<Budget> getBudgetsForElectricityType() {
		return this.budgetsForElectricityType;
	}

	public void setBudgetsForElectricityType(Set<Budget> budgetsForElectricityType) {
		this.budgetsForElectricityType = budgetsForElectricityType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByCabinModel")
	public Set<Budget> getBudgetsForCabinModel() {
		return this.budgetsForCabinModel;
	}

	public void setBudgetsForCabinModel(Set<Budget> budgetsForCabinModel) {
		this.budgetsForCabinModel = budgetsForCabinModel;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByHallButton")
	public Set<Quotation> getQuotationsForHallButton() {
		return this.quotationsForHallButton;
	}

	public void setQuotationsForHallButton(Set<Quotation> quotationsForHallButton) {
		this.quotationsForHallButton = quotationsForHallButton;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByManeuverType")
	public Set<Quotation> getQuotationsForManeuverType() {
		return this.quotationsForManeuverType;
	}

	public void setQuotationsForManeuverType(Set<Quotation> quotationsForManeuverType) {
		this.quotationsForManeuverType = quotationsForManeuverType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataBySpeed")
	public Set<Quotation> getQuotationsForSpeed() {
		return this.quotationsForSpeed;
	}

	public void setQuotationsForSpeed(Set<Quotation> quotationsForSpeed) {
		this.quotationsForSpeed = quotationsForSpeed;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByMachineBase")
	public Set<Budget> getBudgetsForMachineBase() {
		return this.budgetsForMachineBase;
	}

	public void setBudgetsForMachineBase(Set<Budget> budgetsForMachineBase) {
		this.budgetsForMachineBase = budgetsForMachineBase;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "basicDataByElevatorCapacitance")
	public Set<Quotation> getQuotationsForElevatorCapacitance() {
		return this.quotationsForElevatorCapacitance;
	}

	public void setQuotationsForElevatorCapacitance(Set<Quotation> quotationsForElevatorCapacitance) {
		this.quotationsForElevatorCapacitance = quotationsForElevatorCapacitance;
	}

}
