package outputs.modifiers;

import java.io.IOException;

import outputs.Output;

public class Encriptar extends AbstractOutput {

	private Output out;

	public Encriptar(Output out) {
		super(out);
		this.out = out;
	}
	
	@Override
	public void send(char c) throws IOException {
		char encrypted = (char) (Character.isLetterOrDigit(c) ? c + 1 : c);
		out.send(encrypted);
	}
	
}
