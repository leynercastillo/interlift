package controller.seguridad.grupo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.dao.DaoSecurityRole;
import model.database.SecurityGroup;
import model.database.SecurityRole;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.WireVariable;


public class FrmSecurityGroups {

    @WireVariable
    private DaoSecurityRole daoSecurityRole;
    
    private SecurityGroup group;
    private List<SecurityGroup> listGroups;
    private List<SecurityRole> listRoles;
    private List<SecurityRole> listGroupRoles;
    private Set<SecurityRole> listTempRoles;
    private Set<SecurityRole> listTempGroupRoles;
    private Boolean disabledAll;

    public Set<SecurityRole> getListTempGroupRoles() {
	return listTempGroupRoles;
    }

    public void setListTempGroupRoles(Set<SecurityRole> listTempGroupRoles) {
	this.listTempGroupRoles = listTempGroupRoles;
    }

    public Set<SecurityRole> getListTempRoles() {
	return listTempRoles;
    }

    public void setListTempRoles(Set<SecurityRole> listTempRoles) {
	this.listTempRoles = listTempRoles;
    }

    public Boolean getDisabledAll() {
	return disabledAll;
    }

    public void setDisabledAll(Boolean disabledAll) {
	this.disabledAll = disabledAll;
    }

    public SecurityGroup getGroup() {
	return group;
    }

    public void setGroup(SecurityGroup group) {
	this.group = group;
    }

    public List<SecurityGroup> getListGroups() {
	return listGroups;
    }

    public void setListGroups(List<SecurityGroup> listGroups) {
	this.listGroups = listGroups;
    }

    public List<SecurityRole> getListRoles() {
	return listRoles;
    }

    public void setListRoles(List<SecurityRole> listRoles) {
	this.listRoles = listRoles;
    }

    public List<SecurityRole> getListGroupRoles() {
	return listGroupRoles;
    }

    public void setListGroupRoles(List<SecurityRole> listGroupRoles) {
	this.listGroupRoles = listGroupRoles;
    }

    @Init
    public void init() {
	restartForm();
    }

    @NotifyChange({ "group", "listGroups", "listRoles", "listGroupRoles" })
    @Command
    public void restartForm() {
	group = new SecurityGroup();
	listGroups = new ArrayList<SecurityGroup>();
	listRoles = daoSecurityRole.listRoles();
	listGroupRoles = new ArrayList<SecurityRole>();
	listTempRoles = new HashSet<SecurityRole>();
	listTempGroupRoles = new HashSet<SecurityRole>();
	disabledAll = new Boolean(false);
    }

    @NotifyChange({ "listGroupRoles", "listRoles", "listTempRoles" })
    @Command
    public void addRole() {
	roleOperations(listGroupRoles, listRoles, listTempRoles);
    }

    @NotifyChange({ "listGroupRoles", "listRoles", "listTempGroupRoles" })
    @Command
    public void minusRole() {
	roleOperations(listRoles, listGroupRoles, listTempGroupRoles);
    }

    public void roleOperations(List<SecurityRole> list2, List<SecurityRole> list1, Set<SecurityRole> tempRoles) {
	for (SecurityRole role : tempRoles) {
	    list2.add(role);
	    list1.remove(role);
	}
	tempRoles.clear();
    }

    @Command
    public void searchGroup() {
    }
}