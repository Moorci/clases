package Ejercicio6;

import java.util.Random;

public class Productor extends Thread {
    private Buffer buffer;
    private int tiempoEspera;

    public Productor(Buffer buffer, int tiempoEspera) {
        this.buffer = buffer;
        this.tiempoEspera = tiempoEspera;
    }

    @Override
    public void run() {
    	Random rnd = new Random();
    	
        for (int i = 0; i < 10; i++) {
            char letra = (char) ('A'  + rnd.nextInt(26));
            buffer.poner(letra); 
            System.out.println("Productor generó la letra: " + letra);
            try {
                Thread.sleep(tiempoEspera); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
