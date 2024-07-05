package editor.actions;

import java.io.IOException;

import editor.Editor;

public class InsertarAction implements Action {

	private String toInsert;

	public InsertarAction(String toInsert) {
		this.toInsert = toInsert;
	}

	@Override
	public void execute(Editor editor) throws IOException {
		StringBuilder texto = editor.getTexto();
		texto.append(this.toInsert);
		editor.reemplazarTexto(texto);
	}

}
