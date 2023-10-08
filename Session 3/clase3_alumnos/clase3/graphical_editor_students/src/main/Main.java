package main;

import java.io.IOException;

import editor.Editor;

public class Main {

	public static void main(String[] args) throws IOException {
		Editor editor = new Editor();
		final Menu menu = new Menu(editor);
		menu.run();
	}
}
