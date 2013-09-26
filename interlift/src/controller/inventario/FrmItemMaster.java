package controller.inventario;

import general.SimpleListModelCustom;
import general.ValidateZK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.database.BasicData;
import model.database.Item;
import model.service.ServiceBasicData;
import model.service.ServiceItem;

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
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.impl.InputElement;

public class FrmItemMaster {

	@WireVariable
	private ServiceItem serviceItem;
	@WireVariable
	private ServiceBasicData serviceBasicData;
	private String minCombo;
	private String seleccione;
	private Boolean disableAll;
	private Boolean disableBeforeSearch;
	private Item item;
	private Boolean update;
	private BasicData elevatorComponent;
	private List<BasicData> listPriceType;
	private ListModel<Object> listItemCode;
	private ListModel<Object> listItemName;
	private ListModel<Object> listComponents;

	public List<BasicData> getListPriceType() {
		return listPriceType;
	}

	public void setListPriceType(List<BasicData> listPriceType) {
		this.listPriceType = listPriceType;
	}

	public ListModel<Object> getListComponents() {
		return listComponents;
	}

	public void setListComponents(ListModel<Object> listComponents) {
		this.listComponents = listComponents;
	}

	public BasicData getElevatorComponent() {
		return elevatorComponent;
	}

	public void setElevatorComponent(BasicData elevatorComponent) {
		this.elevatorComponent = elevatorComponent;
	}

	public Boolean getDisableBeforeSearch() {
		return disableBeforeSearch;
	}

	public void setDisableBeforeSearch(Boolean disableBeforeSearch) {
		this.disableBeforeSearch = disableBeforeSearch;
	}

	public ListModel<Object> getListItemName() {
		return listItemName;
	}

	public void setListItemName(ListModel<Object> listItemName) {
		this.listItemName = listItemName;
	}

	public String getMinCombo() {
		return minCombo;
	}

	public void setMinCombo(String minCombo) {
		this.minCombo = minCombo;
	}

	public String getSeleccione() {
		return seleccione;
	}

	public void setSeleccione(String seleccione) {
		this.seleccione = seleccione;
	}

	public Boolean getUpdate() {
		return update;
	}

	public void setUpdate(Boolean update) {
		this.update = update;
	}

	public ListModel<Object> getListItemCode() {
		return listItemCode;
	}

	public void setListItemCode(ListModel<Object> listItemCode) {
		this.listItemCode = listItemCode;
	}

	public Boolean getDisableAll() {
		return disableAll;
	}

