package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ejer3 {

	public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/C", "getmac");
        try {
            Process proces = pb.start();
            InputStream is = proces.getInputStream();
            BufferedReader bis = new BufferedReader(new InputStreamReader(is));
            String linea = "";
            while ((linea = bis.readLine()) != null) {
                linea = linea.trim();//quita espacios
                if (linea.contains("-")) {//si la linea contiene un guion, es decir, una direc.mac
                    String mac = linea.split(" ")[0];//divide hasta el espacio
                    System.out.println(mac);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
