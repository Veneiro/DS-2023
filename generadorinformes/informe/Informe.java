package generadorinformes.informe;

import generadorinformes.modelo.Factura;

import java.util.ArrayList;
import java.util.List;

public class Informe {

    private List<Factura> items = new ArrayList<>();

    public void add(Factura f) {
        items.add(f);
    }

    public void generar() {
        System.out.printf("%-30s%s\n", "CONCEPTO", "VALOR");
        double total = 0;
        for (Factura item: items) {
            System.out.printf("%-30s", item.getCliente());
            System.out.printf("%f", item.getImporte());
            System.out.println();
            total += item.getImporte();
        }
        System.out.printf("%30s%f\n", "TOTAL: ", total);
    }
}
