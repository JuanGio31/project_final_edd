package org.example.modelo.estructuras;

public class Vertice {

    private String nombre;
    private int numVertice;

    public Vertice(String x) {
        nombre = x;
        numVertice = -1;
    }

    public String nomVertice() {
        return nombre;
    }

    public boolean equals(Vertice n) {
        return nombre.equals(n.nombre);
    }

    public void asigVert(int n) { // establece el número de vértices
        this.numVertice = n;
    }

    public String toString() { // características del vértice
        return nombre + " (" + numVertice + ")";
    }
}
