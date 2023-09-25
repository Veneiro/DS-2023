package main.opearations;

import main.opearations.memory.Memory;
import main.opearations.memory.Stack;

public class Load implements Instruction {

	@Override
	public int execute(int ip, Stack stack, Memory memory, Instruction sentence) {
		int address = stack.pop();
		stack.push(memory.getValue(address));
		return ip++;
	}

}
