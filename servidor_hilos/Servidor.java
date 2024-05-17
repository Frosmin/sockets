import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Servidor {
    static final int PUERTO = 2000;

    public Servidor() {
        try {
            ServerSocket servidor = new ServerSocket(PUERTO);
            
            while (true) {
                Socket cliente = servidor.accept();
                new Thread(new ClienteHandler(cliente)).start();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("servidor iniciado");
        new Servidor();
    }

    private static class ClienteHandler implements Runnable {
        private Socket cliente;

        public ClienteHandler(Socket cliente) {
            this.cliente = cliente;
        }

        @Override
        public void run() {
            try {
                DataInputStream in = new DataInputStream(cliente.getInputStream());
                String mensaje;
                
                while ((mensaje = in.readUTF()) != null) {
                    System.out.println(mensaje);
                }
                //cliente.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}