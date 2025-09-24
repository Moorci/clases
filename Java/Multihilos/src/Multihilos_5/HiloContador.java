package Multihilos_5;

public class HiloContador extends Thread {
	private int contador;
	private int prioridad;
	
	public HiloContador(int contador, int prioridad) {
        this.contador = contador;
        this.prioridad = prioridad;
    }
	
	@Override
	public void run() {
		while (true) {
			if(prioridad == 0) {
				contador++;
			}else {
				contador++;
				contador++;
			}
		}
	}
	
}
