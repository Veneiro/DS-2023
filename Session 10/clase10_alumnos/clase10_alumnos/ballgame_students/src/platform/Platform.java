package platform;

import java.awt.Point;

public interface Platform {

	public Image2D load(String resource);
	public void show(int x, int y, Image2D image);
	public Point getControls();
}
