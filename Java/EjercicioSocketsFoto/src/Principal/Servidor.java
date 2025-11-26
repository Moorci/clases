package Principal;

import java.io.*;
import java.net.*;

public class Servidor {
    public static void main(String[] args) {
        try (ServerSocket servidor = new ServerSocket(5000)) {
            System.out.println("Servidor iniciado");
            try (Socket cliente = servidor.accept();
                 DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
                 BufferedInputStream fileInput = new BufferedInputStream(new FileInputStream("lib/img.png"))) {

                File fich = new File("lib/img.png");
                salida.writeLong(fich.length()); // enviar tamaño primero

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fileInput.read(buffer)) != -1) {
                    salida.write(buffer, 0, bytesRead);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
