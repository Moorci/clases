package Principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class HiloServidor extends Thread{
	
	private Socket cliente;
	private ArrayList<Usuario> usuarios;

	public HiloServidor(Socket cliente, ArrayList<Usuario> usuarios) {
		this.cliente = cliente;
	}

	@Override
	public void run() {
		try {
			DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
			dos.writeUTF("[1] Registrarse \n[2]Login");
			
			DataInputStream dis = new DataInputStream(cliente.getInputStream());
			int opcion = dis.read();
			if(opcion == 1) {
				dos.writeUTF("Introduce username:");
				String username = dis.readUTF();
				dos.writeUTF("Introduce nombre: ");
				String nombre = dis.readUTF();
				dos.writeUTF("Introduce contraseña: ");
				String contraseña = dis.readUTF();
				String resumenTexto = new String();
				try {
					MessageDigest md = MessageDigest.getInstance("SHA");
					byte dataBytes[] = contraseña.getBytes();
					md.update(dataBytes);
					byte resumen[] = md.digest();
					resumenTexto = new String(resumen);
				}catch(NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
				
				Usuario user = new Usuario(username, nombre, resumenTexto);
				usuarios.add(user);
				dos.writeUTF("Usuario registrado correctamente");
			}else if(opcion == 2) {
				dos.writeUTF("Introduce username: ");
				String username = dis.readUTF();
				dos.writeUTF("Introduce contraseña: ");
				String contraseña = dis.readUTF();
				String resumenTexto = new String();
				try {
					MessageDigest md = MessageDigest.getInstance("SHA");
					byte dataBytes[] = contraseña.getBytes();
					md.update(dataBytes);
					byte resumen[] = md.digest();
					resumenTexto = new String(resumen);
				}catch(NoSuchAlgorithmException e) {
					e.printStackTrace();
				}
				
				for (int i = 0; i < usuarios.size(); i++) {
					if (usuarios.get(i).user.equals(username) && usuarios.get(i).contraseña.equals(resumenTexto)) {
						dos.writeUTF("Login correcto");
					}else {
						dos.writeUTF("Login incorrecto");
					}
				}
			}else {
				dos.writeUTF("Introduce un dato valido");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

}
