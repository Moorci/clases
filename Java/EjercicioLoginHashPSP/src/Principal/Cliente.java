package Principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        try (Socket cliente = new Socket("localhost", 5000)) {

            DataInputStream dis = new DataInputStream(cliente.getInputStream());//recibir del servidor
            DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());//enviar al servidor

            while (true) {
                System.out.println(dis.readUTF());

                char opcion = teclado.next().toUpperCase().charAt(0);
                dos.writeChar(opcion);

                if (opcion == 'R') {
                    System.out.println(dis.readUTF());
                    dos.writeUTF(teclado.next());

                    System.out.println(dis.readUTF());
                    dos.writeUTF(teclado.next());

                    System.out.println(dis.readUTF());
                    dos.writeUTF(teclado.next());

                    System.out.println(dis.readUTF());

                } else if (opcion == 'L') {
                    System.out.println(dis.readUTF());
                    dos.writeUTF(teclado.next());

                    System.out.println(dis.readUTF());
                    dos.writeUTF(teclado.next());

                    System.out.println(dis.readUTF());
                } else {
                    System.out.println(dis.readUTF());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        teclado.close();
    }
}