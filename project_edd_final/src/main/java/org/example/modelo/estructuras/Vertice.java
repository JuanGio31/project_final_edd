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
}
