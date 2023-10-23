package editor;

import java.io.PrintStream;

import editor.herramientas.HeramientaSeleccion;
import editor.herramientas.Herramienta;
import editor.historial.Historial;

public class Editor {

	private Drawing drawing;
	private PrintStream output = System.out;
	public static boolean DEBUG;
	private Herramienta selectionTool;
	private Herramienta currentTool;
	private Historial historial = new Historial();

	public Editor() {
		setDrawing(new Drawing());
		this.output = new PrintStream(System.out, true);
		final HeramientaSeleccion selectionTool = new HeramientaSeleccion(this);
		this.selectionTool = selectionTool;
		this.currentTool = selectionTool;
	}

	public Editor(Drawing drawing) {
		setDrawing(drawing);
	}

	// $ Métodos del dibujo --------------------------------

	public Drawing getDrawing() {
		return drawing;
	}

	public void setDrawing(Drawing drawing) {
		this.drawing = drawing;
	}

	public void drawDocument() {
		this.drawing.draw(this.output);
	}

	public void selectTool(final Herramienta tool) {
		if (tool == null) {
			throw new IllegalArgumentException(
					"¡No se puede seleccionar una herramienta nula!");
		}
		this.currentTool = tool;
		this.trace("Se seleccion\u00f3 la herramienta: " + tool);
	}

	public void toolDone() {
		this.selectTool(this.selectionTool);
	}

	public void clickedOn(final int x, final int y) {
		this.currentTool.clickOn(x, y);
	}

	public void movedTo(final int x, final int y) {
		this.currentTool.moveTo(x, y);
	}

	public void released() {
		this.currentTool.release();
	}

	public void undo() {
		getHistorial().undo();
	}

	public void redo() {
		getHistorial().redo();
	}

	public void trace(final String message) {
		if (Editor.DEBUG) {
			this.output.println(message);
		}
	}

	public Historial getHistorial() {
		return historial;
	}
}
