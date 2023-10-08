package editor.figuras;

import editor.Editor;
import editor.herramientas.Delimitador;
import editor.herramientas.Herramienta;
import editor.herramientas.HerramientaCreacionAbstracta;

public class RectangleCreationTool extends HerramientaCreacionAbstracta
		implements Herramienta {
	public RectangleCreationTool(final Editor editor) {
		super(editor);
	}

	@Override
	protected Figure createFigure(final Delimitador boundingBox) {
		return new Rectangle(boundingBox);
	}

	@Override
	public String toString() {
		return "Rect\u00e1ngulo (herramienta de creaci\u00f3n de)";
	}
}
