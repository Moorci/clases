package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ejer5 {

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("cmd","/C","tasklist");
		Process proces;
		boolean encontrado = false;
		try {
		proces = pb.start();
		InputStream is = proces.getInputStream();
		BufferedReader bis = new BufferedReader(new InputStreamReader(is));
		String linea = "";
		while((linea = bis.readLine()) != null) {
			if(linea.toLowerCase().contains("notepad.exe")) {
				encontrado = true;
			}
		}
		if(encontrado) {
			ProcessBuilder pbKill = new ProcessBuilder("cmd", "/C", "taskkill", "/F", "/IM", "notepad.exe");
			Process Killprocess = pbKill.start();
			//muestra si se ha terminado el proceso
			BufferedReader reader = new BufferedReader(new InputStreamReader(Killprocess.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
			    System.out.println(line);
			}
			Killprocess.waitFor();
		}else {
			System.out.println("Proceso no encontrado");
		}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

}
