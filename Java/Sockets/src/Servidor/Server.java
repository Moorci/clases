package Servidor;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket servidor = new ServerSocket(5000); //creamos el servidor en este puerto
			System.out.println("Servidor iniciado");
			
			Socket cliente = servidor.accept(); // decimos que los socket que mande el cliente se acepten en el servidor
			System.out.println("Cliente aceptado");
			DataInputStream dis = new DataInputStream(cliente.getInputStream());//recibimos el mensaje del cliente con input
			String mensaje = dis.readUTF();//recogemos el mensaje como string
			System.out.println(mensaje);//mostramos el mensaje
			
			servidor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
