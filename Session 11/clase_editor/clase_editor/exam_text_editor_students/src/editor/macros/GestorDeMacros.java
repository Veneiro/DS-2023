package editor.macros;

import java.io.IOException;
import java.util.HashMap;

import editor.Editor;
import editor.actions.Action;

public class GestorDeMacros {

	private HashMap<String, Macro> macros = new HashMap<String, Macro>();
	private boolean recording = false;
	private Editor editor;

	public GestorDeMacros(Editor editor) {
		this.recording = true;
		this.editor = editor;
	}

	public void record(Action a, String macroName) {
		Macro m = macros.get(macroName);
		if (m != null) {
			m.actions.add(a);
		} else {
			m = new Macro(editor);
			macros.put(macroName, m);
			m.actions.add(a);
		}
	}

	public void executeMacro(String name) throws IOException {
		macros.get(name).executeActions();
	}

	public boolean isRecording() {
		return recording;
	}

	public void stopRecording() {
		this.recording = false;
	}
}
