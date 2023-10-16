package form.validator;

public class ValidadorNumerico implements Validador {
	
	@Override
	public boolean validate(String value) {
		for (char ch : value.toCharArray()) {
			if (!Character.isDigit(ch)) {
				return false;
			}
		}
		return true;
	}

}
