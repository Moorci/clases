package Principal;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		try {
			ServerSocket servidor = new ServerSocket(5000);
			System.out.println("Servidor iniciado");
			Socket cliente = servidor.accept();
			EnviarThread envio = new EnviarThread(cliente);
			RecibirThread recibir = new RecibirThread(cliente);
			envio.start();
			recibir.start();
			
			envio.join();
			recibir.join();
			servidor.close();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
