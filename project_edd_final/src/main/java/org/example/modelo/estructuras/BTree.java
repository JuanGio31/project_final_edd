package org.example.modelo.estructuras;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author giovanic
 */
public class BTree {

    ArrayList<String> mp;
    private JDialog fr;
    private BTreeNode root;
    private int t; // Orden del árbol

    // Constructor
    public BTree(int t) {
        this.root = null;
        this.t = t;
        mp = new ArrayList<>();
    }

    public void setDialog(JDialog fr) {
        this.fr = fr;
    }

    // Clase interna para los nodos del árbol B
    public class BTreeNode {

        String[] keys; // Claves en el nodo
        int n; // Número de claves actuales
        BTreeNode[] children; // Hijos del nodo
        boolean leaf; // ¿Es una hoja?

        // Constructor
        BTreeNode(boolean leaf) {
            this.keys = new String[2 * t - 1];
            this.children = new BTreeNode[2 * t];
            this.leaf = leaf;
            this.n = 0;
        }

    }

    // Método para insertar una clave en el árbol
    public void insert(String key) {
        if (!mp.contains(key)) {
            if (root == null) {
                root = new BTreeNode(true);
                root.keys[0] = key;
                root.n = 1;
            } else {
                if (root.n == 2 * t - 1) {
                    // Si la raíz está llena, se divide y se crea una nueva raíz
                    BTreeNode newRoot = new BTreeNode(false);
                    newRoot.children[0] = root;
                    splitChild(newRoot, 0);
                    root = newRoot;
                }
                // Insertar en el árbol
                insertNonFull(root, key);

            }
            mp.add(key);
        }
    }
    // Método para generar el código DOT

