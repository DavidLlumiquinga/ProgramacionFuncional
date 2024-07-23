package Controller;

import Interfaces.ShapeDrawer;
import View.View;
import javax.swing.*;
import java.awt.*;

public class Controller {
    private View view;
    private ShapeDrawer currentDrawer;

    public Controller(View view) {
        this.view = view;
        initialize();
    }

    private void initialize() {
        view.getBoton1().addActionListener(e-> {
            currentDrawer = g -> {
                g.setColor(Color.RED);
                int[] xPoints = {
                        view.getPanelDibujo().getWidth() / 2 - 50,
                        view.getPanelDibujo().getWidth() / 2,
                        view.getPanelDibujo().getWidth() / 2 + 50
                };
                int[] yPoints = {
                        view.getPanelDibujo().getHeight() / 2 + 50,
                        view.getPanelDibujo().getHeight() / 2 - 50,
                        view.getPanelDibujo().getHeight() / 2 + 50
                };
                g.fillPolygon(xPoints, yPoints, 3);
            };
            view.getPanelDibujo().repaint();
        });

        view.getBoton2().addActionListener(e -> {
            currentDrawer = g -> {
                g.setColor(Color.BLUE);
                int x = view.getPanelDibujo().getWidth() / 2 - 50;
                int y = view.getPanelDibujo().getHeight() / 2 - 50;
                g.fillOval(x, y, 100, 100); // Dibuja un óvalo en lugar de un rectángulo
            };
            view.getPanelDibujo().repaint();
        });

        view.getBoton3().addActionListener(e -> {
            currentDrawer = g -> {
                g.setColor(Color.GREEN);
                int x = view.getPanelDibujo().getWidth() / 2 - 50;
                int y = view.getPanelDibujo().getHeight() / 2 - 50;
                g.fillOval(x, y, 100, 100);
            };
            view.getPanelDibujo().repaint();
        });

        JPanel drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (currentDrawer != null) {
                    currentDrawer.drawShape(g);
                }
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(300, 200);
            }
        };
        view.setPanelDibujo(drawingPanel);
    }
}








