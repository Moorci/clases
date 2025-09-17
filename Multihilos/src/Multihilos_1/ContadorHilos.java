package Multihilos_1;

public class ContadorHilos {
    public static void main(String[] args) {
        Runnable contador1 = new Contador("Hilo-1");
        Runnable contador2 = new Contador("Hilo-2");

        Thread hilo1 = new Thread(contador1);
        Thread hilo2 = new Thread(contador2);

        hilo1.start();
        hilo2.start();
    }
}

class Contador implements Runnable {
    private String nombre;

    public Contador(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i < 3; i++) {
            System.out.println(nombre + " cuenta: " + i);
        }
        System.out.println(nombre + " ha terminado.");
    }
}