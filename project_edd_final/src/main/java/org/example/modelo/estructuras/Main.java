package org.example.modelo.estructuras;

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



        //Grafico temp = new Grafico();
        //temp.writerDot("abacaddb");
        //temp.graphvizJava("example/ejemplo.dot", "example/ej.png");
        // gr.mostrar();
        //System.out.println("\n\nBUSCAR");
    }
}
