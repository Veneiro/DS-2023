package form;

import form.fields.Field;
import form.validator.ValidadorAnd;
import form.validator.ValidadorLongitud;
import form.validator.ValidadorMayorQue;
import form.validator.ValidadorMenorQue;
import form.validator.ValidadorNumerico;
import form.validator.ValidadorOr;
import form.validator.ValidadorPredefinido;
import form.validator.ValidadorTexto;

public class Main {

	public static void main(String[] args) {
		Form form = new Form();

		form.addField(new Field("Nombre", new ValidadorTexto()));
		form.addField(new Field("Apellido", new ValidadorTexto()));
		form.addField(new Field("Teléfono", new ValidadorNumerico()));
		form.addField(new Field("Ciudad",
				new ValidadorPredefinido("Santander", "Oviedo", "Cádiz")));

		form.addField(
				new Field("Codigo de Producto", new ValidadorLongitud(4)));
		form.addField(new Field("Codigo Postal", new ValidadorAnd(
				new ValidadorNumerico(), new ValidadorLongitud(5))));
		form.addField(new Field("Edad", new ValidadorAnd(
				new ValidadorNumerico(), new ValidadorMayorQue(18))));
		form.addField(new Field("Sueldo",
				new ValidadorAnd(new ValidadorNumerico(),
						new ValidadorAnd(new ValidadorMayorQue(800),
								new ValidadorMenorQue(1200)))));
		form.addField(
				new Field("Ubicacion",
						new ValidadorOr(new ValidadorTexto(),
								new ValidadorAnd(new ValidadorNumerico(),
										new ValidadorLongitud(5)))));
		form.addField(
				new Field("Codigo de Promocion",
						new ValidadorOr(new ValidadorTexto(),
								new ValidadorAnd(new ValidadorNumerico(),
										new ValidadorLongitud(3)))));
		form.askUser();
	}
}
