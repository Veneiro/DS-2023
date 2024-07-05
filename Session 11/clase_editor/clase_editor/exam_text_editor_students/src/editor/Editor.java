package editor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import editor.actions.AbrirAction;
import editor.actions.Action;
import editor.actions.BorrarAction;
import editor.actions.InsertarAction;
import editor.actions.ReemplazarAction;
import editor.macros.GestorDeMacros;

public class Editor {

	private BufferedReader in;
	private StringBuilder texto = new StringBuilder();
	private String[] lines;
	private GestorDeMacros gm;
	private String currentRecord;

	public void run() throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		texto = new StringBuilder("");

		show();

		do {
			System.out.print("> ");

			String[] line = in.readLine().split(" ");

			if (line[0].equals("salir"))
				return;

			// No se comprueba que el número de palabras sea el adecuado
			System.out.println(texto);
			System.out.println(checkacro(line));

		} while (true);
	}

	private void show() {
		System.out.println("Acciones");
		System.out.println("--------");
		System.out.println("abre <fichero>");
		System.out.println(
				"inserta <texto>\t\t// inserta las palabras al final del texto");
		System.out.println("borra\t\t\t// borra la última palabra");
		System.out.println(
				"reemplaza <a> <b>\t// reemplaza la cadena <a> por la <b> en todo el texto");
		System.out.println("salir");
		System.out.println();
		System.out.println("Tareas");
		System.out.println("------");
		System.out.println(
				"graba <macro>\t\t// comienza la grabación de una macro");
		System.out.println("para\t\t\t// finaliza la grabación");
		System.out.println(
				"ejecuta <macro>\t\t// ejecuta la macro cuyo nombre se indique");
		System.out.println();
	}

	public StringBuilder checkacro(String[] line) throws IOException {
		this.lines = line;
		if (lines[0].equals("abre")) {
			check(new AbrirAction());
		} else if (lines[0].startsWith("ins")) {
			check(new InsertarAction(lines[1]));
		} else if (lines[0].startsWith("borr")) {
			check(new BorrarAction());
		} else if (lines[0].startsWith("reem")) {
			check(new ReemplazarAction(lines[1], lines[2]));
		} else if (lines[0].startsWith("graba")) {
			gm = new GestorDeMacros(this);
			this.currentRecord = lines[1];
		} else if (lines[0].startsWith("para")) {
			this.currentRecord = "";
			gm.stopRecording();
		} else if (lines[0].startsWith("ejecuta")) {
			gm.executeMacro(lines[1]);
		} else {
			System.out.println("Instrucción desconocida");
		}
		return texto;
	}

	private void check(Action action) throws IOException {
		if (gm != null) {
			if (!gm.isRecording()) {
				action.execute(this);
			} else {
				gm.record(action, this.currentRecord);
			}
		} else {
			action.execute(this);
		}
	}

	public String getLine(int i) {
		return this.lines[i];
	}

	public String[] getLines() {
		return this.lines;
	}

	public StringBuilder getTexto() {
		return this.texto;
	}
	
	public void reemplazarTexto(StringBuilder texto) {
		this.texto = texto;
	}

}
