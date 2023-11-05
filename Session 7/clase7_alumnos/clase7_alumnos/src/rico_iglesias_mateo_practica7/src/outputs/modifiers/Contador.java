package outputs.modifiers;

import java.io.IOException;

import outputs.Output;

public class Contador extends AbstractOutput {

	private Output out;
	private int counter = 0;

	public Contador(Output out) {
		super(out);
		this.out = out;
	}
	
	@Override
	public void send(char c) throws IOException {
		this.counter++;
		out.send(c);
	}
	
	public int getCounter() {
		return this.counter;
	}

}
