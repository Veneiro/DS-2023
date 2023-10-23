package generadorinformes.modelo;

public class Factura {

    private double importe;
    private String cliente;

    public Factura(double importe, String cliente) {
        this.importe = importe;
        this.cliente = cliente;
    }

    public double getImporte() {
        return importe;
    }

    public String getCliente() {
        return cliente;
    }
}
