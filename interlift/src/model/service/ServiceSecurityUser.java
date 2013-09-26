package model.service;

import java.util.List;

import model.dao.DaoSecurityUser;
import model.database.SecurityUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceSecurityUser {

	@Autowired
	private DaoSecurityUser daoSecurityUser;

	@Transactional
	public Boolean save(SecurityUser securityUser) {
		if (securityUser.getIdSecurityUser() == 0)
			return daoSecurityUser.save(securityUser);
		else
			return daoSecurityUser.update(securityUser);
	}

	@Transactional(readOnly = true)
	public SecurityUser findUser(String userName) {
		return daoSecurityUser.findByField("email", userName);
	}

	@Transactional(readOnly = true)
	public List<SecurityUser> listAll() {
		return daoSecurityUser.listAll();
	}

	@Transactional(readOnly = true)
	public List<SecurityUser> listByGroup(int idGroup) {
		return daoSecurityUser.listByGroup(idGroup);
	}
}