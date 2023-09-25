package main.opearations;

import main.opearations.memory.Memory;
import main.opearations.memory.Stack;

public class Sub implements Instruction {

	@Override
	public int execute(int ip, Stack stack, Memory memory, Instruction sentence) {
		int b = stack.pop();
		int a = stack.pop();
		stack.push(a - b);
		return ip++;
	}
}
