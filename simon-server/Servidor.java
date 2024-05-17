import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Servidor{
    static final int puerto = 2000;
    
    
    
    public Servidor(){
        try{
                ServerSocket servidor = new ServerSocket(puerto);
                Socket cliente = servidor.accept();
                System.out.println("hola");
            
                DataInputStream in = new DataInputStream(cliente.getInputStream());
                DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
                Scanner sc = new Scanner(System.in);
                
                String mensaje = in.readUTF();
                System.out.println(mensaje);
                cliente.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
     
    }
      public static void main(String[] args){
        System.out.println("hola");
        new Servidor();
    }  
}
