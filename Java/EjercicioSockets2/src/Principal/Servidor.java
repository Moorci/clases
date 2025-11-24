package Principal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Servidor {

	public static void main(String[] args) {
		try {
			ServerSocket servidor = new ServerSocket(5000);
			System.out.println("Servidor iniciado");
			Socket cliente = servidor.accept();
			
			// Enviar
			ObjectOutputStream dos = new ObjectOutputStream(cliente.getOutputStream());
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String fechaStr = "15/04/1990";
			Date fechaNacimiento = sdf.parse(fechaStr);
			Persona persona = new Persona("12345678A", "Juan", "Pérez", fechaNacimiento , 'M');
			dos.writeObject(persona);
			
			System.out.println("persona enviada: \n" + persona);
			
			// Recibir
			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
			Persona personaModificada = (Persona) ois.readObject();
			System.out.println("persona modificada: \n" + personaModificada);
			servidor.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
