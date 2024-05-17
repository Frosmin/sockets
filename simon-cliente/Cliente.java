import java.io.*;
import java.util.Scanner;
import java.net.*;
public class Cliente
{
    static final int PUERTO = 2000;
      String mensaje;
      String mensaje3;
   public Cliente(){
        try{
            Socket cliente = new Socket("localhost",PUERTO);
            
            DataInputStream in = new DataInputStream(cliente.getInputStream());
            DataOutputStream out = new DataOutputStream(cliente.getOutputStream());
            //String mensaje2 = " ";
            Scanner sc = new Scanner(System.in);
            
                System.out.println("Escriba el mensaje a enviar");
                mensaje3 = sc.nextLine();
                
                out.writeUTF(mensaje3);
           
                //mensaje = in.readUTF();
               System.out.println("2");
       
            
            cliente.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    } 
    
  public static void main(String[] args){
        new Cliente();
    } 
}
