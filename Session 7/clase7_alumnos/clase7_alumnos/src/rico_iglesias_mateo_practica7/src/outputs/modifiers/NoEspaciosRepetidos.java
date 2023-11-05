package outputs.modifiers;

import java.io.IOException;

import outputs.Output;

public class NoEspaciosRepetidos extends AbstractOutput {

	private Output out;
	private char lastChar = '.';

	public NoEspaciosRepetidos(Output out) {
		super(out);
		this.out = out;
	}
	
	@Override
	public void send(char c) throws IOException {
		if (lastChar != ' ' || c != ' ') {
			out.send(c);
		}
		lastChar = c;
	}
}
