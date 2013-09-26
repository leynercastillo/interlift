package model.service;

import model.dao.DaoContact;
import model.database.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceContact {

	@Autowired
	private DaoContact daoContact;

	@Transactional
	public boolean save(Contact contact) {
		if (contact.getIdContact() == 0)
			return daoContact.save(contact);
		else
			return daoContact.update(contact);
	}
}