	public void setDisableAll(Boolean disableAll) {
		this.disableAll = disableAll;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Validator getNoEmpty() {
		return new ValidateZK().getNoEmpty();
	}

	public Validator getNoEmptyInTab() {
		return new ValidateZK().getNoEmptyInTab();
	}

	public Validator getNoSelectInTab() {
		return new ValidateZK().getNoSelectInTab();
	}

	public Validator getNoRepeatCode() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				String string = inputElement.getText();
				String str = null;
				Item auxItem = serviceItem.findByCode(string);
				if (auxItem != null && !update)
					str = auxItem.getCode();
				if (string.isEmpty())
					throw new WrongValueException(inputElement, "Ingrese un dato valido.");
				if (string.equalsIgnoreCase(str))
					throw new WrongValueException(inputElement, "Este codigo ya se encuentra registrado en el sistema.");
			}
		};
	}

	@Init
	public void init() {
		restartForm();
	}

	@NotifyChange({ "*" })
	@Command
	public void restartForm() {
		item = new Item();
		minCombo = "--";
		seleccione = "--Seleccione--";
		disableAll = false;
		disableBeforeSearch = true;
		update = false;
		item.setStatus('A');
		elevatorComponent = new BasicData();
		listPriceType = serviceBasicData.listPriceType();
		listItemCode = new ListModelList<Object>();
		listItemName = new ListModelList<Object>();
		listComponents = new ListModelList<Object>();
	}

	@NotifyChange({ "listItemCode", "listItemName", "listComponents" })
	@Command
	public void searchItemByField(@BindingParam("field") String field) {
		if (field.compareTo("code") == 0) {
			listItemCode = new SimpleListModelCustom<Object>(serviceItem.listCodes());
		} else if (field.compareTo("name") == 0) {
			listItemName = new SimpleListModelCustom<Object>(serviceItem.listNames());
		} else if (field.compareTo("componentName") == 0) {
			listComponents = new SimpleListModelCustom<Object>(serviceBasicData.listNamesByBudgetComponent());
		}
	}

	@NotifyChange("elevatorComponent")
	@Command
	public void loadItemByField(@BindingParam("input") InputElement input) {
		List<BasicData> list = serviceBasicData.listNames(input.getText());
		int listSize = list.size();
		if (listSize == 1) {
			elevatorComponent = new BasicData();
			elevatorComponent = list.get(0);
			return;
		} else if (listSize == 0) {
			Clients.showNotification("Ningun registro coincide", "info", input, "end_center", 2000);
		} else {
			Clients.showNotification("Ningun registro coincide", "info", input, "end_center", 2000);
		}
	}

	@NotifyChange({ "item", "disableAll", "update", "listItem" })
	@Command
	public void loadItem(@BindingParam("field") String field, @BindingParam("val") String value) {
		List<Item> listItemAux = new ArrayList<Item>();
		if (field.compareTo("code") == 0)
			listItemAux = serviceItem.listByCodes(value);
		else if (field.compareTo("name") == 0)
			listItemAux = serviceItem.listByName(value);
		int listSize = listItemAux.size();
		if (listSize == 1) {
			item = new Item();
			item = listItemAux.get(0);
			disableAll = false;
			update = true;
			return;
		} else if (listSize == 0) {
			Clients.showNotification("Ningun registro coincide", "info", null, "top_center", 2000);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("listItem", listItemAux);
			Executions.createComponents("system/articulos/frmItemList.zul", null, map);
		}
	}

	@NotifyChange("*")
	@Command
	public void save() {
		if (!serviceItem.save(item)) {
			Clients.showNotification("Fallo guardado articulo", "error", null, "middle_center", 2000);
			return;
		}
		Clients.showNotification("Articulo guardado correctamente", "info", null, "middle_center", 2000);
		restartForm();
	}

	@NotifyChange({ "*" })
	@Command
	public void search() {
		restartForm();
		disableAll = true;
		disableBeforeSearch = false;
	}

	@NotifyChange({ "item", "disableAll", "update" })
	@GlobalCommand
	public void selectedItem(@BindingParam("item") Item selectedItem) {
		item = serviceItem.findById(selectedItem.getIdItem());
		disableAll = false;
		update = true;
	}

	@NotifyChange({ "elevatorComponent" })
	@Command
	public void addItem() {
		Boolean found = false;
		for (BasicData componeData : item.getBasicDatas()) {
			if (componeData.getIdBasic() == elevatorComponent.getIdBasic()) {
				found = true;
				break;
			}
		}
		if (!found) {
			item.getBasicDatas().add(elevatorComponent);
			BindUtils.postNotifyChange(null, null, item, "basicDatas");
		} else
			Clients.showNotification("Ya se encuentra en la lista", "info", null, "middle_center", 2000);
		elevatorComponent = new BasicData();
	}

	@Command
	public void deleteItem() {
		for (Iterator<BasicData> iterator = item.getBasicDatas().iterator(); iterator.hasNext();) {
			BasicData componentAux = iterator.next();
			if (componentAux.getIdBasic() == elevatorComponent.getIdBasic()) {
				elevatorComponent = new BasicData();
				iterator.remove();
				BindUtils.postNotifyChange(null, null, item, "basicDatas");
				break;
			}
		}
	}

	@Command
	public void close() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "");
		BindUtils.postGlobalCommand(null, null, "selectedPage", map);
	}
}