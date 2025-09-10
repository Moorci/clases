package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ejer2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ProcessBuilder pb = new ProcessBuilder("cmd","/C","tree");
		try {
		Process proces = pb.start();
		InputStream is = proces.getInputStream();
		BufferedReader bis = new BufferedReader(new InputStreamReader(is));
		String linea = "";
			while((linea = bis.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
