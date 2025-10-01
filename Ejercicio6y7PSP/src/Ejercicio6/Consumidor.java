package Ejercicio6;

public class Consumidor extends Thread {
    private Buffer buffer;
    private int tiempoEspera;

    public Consumidor(Buffer buffer, int tiempoEspera) {
        this.buffer = buffer;
        this.tiempoEspera = tiempoEspera;
    }

    @Override
    public void run() {
        while (true) {
            char letra = buffer.recoger();
            System.out.println("Consumidor recogió la letra: " + letra);

            try {
                Thread.sleep(tiempoEspera);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
