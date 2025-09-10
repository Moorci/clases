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
                linea = linea.trim();
                if (linea.contains("-")) {
                    String mac = linea.split(" ")[0];
                    System.out.println(mac);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
