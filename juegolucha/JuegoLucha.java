package juegolucha;

import juegolucha.personajes.Guerrero;
import juegolucha.personajes.Mago;
import juegolucha.personajes.Personaje;

/*

El programa es un juego de lucha en el que cada jugador crea un equipo que puede estar formado (de momento) por
guerreros y/o magos. Cada un tiene unos puntos de ataque y otros de defensa (que irán cambiando en el transcurso del
juego).  Para obtener estos puntos se llama a los métodos atacar() y defender()
En la lucha se irán seleccionando parejas de contrincantes (al azar) y se pondrán a luchar, en función del desarrollo de
la lucha (cuyo algoritmo puede verse en la clase Batalla), se asignará un punto al jugador 1 o 2. El que consiga mas
puntos gana.

 Se pide:
 Permitir añadir elementos a los personajes (De momento una armadura, poción y ballesta, aunque mas adelante podrían
 aparecer otros). Estos modificarán el comportamiento de los jugadores como se muestra:
    a) La armadura aumenta en 30 unidades la puntuación de defensa (cuando se llama al metodo defender(), el resultado
    de este se aumenta en 30 unidades sobre el obtenido sin armadura) y reduce en 10 la de ataque.
    b) La poción multiplica por 2 la puntuación de ataque, auque solo se puede usar en 3 ataques. Luego no tiene
    efecto. No influye en la defensa.
    c) La ballesta aumenta en 50 unidades la puntuación de ataque, pero solo las 5 primeras veces, mientras que reduce
    la defensa a la mitad siempre.
Debe tenerse en cuenta que a cada personaje se le podrá añadir cero, uno o varios elementos.




 */
public class JuegoLucha {

    public static void main(String[] args) {
        Batalla b = new Batalla(
                new Personaje[]{
                        new Guerrero(),
                        new Guerrero(),
                        new Mago()
                },
                new Personaje[]{
                        new Guerrero(),
                        new Mago(),
                        new Mago()
                }
        );
        b.luchar();
    }
}
