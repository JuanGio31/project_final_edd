package org.example.modelo.estructuras;

import java.util.*;

/**
 *
 * @author giovanic
 */
public class Dijkstra {

    public static Map[] dijkstra(Grafo g, Vertice start) {
        Map<String, Integer> distancia = new HashMap<>();
        Map<String, Vertice> previo = new HashMap<>();
        PriorityQueue<QueueObject> cola = new PriorityQueue<>();

        cola.add(new QueueObject(start, 0));

        for (Vertice v : g.getVertices()) {
            if (v != start) {
                distancia.put(v.getNombre(), Integer.MAX_VALUE);
            }
            previo.put(v.getNombre(), new Vertice("Null"));
        }

        distancia.put(start.getNombre(), 0);

        while (!cola.isEmpty()) {
            Vertice actual = cola.poll().vertice;
            for (Arco e : actual.getArcos()) {
                Integer alternative = distancia.get(actual.getNombre()) + e.getPeso().getDistancia();
                String neighborValue = e.getDestino().getNombre();
                if (alternative < distancia.get(neighborValue)) {
                    distancia.put(neighborValue, alternative);
                    previo.put(neighborValue, actual);
                    cola.add(new QueueObject(e.getDestino(), distancia.get(neighborValue)));
                }
            }
        }
        return new Map[]{distancia, previo};
    }

    public static List<String> shortestPathBetween(Grafo g, Vertice origen, Vertice destino) {
        //String str = "";
        List<String> camino = new ArrayList<>();
        Map[] dijkstraDictionaries = dijkstra(g, origen);
        Map distances = dijkstraDictionaries[0];
        Map previous = dijkstraDictionaries[1];

        Integer distance = (Integer) distances.get(destino.getNombre());
        System.out.println("Shortest Distance between " + origen.getNombre() + " and " + destino.getNombre());
        System.out.println(distance);
        camino.add(distance.toString());

        ArrayList<Vertice> path = new ArrayList<>();
        Vertice v = destino;

        while (!"Null".equals(v.getNombre())) {
            path.add(0, v);
            v = (Vertice) previous.get(v.getNombre());
        }
        System.out.println("Camino corto (s)");
        for (Vertice pathVertex : path) {
            System.out.println(pathVertex.getNombre());
            //str += pathVertex.getNombre() + ".\n";
            camino.add(pathVertex.getNombre());
        }
        return camino;
    }

    public static void dijkstraResultPrinter(Dictionary[] d) {
        System.out.println("Distances:\n");
        for (Enumeration keys = d[0].keys(); keys.hasMoreElements();) {
            String nextKey = keys.nextElement().toString();
            System.out.println(nextKey + ": " + d[0].get(nextKey));
        }
        System.out.println("\nPrevious:\n");
        for (Enumeration keys = d[1].keys(); keys.hasMoreElements();) {
            String nextKey = keys.nextElement().toString();
            Vertice nextVertex = (Vertice) d[1].get(nextKey);
            System.out.println(nextKey + ": " + nextVertex.getNombre());
        }
    }

}
