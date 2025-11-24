package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket servidor = new ServerSocket(5000);
			System.out.println("Servidor iniciado");
			
			for (int i = 1; i <= 3; i++) {
				Socket cliente = servidor.accept();
				System.out.println("Recibido --------------");
				DataInputStream dis = new DataInputStream(cliente.getInputStream());
				String mensaje = dis.readUTF();
				System.out.println(mensaje);
				
				DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
				dos.writeUTF("Hola desde el servidor al cliente " + i);
			}
			
			System.out.println("Demasiados clientes por hoy");
			servidor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
