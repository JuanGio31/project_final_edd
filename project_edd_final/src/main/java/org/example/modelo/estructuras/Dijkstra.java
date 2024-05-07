package org.example.modelo.estructuras;

import java.util.*;

/**
 *
 * @author giovanic
 */
public class Dijkstra {

    public static Dictionary[] dijkstra(Grafo g, Vertice start) {
        Dictionary<String, Integer> distances = new Hashtable<>();
        Dictionary<String, Vertice> previous = new Hashtable<>();
        PriorityQueue<QueueObject> queue = new PriorityQueue<>();

        queue.add(new QueueObject(start, 0));

        for (Vertice v : g.getVertices()) {
            if (v != start) {
                distances.put(v.getNombre(), Integer.MAX_VALUE);
            }
            previous.put(v.getNombre(), new Vertice("Null"));
        }

        distances.put(start.getNombre(), 0);

        while (!queue.isEmpty()) {
            Vertice current = queue.poll().vertex;
            for (Arco e : current.getArcos()) {
                Integer alternative = distances.get(current.getNombre()) + e.getPeso().getDistancia();
                String neighborValue = e.getDestino().getNombre();
                if (alternative < distances.get(neighborValue)) {
                    distances.put(neighborValue, alternative);
                    previous.put(neighborValue, current);
                    queue.add(new QueueObject(e.getDestino(), distances.get(neighborValue)));
                }
            }
        }
        return new Dictionary[]{distances, previous};
    }

    public static String shortestPathBetween(Grafo g, Vertice origen, Vertice destino) {
        String str = "";
        Dictionary[] dijkstraDictionaries = dijkstra(g, origen);
        Dictionary distances = dijkstraDictionaries[0];
        Dictionary previous = dijkstraDictionaries[1];

        Integer distance = (Integer) distances.get(destino.getNombre());
        System.out.println("Shortest Distance between " + origen.getNombre() + " and " + destino.getNombre());
        System.out.println(distance);
        str += "DISTANCIA RECORRIDA: " + distance + " KM.\n";

        ArrayList<Vertice> path = new ArrayList<>();
        Vertice v = destino;

        while (!"Null".equals(v.getNombre())) {
            path.add(0, v);
            v = (Vertice) previous.get(v.getNombre());
        }
        System.out.println("Camino corto (s)");
        for (Vertice pathVertex : path) {
            System.out.println(pathVertex.getNombre());
            str += pathVertex.getNombre() + ".\n";
        }
        return str;
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
