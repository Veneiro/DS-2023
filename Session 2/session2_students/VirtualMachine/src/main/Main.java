package main;

public class Main {
	
	private static VirtualMachine vm;

	public static void main(String[] args) throws Exception {
		vm = new VirtualMachine();
		vm.executeProgram();
	}
}
