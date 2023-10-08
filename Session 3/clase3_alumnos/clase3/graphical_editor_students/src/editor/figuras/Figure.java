package editor.figuras;

import java.io.PrintStream;

public interface Figure {
	void draw(final PrintStream output);

	boolean contains(final int p0, final int p1);

	void moveBy(final int p0, final int p1);
}
