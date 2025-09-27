package Multihilos_4;


public class Principal {

	public static void main(String[] args) {
		DetonadorConRetardo hilo1 = new DetonadorConRetardo("Hilo 1", 20);
		DetonadorConRetardo hilo2 = new DetonadorConRetardo("Hilo 2", 30);
		DetonadorConRetardo hilo3 = new DetonadorConRetardo("Hilo 3", 30);
		DetonadorConRetardo hilo4 = new DetonadorConRetardo("Hilo 4", 30);

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        
        try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
            hilo4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Todos los hilos han terminado la ejecución.");
	}

}