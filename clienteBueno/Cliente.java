import java.io.*;
import java.util.Scanner;
import java.net.*;

public class Cliente
{
    static final String HOST = "127.0.0.1";
    static final int PUERTO = 2000;
    String mensaje;
    
    public Cliente(){
        try{
            Socket skCliente = new Socket(HOST, PUERTO);
            
            DataInputStream in = new DataInputStream(skCliente.getInputStream());
            DataOutputStream out = new DataOutputStream(skCliente.getOutputStream());
            String mensaje2 = " ";
            Scanner sc = new Scanner(System.in);
            
    
            while(!mensaje2.equals("cerrar")){
                System.out.println("Escriba el mensaje a enviar");
                mensaje2 = sc.nextLine();
                out.writeUTF(mensaje2);
                mensaje = in.readUTF();
                System.out.println(mensaje);
            }
            skCliente.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String [] arg){
          new Cliente();      
    }
}
