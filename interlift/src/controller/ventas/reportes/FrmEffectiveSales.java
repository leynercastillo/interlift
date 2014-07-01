package controller.ventas.reportes;

import general.GenericReport;
import general.ValidateZK;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.database.SecurityGroup;
import model.database.SecurityUser;
import model.service.ServiceSecurityGroup;
import model.service.ServiceSecurityUser;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

public class FrmEffectiveSales {

	@WireVariable
	private ServiceSecurityUser serviceSecurityUser;
	@WireVariable
	private ServiceSecurityGroup serviceSecurityGroup;
	private Date beginDate;
	private Date endDate;
	private Boolean newSales;
	private Boolean modernization;
	private ListModelList<SecurityUser> listUsers;
	private Set<SecurityUser> listSelectedUsers;

	public Boolean getNewSales() {
		return newSales;
	}

	public void setNewSales(Boolean newSales) {
		this.newSales = newSales;
	}

	public Boolean getModernization() {
		return modernization;
	}

	public void setModernization(Boolean modernization) {
		this.modernization = modernization;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Set<SecurityUser> getListSelectedUsers() {
		return listSelectedUsers;
	}

	public void setListSelectedUsers(Set<SecurityUser> listSelectedUsers) {
		this.listSelectedUsers = listSelectedUsers;
	}

	public ListModelList<SecurityUser> getListUsers() {
		return listUsers;
	}

	public void setListUsers(ListModelList<SecurityUser> listUsers) {
		this.listUsers = listUsers;
	}

	public Validator getNoEmpty() {
		return new ValidateZK().getNoEmpty();
	}

	public Validator getNoBeforeDate() {
		return new ValidateZK().getNoBeforeDate();
	}

	@Init
	public void init() {
		restartForm();
	}

	@NotifyChange("*")
	@Command
	public void restartForm() {
		beginDate = null;
		endDate = null;
		listSelectedUsers = new HashSet<SecurityUser>();
		SecurityGroup group = serviceSecurityGroup.findGroupSeller();
		listUsers = new ListModelList<SecurityUser>();
		listUsers.setMultiple(true);
		listUsers.addAll(serviceSecurityUser.listByGroup(group.getIdSecurityGroup()));
		newSales = false;
		modernization = false;
	}

	@Command
	public void generateReport() {
		List<Boolean> listQuotationTypes = new ArrayList<Boolean>();
		if (newSales)
			listQuotationTypes.add(true);
		if (modernization)
			listQuotationTypes.add(false);
		GenericReport report = new GenericReport();
		List<Integer> listIdUser = new ArrayList<Integer>();
		for (SecurityUser user : listSelectedUsers) {
			listIdUser.add(user.getIdSecurityUser());
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("LIST_USER", listIdUser);
		map.put("START_DATE", beginDate);
		map.put("END_DATE", endDate);
		map.put("LIST_TYPE", listQuotationTypes);
		map.put("IMAGES_DIR", "../../resource/images/system/reports/");
		report.createPdf("/resource/reports/ventas/reportes", "effective_sales.jasper", map, "ventas-efectivas.pdf");
		report.viewPdf("/resource/reports/ventas/reportes/ventas-efectivas.pdf", "Ventas efectivas");
	}

	@Command
	public void close() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", "");
		BindUtils.postGlobalCommand(null, null, "selectedPage", map);
	}
}