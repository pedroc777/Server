package examen2;

import java.util.Scanner;
import javaBean.Producto;

/**
 * <p>Esta es la clase PrincipalCliente, la cual nos sirve para crear una instancia de un cliente</p>
 * 
 * @author 2193000343
 */
public class PrincipalCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cliente k = new Cliente(9000,"localhost");
        System.out.println("CLIENTE\n");
        k.init();
        
        //Scanner sc = new Scanner(System.in);
        
        //Producto p = new Producto();
        
        
       
    }
    
}
