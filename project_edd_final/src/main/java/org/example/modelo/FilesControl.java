package org.example.modelo;

import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.example.modelo.estructuras.Grafo;
import org.example.modelo.estructuras.Peso;

/**
 * Clase que gestiona los ficheros
 *
 * @author giovanic
 */
public class FilesControl {

    /**
     * Metodo para crear un onjeto 'grafo' inicializando sus valores mediante un
     * file
     *
     * @return Grafo
     */
    public Grafo leerMapa() {
        Grafo grafo = new Grafo();

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.txt", "TXT");
        try {
            File file = seleccionarArchivo(filtro);

            FileReader fr = new FileReader(file);
            Scanner scan = new Scanner(fr);

            String[] contenido = null;

            while (scan.hasNextLine()) {
                String linea = scan.nextLine();

                contenido = linea.split("\\|");

                grafo.addVertice(contenido[0]);
                grafo.addVertice(contenido[1]);

                Peso peso = new Peso(
                        Integer.parseInt(contenido[2]),
                        Integer.parseInt(contenido[3]),
                        Integer.parseInt(contenido[4]),
                        Integer.parseInt(contenido[5]),
                        Integer.parseInt(contenido[6]));

                try {
                    grafo.addArco(contenido[0], contenido[1], peso);
                } catch (Exception e) {
                }
            }
            return grafo;
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("error -> No se pudo leer el archivo");
        }
        return null;
    }

    /**
     * Metodo para para la creacion de un Lista de objetos 'trafico'
     * inicializando sus valores mediante un file
     *
     * @return lista de traficos
     */
    public Congestionamiento leerFileTrafico() {
        Congestionamiento congestionamiento = new Congestionamiento();

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.txt", "TXT");
        try {
            File file = seleccionarArchivo(filtro);

            FileReader fr = new FileReader(file);
            Scanner scan = new Scanner(fr);

            String[] arr = null;

            while (scan.hasNextLine()) {
                String linea = scan.nextLine();
                arr = linea.split("\\|");

                Trafico trafico = new Trafico(
                        arr[0],
                        arr[1],
                        Integer.parseInt(arr[2]),
                        Integer.parseInt(arr[3]),
                        Integer.parseInt(arr[4])
                );
                congestionamiento.addTrafico(trafico);
            }
            
            return congestionamiento;
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("error -> No se pudo leer el archivo");
        }
        return null;
    }

    /**
     * Metodo para obtener un file
     *
     * @param filtro la extension predeterminada que se muestra en el
     * filechooser
     * @return File
     * @throws java.io.FileNotFoundException
     */
    private File seleccionarArchivo(FileNameExtensionFilter filtro) throws FileNotFoundException {
        JFileChooser fileChooser = new JFileChooser("src");
        fileChooser.setFileFilter(filtro);
        int respuesta = fileChooser.showOpenDialog(null);
        switch (respuesta) {
            case JFileChooser.APPROVE_OPTION -> {
                return fileChooser.getSelectedFile();
            }
            case JFileChooser.CANCEL_OPTION, JFileChooser.ERROR_OPTION -> {
                return null;
            }
        }
        return null;
    }

    /**
     * Metodo para obtener el contenido de un archivio
     *
     * @param f el path del archivo
     * @return string con el contenido del archivo
     */
    public String getContenido(String f) {
        String cont = "";
        try {
            cont = getArchivo(f);
        } catch (NullPointerException e) {
            System.out.println("error -> No se pudo leer el archivo");
        }
        return cont;
    }

    public String getContenido() {
        String cont = "";
        try {
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.txt", "TXT");
            File myObj = seleccionarArchivo(filtro);
            cont = getArchivo(myObj.getAbsolutePath());
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("error -> No se pudo leer el archivo");
        }
        return cont;
    }

    //-------------------------Se obtiene el contenido del Archivo----------------//
    private String getArchivo(String ruta) {
        FileReader fr = null;
        BufferedReader br = null;
        //Cadena de texto donde se guardara el contenido del archivo
        String contenido = "";
        try {
            //ruta puede ser de tipo String
            fr = new FileReader(ruta);
            br = new BufferedReader(fr);

            String linea;
            //Obtenemos el contenido del archivo linea por linea
            while ((linea = br.readLine()) != null) {
                contenido += linea + "\n";
            }

        } catch (IOException ignored) {
        } //finally se utiliza para que si todo ocurre correctamente o si ocurre
        //algun error se cierre el archivo que anteriormente abrimos
        finally {
            try {
                br.close();
            } catch (IOException ignored) {
            }
        }
        return contenido;
    }

    /**
     * Metodo para crear un archivo, en este caso html
     *
     * @param name el nombre del archivo
     * @return retornara el archivo creado
     */
    private File crearArchivo(String name) {
        try {
            File myObj = new File(name);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
            return myObj;
        } catch (IOException ignored) {
        }
        return null;
    }

    /**
     * Metodo para escribir en un archivo
     *
     * @param contenido cadena de caracteres
     * @param fileName el path del archivo
     */
    public void escribirEnFile(String contenido, String fileName) {
        try {
            File file = crearArchivo(fileName);
            try (FileWriter myWriter = new FileWriter(file)) {
                myWriter.write(contenido);
            }
            System.out.println("Successfully wrote to the file.");
        } catch (IOException | NullPointerException e) {
            System.out.println("An error occurred.");
        }
    }

    /**
     * Metodo para eliminar un archivo.
     *
     * @param file_name ruta del archivo y nombre
     */
    public void eliminarArchivo(String file_name) {
        File file = new File(file_name);
        file.delete();
    }

    /**
     * Elimina los archivos con una determinada extensión de una carpeta
     *
     * @param path Carpeta de la cual eliminar los archivos
     * @param extension Extensión de los archivos a eliminar
     */
    public void eliminarPorExtension(String path, final String extension) {
        File[] archivos = new File(path).listFiles((File archivo) -> {
            if (archivo.isFile()) {
                return archivo.getName().endsWith('.' + extension);
            }
            return false;
        });
        for (File archivo : archivos) {
            archivo.delete();
        }
    }

    /**
     * Metodo para comprobar la existencia de un archivo
     *
     * @param path ruta del archivo
     * @return regresa un valor booleando en caso de que es archivo exista o no
     */
    public boolean existencia(String path) {
        File fr = new File(path);
        return fr.exists();
    }
}
