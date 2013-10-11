package model.service;

import java.util.List;

import model.dao.DaoQuotation;
import model.database.Quotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceQuotation {

	@Autowired
	private DaoQuotation daoQuotation;

	@Transactional
	public Boolean save(Quotation quotation) {
		Quotation auxQuotation = findById(quotation.getIdQuotation());
		if (quotation.getIdQuotation() == 0 || quotation.getTotalPrice() != auxQuotation.getTotalPrice() || !quotation.getPayment().equals(auxQuotation.getPayment()) || !quotation.getWarranty().equals(auxQuotation.getWarranty()) || !quotation.getExtendedWarranty().equals(auxQuotation.getExtendedWarranty()) || !quotation.getDeliveryEstimate().equals(auxQuotation.getDeliveryEstimate()) || !quotation.getNotes().equals(auxQuotation.getNotes()))
			return daoQuotation.save(quotation);
		else if (quotation.getStatus() != auxQuotation.getStatus())
			return daoQuotation.update(quotation);
		else
			return true;
	}

	@Transactional(readOnly = true)
	public Quotation findById(int idQuotation) {
		return daoQuotation.findByField("idQuotation", idQuotation);
	}

	@Transactional(readOnly = true)
	public Integer findMaxNewNumber() {
		return daoQuotation.getMaxNumber("newNumber");
	}

	@Transactional(readOnly = true)
	public Integer findMaxModernizationNumber() {
		return daoQuotation.getMaxNumber("modernizationNumber");
	}

	@Transactional(readOnly = true)
	public List<Quotation> listByBudget(int budgetNumber) {
		return daoQuotation.listByField("budgetNumber", budgetNumber);
	}

	@Transactional(readOnly = true)
	public List<Quotation> listByNewNumber(Integer newNumber) {
		return daoQuotation.listByField("newNumber", newNumber);
	}

	@Transactional(readOnly = true)
	public List<Quotation> listByModernizationNumber(Integer modernizationNumber) {
		return daoQuotation.listByField("modernizationNumber", modernizationNumber);
	}

	@Transactional(readOnly = true)
	public List<Quotation> listByNitPartner(String nitPartner) {
		return daoQuotation.listByField("nitPartner", nitPartner);
	}

	@Transactional(readOnly = true)
	public List<Quotation> listByConstruction(String construction) {
		return daoQuotation.listByField("construction", construction);
	}

	@Transactional(readOnly = true)
	public List<Quotation> listBySeller(String seller) {
		return daoQuotation.listByField("seller", seller);
	}

	@Transactional(readOnly = true)
	public List<Quotation> listByPartnerName(String partnerName) {
		return daoQuotation.listByField("partnerName", partnerName);
	}

	@Transactional(readOnly = true)
	public List<Quotation> listOrderedByDate() {
		return daoQuotation.listActiveOrderDescByField("date");
	}

	@Transactional(readOnly = true)
	public List<String> listNitPartner() {
		return daoQuotation.listStringByFields("nitPartner");
	}

	@Transactional(readOnly = true)
	public List<String> listBudgetNumber() {
		return daoQuotation.listStringByFields("budgetNumber");
	}

	@Transactional(readOnly = true)
	public List<String> listPartnerName() {
		return daoQuotation.listStringByFields("partnerName");
	}

	@Transactional(readOnly = true)
	public List<String> listNewNumber() {
		return daoQuotation.listStringByFields("newNumber");
	}

	@Transactional(readOnly = true)
	public List<String> listModernizationNumber() {
		return daoQuotation.listStringByFields("modernizationNumber");
	}

	@Transactional(readOnly = true)
	public List<String> listConstruction() {
		return daoQuotation.listStringByFields("construction");
	}

	@Transactional(readOnly = true)
	public List<String> listSeller() {
		return daoQuotation.listStringByFields("seller");
	}
}