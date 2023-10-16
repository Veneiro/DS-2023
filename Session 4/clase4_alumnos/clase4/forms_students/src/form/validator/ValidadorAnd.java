package form.validator;

public class ValidadorAnd implements Validador {

	Validador[] validators;
	
	public ValidadorAnd(Validador... validators) {
		this.validators = validators;
	}
	
	@Override
	public boolean validate(String value) {
		for (Validador validador : validators) {
			if(!validador.validate(value)) {
				return false;
			}
		}
		return true;
	}

}
