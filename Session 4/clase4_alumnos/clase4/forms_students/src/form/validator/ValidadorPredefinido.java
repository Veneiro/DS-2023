package form.validator;

public class ValidadorPredefinido implements Validador {

	private String[] predefinedValues;
	
	public ValidadorPredefinido(String... preValues) {
		this.predefinedValues = preValues;
	}
	
	@Override
	public boolean validate(String value) {
		for (String each : predefinedValues) {
			if (value.toLowerCase().equals(each.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

}
