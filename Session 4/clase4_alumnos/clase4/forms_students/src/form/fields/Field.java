
package form.fields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import form.validator.Validador;

public class Field {
	
	private String label;
	private String value;
	private Validador validator;

	public Field(String label, Validador v) {
			this.label = label;
			this.validator = v;
		}

	public void askUser() {
		BufferedReader console = new BufferedReader(
				new InputStreamReader(System.in));
		do {
			try {
				System.out.print(label + ": ");
				value = console.readLine();
			} catch (IOException ex) {
				System.out.println(ex);
			}
		} while (!validator.validate(value));
	}

	public String getValue() {
		return value;
	}
}
