package editor.historial;

import java.util.Stack;

import editor.historial.actions.Action;

public class Historial {
	private Stack<Action> cacheToRedo = new Stack<Action>();
	private Stack<Action> cacheToUndo = new Stack<Action>();

	public void add(Action a) {
		cacheToUndo.push(a);
	}
	
	public void undo() {
		Action a = cacheToUndo.pop();
		a.undo();
		cacheToRedo.push(a);
	}
	
	public void redo() {
		Action a = cacheToRedo.pop();
		a.redo();
		cacheToUndo.push(a);
	}
}
