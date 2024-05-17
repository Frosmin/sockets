import java.io.*;
import java.net.*;
import java.util.Scanner;

public class servidor
{
     static final int PUERTO = 2000;
     
     public servidor(){
         try{
             ServerSocket skServidor = new ServerSocket(PUERTO);
             System.out.println("Escucho el puerto " + PUERTO);
             int numero;
             int suma = 0;
            
             
             for(int numCli = 0; numCli <3; numCli++){
                 Socket skCliente = skServidor.accept();
                 System.out.println("Sirvo al cliente " + numCli);
                 
                 DataInputStream in = new DataInputStream(skCliente.getInputStream());
                 DataOutputStream out = new DataOutputStream(skCliente.getOutputStream());
                 //Scanner sc = new Scanner(System.in);
                 String mensajeAux = "";
                 
                 
            
                 while(!mensajeAux.equals("cerrar")){
                     numero = in.readInt(); 
                     System.out.println(numero); 
                     suma += numero;
                     out.writeInt(suma);
                     System.out.println("la suma es " + suma); 
                     
                     //System.out.println("Escriba el mensaje a enviar: ");
                    // mensajeAux = sc.nextLine();
                     //out.writeUTF(mensajeAux); 
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
