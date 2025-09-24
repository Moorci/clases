package Multihilos_3;

public class Escritora extends Thread {
    private boolean escribeNumeros;

    public Escritora(boolean escribeNumeros) {
        this.escribeNumeros = escribeNumeros;
    }

    @Override
    public void run() {
        while (true) { // ejecutado de forma indefinida
            if (escribeNumeros) {
                for (int i = 1; i <= 30; i++) {
                    System.out.println("Numero: " + i);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                for (char c = 'a'; c <= 'z'; c++) {
                    System.out.println("Letra: " + c);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
