package libros.modelo;

import java.util.List;

public class Seccion {

    private String titulo;
    private Object[] contenido;

    public Seccion(String titulo, Object ... contenido) {
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public String getTitulo() {
        return titulo;
    }

    public Object[] getContenido() {
        return contenido;
    }
}
