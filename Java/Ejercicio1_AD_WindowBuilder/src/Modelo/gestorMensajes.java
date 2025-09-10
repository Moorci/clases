package Modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class gestorMensajes {

    ArrayList<mensaje> mensajes = new ArrayList<>();
    private static final String ARCHIVO = "archivos/mensajes.txt";

    public ArrayList<mensaje> getMensajes() {
        return mensajes;
    }

    public void añadirMensaje(mensaje m) {
        if (m != null) {
            mensajes.add(m);
        }
    }
    
    public int contadorMensajes() {
    	return mensajes.size();
    }

    public void leerMensajesDesdeFichero() {
        mensajes.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            mensaje m = null;

            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if (linea.isEmpty()) continue;

                if (linea.startsWith("fecha:")) {
                    m = new mensaje();
                    String fechaStr = linea.substring(6).trim();
                    LocalDate fechaLocal = LocalDate.parse(fechaStr);
                    Date fecha = java.util.Date.from(
                        fechaLocal.atStartOfDay(java.time.ZoneId.systemDefault()).toInstant()
                    );
                    m.setFecha(fecha);

                } else if (linea.startsWith("hora:") && m != null) {
                    String horaStr = linea.substring(5).trim();
                    m.setHora(LocalTime.parse(horaStr));

                } else if (linea.startsWith("para:") && m != null) {
                    m.setReceptor(linea.substring(5).trim());

                } else if (linea.startsWith("de:") && m != null) {
                    m.setRemitente(linea.substring(3).trim());

                } else if (linea.startsWith("asunto:") && m != null) {
                    m.setAsunto(linea.substring(7).trim());

                } else if (linea.startsWith("contenido:") && m != null) {
                    m.setContenido(linea.substring(10).trim());

                } else if (linea.startsWith("****") && m != null) {
                    mensajes.add(m);
                    m = null;
                }
            }

            if (m != null) {
                mensajes.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void guardarMensajesEnFichero() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            for (mensaje m : mensajes) {
                LocalDate fechaLocal = m.getFecha().toInstant()
                                       .atZone(java.time.ZoneId.systemDefault())
                                       .toLocalDate();

                bw.write("fecha: " + fechaLocal.toString());
                bw.newLine();

                bw.write("hora: " + m.getHora().format(timeFormatter));
                bw.newLine();

                bw.write("para: " + m.getReceptor());
                bw.newLine();

                bw.write("de: " + m.getRemitente());
                bw.newLine();

                bw.write("asunto: " + m.getAsunto());
                bw.newLine();

                bw.write("contenido: " + m.getContenido());
                bw.newLine();

                bw.write("****");
                bw.newLine();
            }

            bw.flush();
            System.out.println("Mensajes guardados correctamente");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
