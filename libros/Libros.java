package libros;

import libros.modelo.*;

import java.awt.*;
import java.util.Map;

/*

Este programa permite crear libros formados por páginas. Cada página podrá estar formada por parrafos, imagenes
o secciones (que a su vez podrán estar formadas por parrafos, imagenes o secciones). El libro cuenta con un método
imprimir que permite mostrar por pantalla el contenido de este. Sin embargo, el programa actual no esta functionando
correctamente. La sección "Explicación" no se está mostrando (debería aparecer como parte de la sección "Gráfico con
texto".

Se pide:
    - Arreglar el programa anterior para que el libro se imprima correctamente (incluyendo la sección "Explicación").
    - Completar los métodos indiceDeImagenes, resumen y buscar de la clase Libro. Estos métodos tienen ahora una
      implementación de muestra que deberá ser sustituida por la real.

 */

public class Libros {

    public static void main(String [] args) {

        Parrafo p1 = new Parrafo("Este es el primera parrafo del libro");
        Parrafo p2 = new Parrafo("Este es el segundo parrafo del libro");
        Parrafo p3 = new Parrafo("Este es el tercer parrafo del libro");
        Parrafo p4 = new Parrafo("Este es el cuarto parrafo del libro");
        Parrafo p5 = new Parrafo("Este es el quinto parrafo del libro");

        Imagen i1 = new Imagen("Paisaje", "paisaje.jpg");
        Imagen i2 = new Imagen("Retrato", "retrato.jpg");
        Imagen i3 = new Imagen("Gráfico", "grafico.png");

        Seccion s1 = new Seccion("Texto y foto", p1, i1);
        Seccion s2 = new Seccion("Explicacion", p4, p5);
        Seccion s3 = new Seccion("Gráfico con texto", i3, s2);

        Pagina pag1 = new Pagina(1, s1, p2);
        Pagina pag2 = new Pagina(2, p3, i2);
        Pagina pag3 = new Pagina(2, s3);

        Libro libro = new Libro(pag1, pag2, pag3);
        libro.imprimir();

        Map<String, Integer> ts = libro.indiceDeImagenes();
        System.out.println();
        System.out.println("INDICE DE IMAGENES");
        for (Map.Entry<String, Integer> e: ts.entrySet()) {
            System.out.printf("%-10s Pág %d\n", e.getKey(), e.getValue());
        }

        System.out.println();
        System.out.println("RESUMEN");
        System.out.println(libro.resumen());

        System.out.println();
        System.out.println("BUSQUEDAS");
        System.out.println("'Explicación' esta en la página " + libro.buscar("Explicación"));
        System.out.println("'cuarto' esta en la página " + libro.buscar("cuarto"));
        System.out.println("'Retrato' esta en la página " + libro.buscar("Retrato"));
    }
}
