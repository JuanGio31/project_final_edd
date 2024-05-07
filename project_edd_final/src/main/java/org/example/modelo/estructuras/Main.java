package org.example.modelo.estructuras;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.io.IOException;
import org.example.modelo.FilesControl;
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
//        FilesControl control = new FilesControl();
//        GrafoDirigido grafo = control.leerMapa();
//        try {
//            var matriz = grafo.buscarRuta("SanMarcos", "Retalhuleu");
//            for (Vertice vertice : matriz) {
//                System.out.println(" - "+ vertice.toString());
//            }
//        } catch (Exception e) {
//        }

    }
}
