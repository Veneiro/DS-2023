package juegolucha.personajes;

public class Guerrero implements Personaje {
    private int energia = 100;

    @Override
    public String getNombre() {
        return "Guerrero";
    }

    @Override
    public int atacar() {
        energia -= 10;
        return energia*2;
    }

    @Override
    public int defender() {
        return 60;
    }
}
