package org.example.modelo.estructuras;

/**
 *
 * @author giovanic
 */
public class QueueObject implements Comparable<QueueObject> {

    Vertice vertice;
    int prioridad;

    public QueueObject(Vertice v, int p) {
        this.vertice = v;
        this.prioridad = p;
    }

    @Override
    public int compareTo(QueueObject o) {
        if (this.prioridad == o.prioridad) {
            return 0;
        } else if (this.prioridad > o.prioridad) {
            return 1;
        } else {
            return -1;
        }
    }
}
