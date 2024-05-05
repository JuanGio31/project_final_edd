package org.example.modelo.estructuras;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GrafoDirigido {

    private List<Vertice> nodos = new ArrayList<>();
    private List<Arco> arcos = new ArrayList<>();

    public GrafoDirigido() {
    }

    public void addNodo(String nombre) {
        Vertice nodo = new Vertice(nombre);
        nodos.add(nodo);
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

    private void addArco(Vertice nodoOrigen, Vertice nodoDestino, Peso peso) {
        Arco arco = new Arco();
        arco.setOrigen(nodoOrigen);
        arco.setDestino(nodoDestino);
        arco.setPeso(peso);
        arcos.add(arco);
        nodoOrigen.agregarArco(arco);
    }

    public Vertice buscarNodo(String nombre) {
        for (Vertice nodo : nodos) {
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

            // ignore los nodos ya visitados
            if (nodosVisitados.contains(actual)) {
                continue;
            }

            // es el nodo que estamos buscando ?
            if (actual.equals(nodoDestino)) {
                nodosRuta.addAll(pilaDeNodos);
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

    public List<Vertice> getNodos() {
        return nodos;
    }

    public void setNodos(List<Vertice> nodos) {
        this.nodos = nodos;
    }

    public List<Arco> getArcos() {
        return arcos;
    }

    public void setArcos(List<Arco> arcos) {
        this.arcos = arcos;
    }

}
