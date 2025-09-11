package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class EjemploLectura {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nombre = sc.nextLine();
		System.out.println("Salida: " + nombre);
		sc.close();
	}
}