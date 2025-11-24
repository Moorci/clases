package Principal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {
		try (Socket cliente = new Socket("localhost", 5000)) {
			// Recibir
			ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
			Persona persona = (Persona) ois.readObject();
			persona.setNombre("María");
			persona.setGenero('F');
			
			// Enviar
			ObjectOutputStream oos = new ObjectOutputStream(cliente.getOutputStream());
			oos.writeObject(persona);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
