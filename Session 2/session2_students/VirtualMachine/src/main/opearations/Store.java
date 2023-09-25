package main.opearations;

import main.opearations.memory.Memory;
import main.opearations.memory.Stack;

public class Store implements Instruction {

	@Override
	public int execute(int ip, Stack stack, Memory memory, Instruction sentence) {
		int value = stack.pop();
		int address = stack.pop();
		memory.setValue(address, value);
		return ip++;
	}
}
