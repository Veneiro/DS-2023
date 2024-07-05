package libros.modelo;

public class Imagen {

    private String nombre;
    private String url;

    public Imagen(String nombre, String url) {
        this.nombre = nombre;
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrl() {
        return url;
    }
}
