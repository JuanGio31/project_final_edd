package org.example;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.io.IOException;
import org.example.view.PrincipalFr;

public class Main {

    public static void main(String[] args) throws IOException {

        FlatMacDarkLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            PrincipalFr fr = new PrincipalFr();
            fr.setLocationRelativeTo(null);
            fr.setVisible(true);
        });

    }
}
