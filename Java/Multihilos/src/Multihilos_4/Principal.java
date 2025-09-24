package Multihilos_4;


public class Principal {

	public static void main(String[] args) {
		DetonadorConRetardo hilo1 = new DetonadorConRetardo("Hilo 1", 20);
		DetonadorConRetardo hilo2 = new DetonadorConRetardo("Hilo 2", 30);

        hilo1.start();
        hilo2.start();
        
	}

}
