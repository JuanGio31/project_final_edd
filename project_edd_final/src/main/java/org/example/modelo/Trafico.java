package org.example.modelo;

/**
 *
 * @author giovanic
 */
public class Trafico {

    private int hora_inicio;
    private int hora_finaliza;
    private int probabilidad_trafico;

    public Trafico(int hora_inicio, int hora_finaliza, int probabilidad_trafico) {
        this.hora_inicio = hora_inicio;
        this.hora_finaliza = hora_finaliza;
        this.probabilidad_trafico = probabilidad_trafico;
    }

    public Trafico() {
    }

    public int getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(int hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public int getHora_finaliza() {
        return hora_finaliza;
    }

    public void setHora_finaliza(int hora_finaliza) {
        this.hora_finaliza = hora_finaliza;
    }

    public int getProbabilidad_trafico() {
        return probabilidad_trafico;
    }

    public void setProbabilidad_trafico(int probabilidad_trafico) {
        this.probabilidad_trafico = probabilidad_trafico;
    }

    public String calcularVelocidad(Dato dato, int tipo) {
        //Si es 0 => es un vehiculo, de lo contrario => caminar
        if (tipo == 0) {
            int rapidez = dato.getDistancia() / (dato.getTiempo_vehiculo() * (1 + probabilidad_trafico));
            return "Rapidez: " + rapidez;
        } else if (tipo == 1) {
            int rapidez = dato.getDistancia() / dato.getTiempo_pie();
            return "Rapidez: " + rapidez;
        }

        return null;
    }
}
