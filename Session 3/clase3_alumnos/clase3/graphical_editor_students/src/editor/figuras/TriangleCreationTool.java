package editor.figuras;

import editor.Editor;
import editor.herramientas.Herramienta;
import editor.historial.actions.CreateAction;

public class TriangleCreationTool implements Herramienta {
	private Editor editor;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int x3;
	private int y3;
	private int vertices;

	public TriangleCreationTool(final Editor editor) {
		if (editor == null) {
			throw new IllegalArgumentException(
					"Se necesita una referencia al editor");
		}
		this.editor = editor;
	}

	@Override
	public void clickOn(final int x, final int y) {
		++this.vertices;
		if (this.vertices == 1) {
			this.editor.getDrawing().clearCurrentSelection();
			this.x1 = x;
			this.y1 = y;
		} else if (this.vertices == 2) {
			this.x2 = x;
			this.y2 = y;
		} else if (this.vertices == 3) {
			this.x3 = x;
			this.y3 = y;
			Figure f = new Triangle(this.x1, this.y1,
					this.x2, this.y2, this.x3, this.y3);
			this.editor.getDrawing().addFigure(f);
			this.vertices = 0;
			this.editor.toolDone();
			this.editor.getHistorial()
			.add(new CreateAction(editor.getDrawing(), f));
		}
	}

	@Override
	public void moveTo(final int x, final int y) {
	}

	@Override
	public void release() {
	}

	@Override
	public String toString() {
		return "Tri\u00e1ngulo (herramienta de creaci\u00f3n de)";
	}
}
