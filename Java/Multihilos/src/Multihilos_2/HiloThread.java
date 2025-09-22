package Multihilos_2;

public class HiloThread {

	public static void main(String[] args) {
		ClasehiloThread tarea1 = new ClasehiloThread("Hilo-1");
		ClasehiloThread tarea2 = new ClasehiloThread("Hilo-2");

		tarea1.start();
		tarea2.start();
		
		while (tarea1.isAlive() || tarea2.isAlive()) {
			System.out.println("Esperando que los hilos terminen...");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				System.out.println("El hilo principal fue interrumpido.");
			}
		}

		System.out.println("¡Ambos hilos han finalizado!");
		
		
	}

}

class ClasehiloThread extends Thread {
	private String nombre;

	public ClasehiloThread(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void run() {
		System.out.println("Iniciando " + nombre);
		for (int i = 1; i <= 5; i++) {
			System.out.println(nombre + " cuenta: " + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println(nombre + " fue interrumpido.");
			}
		}
		System.out.println(nombre + " ha terminado.");
	}
}
