package main.opearations;

import main.opearations.memory.Memory;
import main.opearations.memory.Stack;

public class Push implements Instruction {

	@Override
	public int execute(int ip, Stack stack, Memory memory, Instruction sentence) {
//		push(Integer.parseInt(sentence[1]));
		return ip++;
	}

}
