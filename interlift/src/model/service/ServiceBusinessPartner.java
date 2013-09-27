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
	public BusinessPartner findByRif(String rif) {
		return daoBusinessPartner.findByField("rif", rif);
	}

	@Transactional(readOnly = true)
	public BusinessPartner findActiveByRif(String rif) {
		return daoBusinessPartner.findActiveByField("rif", rif);
	}

	@Transactional(readOnly = true)
	public BusinessPartner findActiveByName(String name) {
		return daoBusinessPartner.findActiveByField("name", name);
	}

	@Transactional(readOnly = true)
	public List<String> listRif() {
		return daoBusinessPartner.listStringByFields("rif");
	}

	@Transactional(readOnly = true)
	public List<String> listName() {
		return daoBusinessPartner.listStringByFields("name");
	}
}
