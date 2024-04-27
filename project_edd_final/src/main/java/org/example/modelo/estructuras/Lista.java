package org.example.modelo.estructuras;

public class Lista {
    // instance variables - replace the example below with your own
    public static Listado<Integer> ingresados;


    public Lista() {
        ingresados = new Listado<>();
    }

    public boolean buscar(int valor) throws ListaException {
        boolean esta = false;
        for (int i = 0; i < ingresados.getSize() && !esta; i++) {
            if (ingresados.obtenerElemento(i) == valor) {
                esta = true;

            }
        }
        return esta;

    }
}
