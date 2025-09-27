package Multihilos_5;

public class HiloContador extends Thread {
	private int contador;
	private volatile boolean activo = true;

	public HiloContador(int contador) {
		this.contador = contador;
	}

	@Override
	public void run() {
		while (activo) {
			contador++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				break;
			}
		}
	}

	public void detener() {
		activo = false;
	}

	public int getContador() {
		return contador;
	}
}