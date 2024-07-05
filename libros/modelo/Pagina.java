package libros.modelo;

public class Pagina {

    private int numero;

    private Object [] contenido;

    public Pagina(int numero, Object ... contenido) {
        this.numero = numero;
        this.contenido = contenido;
    }

    public int getNumero() {
        return numero;
    }

    public Object[] getContenido() {
        return contenido;
    }
}
