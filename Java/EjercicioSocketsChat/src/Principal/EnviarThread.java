package Principal;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EnviarThread extends Thread {
    private Socket cliente;
    private Scanner teclado = new Scanner(System.in);
    private DataOutputStream dos;    
    
    public EnviarThread(Socket cliente) throws IOException {
        this.cliente = cliente;
        this.setDos(new DataOutputStream(cliente.getOutputStream()));
    }

    @Override
    public void run() {
        try {
            DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
            while (true) {
                String mensaje = teclado.nextLine();
                dos.writeUTF(mensaje);
                if ("salir".equalsIgnoreCase(mensaje)) {
                    cliente.close(); 
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public DataOutputStream getDos() {
		return dos;
	}

	public void setDos(DataOutputStream dos) {
		this.dos = dos;
	}

}
