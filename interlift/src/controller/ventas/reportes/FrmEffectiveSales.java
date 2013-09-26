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
	private ListModelList<SecurityUser> listUsers;
	private Set<SecurityUser> listSelectedUsers;

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
		listSelectedUsers = new HashSet<SecurityUser>();
		SecurityGroup group = serviceSecurityGroup.findGroupSeller();
		listUsers = new ListModelList<SecurityUser>();
		listUsers.setMultiple(true);
		listUsers.addAll(serviceSecurityUser.listByGroup(group.getIdSecurityGroup()));
	}

	@Command
	public void generateReport() {
		GenericReport report = new GenericReport();
		List<Integer> listIdUser = new ArrayList<Integer>();
		for (SecurityUser user : listSelectedUsers) {
			listIdUser.add(user.getIdSecurityUser());
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("LIST_USER", listIdUser);
		map.put("START_DATE", beginDate);
		map.put("END_DATE", endDate);
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