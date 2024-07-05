package platform.playstation;

import java.awt.Point;

import platform.Image2D;
import platform.Platform;

public class Playstation5APIAdapter implements Platform {

	private Playstation5API api = new Playstation5API();

	@Override
	public Image2D load(String resource) {
		return this.api.loadGraphics(resource);
	}

	@Override
	public void show(int x, int y, Image2D image) {
		this.api.render(x, y, image);
	}

	@Override
	public Point getControls() {
		return this.api.getJoystick();
	}

}
