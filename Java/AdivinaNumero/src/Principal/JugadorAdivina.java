package Principal;

import java.io.*;
import java.net.Socket;

public class JugadorAdivina {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

            Datos datos = (Datos) entrada.readObject();
            System.out.println("Id jugador: " + datos.getIdentificador());
            System.out.println(datos.getCadena());

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            while (datos.isJuega()) {
                if (datos.getIntentos() >= 5) {
                    System.out.println("JUEGO FINALIZADO, NO HAY MÁS INTENTOS");
                    break;
                }

                System.out.print("Intento: " + (datos.getIntentos() + 1) + " => Introduce número: ");
                String numero = br.readLine();
                datos.setCadena(numero);

                salida.writeObject(datos);
                salida.flush();

                datos = (Datos) entrada.readObject();
                System.out.println(datos.getCadena());

                if (datos.isGana()) {
                    System.out.println("HAS GANADO!! EL JUEGO HA TERMINADO");
                    break;
                }

                if (!datos.isJuega() && !datos.isGana()) {
                    System.out.println("EL JUEGO HA TERMINADO, HAN ADIVINADO EL NUMERO");
                    break;
                }
            }

            socket.close();
        } catch (Exception e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }
}