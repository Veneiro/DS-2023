package juegolucha.personajes;

public class Mago implements Personaje{

    private int numAtaque = 0;
    private int numDefensa = 0;

    @Override
    public String getNombre() {
        return "Mago";
    }

    @Override
    public int atacar() {
        numAtaque++;
        if (numAtaque % 3 == 0) {
            return 100;
        }
        else {
            return 10;
        }
    }

    @Override
    public int defender() {
        numDefensa++;
        if (numDefensa % 3 == 0) {
            return 100;
        }
        else {
            return 10;
        }
    }
}
