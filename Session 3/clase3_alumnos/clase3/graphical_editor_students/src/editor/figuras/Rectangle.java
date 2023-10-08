package editor.figuras;

import java.io.PrintStream;

import editor.herramientas.Delimitador;

public class Rectangle implements Figure {
	private int x;
	private int y;
	private int width;
	private int height;

	public Rectangle(final int x, final int y, final int width,
			final int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public Rectangle(final Delimitador boundingBox) {
		this(boundingBox.getX(), boundingBox.getY(), boundingBox.getWidth(),
				boundingBox.getHeight());
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	@Override
	public void draw(final PrintStream output) {
		output.format("Rect\u00e1ngulo: (%d, %d), ancho = %d, alto = %d",
				this.x, this.y, this.width, this.height);
	}

	@Override
	public boolean contains(final int x, final int y) {
		return this.x <= x && x <= this.x + this.width && this.y <= y
				&& y <= this.y + this.height;
	}

	@Override
	public void moveBy(final int dx, final int dy) {
		this.x += dx;
		this.y += dy;
	}

	@Override
	public String toString() {
		return String.format("Rect\u00e1ngulo: (%d, %d), ancho = %d, alto = %d",
				this.x, this.y, this.width, this.height);
	}
}
