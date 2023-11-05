package main;

import java.io.IOException;

import outputs.modifiers.Contador;
import outputs.modifiers.Encriptar;
import outputs.modifiers.NoEspaciosRepetidos;
import outputs.modifiers.Normalizar;
import outputs.types.FileOutput;
import outputs.types.Internet;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		FileSystem system = new FileSystem();
		Contador fOutput = new Contador(new FileOutput("copiaPrivada.txt"));
		Contador fOut = new Contador(new Encriptar(fOutput));
		system.copyFile("privado.txt", fOut);
		System.out.println("Se han enviado " + fOutput.getCounter() + "# caracteres");

		Contador fOutputP = new Contador(new FileOutput("copiaPublica.txt"));
		system.copyFile("privado.txt", fOutputP);
		System.out.println("Se han enviado " + fOutputP.getCounter() + "# caracteres");

		Contador f = new Contador(new Internet("156.17.11.196"));
		Contador out = new Contador(new Normalizar(new NoEspaciosRepetidos(f)));
		system.copyFile("privado.txt", out);
		System.out.println("Se han enviado " + f.getCounter() + "# caracteres");

		f = new Contador(new Internet("156.17.11.196"));
		out = new Contador(new Normalizar(f));
		system.copyFile("privado.txt", out);
		System.out.println("Se han enviado " + f.getCounter() + "# caracteres");
		System.out.println("Incialmente había " + out.getCounter() + "# caracteres");
		System.out.println("Después de normalizar, se han enviado " + f.getCounter() + "# caracteres");

		f = new Contador(new Internet("156.17.11.196"));
		out = new Contador(new NoEspaciosRepetidos(f));
		system.copyFile("privado.txt", out);
		System.out.println("Se han enviado " + f.getCounter() + "# caracteres");
		System.out.println("Incialmente había " + out.getCounter() + "# caracteres");
		System.out.println("Después de quitar espacios repetidos, se han enviado " + f.getCounter() + "# caracteres");

		f = new Contador(new Internet("156.17.11.196"));
		out = new Contador(new Normalizar(new NoEspaciosRepetidos(f)));
		system.copyFile("privado.txt", out);
		System.out.println("Se han enviado " + f.getCounter() + "# caracteres");
		System.out.println("Incialmente había " + out.getCounter() + "# caracteres");
		System.out.println("Después de normalizar y quitar espacios, se han enviado " + f.getCounter() + "# caracteres");
	}

}
