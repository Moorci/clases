package Principal;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class RecibirThread extends Thread {
    private Socket cliente;
    private DataInputStream dis;

    public RecibirThread(Socket cliente) throws IOException {
        this.cliente = cliente;
        this.setDis(new DataInputStream(cliente.getInputStream()));
    }

    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(cliente.getInputStream());
            String mensaje;
            while ((mensaje = dis.readUTF()) != null) {
                System.out.println("Mensaje: " + mensaje);
                if ("salir".equalsIgnoreCase(mensaje)) {
                    cliente.close();
                    break;
                }
            }
        } catch (IOException e) {
        	e.printStackTrace();
        }
    }

	public DataInputStream getDis() {
		return dis;
	}

	public void setDis(DataInputStream dis) {
		this.dis = dis;
	}

}

