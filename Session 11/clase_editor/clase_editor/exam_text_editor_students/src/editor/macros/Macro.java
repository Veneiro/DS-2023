package editor.macros;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import editor.Editor;
import editor.actions.Action;

public class Macro {
	
	public List<Action> actions = new ArrayList<>();
	private Editor editor;
	
	public Macro(Editor editor) {
		this.editor = editor;
	}

	public void executeActions() throws IOException {
		for (Action action : actions) {
			action.execute(this.editor);
		}
	}
	
	public void addAction(Action a) {
		this.actions.add(a);
	}
}
