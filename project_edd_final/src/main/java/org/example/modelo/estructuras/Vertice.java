package org.example.modelo.estructuras;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author giovanic
 */
public class Vertice {

    private String nombre;
    private List<Arco> arcos = new ArrayList<>();

    public Vertice(String nombre) {
        this.nombre = nombre;
    }

    public Vertice() {
    }

    public void addArco(Vertice destino, Peso peso) {
        this.arcos.add(new Arco(this, destino, peso));
    }

    public void removeArco(Vertice destinio) {
        this.arcos.removeIf(edge -> edge.getDestino().equals(destinio));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarArco(Arco arco) {
        arcos.add(arco);
    }

    public List<Arco> getArcos() {
        return arcos;
    }

    public List<Vertice> getNodosAdyacentes() {
        List<Vertice> vertices = new ArrayList<>();
        for (Arco arco : arcos) {
            vertices.add(arco.getDestino());
        }
        return vertices;
    }

    @Override
    public String toString() {
        return "Vertice{" + "nombre=" + nombre + '}';
    }

    public void print(boolean esPonderado) {
        String message = "";

        if (this.arcos.isEmpty()) {
            System.out.println(this.nombre + " -->");
            return;
        }

        for (int i = 0; i < this.arcos.size(); i++) {
            if (i == 0) {
                message += this.arcos.get(i).getOrigen().nombre + " -->  ";
            }

            message += this.arcos.get(i).getDestino().nombre;

            if (esPonderado) {
                message += " (" + this.arcos.get(i).getPeso().getDistancia() + ")";
            }

            if (i != this.arcos.size() - 1) {
                message += ", ";
            }
        }
        System.out.println(message);
    }

    public void setArcos(List<Arco> arcos) {
        this.arcos = arcos;
    }

}
