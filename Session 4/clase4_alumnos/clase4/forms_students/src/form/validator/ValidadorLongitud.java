package form.validator;

public class ValidadorLongitud implements Validador {

	int maxLong = 0;
	
	public ValidadorLongitud(int longitud) {
		this.maxLong = longitud;
	}
	
	@Override
	public boolean validate(String value) {
		if(value.length() > maxLong) {
			return false;
		}
		return true;
	}
	
}
