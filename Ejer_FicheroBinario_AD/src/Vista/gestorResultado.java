package Vista;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class gestorResultado {
	
	ArrayList <Resultados> resultados = new ArrayList<>();
	
	public void añadirResultado(Resultados r) {
		resultados.add(r);
	}
	
	public ArrayList<Resultados> cargarResultados() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Resultados.dat"))) {
            resultados = (ArrayList<Resultados>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            resultados = new ArrayList<>(); // si falla la carga, devolver lista vacía
        }

        return resultados;
    }
	
	public void guardarResultados(ArrayList<Resultados> resultados) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Resultados.dat"))) {
            oos.writeObject(resultados);
            oos.flush();
        } catch (IOException e) {
            System.out.println("Error guardando el fichero Resultados.dat");
            e.printStackTrace();
        }
    }
	
}
