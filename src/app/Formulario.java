package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Formulario extends JFrame {

    private int limiteMovimientoDerecha = 90;
    private int limiteMovimientoIzquierda = 0;
    private Timer temporizador;
    private int velocidadCaida = 500;
    private Pantalla pantalla;
    private PanelDeBotones btn;
    private int cantBombasCaidas = 5;

    /** Inicializa el contenido del formulario */
    public Formulario() {

        setTitle("Bombardero");
        setLayout(new BorderLayout(30, 30));
        llenarFormulario();

    }

    /**
     * Carga el contenido del formulario
     */

    private void llenarFormulario() {

        JLabel margenSuperior = new JLabel();
        JLabel margenDerecho = new JLabel();
        JLabel margenIzquierdo = new JLabel();

        add(margenSuperior, BorderLayout.NORTH);
        add(margenDerecho, BorderLayout.WEST);
        add(margenIzquierdo, BorderLayout.EAST);

        pantalla = new Pantalla();
        add(pantalla, BorderLayout.CENTER);

        btn = new PanelDeBotones();
        add(btn, BorderLayout.SOUTH);

        moverPersonaje();
        aparicionBomba();
    }

    /**
     * Mueve al personaje en el eje X.
     * 
     * @param jugador Jugador
     * @param btn     boton izq o der
     */

    public void moverPersonaje() {
        Personaje jugador = pantalla.getPersonaje(false);
        btn.getIzq().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (jugador.getPosicionPersonajeX() < limiteMovimientoDerecha) {
                    jugador.setPosicionPersonajeX(jugador.getPosicionPersonajeX() + 5);
                    jugador.mostrarPersonaje();
                }
            }

        });

        btn.getDer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                if (jugador.getPosicionPersonajeX() > limiteMovimientoIzquierda) {
                    jugador.setPosicionPersonajeX(jugador.getPosicionPersonajeX() - 5);
                    jugador.mostrarPersonaje();

                }
            }

        });
    }

    /**
     * Muestra la caída de la bomba. La velocidad inicial esta determinado en
     * VelocidadCaida. Aumenta su velocidad de 15 en 15. Al caer 5 veces termina el
     * juego.
     * 
     * @param bomba bomba
     */

    private void caidaBomba(Personaje bomba) {

        temporizador = new Timer(velocidadCaida, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                bomba.setPosicionPersonajeY(bomba.getPosicionPersonajeY() + 20);
                bomba.mostrarPersonaje();

                if (bomba.getPosicionPersonajeY() > 180) {
                    // System.err.println(cantBombasCaidas);
                    temporizador.stop();
                    cantBombasCaidas--;
                    if (ganador(false)) {
                        velocidadCaida -= 15;
                        // temporizador.setDelay(velocidadCaida);
                        aparicionBomba();

                    }
                }
                if (cantBombasCaidas == 0) {
                    temporizador.stop();
                    ganador(true);
                    volverJugar();
                }

            }
        });
        temporizador.start();
    }


    /**
     * Informa ganador
     * @param fin true: No hay mas bomba, ha ganado | false: comprueba si ha colisionado con el jugador
     * @return false: termino el juego | false: continua juego
     */

    private boolean ganador(boolean fin) {

        Personaje pj = pantalla.getPersonaje(false);
        Personaje bomba = pantalla.getPersonaje(true);

        if (fin) {
            JOptionPane.showMessageDialog(null, "Has ganado", "FIN DEL JUEGO", JOptionPane.INFORMATION_MESSAGE);
            bomba.setIcon(null);
            return false;
        } else {
            if ((pj.getPosicionPersonajeX() - bomba.getPosicionPersonajeX() >= -25
                    && pj.getPosicionPersonajeX() - bomba.getPosicionPersonajeX() <= 25)) {
                pantalla.getExplosion().setPosicionPersonajeX(pj.getPosicionPersonajeX());
                pantalla.getExplosion().mostrarPersonaje();
                JOptionPane.showMessageDialog(null, "Has perdido", "FIN DEL JUEGO", JOptionPane.INFORMATION_MESSAGE);
                temporizador.stop();
                volverJugar();
                return false;
            } else {
                return true;
            }

        }
    }

    /**
     * Pregunta si desea volver a jugar. Instancai desde 0 la cantidad de bombas caidas y velocidad de caida.
     */

    public void volverJugar() {
        int n = JOptionPane.showConfirmDialog(null, "Desea volver a jugar?", "Juego Nuevo", JOptionPane.OK_OPTION);
        if (n == 0) {
            pantalla.getExplosion().setIcon(null);
            cantBombasCaidas = 5;
            velocidadCaida = 500;
            temporizador.setDelay(velocidadCaida);
            aparicionBomba();
        } else {
            pantalla.getPersonaje(true).setIcon(null);
            temporizador.stop();
        }
    }

    /***
     * Aparece la bomba aleatoriamente en el eje X. El rango de apariición está
     * determinado por los limites establecidos.
     * 
     * @param bomba bomba
     */
    private void aparicionBomba() {
        Personaje bomba = pantalla.getPersonaje(true);
        int aleatorio = (int) (Math.random() * (limiteMovimientoDerecha - limiteMovimientoIzquierda))
                + limiteMovimientoIzquierda;
        bomba.setPosicionPersonajeX(aleatorio);
        bomba.setPosicionPersonajeY(0);
        caidaBomba(bomba);
        // bomba.mostrarPersonaje();
    }
}
