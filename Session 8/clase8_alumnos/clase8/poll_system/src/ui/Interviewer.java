package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import poll.Poll;

public class Interviewer {
	private BufferedReader input;
	private List<String> answers = new ArrayList<>();

	public Interviewer() {
		answers.add("sí");
		answers.add("no");
	}

	public void fill(Poll poll) throws IOException 
	{
		input = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Acciones: [sí] / [no]");

		while (true) {
			System.out.println();
			System.out.println("Pregunta: " + poll.getQuestion());
			System.out.print(">");

			String[] line = input.readLine().split(" ");
			// (no se comprueba que el número de palabras sea el adecuado)

			if (line[0].equals("salir"))
				return;

			if (line[0].equals("sí"))
				poll.incrementYeses();

			if (line[0].equals("no"))
				poll.incrementNos();
		}
	}
}
