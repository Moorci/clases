package Principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		try (Socket cliente = new Socket("localhost", 5000)){
			DataInputStream dis = new DataInputStream(cliente.getInputStream());
			dis.readUTF();
			
			DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
			int opcion = teclado.nextInt();
			dos.writeInt(opcion);
			
			if(opcion == 1) {
				dis.readUTF();
				String username = teclado.next();
				dos.writeUTF(username);
				
				dis.readUTF();
				String nombre = teclado.next();
				dos.writeUTF(nombre);
				
				dis.readUTF();
				String contraseña = teclado.next();
				dos.writeUTF(contraseña);
				
				dis.readUTF();
				
			}else if(opcion == 2) {
				dis.readUTF();
				String username = teclado.next();
				dos.writeUTF(username);
				
				dis.readUTF();
				String contraseña = teclado.next();
				dos.writeUTF(contraseña);
				
				dis.readUTF();
				
			}else {
				dis.readUTF();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		teclado.close();
	}

}
