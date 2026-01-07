package Principal;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Servidor {

	public static void main(String[] args) {
		ServerSocket servidor;
		try {
			servidor = new ServerSocket(5000);
			System.out.println("Servidor iniciado");
			Socket cliente = servidor.accept();
			DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
			dos.writeUTF("Introduce texto");
			
			DataInputStream dis = new DataInputStream(cliente.getInputStream());
			String texto = dis.readUTF();
			System.out.println(texto);
			
			String resumenTexto = new String();
			try {
				MessageDigest md = MessageDigest.getInstance("SHA");
				byte dataBytes[] = texto.getBytes();
				md.update(dataBytes);
				byte resumen[] = md.digest();
				resumenTexto = new String(resumen);
			}catch(NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			System.out.println(resumenTexto);
			dos.writeUTF("Escribe la frase");
			
			String textoComparar = dis.readUTF();
			System.out.println(textoComparar);
			if(textoComparar.equals(resumenTexto)) {
				dos.writeUTF("Hash igual");
			}else {
				dos.writeUTF("Hash no es igual");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
