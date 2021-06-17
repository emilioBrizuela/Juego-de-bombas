package app;

import javax.swing.*;

public class PanelDeBotones extends JPanel {

    private JButton izq;
    private JButton der;

    /**
     * Instancia los parametros
     */
    public PanelDeBotones() {

        der = new JButton("\u2190");
        der.setBounds(30, 300, 50, 30);
        add(der);
        
        izq = new JButton("\u2192");
        izq.setBounds(110, 300, 50, 30);
        add(izq);
        
        // izq.addActionListener(mover);
        // der.addActionListener(mover);
    }

    /**
     * Devuelvo el boton izquierdo
     * @return boton izquierdo
     */
    public JButton getIzq(){
        return this.izq;
    }
    /**
     * Devuelvo el boton derecho
     * @return boton dercho
     */
    public JButton getDer(){
        return this.der;
    }


}