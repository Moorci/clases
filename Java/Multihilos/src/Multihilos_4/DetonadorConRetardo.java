package Multihilos_4;

public class DetonadorConRetardo extends Thread{
	private String nombre;
	private int contador;
	
	public DetonadorConRetardo(String nombre, int contador) {
        this.nombre = nombre;
        this.contador = contador;
    }
	
	@Override
	public void run() {
		while (contador != 0) {
			System.out.println(nombre + "\nContador: " + contador +"\n");
			System.out.println("---------------------------");
			contador --;
			try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
	}

}
