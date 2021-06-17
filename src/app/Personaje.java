package app;

import javax.swing.*;
import java.awt.*;

public class Personaje extends JLabel {

    private int posicionPersonajeY;
    private int posicionPersonajeX;
    private int tamanio;
    private String rutaImg;

    /**
     * Inicializa las variables
     * @param x Eje X
     * @param y Eje y
     * @param img Ruta imagen
     */
    public Personaje(int x, int y, String img) {
        this.posicionPersonajeX = x;
        this.posicionPersonajeY = y;
        this.rutaImg = img;
        this.tamanio = 30;
    }
    public Personaje(int x, int y, String img,int tamanio) {
        this.posicionPersonajeX = x;
        this.posicionPersonajeY = y;
        this.rutaImg = img;
        this.tamanio = tamanio;
    }

    /**
     * Muestra el personaje
     */
    public void mostrarPersonaje(){
        setBounds(posicionPersonajeX, posicionPersonajeY, tamanio, tamanio);
        setIcon(imagenTamaño());
    }
    public void quitarPersonaje(){
        setBounds(50000, posicionPersonajeY, tamanio, tamanio);
        setIcon(imagenTamaño());
    }

    /**
     * Crea la imagen y le da un tamaño preestablecido
     * 
     * @param rutaImg  dirección de la imagen
     * @param etiqueta etiqueta
     * @return imagen
     */

    public Icon imagenTamaño() {
        ImageIcon img = new ImageIcon(rutaImg);
        Icon icon = new ImageIcon(
                img.getImage().getScaledInstance(tamanio, tamanio,Image.SCALE_DEFAULT));
        repaint();
        return icon;
    }

    /**
     * Devuelve la posicion Y del personaje
     * @return posicion Y
     */
    public int getPosicionPersonajeY() {
        return posicionPersonajeY;
    }

    /**
     * Instancia la posicion Y
     * @param posicionPersonajeY posicion Y
     */
    public void setPosicionPersonajeY(int posicionPersonajeY) {
        this.posicionPersonajeY = posicionPersonajeY;
    }

    
    /**
     * Devuelve la posicion X del personaje
     * @return posicion X
     */
    public int getPosicionPersonajeX() {
        return posicionPersonajeX;
    }

    /**
     * Instancia la posicion X 
     * @param posicionPersonajeX posicion X
     */
    public void setPosicionPersonajeX(int posicionPersonajeX) {
        this.posicionPersonajeX = posicionPersonajeX;
    }

}