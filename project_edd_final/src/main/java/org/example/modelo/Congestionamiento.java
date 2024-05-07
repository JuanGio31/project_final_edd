package org.example.modelo;

import java.util.*;

/**
 *
 * @author giovanic
 */
public class Congestionamiento {

    private List<Trafico> traficos;

    public Congestionamiento() {
        this.traficos = new ArrayList<>();
    }

    public Congestionamiento(List<Trafico> traficos) {
        this.traficos = traficos;
    }

    public void addTrafico(Trafico trafico) {
        this.traficos.add(trafico);
    }

    public void removeTrafico(Trafico trafico) {
        if (traficos.contains(trafico)) {
            traficos.remove(trafico);
        }
    }

    public int[] getValue(String origen, String destino) {
        for (Trafico i : traficos) {
            if (i.getOrigen().equals(origen) && i.getDestino().equals(destino)) {
                return i.getValue();
            }
        }
        return null;
    }

    public List<Trafico> getTraficos() {
        return traficos;
    }

    public void setTraficos(List<Trafico> traficos) {
        this.traficos = traficos;
    }
}
