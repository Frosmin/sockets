import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente{
    static final String HOST = "127.0.0.1";
    static final int PUERTO = 51250;
    
    public Cliente (){
        try{
            Socket skCliente = new Socket (HOST, PUERTO);
            String pal = " ";
            while(!pal.equals("adios")){
                DataInputStream in = new DataInputStream(skCliente.getInputStream());
                DataOutputStream out = new DataOutputStream(skCliente.getOutputStream());
                
                Scanner param = new Scanner(System.in);
                System.out.print("Cliente: ");
                pal = param.nextLine();
                
                out.writeUTF(pal);
                
                String result = in.readUTF();
                System.out.println("Servidor: " + result);
                out.writeUTF(result);
                
                skCliente = new Socket (HOST, PUERTO);
            }
            skCliente.close();
        } catch(Exception e){
          System.out.println(e.getMessage());  
        }
    }
    
    public static void main(String [] args) {
        new Cliente();
    }
} 