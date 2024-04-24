package org.example;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import org.example.view.PrincipalFr;

public class Main {

    public static void main(String[] args) {

        FlatMacDarkLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            PrincipalFr fr = new PrincipalFr();
            fr.setLocationRelativeTo(null);
            fr.setVisible(true);
        });
    }
}
