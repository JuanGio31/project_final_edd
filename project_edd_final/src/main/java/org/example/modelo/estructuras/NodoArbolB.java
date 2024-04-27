package org.example.modelo.estructuras;

public class NodoArbolB {
    public int[] valores;
    public NodoArbolB[] nodo;
    public static int numValores;
    public boolean tengoHijos = false;
    public int ocupados = 0;
    public NodoArbolB padre;

    public NodoArbolB() {
        nodo = new NodoArbolB[Raiz.grado * 2 + 3];
        valores = new int[Raiz.grado * 2 + 1];
    }
}
