package Multihilos_2;

public class ejercicio3 {

	public static void main(String[] args) {
		ClaseThread tarea1 = new ClaseThread("Hilo-1");
		ClaseThread tarea2 = new ClaseThread("Hilo-2");

		tarea1.start();
		tarea2.start();
		
		while (tarea1.isAlive() || tarea2.isAlive()) {
			System.out.println("Esperando que las personas terminen...");
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("¡Ambas personas han finalizado!");
		
		
	}

}

class ClaseThread extends Thread {
	private String nombre;

	public ClaseThread(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void run() {
		System.out.println("Iniciando " + nombre);
		for (int i = 1; i < 3; i++) {
			System.out.println(nombre + " realizando operacion: " + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("todos los procesos terminado.");
	}
}
