package editor.figuras;

import editor.Editor;
import editor.herramientas.Delimitador;
import editor.herramientas.Herramienta;
import editor.herramientas.HerramientaCreacionAbstracta;

public class CircleCreationTool extends HerramientaCreacionAbstracta
		implements Herramienta {
	public CircleCreationTool(final Editor editor) {
		super(editor);
	}

	@Override
	protected Figure createFigure(final Delimitador boundingBox) {
		return new Circle(boundingBox);
	}

	@Override
	public String toString() {
		return "C\u00edrculo (herramienta de creaci\u00f3n de)";
	}
}
