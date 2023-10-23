package editor;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import editor.figuras.Figure;

public class Drawing {

	private List<Figure> figures;
	private Figure currentSelection;
	
	public Drawing() {
		this.figures = new ArrayList<Figure>();
	}

	public void addFigure(final Figure figure) {
		if (figure == null) {
			throw new IllegalArgumentException(
					"¡No se puede a\u00f1adir una figura nula!");
		}
		this.figures.add(0, figure);
		this.clearCurrentSelection();
		this.setCurrentSelection(figure);
	}

	public void removeFigure(final Figure figure) {
		if (figure == null) {
			throw new IllegalArgumentException(
					"¡No se puede borrar una figura nula!");
		}
		if (!this.figures.contains(figure)) {
			throw new IllegalArgumentException(
					"El documento no contiene dicha figura, no se ha podido borrar: "
							+ figure);
		}
		this.figures.remove(figure);
	}

	public Figure findFigureAt(final int x, final int y) {
		for (final Figure figure : this.figures) {
			if (figure.contains(x, y)) {
				return figure;
			}
		}
		return null;
	}

	public void draw(final PrintStream output) {
		if (this.figures.isEmpty()) {
			return;
		}
		output.println("Figuras: ");
		for (final Figure figure : this.figures) {
			output.print(" - ");
			figure.draw(output);
			if (figure == this.currentSelection) {
				output.print(" (*)");
			}
			output.println();
		}
	}

	public void setCurrentSelection(final Figure figure) {
		if (!this.figures.contains(figure)) {
			throw new IllegalArgumentException(
					"¡No se puede seleccionar una figura que no existe en el documento!: "
							+ figure);
		}
		this.currentSelection = figure;
	}

	public Figure getCurrentSelection() {
		return this.currentSelection;
	}

	public void clearCurrentSelection() {
		this.currentSelection = null;
	}

	public List<Figure> getFigures() {
		return new ArrayList<Figure>(figures);
	}
}
