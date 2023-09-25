package main.opearations.memory;

public class Stack {

	private static int sp = 0;
	private static int[] stack;
	
	public Stack(int[] size) {
		this.stack = size;
	}
	
	public void push(int value) {
		stack[sp] = value;
		sp++;
	}

	public int pop() {
		sp--;
		return stack[sp];
	}
}
