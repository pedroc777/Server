package examen2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <p>
 * Esta es la clase Servidor. Esta nos sirve para crear un servidor que recibe y
 * envía mensajes de un cliente</p>
 *
 * @author 2193000343
 */
public class Servidor {

    /**
     * <p>
     * Este atributo nos ayuda a indicar el número de puerto que se usará</p>
     */
    private int port;
    /**
     * <p>
     * Este atributo nos ayuda a indicar el nombre que se usará</p>
     */
    private String host;

    /**
     * <p>
     * Este es un método constructor de la clase Servidor</p>
     * <p>
     * @param port indica el número de puerto que se usará<br />
     * </p>
     *
     */
    public Servidor(int port) {
        this.port = port;
    }

    /**
     * <p>
     * Este es un método constructor de la clase Servidor</p>
     * <p>
     * @param port indica el número de puerto que se usará<br />
     * @param host indica el nombre que se usará<br />
     * </p>
     *
     */
    public Servidor(int port, String host) {
        this.port = port;
        this.host = host;
    }

    /**
     * <p>
     * Este es el método init. Con este método se crea un servidor, se reciben
     * los mensajes del cliente (los cuales se almacenan en una lista ligada),
     * luego se concatenan estos mensajes y se crea y escribe un archivo con
     * ellos</p>
     *
     *
     */
    public void init() throws FileNotFoundException, IOException {
        LinkedList<String> listap = new LinkedList<String>();
        try {
            System.out.println("Iniciando el servidor...");
            ServerSocket serverSocket = new ServerSocket(this.port);

            System.out.println("Esperando conexiones...");
            Socket clientSocket = serverSocket.accept();

            System.out.println("Cliente conectado...");

            BufferedReader entrada = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Envío del cliente: \n");
            for (int i = 0; i < 9; i++) {
                listap.add(entrada.readLine());
            }

            entrada.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

        creaciónArchivo();
        escrituraArchivo(listap);
        lecturaArchivo();
    }


    public void creaciónArchivo(){
        try {
            File arc = new File("producto.txt");
            if (arc.createNewFile()) {
                System.out.println("Archivo creado: " + arc.getName());
            } else {
                System.out.println("Ya existe el archivo.");
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error");
            e.printStackTrace();
        }
    }


    public void escrituraArchivo(LinkedList listap){
        try {
            FileWriter esc = new FileWriter("producto.txt");
            for (int i = 0; i < listap.size(); i++) {
                esc.write(listap.get(i) + "\n");
            }
            esc.close();
            System.out.println("El archivo se escribió exitosamente.");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error.");
            e.printStackTrace();
        }
    }

    public void lecturaArchivo() throws FileNotFoundException, IOException{
        System.out.println("\nAQUÍ ESTÁ LA LECTURA DEL ARCHIVO:");
        File file = new File("producto.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        while ((st = br.readLine()) != null) {
            System.out.println(st);
        }
    }

}


