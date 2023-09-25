package main.opearations;

import main.opearations.memory.Memory;
import main.opearations.memory.Stack;

public class Output implements Instruction {

	@Override
	public int execute(int ip, Stack stack, Memory memory, Instruction sentence) {
		System.out.println(stack.pop());
		return ip++;
	}

}
