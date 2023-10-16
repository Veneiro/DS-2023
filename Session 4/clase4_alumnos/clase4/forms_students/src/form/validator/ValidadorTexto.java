package form.validator;

public class ValidadorTexto implements Validador {

	@Override
	public boolean validate(String value) {
		for (char ch : value.toCharArray()) {
			if (!Character.isLetter(ch)) {
				return false;
			}
		}
		return true;
	}

}
