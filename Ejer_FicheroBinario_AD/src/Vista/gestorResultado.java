package Vista;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class gestorResultado {
	
	ArrayList <Resultados> resultados = new ArrayList();
	
	public void cargarFichero() {
		File fichero = new File("Resultados.dat");
		try {
			FileWriter fic = new FileWriter(fichero);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
