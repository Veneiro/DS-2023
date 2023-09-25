package main.opearations;

import main.opearations.memory.Memory;
import main.opearations.memory.Stack;

public class Mul implements Instruction {

	@Override
	public int execute(int ip, Stack stack, Memory memory, Instruction sentence) {
		// TODO Auto-generated method stub
		stack.push(stack.pop() * stack.pop());
		return ip++;
	}

}
