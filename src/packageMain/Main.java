package packageMain;

import Controller.Controller;
import View.View;

import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            View view = new View();
            new Controller(view);
            view.setVisible(true);

        });
    }
}