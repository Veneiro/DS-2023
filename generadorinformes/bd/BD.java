package generadorinformes.bd;

import generadorinformes.informe.Informe;
import generadorinformes.modelo.Factura;
import generadorinformes.modelo.Producto;

import java.util.Arrays;
import java.util.List;

public class BD {

    public List<Factura> getFacturas() {
        return Arrays.asList(
                new Factura(123.52, "Juan"),
                new Factura(99.99, "Ana"),
                new Factura(200.99, "Luis")
        );
    }

    public List<Producto> getProductos() {
        return Arrays.asList(
                new Producto("Pantalon", 30.99, 100),
                new Producto("Camiseta", 18.50, 200),
                new Producto("Sudadera", 42.95, 300)
        );
    }
}
