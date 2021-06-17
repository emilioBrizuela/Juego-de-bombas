package app;

import java.awt.*;
import javax.swing.*;

public class Pantalla extends JPanel {

    private Personaje jugador;
    private Personaje bomba;
    private Personaje explosion;

    public Pantalla() {
        setLayout(null);

        setBackground(Color.WHITE);

        explosion = new Personaje(0, 200, "img/img3.jpg",40);
        //explosion.mostrarPersonaje();
        add(explosion);

        bomba = new Personaje(45, 0, "img/img2.jpg");
        bomba.mostrarPersonaje();
        add(bomba);
        
        jugador = new Personaje(45, 200, "img/img.jpg");
        jugador.mostrarPersonaje();
        add(jugador);


    }

    /**
     * Devuelve el personaje o la bomba
     * @return false: personaje | false: bomba
     */
    public Personaje getPersonaje(boolean bomba) {
         
        if(bomba){
            return this.bomba;
        }else{
            return this.jugador;
        }
        
    }
    public Personaje getExplosion() {

        return this.explosion;
    }


}