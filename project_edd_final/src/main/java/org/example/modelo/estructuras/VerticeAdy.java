package org.example.modelo.estructuras;

import java.util.ArrayList;
import java.util.List;

public class VerticeAdy {
    private String nombre;
    private int numVertice;
    private List<String> lad; // lista de adyacencia

    // constructor de la clase
    public VerticeAdy(String x) {
        nombre = x;
        numVertice = -1;
        lad = new ArrayList<>();
    }
}
