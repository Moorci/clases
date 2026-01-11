package Principal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

	public static void main(String[] args) {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		Usuario usuario1 = new Usuario("XXXX","YYYY", "���D*ƅ�A���M=2�{�5D/i��N"); // password1
		Usuario usuario2 = new Usuario("XXXX","YYYY", ":�Y0n��`σ-4���؍ao�©��-�o�g");// pass3
		
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		ServerSocket servidor;
		try {
			servidor = new ServerSocket(5000);
			System.out.println("Servidor iniciado");
			while(true) {
				Socket cliente = servidor.accept();
				HiloServidor hilo = new HiloServidor(cliente, usuarios);
				hilo.start();
			}
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
