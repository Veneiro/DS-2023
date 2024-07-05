package libros.modelo;

import java.util.HashMap;
import java.util.Map;

public class Libro {

    private Pagina [] paginas;

    public Libro(Pagina ... paginas) {
        this.paginas = paginas;
    }

    public void imprimir() {
        for (Pagina pagina: paginas) {
            for (Object o: pagina.getContenido()) {
                if (o instanceof Seccion) {
                    System.out.println(((Seccion)o).getTitulo().toUpperCase());
                    for (Object o2: ((Seccion)o).getContenido()) {
                        imprimirContenido(o2);
                    }
                }
                else {
                    imprimirContenido(o);
                }
            }
            System.out.println(" - Pagina " + pagina.getNumero() + " -");
        }
    }

    public Map<String, Integer> indiceDeImagenes() {

        // Esto es solo una muestra. El método deberá devolver un map con los nombres de las imagenes y el número
        // de página en el que se encuentran.

        Map<String, Integer> i = new HashMap<>();
        i.put("Prueba A", 1);
        i.put("Prueba B", 2);
        return i;
    }

    public String resumen() {
        // Esto es solo una muestra. Este método deberá devolver un resumen del libro. El resumen consistirá en un
        // String que contendrá los 10 primeros caracteres de cada Parrafo del libro.
        return "Resumen";
    }

    public int buscar(String palabra) {
        // Esto es solo una muestra. Este método deberá devolver el número de página donde se encuentre la palabra
        // indicada (solo se devolverá la primera página, si está en mas de una). La palabrá deberá buscarse en:
        //  - texto de los parrafos.
        //  - titulo de las secciones.
        //  - Nombre de las imagenes.
        return 0;
    }

    private void imprimirContenido(Object o) {
        if (o instanceof Parrafo) {
            System.out.println(((Parrafo)o).getTexto());
        }
        else if (o instanceof Imagen) {
            System.out.println("IMAGEN " + ((Imagen)o).getNombre() + ": " + ((Imagen)o).getUrl());
        }
    }
}
