package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ejer7 {

	public static void main(String[] args) {
		try {
			System.out.print("Introduce un texto: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String texto = br.readLine();

			ProcessBuilder pb = new ProcessBuilder("java", "ejercicio1.EjemploLectura");
			pb.redirectErrorStream(true);
			Process p = pb.start();

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
			bw.write(texto);
			bw.newLine();
			bw.flush();
			bw.close();

			BufferedReader salida = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String linea;
			while ((linea = salida.readLine()) != null) {
				System.out.println("Salida del programa: " + linea);
			}

			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}