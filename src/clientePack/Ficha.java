package clientePack;

import java.awt.Color;


/**
 * <h1>Name.java</h1><hr>
 * <p>Esta clase represanta </p>
 *
 * @author Adrián Suárez Valdayo
 * @vesrion 27-dic-2024
 */
public class Ficha {

    private char jugador;
    private Color color;

    public Ficha(char jugador) {
        this.jugador = jugador;
        if(this.jugador == 'X')
            this.color = Color.BLUE;
        else if (this.jugador == 'O')
            this.color = Color.RED;
        else
            this.color = Color.BLACK;
    }

    public Color getColor() {
        return color;
    }

    public char getJugador() {
        return jugador;
    }
}
