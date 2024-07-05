package main;

import game.BallGame;
import platform.Platform;
import platform.android.AndroidAPIAdapter;
import platform.playstation.Playstation5APIAdapter;
import platform.windows.WindowsAPIAdapter;

public class Main {
	public static void main(String[] args) {

		Platform android = new AndroidAPIAdapter();
		Platform playstation = new Playstation5APIAdapter();
		Platform windows = new WindowsAPIAdapter();

		BallGame game = new BallGame(android);
		game.play();
	}
}
