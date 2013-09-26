package general;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.Validator;
import org.zkoss.bind.validator.AbstractValidator;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Tab;
import org.zkoss.zul.impl.InputElement;

public class ValidateZK {

	/**
	 * Metodo que valida que un componente ZK no este vacio.
	 * 
	 * @return {@link Validator}
	 */
	public Validator getNoEmpty() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				String string = inputElement.getText();
				if (string.trim().isEmpty()) {
					throw new WrongValueException(inputElement, "Ingrese un dato valido.");
				}
			}
		};
	}

	/**
	 * Metodo que valida que un componente ZK no este vacio, y ademas se encuentre dentro de un tabbox > tabs > tab
	 * 
	 * @return
	 */
	public Validator getNoEmptyInTab() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				Tab tab = (Tab) ctx.getBindContext().getValidatorArg("tab");
				String string = inputElement.getText();
				if (string.trim().isEmpty()) {
					tab.setSelected(true);
					throw new WrongValueException(inputElement, "Ingrese un dato valido.");
				}
			}
		};
	}

	/**
	 * Metodo que valida que un string sea un Email valido. Debe ser un email, y no debe estar vacío. Solo aplica
	 * para componentes ZK
	 * 
	 * @return {@link Validator}
	 */
	public Validator getNoEmail() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				String string = inputElement.getText();
				if (!string.trim().isEmpty() && !string.matches(".+@.+\\.[a-zA-Z]+")) {
					throw new WrongValueException(inputElement, "Ingrese una direccion de correo valida.");
				}
			}
		};
	}

	/**
	 * Metodo que valida que un combobox small no tenga seleccionado la opcion por defecto del sistema '--'.
	 * 
	 * Solo aplica para componentes ZK
	 * 
	 * @return {@link Validator}
	 */
	public Validator getNoDash() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				String string = inputElement.getText();
				if (string.trim().isEmpty() || string.equals("-")) {
					throw new WrongValueException(inputElement, "Seleccione una opcion valida.");
				}
			}
		};
	}

	/**
	 * Metodo que valida que un combobox no tenga seleccionado nada.
	 * 
	 * @return {@link Validator}
	 */
	public Validator getNoSelect() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				Combobox combo = (Combobox) ctx.getBindContext().getValidatorArg("component");
				if (combo.getSelectedItem() == null) {
					throw new WrongValueException(combo, "Seleccione una opcion valida.");
				}
			}
		};
	}

	/**
	 * Metodo que valida que un combobox no tenga seleccionado nada y ademas se encuentre dentro de un tabbox > tabs
	 * > tab
	 * 
	 * @return {@link Validator}
	 */
	public Validator getNoSelectInTab() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				Combobox combo = (Combobox) ctx.getBindContext().getValidatorArg("component");
				Tab tab = (Tab) ctx.getBindContext().getValidatorArg("tab");
				if (combo.getSelectedItem() == null) {
					tab.setSelected(true);
					throw new WrongValueException(combo, "Seleccione una opcion valida.");
				}
			}
		};
	}

	/**
	 * Metodo que valida que un componente tenga no sea vacio ni tenga valor 0. Se aconseja para usar en intbox o
	 * spinner.
	 * 
	 * @return {@link Validator}
	 */
	public Validator getNoZero() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				String string = inputElement.getText();
				if (string.trim().isEmpty() || Integer.valueOf(string) <= 0) {
					throw new WrongValueException(inputElement, "Ingrese una cantidad valida.");
				}
			}
		};
	}

	/**
	 * Metodo que valida que un componente tenga no sea vacio ni tenga valor 0. Se aconseja para usar en doublebox o
	 * doublespinner.
	 * 
	 * @return {@link Validator}
	 */
	public Validator getNoZeroDouble() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				InputElement inputElement = (InputElement) ctx.getBindContext().getValidatorArg("component");
				NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
				Double number = new Double(0);
				try {
					number = format.parse(inputElement.getText()).doubleValue();
				} catch (WrongValueException e) {
					e.printStackTrace();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if (number <= 0) {
					throw new WrongValueException(inputElement, "Ingrese una cantidad valida.");
				}
			}
		};
	}

	/**
	 * Metodo que valida que la fecha del datebox sea menor o igual a otra fecha.
	 * 
	 * @return {@link Validator}
	 */
	public Validator getNoAfterDate() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				Datebox datebox = (Datebox) ctx.getBindContext().getValidatorArg("component");
				Date otherDate = (Date) ctx.getBindContext().getValidatorArg("otherDate");
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				if (datebox.getValue() == null) {
					throw new WrongValueException(datebox, "Ingrese una fecha valida.");
				} else if (datebox.getValue().after(otherDate)) {
					throw new WrongValueException(datebox, "Ingrese una fecha menor a " + format.format(otherDate));
				}
			}
		};
	}

	/**
	 * Metodo que valida que la fecha del datebox sea mayor o igual a otra fecha.
	 * 
	 * @return {@link Validator}
	 */
	public Validator getNoBeforeDate() {
		return new AbstractValidator() {
			@Override
			public void validate(ValidationContext ctx) {
				Datebox datebox = (Datebox) ctx.getBindContext().getValidatorArg("component");
				Date otherDate = (Date) ctx.getBindContext().getValidatorArg("otherDate");
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				if (datebox.getValue() == null) {
					throw new WrongValueException(datebox, "Ingrese una fecha valida.");
				} else if (datebox.getValue().before(otherDate)) {
					throw new WrongValueException(datebox, "Ingrese una fecha mayor a " + format.format(otherDate));
				}
			}
		};
	}
}