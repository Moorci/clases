package Principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		try (Socket cliente = new Socket("localhost", 5000)){
			
			DataInputStream dis = new DataInputStream(cliente.getInputStream());
			String mensaje = dis.readUTF();
			System.out.println(mensaje);
			
			DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
			String texto = teclado.next();
			dos.writeUTF(texto);
			
			String mensaje2 = dis.readUTF();
			System.out.println(mensaje2);
			
			String hash = teclado.next();
			try {
				MessageDigest md = MessageDigest.getInstance("SHA");
				byte dataBytes[] = texto.getBytes();
				md.update(dataBytes);
				byte resumen[] = md.digest();
				hash = new String(resumen);
			}catch(NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			dos.writeUTF(hash);
			System.out.println(hash);
			
			String mensaje3 = dis.readUTF();
			System.out.println(mensaje3);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		teclado.close();

	}

}
