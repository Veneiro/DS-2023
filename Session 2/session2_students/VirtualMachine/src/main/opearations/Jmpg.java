package main.opearations;

import main.opearations.memory.Memory;
import main.opearations.memory.Stack;

public class Jmpg implements Instruction {

	@Override
	public int execute(int ip, Stack stack, Memory memory, Instruction sentence) {
		int b = stack.pop();
		int a = stack.pop();
		if (a > b)
		//	ip = Integer.parseInt(sentence[1]);
			return ip;
		else
			return ip++;
	}

}
