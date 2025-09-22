package Multihilos_2;

public class HiloRunnable {
	public static void main(String[] args) {
		ClasehiloRunnable tarea1 = new ClasehiloRunnable("Hilo-1");
		ClasehiloRunnable tarea2 = new ClasehiloRunnable("Hilo-2");

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

class ClasehiloRunnable implements Runnable {
	private String nombre;

	public ClasehiloRunnable(String nombre) {
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
