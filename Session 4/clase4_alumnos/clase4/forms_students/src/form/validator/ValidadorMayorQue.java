package form.validator;

public class ValidadorMayorQue implements Validador {

	private int mayorQue = 0;
	
	public ValidadorMayorQue(int numero) {
		this.mayorQue = numero;
	}
	
	@Override
	public boolean validate(String value) {
		if(Integer.parseInt(value) < mayorQue) {
			return false;
		}
		return true;
	}

}
