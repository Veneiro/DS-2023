package platform.windows;

import java.awt.Point;

import platform.Image2D;
import platform.Platform;

public class WindowsAPIAdapter implements Platform {

	private WindowsAPI api = new WindowsAPI();
	
	@Override
	public Image2D load(String resource) {
		return this.api.loadFile(resource);
	}

	@Override
	public void show(int x, int y, Image2D image) {
		this.api.paint(x, y, image);
	}

	@Override
	public Point getControls() {
		return this.api.getMouseClick();
	}

}
