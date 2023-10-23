package editor.historial.actions;

import editor.figuras.Figure;

public class MoveAction implements Action {

	private int dx;
	private int dy;
	private Figure figure;
	
	public MoveAction(Figure figure, int x, int y) {
		this.dx = x;
		this.dy = y;
		this.figure = figure;
	}
	
	@Override
	public void redo() {
		this.figure.moveBy(dx, dy);
	}

	@Override
	public void undo() {
		this.figure.moveBy(-dx, -dy);
	}

}
