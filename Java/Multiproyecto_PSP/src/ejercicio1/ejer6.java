package ejercicio1;

import java.io.File;
import java.io.IOException;

public class ejer6 {

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("miBat.bat"); // el .bat genera una salida y un error, cada una va a su lugar
		pb.redirectOutput(new File("salida.txt"));
		pb.redirectError(new File("errores.txt"));
		try {
			Process proces = pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
