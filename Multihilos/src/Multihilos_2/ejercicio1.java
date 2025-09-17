package Multihilos_2;

public class ejercicio1 {
	public static void main(String[] args) {
		HiloRunnable tarea1 = new HiloRunnable("Hilo-1");
		HiloRunnable tarea2 = new HiloRunnable("Hilo-2");

		Thread hilo1 = new Thread(tarea1);
		Thread hilo2 = new Thread(tarea2);

		hilo1.start();
		hilo2.start();

		while (hilo1.isAlive() || hilo2.isAlive()) {
			System.out.println("Esperando que los hilos terminen...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("El hilo principal fue interrumpido.");
			}
		}

		System.out.println("¡Ambos hilos han finalizado!");
	}
}

class HiloRunnable implements Runnable {
	private String nombre;

	public HiloRunnable(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 1000; i++) {
			System.out.println(nombre + " cuenta: " + i);
		}
		System.out.println(nombre + " ha terminado.");
	}
}
