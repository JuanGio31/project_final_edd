package org.example;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import org.example.modelo.Grafico;
import org.example.modelo.estructuras.NodoArbolB;
import org.example.modelo.estructuras.Raiz;
import org.example.view.PrincipalFr;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

//        FlatMacDarkLaf.setup();
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> {
//            PrincipalFr fr = new PrincipalFr();
//            fr.setLocationRelativeTo(null);
//            fr.setVisible(true);
//        });

//        Grafico temp = new Grafico();
//        temp.writerDot("Hola mundo");
//        temp.graphvizJava("example/ejemplo.dot", "example/ej.png");

        Raiz raiz = new Raiz(5);
        raiz.insertar(190);
        raiz.insertar(57);
        raiz.insertar(89);
        raiz.insertar(90);
        raiz.insertar(121);
        raiz.insertar(170);

        raiz.ordenarNodos(raiz.primerNodo);
        System.out.println(raiz.recorrer(raiz.primerNodo));
    }


}
