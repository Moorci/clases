package Vista;

import java.util.Scanner;

public class EjemploProceso {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nombre = sc.nextLine();
		System.out.println("Salida: " + nombre);
		sc.close();
	}
}
