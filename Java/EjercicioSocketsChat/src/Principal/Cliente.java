package Principal;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {
		try {
			
			Socket cliente = new Socket("localhost", 5000);
			EnviarThread envio = new EnviarThread(cliente);
			RecibirThread recibir = new RecibirThread(cliente);
			envio.start();
			recibir.start();
			
			envio.join();
			recibir.join();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
