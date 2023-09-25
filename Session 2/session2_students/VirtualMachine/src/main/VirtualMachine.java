package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import main.opearations.Add;
import main.opearations.Input;
import main.opearations.Instruction;
import main.opearations.Jmp;
import main.opearations.Jmpg;
import main.opearations.Load;
import main.opearations.Mul;
import main.opearations.Output;
import main.opearations.Push;
import main.opearations.Store;
import main.opearations.Sub;
import main.opearations.memory.Memory;
import main.opearations.memory.Stack;

public class VirtualMachine {

	private static List<Instruction> instructions = new ArrayList<>();
	private static int ip = 0;
	
	private Stack stack = new Stack(new int[32]);

	private Memory memory = new Memory(new int[1024]);

	public VirtualMachine() {
		BufferedReader file;
		try {
			file = new BufferedReader(new FileReader("factorial.txt"));
			String line;
			while ((line = file.readLine()) != null)
				loadSentence(line);
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void executeProgram() {
		while (ip < instructions.size()) {
			Instruction sentence = instructions.get(ip);
			ip = sentence.execute(ip, this.stack, this.memory, sentence);
		}
	}

	private static void loadSentence(String line) {
		if (line.trim().length() == 0)
			return;
		String[] tokens = line.split(" ");
		 	if (tokens[0].equals("push")) {
		 		instructions.add(new Push());
			} else if (tokens[0].equals("add")) {
				instructions.add(new Add());
			} else if (tokens[0].equals("sub")) {
				instructions.add(new Sub());
			} else if (tokens[0].equals("mul")) {
				instructions.add(new Mul());
			} else if (tokens[0].equals("jmp")) {
				instructions.add(new Jmp());
			} else if (tokens[0].equals("jmpg")) {
				instructions.add(new Jmpg());
			} else if (tokens[0].equals("load")) {
				instructions.add(new Load());
			} else if (tokens[0].equals("store")) {
				instructions.add(new Store());
			} else if (tokens[0].equals("input")) {
				instructions.add(new Input());
			} else if (tokens[0].equals("output")) {
				instructions.add(new Output());
			}
	}
}
