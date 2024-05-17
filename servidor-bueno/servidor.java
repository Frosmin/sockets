import java.io.*;
import java.net.*;
import java.util.Scanner;

public class servidor
{
     static final int PUERTO = 2620;
     
     public servidor(){
         try{
             ServerSocket skServidor = new ServerSocket(PUERTO);
             System.out.println("Escucho el puerto " + PUERTO);
             String mensaje;
             
             for(int numCli = 0; numCli <3; numCli++){
                 Socket skCliente = skServidor.accept();
                 System.out.println("Sirvo al cliente " + numCli);
                 
                 DataInputStream in = new DataInputStream(skCliente.getInputStream());
                 DataOutputStream out = new DataOutputStream(skCliente.getOutputStream());
                 Scanner sc = new Scanner(System.in);
                 String mensajeAux = "";
                 
            
                 while(!mensajeAux.equals("cerrar")){
                     mensaje = in.readUTF(); 
                     System.out.println(mensaje); 
                     System.out.println("Escriba el mensaje a enviar: ");
                     mensajeAux = sc.nextLine();
                     out.writeUTF(mensajeAux); 
                 }
                 skCliente.close();
             }
             System.out.println("Numero de clientes limite alcanzado");
         }catch(Exception e){
             System.out.println(e.getMessage());
        }
     }
     
     public static void main(String [] arg){
         new servidor();
     }
}
