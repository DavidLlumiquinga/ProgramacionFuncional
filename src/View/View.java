package View;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private JButton boton1, boton2, boton3;
    private JPanel panelDibujo;

    public View() {
        setTitle("Ventana");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Botones
        boton1 = new JButton("Triangulo");
        boton2 = new JButton("Cuadrado");
        boton3 = new JButton("Circulo");

        panelDibujo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(300, 200);
            }
        };

        JPanel panelBotones = new JPanel();
        panelBotones.add(boton1);
        panelBotones.add(boton2);
        panelBotones.add(boton3);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelBotones, BorderLayout.NORTH);
        getContentPane().add(panelDibujo, BorderLayout.CENTER);
    }

    public JButton getBoton1() {
        return boton1;
    }

    public JButton getBoton2() {
        return boton2;
    }

    public JButton getBoton3() {
        return boton3;
    }

    public JPanel getPanelDibujo() {
        return panelDibujo;
    }

    public void setPanelDibujo(JPanel panelDibujo) {
        getContentPane().remove(this.panelDibujo);
        this.panelDibujo = panelDibujo;
        getContentPane().add(this.panelDibujo, BorderLayout.CENTER);
        validate();
    }
}
