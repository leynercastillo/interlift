package controller.seguridad.perfil;

import general.ShaEncoding;

import java.security.NoSuchAlgorithmException;

import model.database.SecurityUser;
import model.service.ServiceSecurityUser;

import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Window;
import org.zkoss.zul.impl.InputElement;

public class FrmChangePassword {

	@WireVariable
	private ServiceSecurityUser serviceSecurityUser;

	private SecurityUser user;
	private String newPassword;
	private String confirmPassword;
	private String currentPassword;

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public SecurityUser getUser() {
		return user;
	}

	public void setUser(SecurityUser user) {
		this.user = user;
	}

	@Init
	public void init(@ExecutionArgParam("user") SecurityUser user) {
		this.user = user;
		newPassword = new String();
		confirmPassword = new String();
		currentPassword = new String();
	}

	public Validator getNoCurrentPassword() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				String string = inputElement.getText();
				ShaEncoding shaEncoding = new ShaEncoding(string);
				try {
					string = shaEncoding.encodingPassword();
				} catch (NoSuchAlgorithmException e) {
					// password don't encoding
					e.printStackTrace();
				}
				if (user.getPassword().compareTo(string) != 0) {
					throw new WrongValueException(inputElement, "Contrase�a invalida.");
				}
			}
		};
	}

	public Validator getNoEqualPassword() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				String string = inputElement.getText();
				if (confirmPassword.compareTo(string) != 0) {
					throw new WrongValueException(inputElement, "Las contrase�as no coinciden.");
				}
			}
		};
	}

	@Command
	public void save(@BindingParam("component") Window passWindow) {
		ShaEncoding encoding = new ShaEncoding(newPassword);
		try {
			user.setPassword(encoding.encodingPassword());
		} catch (NoSuchAlgorithmException e) {
			Clients.showNotification("No se pudo encriptar la contrase�a", "error", null, "end_center", 2000);
			e.printStackTrace();
			return;
		}
		if (!serviceSecurityUser.save(user)) {
			Clients.showNotification("No se pudo guardar usuario", "error", null, "middle_center", 2000);
			return;
		} else
			Clients.showNotification("Usuario guardado", "info", null, "middle_center", 2000);
		passWindow.detach();
	}
}