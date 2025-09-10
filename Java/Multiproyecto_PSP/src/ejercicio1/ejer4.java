package ejercicio1;

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ejer4 {

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("cmd","/C","tasklist");
		Process proces;
		try {
		proces = pb.start();
		InputStream is = proces.getInputStream();
		BufferedReader bis = new BufferedReader(new InputStreamReader(is));
		String linea = "";
		while((linea = bis.readLine()) != null) {
			System.out.println(linea);
		}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
