package examen2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaBean.Producto;

/**
 * <p>Esta es la clase Cliente. Esta nos sirve para crear un cliente que recibe y envía mensajes de un servidor</p>
 * 
 * @author 2193000343
 */
public class Cliente {
    /**
     * <p>Este atributo nos ayuda a indicar el número de puerto que se usará</p>
     */
    private int port;
    /**
     * <p>Este atributo nos ayuda a indicar el nombre que se usará</p>
     */
    private String host;

    /**
     * <p>Este es un método constructor de la clase Cliente</p>
     * <p>
     * @param port indica el número de puerto que se usará<br /> 
     * @param host indica el nombre que se usará<br /> 
     * </p>
     * 
     */
    public Cliente(int port, String host) {
        this.port = port;
        this.host = host;
    }
    
    /**
     * <p>Este es el método init. Con este método se crea un cliente, se reciben los mensajes del del servidor (los cuales se almacenan en una lista ligada) y se muestran en pantalla</p>
     * 
     * 
     */
    public void init(){
        
        try {
            Producto p = new Producto();
            System.out.println("Iniciando al cliente...");
            Socket clientSocket = new Socket(this.host, this.port);
            
            System.out.println("Conexión exitosa!");
            
            PrintWriter salida = new PrintWriter(clientSocket.getOutputStream(), true);
            
            System.out.println("Aquí se escriben los datos del producto");
            p = pedirDatos();
            //System.out.println("Esta es la cadena" + Double.toString(p.getPrecio()));
            
            
            for(int i=0; i<9;i++){
                salida.println(p.toString());
            }

            
            salida.close();
            clientSocket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Producto pedirDatos(){
        Producto p = new Producto();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Dame el número de serie");
        p.setNumSerie(sc.nextLine());
        
        System.out.println("Dame la marca");
        p.setMarca(sc.nextLine());
        
        System.out.println("Dame el modelo");
        p.setModelo(sc.nextLine());
        
        System.out.println("Dame el tipo de dispositivo");
        p.setTipoDispositivo(sc.nextLine());
        
        System.out.println("Dame la compañía");
        p.setCompania(sc.nextLine());
        
        System.out.println("Dame el material");
        p.setMaterial(sc.nextLine());
        
        System.out.println("Dame el tipo de interfaz de carga");
        p.setTipoCarga(sc.nextLine());
        
        System.out.println("Dame la descripción");
        p.setDescripcion(sc.nextLine());
        
        System.out.println("Dame el precio");
        p.setPrecio(sc.nextDouble());
        
        return p;
    }
    
    
}
