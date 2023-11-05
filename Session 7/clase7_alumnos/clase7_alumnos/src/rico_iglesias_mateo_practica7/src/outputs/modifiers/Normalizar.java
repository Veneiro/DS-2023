package outputs.modifiers;

import java.io.IOException;

import outputs.Output;

public class Normalizar extends AbstractOutput {
	
	private Output out;

	public Normalizar(Output out) {
		super(out);
		this.out = out;
	}

	@Override
	public void send(char c) throws IOException {
		if (c != '\r') out.send(c);
	}
}
