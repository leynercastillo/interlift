package controller.contacto;

import general.ValidateZK;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.database.Contact;
import model.database.SecurityGroup;
import model.database.SecurityUser;
import model.service.ServiceContact;
import model.service.ServiceSecurityGroup;

import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;

import springBean.Emails;

public class FrmContact {

	@WireVariable
	private ServiceSecurityGroup serviceSecurityGroup;
	@WireVariable
	private ServiceContact serviceContact;
	@WireVariable
	private Emails emails;

	private List<SecurityUser> listSecurityUsers;
	private Contact contact;

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<SecurityUser> getListSecurityUsers() {
		return listSecurityUsers;
	}

	public void setListSecurityUsers(List<SecurityUser> listSecurityUsers) {
		this.listSecurityUsers = listSecurityUsers;
	}

	public Validator getNoEmpty() {
		return new ValidateZK().getNoEmpty();
	}

	public Validator getNoSelect() {
		return new ValidateZK().getNoSelect();
	}

	public Validator getNoEmail() {
		return new ValidateZK().getNoEmail();
	}

	@Init
	public void init() {
		restartForm();
	}

	@NotifyChange({ "*" })
	@Command
	public void restartForm() {
		contact = new Contact();
		contact.setStatus('A');
		contact.setDate(new Date());
		SecurityGroup group = serviceSecurityGroup.findGroupSeller();
		listSecurityUsers = new ArrayList<SecurityUser>(group.getSecurityUsers());
		group = serviceSecurityGroup.findGroupSalesCoordinator();
		listSecurityUsers.addAll(group.getSecurityUsers());
	}

	public String mailMessage() {
		String message = new String();
		message = "Buenas...\n\nEste correo es enviado desde el sitio web por un cliente que desea contactar con usted. A continuacion los datos del cliente:\n\nEmpresa:  " + contact.getPartnerName() + "\n\nPersona de contacto: " + contact.getContactName() + "\n\nCiudad: " + contact.getCity() + "\n\nDireccion: " + contact.getAddress() + "\n\nTelefono: " + (contact.getPhone() == null ? "" : contact.getPhone()) + "\n\nDireccion de correo: " + (contact.getContactEmail() == null ? "" : contact.getContactEmail()) + "\n\nComentarios: " + contact.getComment() + "\n\nSaludos";
		return message;
	}

	@NotifyChange({ "*" })
	@Command
	public void send(@BindingParam("component") Component component) {
		List<String> list = new ArrayList<String>();
		list.add(contact.getSecurityUser().getEmail());
		list.add("sistemas@ascensoresnardi.com");
		if (!serviceContact.save(contact)) {
			Clients.showNotification("No se pudo enviar.", "error", component, "bottom_center", 2000);
			return;
		}
		emails.sendMail("sistemas@ascensoresnardi.com", "Contactar", list, mailMessage(), null);
		Clients.showNotification("Informacion enviada", "info", component, "bottom_center", 2000);
		restartForm();
	}
}