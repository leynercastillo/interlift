package model.service;

import java.util.List;

import model.dao.DaoItem;
import model.database.Item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceItem {

	@Autowired
	private DaoItem daoItem;

	@Transactional
	public Boolean save(Item item) {
		if (item.getIdItem() == 0)
			return daoItem.save(item);
		else
			return daoItem.update(item);
	}

	@Transactional(readOnly = true)
	public Item findById(int id) {
		return daoItem.findByField("idItem", id);
	}

	@Transactional(readOnly = true)
	public Item findByCode(String code) {
		return daoItem.findByField("code", code);
	}

	@Transactional(readOnly = true)
	public List<Item> listByCodes(String code) {
		return daoItem.listByString("code", code);
	}

	@Transactional(readOnly = true)
	public List<Item> listByName(String name) {
		return daoItem.listByString("name", name);
	}

	@Transactional(readOnly = true)
	public List<String> listCodes() {
		return daoItem.listStringByFields("code");
	}

	@Transactional(readOnly = true)
	public List<String> listNames() {
		return daoItem.listStringByFields("name");
	}
}
