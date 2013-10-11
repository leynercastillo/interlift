package model.service;

import java.util.List;

import model.dao.DaoBusinessPartner;
import model.database.BusinessPartner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceBusinessPartner {

	@Autowired
	private DaoBusinessPartner daoBusinessPartner;

	@Transactional
	public Boolean save(BusinessPartner businessPartner) {
		if (businessPartner.getIdBusinessPartner() == 0)
			return daoBusinessPartner.save(businessPartner);
		else
			return daoBusinessPartner.update(businessPartner);
	}

	@Transactional(readOnly = true)
	public BusinessPartner findById(int idBusinessPartner) {
		return daoBusinessPartner.findByField("idBusinessPartner", idBusinessPartner);
	}

	@Transactional(readOnly = true)
	public BusinessPartner findByNit(String nit) {
		return daoBusinessPartner.findByField("nit", nit);
	}

	@Transactional(readOnly = true)
	public BusinessPartner findActiveByNit(String nit) {
		return daoBusinessPartner.findActiveByField("nit", nit);
	}

	@Transactional(readOnly = true)
	public BusinessPartner findActiveByName(String name) {
		return daoBusinessPartner.findActiveByField("name", name);
	}

	@Transactional(readOnly = true)
	public List<String> listNit() {
		return daoBusinessPartner.listStringByFields("nit");
	}

	@Transactional(readOnly = true)
	public List<String> listName() {
		return daoBusinessPartner.listStringByFields("name");
	}
}
