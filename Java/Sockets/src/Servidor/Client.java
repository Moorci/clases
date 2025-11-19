package Servidor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		try {
			Socket cliente = new Socket("localhost", 5000);
			DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());//para mandar un dato al server usamos output
			dos.writeUTF("hola");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
