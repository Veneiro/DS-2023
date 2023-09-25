package main.opearations.memory;

public class Memory {

	private int[] memory;
	public Memory(int[] size) {
		this.memory = size;
	}
	
	public int getValue(int pos) {
		return this.memory[pos];
	}
	
	public void setValue(int pos, int value) {
		this.memory[pos] = value;
	}
}
