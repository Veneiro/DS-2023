package editor.herramientas;

import editor.Editor;
import editor.figuras.Figure;

public class HeramientaSeleccion implements Herramienta {
	private Editor editor;
	private int x;
	private int y;
	private Figure selectedFigure;

	public HeramientaSeleccion(final Editor editor) {
		if (editor == null) {
			throw new IllegalArgumentException(
					"La herramienta de selecci\u00f3n necesita una referencia al editor");
		}
		this.editor = editor;
	}

	public void clickOn(final int x, final int y) {
		this.editor.trace(String.format(
				"Se hizo clic con la herramienta de selecci\u00f3n en (%d, %d)",
				x, y));
		this.selectedFigure = this.editor.getDrawing().findFigureAt(x, y);
		if (this.selectedFigure != null) {
			this.editor.trace(
					"Se seleccion\u00f3 la figura: " + this.selectedFigure);
			this.editor.getDrawing().setCurrentSelection(this.selectedFigure);
		} else {
			this.editor.trace(
					"No hay ninguna figura en esa posici\u00f3n, se limpia la selecci\u00f3n anterior que hubiera");
			this.editor.getDrawing().clearCurrentSelection();
		}
		this.setPosition(x, y);
	}

	private void setPosition(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	public void moveTo(final int x, final int y) {
		if (this.selectedFigure == null) {
			this.editor.trace(String.format(
					"Se movi\u00f3 el cursor con la herramienta de selecci\u00f3n a (%d, %d)",
					x, y));
			return;
		}
		this.editor.trace(String.format(
				"Se arrastr\u00f3 con la herramienta de selecci\u00f3n hasta (%d, %d)",
				x, y));
		this.selectedFigure.moveBy(x - this.x, y - this.y);
		this.editor.trace("Se movi\u00f3 la figura: " + this.selectedFigure);
		this.setPosition(x, y);
	}

	public void release() {
		this.editor.trace(String.format(
				"Se solt\u00f3 el bot\u00f3n del rat\u00f3n con la herramienta de selecci\u00f3n en (%d, %d)",
				this.x, this.y));
		this.selectedFigure = null;
	}

	@Override
	public String toString() {
		return "Herramienta de selecci\u00f3n";
	}
}
