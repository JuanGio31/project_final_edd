package org.example.modelo.estructuras;

public class Arco {

    private int destino;
    private double peso;

    public Arco(int d) {
        destino = d;
    }

    public Arco(int d, double p) {
        this(d);
        peso = p;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public boolean equals(Object n) {
        Arco a = (Arco) n;
        return destino == a.destino;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}

