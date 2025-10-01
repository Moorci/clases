package Ejercicio6;

public class Ejecutable {

	public static void main(String[] args) {
		
		Buffer b = new Buffer();
		Productor p = new Productor (b, 500);
		Consumidor c = new Consumidor (b, 1000);
		
		p.start();
		c.start();
		
	}

}
