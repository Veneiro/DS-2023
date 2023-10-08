package editor.herramientas;

import editor.Editor;
import editor.figuras.Figure;

public abstract class HerramientaCreacionAbstracta implements Herramienta {
	private Editor editor;
	private Delimitador boundingBox;

	protected HerramientaCreacionAbstracta(final Editor editor) {
		if (editor == null) {
			throw new IllegalArgumentException(
					"Las herramientas de creaci\u00f3n necesitan una "
							+ "referencia (no nula) al editor");
		}
		this.editor = editor;
	}

	@Override
	public void clickOn(final int x, final int y) {
		this.editor.getDrawing().clearCurrentSelection();
		this.editor.trace(String.format(
				"Comenzando a crear un \u00e1rea rectangular en (%d, %d)...", x,
				y));
		this.boundingBox = new Delimitador(x, y);
	}

	@Override
	public void moveTo(final int x, final int y) {
		if (this.boundingBox == null) {
			this.editor.trace(String.format(
					"Se movi\u00f3 el cursor a (%d, %d), pero sin haber pulsado "
							+ "antes: no tiene ning\u00fan efecto",
					x, y));
			return;
		}
		this.editor.trace(
				String.format("Se movi\u00f3 el cursor del rat\u00f3n a la "
						+ "posici\u00f3n (%d, %d)", x, y));
		this.boundingBox.resizeTo(x, y);
		this.editor.trace(
				"El \u00e1rea actual de la herramienta de creaci\u00f3n es: "
						+ this.boundingBox);
	}

	@Override
	public void release() {
		if (this.boundingBox == null) {
			this.editor.trace(
					"No se deber\u00eda haber recibido un evento de soltar "
							+ "creando una figura sin haber pulsado previamente en "
							+ "alg\u00fan punto");
			return;
		}
		final Figure newFigure = this.createFigure(this.boundingBox);
		this.editor.getDrawing().addFigure(newFigure);
		this.editor.trace("Se cre\u00f3 la figura: " + newFigure);
		this.editor.toolDone();
		this.boundingBox = null;
	}

	protected abstract Figure createFigure(final Delimitador p0);

	@Override
	public String toString() {
		return "Herramienta (abstracta) de creaci\u00f3n";
	}
}
