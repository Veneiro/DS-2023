package main;

import java.io.IOException;

import outputs.modifiers.Contador;
import outputs.modifiers.Encriptar;
import outputs.modifiers.NoEspaciosRepetidos;
import outputs.modifiers.Normalizar;
import outputs.types.Internet;

public class Main 
{
	public static void main(String[] args) throws IOException 
	{
		FileSystem system = new FileSystem();
		Contador f = new Contador(new Internet("156.17.11.196"));
		Contador out = new Contador(new Normalizar(new Encriptar(new NoEspaciosRepetidos(f))));
		system.copyFile("privado.txt", out);
		System.out.println(out.getCounter() + " " + f.getCounter());
	}

}
