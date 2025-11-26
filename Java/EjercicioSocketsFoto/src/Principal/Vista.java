package Principal;

import java.awt.EventQueue;
import java.io.*;
import java.net.Socket;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Vista extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel foto;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Vista frame = new Vista();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Vista() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 685, 486);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        foto = new JLabel(new ImageIcon("lib/nodispo.png"));
        foto.setBounds(122, 48, 386, 327);
        contentPane.add(foto);

        // Recibir imagen desde el socket
        try {
        	Socket client = new Socket("localhost", 5000);
            DataInputStream socketIS = new DataInputStream(client.getInputStream());//Recive la foto
            FileOutputStream fileOS = new FileOutputStream("imagenNueva.png");//Crea una imagen donde hay que escribir los bytes de la foto recibida
            socketIS.readLong();// lee tamaño de la entrega
            byte[] buffer = new byte[4096];// reserva bytes en el buffer
            int bytesRead;
            while ((bytesRead = socketIS.read(buffer)) != -1) {
                fileOS.write(buffer, 0, bytesRead);
            }
            client.close();
            fileOS.close();
            System.out.println("Recibido");
            foto.setIcon(new ImageIcon("imagenNueva.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
