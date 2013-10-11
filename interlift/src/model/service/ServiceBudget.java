package model.service;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoBudget;
import model.database.Budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceBudget {

	@Autowired
	private DaoBudget daoBudget;

	@Transactional
	public Boolean save(Budget budget) {
		if (budget.getIdBudget() == 0)
			return daoBudget.save(budget);
		else
			return daoBudget.update(budget);
	}

	@Transactional(readOnly = true)
	public Budget findByNumber(int number) {
		return daoBudget.findByField("number", number);
	}

	@Transactional(readOnly = true)
	public List<Budget> listByConstruction(String construction) {
		return daoBudget.listByField("construction", construction);
	}

	@Transactional(readOnly = true)
	public List<Budget> listByPartnerName(String partnerName) {
		return daoBudget.listByField("partnerName", partnerName);
	}

	@Transactional(readOnly = true)
	public List<Budget> listByNitPartner(String nitPartner) {
		return daoBudget.listByField("nitPartner", nitPartner);
	}	
	
	@Transactional(readOnly = true)
	public List<Budget> listBySeller(String seller) {
		return daoBudget.listByField("seller", seller);
	}

	@Transactional(readOnly = true)
	public List<Budget> listAll() {
		return daoBudget.listAll();
	}

	@Transactional(readOnly = true)
	public List<String> listSeller() {
		return daoBudget.listStringByFields("seller");
	}

	@Transactional(readOnly = true)
	public List<String> listConstruction() {
		return daoBudget.listStringByFields("construction");
	}

	@Transactional(readOnly = true)
	public List<String> listPartnerName() {
		return daoBudget.listStringByFields("partnerName");
	}

	@Transactional(readOnly = true)
	public List<String> listNitPartner() {
		return daoBudget.listStringByFields("nitPartner");
	}

	@Transactional(readOnly = true)
	public List<String> listNumber() {
		/* Chequear hacer esto mismo con un metodo mas generico */
		List<Integer> list = daoBudget.listIntegerByFields("number");
		List<String> list2 = new ArrayList<String>();
		for (Integer number : list) {
			list2.add(number.toString());
		}
		return list2;
	}
}