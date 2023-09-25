package main.opearations;

import main.opearations.memory.Memory;
import main.opearations.memory.Stack;

public interface Instruction {
	public int execute(int ip, Stack stack, Memory memory, Instruction sentence);
}
