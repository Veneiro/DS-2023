package outputs.modifiers;

import java.io.IOException;

import outputs.Output;

public abstract class AbstractOutput implements Output {
	
	private Output out;

	public AbstractOutput(Output out) {
		this.out = out;
	}

	@Override
	public void send(char c) throws IOException {
		out.send(c);
	}
	
	@Override
	public void close() throws IOException {
		out.close();
	}
}
