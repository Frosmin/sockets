import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    static final String IP = "127.0.0.1"; // Cambia esto a la IP del servidor
    static final int PUERTO = 2000;

    public Cliente() {
        try {
            Socket socket = new Socket(IP, PUERTO);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("Escribe un mensaje para el servidor:");
                String mensaje = sc.nextLine();

                out.writeUTF(mensaje);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        new Cliente();
    }
}