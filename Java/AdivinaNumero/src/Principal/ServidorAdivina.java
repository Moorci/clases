package Principal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class ServidorAdivina {
    public static void main(String[] args) {
        try (ServerSocket servidor = new ServerSocket(5000)){
            System.out.println("Servidor iniciado...");
            int numero = new Random().nextInt(25) + 1;
            System.out.println("NUMERO A ADIVINAR: " + numero);
            ObjetoCompartido compartido = new ObjetoCompartido(numero);
            int id = 0;
            while (true) {
                Socket socket = servidor.accept();
                id++;
                System.out.println("Cliente conectado: " + id);
                HiloServidorAdivina hilo = new HiloServidorAdivina(socket, compartido, id);
                hilo.start();
            }
        } catch (IOException e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}