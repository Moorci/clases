package Servidor;

import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		try {
			Socket cliente = new Socket("10.5.13.246", 5000);
			
			DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());//para mandar un dato al server usamos output
			dos.writeUTF("Hola desde cliente ");
			
			DataInputStream dis = new DataInputStream(cliente.getInputStream());
			String mensaje = dis.readUTF();
			System.out.println(mensaje);
			
			cliente.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
