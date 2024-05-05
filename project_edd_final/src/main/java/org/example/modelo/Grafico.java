package org.example.modelo;

import guru.nidi.graphviz.engine.Format;
import guru.nidi.graphviz.engine.Graphviz;
import guru.nidi.graphviz.parse.Parser;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.example.modelo.estructuras.Arco;

/**
 * @author giovanic
 */
public class Grafico {

    public void writerDot(String str) {
        String cadena = """
                        digraph G {
                            rankdir="LR"
                            """ + str + "\n"
                + "    \n"
                + "}\n";
        FilesControl control = new FilesControl();
        control.escribirEnFile(cadena, "example/ejemplo.dot");
    }

    public String getValue(List<Arco> arco) {
        String str = "";
        for (int i = 0; i < arco.size(); i++) {
            str += arco.get(i).getOrigen().getNombre() + "  -> "
                    + arco.get(i).getDestino().getNombre()
                    + " [label  = \"   "
                    + arco.get(i).getPeso().getDistancia()
                    + " \"] ;\n\t\t";
        }
        return str;
    }

    public void entrada(String fileName) throws IOException {
        try {
            InputStream dot = new FileInputStream(new File("example/" + fileName + ".dot"));
            var g = new Parser().read(dot);
            Graphviz.fromGraph(g).width(500).render(Format.PNG).toFile(new File("example/" + fileName + ".png"));
        } catch (IOException ignored) {
        }

        /*
         * try (InputStream dot =
         * getClass().getResourceAsStream("/archive/archive.dot")) {
         * MutableGraph g = new Parser().read(dot);
         * //Graphviz.fromGraph(g).width(200).render(Format.PNG).toFile(new
         * File("example/graph.png"));
         * Graphviz.fromGraph(g).width(300).render(Format.PNG).toFile(new
         * File("example/graph.png"));
         * g.graphAttrs()
         * .add(Color.WHITE.gradient(Color.rgb("888888")).background().angle(90))
         * .nodeAttrs().add(Color.WHITE.fill())
         * .nodes().forEach(node
         * -> node.add(
         * Color.named(node.name().toString()),
         * Style.lineWidth(4), Style.FILLED));
         * Grafico.fromGraph(g).width(700).render(Format.PNG).toFile(new
         * File("example/ex4-2.png"));
         */
    }

    public void graphvizJava(String direccionDot, String direccionPng) {
        dibujar(direccionDot, direccionPng);
    }

    private void dibujar(String direccionDot, String direccionPng) {
        try {
            ProcessBuilder pbuilder;

            /*
             * Realiza la construccion del comando
             * en la linea de comandos esto es:
             * dot -Tpng -o archivo.png archivo.dot
             */
            pbuilder = new ProcessBuilder("dot", "-Tpng", "-o", direccionPng, direccionDot);
            pbuilder.redirectErrorStream(true);
            // Ejecuta el proceso
            pbuilder.start();

        } catch (IOException e) {
        }
    }
}
