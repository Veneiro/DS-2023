package editor.historial.actions;

import editor.Drawing;
import editor.figuras.Figure;

public class CreateAction implements Action {
	
	private Figure figure;
	private Drawing drawing;

	public CreateAction(Drawing drawing, Figure newFigure) {
		this.figure = newFigure;
		this.drawing = drawing;
	}

	@Override
	public void redo() {
		this.drawing.addFigure(figure);
	}

	@Override
	public void undo() {
		this.drawing.removeFigure(figure);
	}

}