    public void generateDot(String filename) {
        try {
            FileWriter fileWriter = new FileWriter(filename);
            try (PrintWriter printWriter = new PrintWriter(fileWriter)) {
                printWriter.println("digraph BTree {");
                printWriter.println("node [shape=record];");

                // Llamada al método recursivo para generar nodos y conexiones
                generateDotRecursive(root, printWriter);

                printWriter.println("}");
            }
            //cargarImagenArbol();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método recursivo para generar nodos y conexiones en DOT
    private void generateDotRecursive(BTreeNode node, PrintWriter printWriter) {
        // Verificar si el nodo es nulo
        if (node == null) {
            return; // Salir del método si el nodo es nulo
        }

        // Resto del código aquí...
        // Implementación similar al código original...
        printWriter.printf("node%d [label=\"", node.hashCode()); // Usamos el hashCode del nodo como identificador
        for (int i = 0; i < node.n; i++) {
            printWriter.print("<f" + i + "> " + node.keys[i]);
            if (i < node.n - 1) {
                printWriter.print(" | ");
            }
        }
        printWriter.println("\"];");

        // Si no es una hoja, llamar recursivamente a los hijos
        if (!node.leaf) {
            for (int i = 0; i < node.n + 1; i++) {
                if (node.children[i] != null) {
                    generateDotRecursive(node.children[i], printWriter);
                }
            }
        }

        // Escribir las conexiones con los hijos
        for (int i = 0; i < node.n + 1; i++) {
            if (node.children[i] != null) {
                printWriter.printf("node%d:f%d -> node%d;\n", node.hashCode(), i, node.children[i].hashCode());
            }
        }
    }

    // Método para leer datos desde un archivo e insertarlos en el árbol
    public void readAndInsertFromFile(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                String key = data[0].trim(); // La primera columna se considera la clave
                insert(key);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para ejecutar Graphviz y generar la imagen
    public void generateImage(String dotFilename, String outputFilename) {
        try {
            // Ejecutar el comando dot para generar la imagen desde el archivo DOT
            ProcessBuilder pb = new ProcessBuilder("dot", "-Tpng", "-o", outputFilename, dotFilename);
            Process p = pb.start();

            // Esperar a que finalice el proceso
            p.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void splitChild(BTreeNode parentNode, int childIndex) {
        BTreeNode childNode = parentNode.children[childIndex];
        BTreeNode newChildNode = new BTreeNode(childNode.leaf);
        newChildNode.n = t - 1;
        for (int j = 0; j < t - 1; j++) {
            newChildNode.keys[j] = childNode.keys[j + t];
        }
        if (!childNode.leaf) {
            for (int j = 0; j < t; j++) {
                newChildNode.children[j] = childNode.children[j + t];
            }
        }
        childNode.n = t - 1;
        for (int j = parentNode.n; j >= childIndex + 1; j--) {
            parentNode.children[j + 1] = parentNode.children[j];
        }
        parentNode.children[childIndex + 1] = newChildNode;
        for (int j = parentNode.n - 1; j >= childIndex; j--) {
            parentNode.keys[j + 1] = parentNode.keys[j];
        }
        parentNode.keys[childIndex] = childNode.keys[t - 1];
        parentNode.n++;
    }

    private void insertNonFull(BTreeNode node, String key) {
        int i = node.n - 1;
        if (node.leaf) {
            while (i >= 0 && key.compareTo(node.keys[i]) < 0) {
                node.keys[i + 1] = node.keys[i];
                i--;
            }
            node.keys[i + 1] = key;
            node.n++;
        } else {
            while (i >= 0 && key.compareTo(node.keys[i]) < 0) {
                i--;
            }
            i++;
            if (node.children[i].n == 2 * t - 1) {
                splitChild(node, i);
                if (key.compareTo(node.keys[i]) > 0) {
                    i++;
                }
            }
            insertNonFull(node.children[i], key);
        }
    }

    public void Inicio() {
        BTree bTree = new BTree(5); // Aquí especifica el orden del árbol B

        // Lee los datos del archivo e insértalos en el árbol
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Archivos de texto (*.txt)", "txt"));

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            bTree.readAndInsertFromFile(file.getAbsolutePath());
        } else {
            System.out.println("No se seleccionó ningún archivo.");
            return;
        }

        // Genera el código DOT y escribe en un archivo
        String dotFilename = "example/arbol.dot";
        bTree.generateDot(dotFilename);

        // Genera la imagen a partir del archivo DOT
        String outputFilename = "example/arbol.png";
        bTree.generateImage(dotFilename, outputFilename);

    }

    public void mostrarImagenArbol(String rutaImagen, JTextArea Arbol) {
        try {
            System.out.println("Si paso aca?");
            // Cargar la imagen
            File imagenArchivo = new File(rutaImagen);
            Image imagen = ImageIO.read(imagenArchivo);

            // Crear un nuevo ImageIcon con la imagen
            ImageIcon imagenIcono = new ImageIcon(imagen);

            // Establecer el ImageIcon en un JLabel
            JLabel labelImagen = new JLabel(imagenIcono);

            // Colocar el JLabel dentro de un JScrollPane
            JScrollPane scrollPane = new JScrollPane(labelImagen);

            // Limpiar el contenido del JTextArea antes de agregar la imagen
            Arbol.setText("");

            // Establecer el tamaño preferido del JScrollPane para que se ajuste al JTextArea
            scrollPane.setPreferredSize(new Dimension(Arbol.getWidth(), Arbol.getHeight()));

            // Agregar el JScrollPane al JTextArea
            Arbol.add(scrollPane);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void cargarImagenArbol() {
//        try {
//            ImageIcon icon = new ImageIcon("graph.png");
//            JLabel labelImagen = new JLabel(icon);
//
//            // Establecer el tamaño preferido del JLabel para que coincida con el tamaño de la imagen
//            labelImagen.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
//
//            fr.removeAll(); // Limpiar el panel antes de agregar la nueva imagen
//            fr.setLayout(new BorderLayout());
//            JScrollPane scrollPane = new JScrollPane(labelImagen);
//
//            // Establecer el tamaño preferido del JScrollPane para que coincida con el tamaño de la imagen
//            scrollPane.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
//
//            fr.add(scrollPane, BorderLayout.CENTER);
//            fr.revalidate();
//            fr.repaint();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
