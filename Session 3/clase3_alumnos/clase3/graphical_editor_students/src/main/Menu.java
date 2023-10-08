package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;

import editor.Editor;
import editor.figuras.CircleCreationTool;
import editor.figuras.RectangleCreationTool;
import editor.figuras.TriangleCreationTool;
import editor.herramientas.HeramientaSeleccion;
import editor.herramientas.Herramienta;

public class Menu {

	private Editor editor;
	private BufferedReader input;
	private PrintStream output;
	private boolean exit;
	private Herramienta selectionTool;
	private Herramienta rectangle;
	private Herramienta circle;
	private Herramienta triangle;

	public Menu(final Editor editor) {
		this(editor, System.in, System.out);
	}

	public Menu(final Editor editor, final InputStream input,
			final PrintStream output) {
		this(editor, new InputStreamReader(input),
				new PrintStream(output, true));
	}

	public Menu(final Editor editor, final Reader input,
			final OutputStream output) {
		this.exit = false;
		this.input = new BufferedReader(input);
		this.output = new PrintStream(output, true);
		this.editor = editor;
		this.selectionTool = new HeramientaSeleccion(editor);
		this.rectangle = new RectangleCreationTool(editor);
		this.circle = new CircleCreationTool(editor);
		this.triangle = new TriangleCreationTool(editor);
	}

	public void run() throws IOException {
		input = new BufferedReader(new InputStreamReader(System.in));
		while (!exit) {
			showHelp(output);
			ask();
		}
	}

	public void ask() throws IOException {

		output.print("> ");
		output.flush();

		// Pregunta al usuario por consola y la línea introducida en dos
		// partes: el nombre de
		// la herramienta o acción, por un lado, y todos los parámetros
		// adicionales, en caso
		// de haberlos (todo lo que venga tras el primer espacio), por otro;
		// p. ej.:
		//
		// > pulsar 100, 100 ---> tokens = [ "pulsar", "100, 100" ]
		//
		String[] tokens = input.readLine().split("[ ]", 2);
		String action = tokens[0];

		// Comprueba que a las acciones que no requieren parámetros,
		// efectivamente no se les
		// pase ninguno (por usabilidad, para que el usuario se dé cuenta de
		// que la última
		// acción no funciona como él esperaba). Por ejemplo, si por
		// equivocación tecleó:
		//
		// "soltar 200, 345"
		//
		// cuando realmente esas coordenadas no son tenidas en cuenta (se
		// debería haber
		// llamado previamente a "mover 200, 345" y luego simplemente
		// "soltar").
		//
		if (!action.equals("pulsar") && !action.equals("mover")) {
			if (tokens.length > 1) {
				output.printf("Error de sintaxis: \"%s\" no tiene parámetros\n",
						action);
				return;
			}
		}

		if (action.equals("salir")) {
			output.println("¡Adios!");
			this.exit = true;
		}

		if (action.equals("seleccion")) {
			this.editor.selectTool(this.selectionTool);
		} else if (action.equals("rectangulo")) {
			this.editor.selectTool(this.rectangle);
		} else if (action.equals("circulo")) {
			this.editor.selectTool(this.circle);
		} else if (action.equals("triangulo")) {
			this.triangle = new TriangleCreationTool(this.editor);
			this.editor.selectTool(this.triangle);
		} else if (action.equals("pulsar")) {
			try {
				// la siguiente línea es para que funcione
				// independientemente de si las coordenadas
				// están separadas sólo por una coma o si hay espacios entre
				// los números y la coma
				String[] arguments = tokens[1].split("\\s*,\\s*");
				int x = Integer.parseInt(arguments[0]);
				int y = Integer.parseInt(arguments[1]);
				this.editor.clickedOn(x, y);
			} catch (NumberFormatException e) {
				output.println(
						"Error de sintaxis: se esperaban las coordenadas del punto en que se hizo clic: pulsar <x>, <y>");
			}
		} else if (action.equals("mover")) {
			try {
				// la siguiente línea es para que funcione
				// independientemente de si las coordenadas
				// están separadas sólo por una coma o si hay espacios entre
				// los números y la coma
				String[] arguments = tokens[1].split("\\s*,\\s*");
				int x = Integer.parseInt(arguments[0]);
				int y = Integer.parseInt(arguments[1]);
				this.editor.movedTo(x, y);
			} catch (NumberFormatException e) {
				output.println(
						"Error de sintaxis: se esperaban las coordenadas del punto adonde se movió el cursor: mover <x>, <y>");
			}
		} else if (action.equals("soltar")) {
			this.editor.released();
		} else if (action.equals("dibujar")) {
			this.editor.drawDocument();
		} else if (action.equals("ayuda")) {
			showHelp(output);
		} else {
			output.println("Acción desconocida");
			showHelp(output);
		}

	}

	private void showHelp(PrintStream output) {
		output.println("");
		output.println(
				"Herramientas: seleccion - rectangulo - circulo - triangulo");
		output.println(
				"Acciones del ratón: pulsar <x>,<y> - mover <x>,<y> - soltar");
		output.println("Otras acciones: dibujar - ayuda - salir");
		output.println(
				"-----------------------------------------------------------");
	}
}
