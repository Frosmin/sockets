import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Servidor{
    static final int PUERTO = 51250;
    
    public Servidor (){
        try{
            ServerSocket skServidor = new ServerSocket (PUERTO);
            System.out.println("Escucho el puerto " + PUERTO);
            
            System.out.println("Este es el principio de tu epica conversacion con Cliente");
            String pal = " ";
            while(!pal.equals("adios")){
                Socket skCliente = skServidor.accept();
                DataInputStream in = new DataInputStream(skCliente.getInputStream());
                DataOutputStream out = new DataOutputStream(skCliente.getOutputStream());
                
                pal = in.readUTF();
                System.out.println("Cliente: " + pal);
                
                Scanner param = new Scanner(System.in);
                System.out.print("Servidor: ");
                String res = param.nextLine();
                
                out.writeUTF(res);
                skCliente.close(); 
            }
        } catch(Exception e){
          System.out.println(e.getMessage());  
        }
    }

    public static void main(String [] args) {
        new Servidor();
    }
}