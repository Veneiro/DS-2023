package editor.figuras;

import java.io.PrintStream;

import editor.herramientas.Delimitador;

public class Triangle implements Figure {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int x3;
	private int y3;

	public Triangle(final int x1, final int y1, final int x2, final int y2,
			final int x3, final int y3) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
	}

	public Triangle(final Delimitador boundingBox) {
		this.x1 = boundingBox.getX() + boundingBox.getWidth() / 2;
		this.y1 = boundingBox.getY();
		this.x2 = boundingBox.getX();
		this.y2 = boundingBox.getY() + boundingBox.getHeight();
		this.x3 = boundingBox.getX() + boundingBox.getWidth();
		this.y3 = boundingBox.getY() + boundingBox.getHeight();
	}

	public int getX1() {
		return this.x1;
	}

	public int getY1() {
		return this.y1;
	}

	public int getX2() {
		return this.x2;
	}

	public int getY2() {
		return this.y2;
	}

	public int getX3() {
		return this.x3;
	}

	public int getY3() {
		return this.y3;
	}

	@Override
	public void draw(final PrintStream output) {
		output.format("Tri\u00e1ngulo: (%d, %d), (%d, %d), (%d, %d)", this.x1,
				this.y1, this.x2, this.y2, this.x3, this.y3);
	}

	@Override
	public boolean contains(final int x, final int y) {
		return (x == this.x1 && y == this.y1) || (x == this.x2 && y == this.y2)
				|| (x == this.x3 && y == this.y3);
	}

	@Override
	public void moveBy(final int dx, final int dy) {
		this.x1 += dx;
		this.y1 += dy;
		this.x2 += dx;
		this.y2 += dy;
		this.x3 += dx;
		this.y3 += dy;
	}

	@Override
	public String toString() {
		return String.format("Tri\u00e1ngulo: (%d, %d), (%d, %d), (%d, %d)",
				this.x1, this.y1, this.x2, this.y2, this.x3, this.y3);
	}
}
