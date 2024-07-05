package platform.android;

import java.awt.Point;

import platform.Image2D;
import platform.Platform;

public class AndroidAPIAdapter implements Platform {

	private AndroidAPI api = new AndroidAPI();

	@Override
	public Image2D load(String resource) {
		return this.api.loadResource(resource);
	}

	@Override
	public void show(int x, int y, Image2D image) {
		this.api.draw(x, y, image);
	}

	@Override
	public Point getControls() {
		return this.api.getTouch();
	}

}
