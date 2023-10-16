package form.validator;

public class ValidadorMenorQue implements Validador {
	
	private int menorQue = 0;
	
	public ValidadorMenorQue(int numero) {
		this.menorQue = numero;
	}
	
	@Override
	public boolean validate(String value) {
		if(Integer.parseInt(value) > menorQue) {
			return false;
		}
		return true;
	}
}
