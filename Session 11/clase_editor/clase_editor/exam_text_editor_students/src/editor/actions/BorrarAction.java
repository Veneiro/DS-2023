package editor.actions;

import java.io.IOException;

import editor.Editor;

public class BorrarAction implements Action {

	@Override
	public void execute(Editor editor) throws IOException {
		StringBuilder texto = new StringBuilder();
		int indexOfLastWord = texto.toString().trim().lastIndexOf(" ");
		if (indexOfLastWord == -1)
			texto = new StringBuilder("");
		else
			texto.setLength(indexOfLastWord + 1);
		
		editor.reemplazarTexto(texto);
	}

	
}
