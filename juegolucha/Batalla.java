package juegolucha;

import juegolucha.personajes.Personaje;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Batalla {

    private Personaje[] personajesJ1;
    private Personaje[] personajesJ2;

    public Batalla(Personaje[] personajesJ1, Personaje[] personajesJ2) {
        this.personajesJ1 = personajesJ1;
        this.personajesJ2 = personajesJ2;
    }

    public void luchar() {
        int victoriasJ1 = 0;
        int victoriasJ2 = 0;
        Random r = new Random();
        for (int i = 0; i < 100; i++) {
            Personaje personajeJ1 = personajesJ1[r.nextInt(personajesJ1.length)];
            Personaje personajeJ2 = personajesJ2[r.nextInt(personajesJ2.length)];
            System.out.print(personajeJ1.getNombre() + " lucha contra " + personajeJ2.getNombre());
            int puntosAtaqueJ1 = personajeJ1.atacar();
            int puntosAtaqueJ2 = personajeJ2.atacar();
            int puntosDefensaJ1 = personajeJ1.defender();
            int puntosDefensaJ2 = personajeJ2.defender();
            if (puntosAtaqueJ1 > puntosDefensaJ2 && puntosAtaqueJ2 < puntosDefensaJ1) {
                victoriasJ1++;
                System.out.println(" -> " + personajeJ1.getNombre() + " Gana");
            }
            else if (puntosAtaqueJ2 > puntosDefensaJ1 && puntosAtaqueJ1 < puntosDefensaJ2) {
                victoriasJ2++;
                System.out.println(" -> " + personajeJ2.getNombre() + " Gana");
            }
            else {
                System.out.println(" -> El combate acaba en tablas");
            }
            System.out.println("J1 " + victoriasJ1 + " / J2 " + victoriasJ2);
        }

        System.out.println("--- FIN ---");
        if (victoriasJ1 > victoriasJ2) {
            System.out.println("-> Gana el jugador 1");
        }
        else if (victoriasJ1 < victoriasJ2) {
            System.out.println("-> Gana el jugador 2");
        }
        else {
            System.out.println("-> Empate");
        }
    }


}
