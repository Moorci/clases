package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket servidor = new ServerSocket(5000); //creamos el servidor en este puerto
			System.out.println("Servidor iniciado");
			
			for (int i = 1; i <= 3; i++) {
				Socket cliente = servidor.accept();
				System.out.println("Recibido --------------");
				DataInputStream dis = new DataInputStream(cliente.getInputStream());//recibimos el mensaje del cliente con input
				String mensaje = dis.readUTF();//recogemos el mensaje como string
				System.out.println(mensaje + i);//mostramos el mensaje
				
				DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
				dos.writeUTF("Hola cliente desde el servidor");
			}
			
			System.out.println("Demasiados clientes por hoy");
			servidor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
