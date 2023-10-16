package form.validator;

public class ValidadorOr implements Validador {

	Validador[] validators;
	
	public ValidadorOr(Validador... validators) {
		this.validators = validators;
	}
	
	@Override
	public boolean validate(String value) {
		for (Validador validador : validators) {
			if(validador.validate(value)) {
				return true;
			}
		}
		return false;
	}

}
