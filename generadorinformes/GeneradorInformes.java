package generadorinformes;

import generadorinformes.bd.BD;
import generadorinformes.informe.Informe;
import generadorinformes.modelo.Factura;

/*

Tenemos un generador de informes. Cada linea del informe estará compuesta por un texto y un valor real. Además, al final
se mostrará la suma total de todos los valores del informe.

Nos gustaría poder usar este informe para otros tipos de entidades del modelo (Productos de momento). Mejora el diseño
para que se pueda teniendo en cuenta lo siguiente:

1) Las clases del paquete "modelo" no se pueden tocar (proceden de otra parte de la aplicación que debe mantenerse
igual).

2) El informe de productos debería verse así:
CONCEPTO                      VALOR
Pantallo (Stock 100)          30.990000
Camiseta (Stock 200)          18.500000
Sudadera (Stock 300)          42.950000
                       TOTAL: 92.440000

 */

public class GeneradorInformes {

    public static void main(String [] args) {
        BD bd = new BD();
        Informe i = new Informe();
        for (Factura f: bd.getFacturas()) {
            i.add(f);
        }
        i.generar();
    }
}
