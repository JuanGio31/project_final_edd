package org.example.modelo.estructuras;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Grafo {

    private List<Vertice> vertices;
    private List<Arco> arcos;
    private boolean esDirigido;

    public Grafo() {
        esDirigido = false;
        vertices = new ArrayList<>();
        arcos = new ArrayList<>();
    }

    public Grafo(boolean esDirigido) {
        this.esDirigido = esDirigido;
        arcos = new ArrayList<>();
        vertices = new ArrayList<>();
    }

    public void addVertice(String nombre) {
        Vertice nodo = buscar(nombre);
        if (nodo != null) {
            vertices.add(nodo);
        }
    }

    public void addArco(String origen, String destino, Peso peso) throws Exception {
        Vertice nodoOrigen = buscarNodo(origen);
        Vertice nodoDestino = buscarNodo(destino);

        // Origen o destino no encontrado
        if (nodoOrigen == null) {
            throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
        }
        if (nodoDestino == null) {
            throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
        }

        addArco(nodoOrigen, nodoDestino, peso);
    }

    public void removeEdge(Vertice v1, Vertice v2) {
        v1.removeArco(v2);
        if (!this.esDirigido) {
            v2.removeArco(v1);
        }
    }

    private void addArco(Vertice nodoOrigen, Vertice nodoDestino, Peso peso) {
//        if (!this.isWeighted) {
//            weight = null;
//        }
        nodoOrigen.addArco(nodoDestino, peso);
        arcos.add(new Arco(nodoOrigen, nodoDestino, peso));
        if (!this.esDirigido) {
            nodoDestino.addArco(nodoOrigen, peso);
        }
    }

    public void removeVertice(Vertice ve) {
        this.vertices.remove(ve);
    }

    public void print() {
        for (Vertice v : this.vertices) {
            v.print(true);
        }
    }

    private Vertice buscar(String nombre) {
        Vertice nodo = buscarNodo(nombre);
        if (nodo == null) {
            return new Vertice(nombre);
        }
        return null;
    }

    public Vertice buscarNodo(String nombre) {
        for (Vertice nodo : vertices) {
            if (nodo.getNombre().equals(nombre)) {
                return nodo;
            }
        }
        return null;
    }

    public boolean existeRuta(String origen, String destino) throws Exception {
        return buscarRuta(origen, destino) != null;
    }

    public List<Vertice> buscarRuta(String origen, String destino) throws Exception {

        Vertice nodoOrigen = buscarNodo(origen);
        Vertice nodoDestino = buscarNodo(destino);
        List<Vertice> nodosRuta = new ArrayList<>();

        // Origen o destino no encontrado
        if (nodoOrigen == null) {
            throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
        }
        if (nodoDestino == null) {
            throw new RuntimeException("Error en la Búsqueda: NodoOrigen no encontrado");
        }

        if (buscarRutaDFS(nodosRuta, nodoOrigen, nodoDestino)) {
            return nodosRuta;
        } else {
            return null;
        }
    }

    private boolean buscarRutaDFS(List<Vertice> nodosRuta, Vertice nodoOrigen, Vertice nodoDestino) {

        // agrega el origen
        nodosRuta.add(nodoOrigen);

        // origen y destino son el mismo ?
        if (nodoOrigen.getNombre().equals(nodoDestino.getNombre())) {
            return true;
        }

        // si no son el mismo, revise las rutas usando una pila
        Stack<Vertice> pilaDeNodos = new Stack<>();
        ArrayList<Vertice> nodosVisitados = new ArrayList<>();

        pilaDeNodos.add(nodoOrigen);

        while (!pilaDeNodos.isEmpty()) {
            Vertice actual = pilaDeNodos.pop();

            // ignore los vertices ya visitados
            if (nodosVisitados.contains(actual)) {
                continue;
            }

            // es el nodo que estamos buscando ?
            if (actual.equals(nodoDestino)) {
                //nodosRuta.addAll(pilaDeNodos);
                nodosRuta.add(nodoDestino);
                return true;
            } else {
                // siga buscando en las rutas no visitadas
                nodosVisitados.add(actual);
                for (Vertice nodo : actual.getNodosAdyacentes()) {
                    if (!pilaDeNodos.contains(nodo)) {
                        pilaDeNodos.add(nodo);
                    }
                }
            }
        }
        return false;
    }

    public void rutaefec(String origen, String destino) {
        try {
            List<Vertice> camino = buscarRuta(origen, destino);
            if (camino == null) {
                System.out.println("Camino " + origen + " -> " + destino + " no encontrado");
            } else {
                System.out.println("Camino " + origen + " -> " + destino + " encontrado");
                for (Vertice nodo : camino) {
                    System.out.println(nodo.getNombre());
                }
            }

        } catch (Exception e) {
        }
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public void setNodos(List<Vertice> nodos) {
        this.vertices = nodos;
    }

    public List<Arco> getArcos() {
        return arcos;
    }

    public void setArcos(List<Arco> arcos) {
        this.arcos = arcos;
    }
}
