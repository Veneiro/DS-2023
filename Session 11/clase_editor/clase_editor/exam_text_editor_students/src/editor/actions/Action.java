package editor.actions;

import java.io.IOException;

import editor.Editor;

public interface Action {

	public void execute(Editor editor) throws IOException;
}
