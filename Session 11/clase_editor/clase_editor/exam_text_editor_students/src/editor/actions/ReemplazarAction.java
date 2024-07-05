package editor.actions;

import java.io.IOException;
import java.util.regex.Pattern;

import editor.Editor;

public class ReemplazarAction implements Action {

	private String inicial;
	private String reemplazo;
	
	
	
	public ReemplazarAction(String inicial, String reemplazo) {
		super();
		this.inicial = inicial;
		this.reemplazo = reemplazo;
	}



	@Override
	public void execute(Editor editor) throws IOException {
		editor.reemplazarTexto(new StringBuilder(editor.getTexto().toString().replaceAll(
				Pattern.quote(inicial), reemplazo)));
	}

}
