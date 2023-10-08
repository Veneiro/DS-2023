package editor.figuras;

import java.io.PrintStream;

import editor.herramientas.Delimitador;

public class Circle implements Figure {
	private int x;
	private int y;
	private int radious;

	public Circle(final int x, final int y, final int radious) {
		this.x = x;
		this.y = y;
		this.radious = radious;
	}

	public Circle(final Delimitador boundingBox) {
		final int size = Math.max(boundingBox.getWidth(),
				boundingBox.getHeight());
		this.x = boundingBox.getX() + size / 2;
		this.y = boundingBox.getY() + size / 2;
		this.radious = size / 2;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getRadious() {
		return this.radious;
	}

	@Override
	public void draw(final PrintStream output) {
		output.format("C\u00edrculo: (%d, %d), radio = %d", this.x, this.y,
				this.radious);
	}

	@Override
	public boolean contains(final int x, final int y) {
		final double distance = Math.sqrt(Math.pow(x - this.getX(), 2.0)
				+ Math.pow(y - this.getY(), 2.0));
		return distance < this.getRadious();
	}

	@Override
	public void moveBy(final int dx, final int dy) {
		this.x += dx;
		this.y += dy;
	}

	@Override
	public String toString() {
		return String.format("C\u00edrculo: centro = (%d, %d), radio = %d",
				this.x, this.y, this.radious);
	}
}
