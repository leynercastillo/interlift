package model.service;

import model.dao.DaoSecurityRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceSecurityRole {

	@Autowired
	private DaoSecurityRole daoSecurityRole;
}
