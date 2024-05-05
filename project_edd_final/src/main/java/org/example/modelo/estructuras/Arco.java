package org.example.modelo.estructuras;

public class Arco {

    private Vertice origen;

    private Vertice destino;
    private Peso peso;

    public Arco(Peso peso) {
        this.peso = peso;
    }

    public Arco() {
    }

    public Vertice getOrigen() {
        return origen;
    }

    public void setOrigen(Vertice origen) {
        this.origen = origen;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }

    public Peso getPeso() {
        return peso;
    }

    public void setPeso(Peso peso) {
        this.peso = peso;
    }

}
