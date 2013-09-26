package controller;

import model.database.SecurityUser;
import model.service.ServiceSecurityUser;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.GlobalCommand;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.WireVariable;

public class IndexCtrl {

	@WireVariable
	private ServiceSecurityUser serviceSecurityUser;

	private String page;
	private SecurityUser user;

	public SecurityUser getUser() {
		return user;
	}

	public void setUser(SecurityUser user) {
		this.user = user;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	@Init
	public void init() {
		page = new String();
		User auxUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		/*
		 * Se busca por nombre, porque el objeto "auxUser" tipo "User" no almacena email
		 */
		user = serviceSecurityUser.findUser(auxUser.getUsername());
	}

	@NotifyChange("page")
	@GlobalCommand
	public void selectedPage(@BindingParam("page") String page) {
		this.page = page;
	}
}
