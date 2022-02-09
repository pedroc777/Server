/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen2;



import java.io.IOException;
import java.util.Scanner;
import javaBean.Producto;

/**
 * <p>Esta es la clase PrincipalServidor, la cual nos sirve para crear una instancia de un servidor</p>
 * 
 * @author 2193000343
 */
public class PrincipalServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Servidor miServidor = new Servidor(9000);
        System.out.println("SERVIDOR\n");
        miServidor.init();
        
        
        

    }
    
}
