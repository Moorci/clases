package Principal;

import java.io.*;
import java.net.Socket;

public class HiloServidorAdivina extends Thread {
    private Socket socket;
    private ObjetoCompartido compartido;
    private int id;

    public HiloServidorAdivina(Socket socket, ObjetoCompartido compartido, int id) {
        this.socket = socket;
        this.compartido = compartido;
        this.id = id;
    }

    public void run() {
        try {
            ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

            Datos datos = new Datos();
            datos.setCadena("Adivina un numero entre 1 Y 25");
            datos.setIdentificador(id);
            datos.setIntentos(0);
            datos.setJuega(true);
            salida.writeObject(datos);
            salida.flush();

            while (datos.getIntentos() < 5 && !compartido.seAcabo()) {
                try {
                    datos = (Datos) entrada.readObject();
                    datos.setIntentos(datos.getIntentos() + 1);

                    if (compartido.seAcabo()) {
                        datos.setCadena("LO SENTIMOS, EL JUEGO HA TERMINADO, HAN ADIVINADO EL No " + compartido.getGanador());
                        datos.setJuega(false);
                    } else {
                        String resultado = compartido.nuevaJugada(id, Integer.parseInt(datos.getCadena()));
                        datos.setCadena(resultado);
                        if (resultado.contains("gana")) {
                            datos.setGana(true);
                            datos.setJuega(false);
                        }
                    }

                    salida.writeObject(datos);
                    salida.flush();
                } catch (Exception ex) {
                    datos.setCadena("Error: " + ex.getMessage());
                    salida.writeObject(datos);
                    salida.flush();
                }
            }

            System.out.println("Ya no hay nada que leer del jugador: " + id);
            if (compartido.seAcabo()) {
                System.out.println("EL JUEGO SE HA ACABADO.....");
            }
            System.out.println("==>Desconecta: " + id);
            socket.close();
        } catch (IOException e) {
            System.out.println("Error con el jugador " + id + ": " + e.getMessage());
        }
    }
}