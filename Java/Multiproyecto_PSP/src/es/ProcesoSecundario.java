package es;

import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ProcesoSecundario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hola");
		try {
			ProcessBuilder pb = new ProcessBuilder("java","es.Programa");
			pb.directory(new File("bin"));
			
			Process proces = pb.start();
			
			OutputStream os = proces.getOutputStream();
			String nombre = "Iker\n";
			os.write(nombre.getBytes());
			os.flush();//vaciar la memoria
			
			long id = proces.pid();
			System.out.println("ID: " + id);
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
		System.exit(-4);
	}
	
	/*ProcessBuilder pb = new ProcessBuilder("java","es.Programa");
	pb.directory(new File("bin"));
			
	Process proces = pb.start();
	long id = proces.pid();
	System.out.println("ID: " + id);
	InputStream is = proces.getInputStream();
	BufferedReader bis = new BufferedReader(new InputStreamReader(is));
	String linea = "";
	while((linea = bis.readLine()) != null) {
		System.out.println(linea);
	}*/
	
	/*ProcessBuilder pb = new ProcessBuilder("cmd","/C","tasklist");
	pb.redirectError(new File("errores.txt"));
	Process proces = pb.start();
	long id = proces.pid();
	System.out.println("ID: " + id);
	
	InputStream is = proces.getInputStream();
	BufferedReader bis = new BufferedReader(new InputStreamReader(is));
	String linea = "";
	while((linea = bis.readLine()) != null) {
		System.out.println(linea);
	}*/
	
	/*ProcessBuilder pb = new ProcessBuilder("cmd","/C","asd");
	pb.redirectOutput(new File("salida.txt"));
	pb.redirectError(new File("errores.txt"));
	Process proces = pb.start();
	long id = proces.pid();
	System.out.println("ID: " + id);*/
	
	/*ProcessBuilder pb = new ProcessBuilder("cmd","/C","tasklist");
	pb.redirectOutput(new File("salida.txt"));
	Process proces = pb.start();
	long id = proces.pid();
	System.out.println("ID: " + id);*/
	
	/*ProcessBuilder pb = new ProcessBuilder("notepad");
	Process proces = pb.start();
	long id = proces.pid();
	System.out.println("ID: " + id);
	int valorsalid = proces.waitFor();
	System.out.println("Valor: " + valorsalid);*/
	
	/*Process rn = Runtime.getRuntime().exec("notepad");
	rn.waitFor();
	int valorsalida = rn.exitValue();
	System.out.println("Valor: " + valorsalida);*/

}
