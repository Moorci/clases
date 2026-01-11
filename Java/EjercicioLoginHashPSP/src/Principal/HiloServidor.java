package Principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class HiloServidor extends Thread {

    private Socket cliente;
    private ArrayList<Usuario> usuarios;

    public HiloServidor(Socket cliente, ArrayList<Usuario> usuarios) {
        this.cliente = cliente;
        this.usuarios = usuarios;
    }

    @Override
    public void run() {
        try {
            DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
            DataInputStream dis = new DataInputStream(cliente.getInputStream());

            while (true) {

                dos.writeUTF("\n[R] Registrarse\n[L] Login");
                char opcion = dis.readChar();

                if (opcion == 'R') {
                    dos.writeUTF("Introduce username:");
                    String username = dis.readUTF();

                    dos.writeUTF("Introduce nombre:");
                    String nombre = dis.readUTF();

                    dos.writeUTF("Introduce contraseña:");
                    String contraseña = dis.readUTF();

                    String resumen = hashSHA(contraseña);

                    Usuario user = new Usuario(username, nombre, resumen);
                    usuarios.add(user);

                    dos.writeUTF("Usuario registrado correctamente");

                } else if (opcion == 'L') {
                    dos.writeUTF("Introduce username:");
                    String username = dis.readUTF();

                    dos.writeUTF("Introduce contraseña:");
                    String contraseña = dis.readUTF();

                    String resumen = hashSHA(contraseña);

                    // para que si hay varios usuarios no falle
                    boolean ok = false;

                    for (Usuario u : usuarios) {
                        if (u.user.equals(username) && u.contraseña.equals(resumen)) {
                            ok = true;
                            break;
                        }
                    }

                    if (ok) {
                        dos.writeUTF("Login correcto");
                    } else {
                        dos.writeUTF("Login incorrecto");
                    }

                
                } else {
                    dos.writeUTF("Opción no válida");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String hashSHA(String texto) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            byte[] dataBytes = texto.getBytes();
            md.update(dataBytes);
            byte[] resumen = md.digest();
            return new String(resumen);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}