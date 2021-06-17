package app;

import javax.swing.*;

public class App {
    public static void main(String[] args) throws Exception {
        Formulario f = new Formulario();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(200, 400);
        f.setVisible(true);
    }
}