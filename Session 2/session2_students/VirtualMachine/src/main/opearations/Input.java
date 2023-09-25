package main.opearations;

import java.util.Scanner;

import main.opearations.memory.Memory;
import main.opearations.memory.Stack;

public class Input implements Instruction {

	@SuppressWarnings("resource")
	@Override
	public int execute(int ip, Stack stack, Memory memory, Instruction sentence) {
		System.out.println("Escriba un número entero: ");
		Scanner sc = new Scanner(System.in);
		stack.push(sc.nextInt());
		return ip++;
	}

}
