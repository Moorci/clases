package Vista;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class gestorResultado {
	
	ArrayList <Resultados> resultados = new ArrayList<>();
	
	public void añadirResultado(Resultados r) {
		resultados.add(r);
	}
	
	public ArrayList<Resultados> cargarResultados() {
		
		try {
			RandomAccessFile file = new RandomAccessFile("Resultados.dat", "r");
			int golesLocal, golesVisitante;
			String equipoLocal, equipoVisitante, lugar, fecha;
			while(file.getFilePointer()<file.length()) {
				char[] equipoL = new char[20];
				for(int i=0;i<20;i++) {
					equipoL[i] = file.readChar();
				}
				equipoLocal = new String(equipoL).trim();
				
				char[] equipoV = new char[20];
				for(int i=0;i<20;i++) {
					equipoV[i] = file.readChar();
				}
				equipoVisitante = new String(equipoV).trim();
				
				golesLocal = file.readInt();
				golesVisitante = file.readInt();
				
				char[] lugarC = new char[20];
				for(int i=0;i<20;i++) {
					lugarC[i] = file.readChar();
				}
				lugar = new String(lugarC).trim();
				
				char[] fechaC = new char[10];
				for(int i=0;i<10;i++) {
					fechaC[i] = file.readChar();
				}
				fecha = new String(fechaC).trim();
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate fechaLD = LocalDate.parse(fecha, formatter);
				
				Resultados r = new Resultados(equipoLocal, equipoVisitante, golesLocal, golesVisitante, lugar, fechaLD);
				resultados.add(r);
			}
			file.close();
			return resultados;
			
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return resultados;
		
	}

        /*try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Resultados.dat"))) {
            resultados = (ArrayList<Resultados>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            resultados = new ArrayList<>(); // si falla la carga, devolver lista vacía
        }

        return resultados;*/

	
	public void guardarResultados(ArrayList<Resultados> resultados) {
        /*try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Resultados.dat"))) {
            oos.writeObject(resultados);
            oos.flush();
        } catch (IOException e) {
            System.out.println("Error guardando el fichero Resultados.dat");
            e.printStackTrace();
        }*/
		
		File fichero = new File("Resultados.dat");
		try {
			RandomAccessFile file = new RandomAccessFile(fichero, "rw");
			StringBuffer buffer = null;

			file.seek(0);
			for (Resultados r : resultados) {
				buffer = new StringBuffer(r.getNombreLocal());
				buffer.setLength(20);
				file.writeChars(buffer.toString());
				buffer = new StringBuffer(r.getNombreVisit());
				buffer.setLength(20);
				file.writeChars(buffer.toString());
				file.writeInt(r.getGolesLocal());
				file.writeInt(r.getGolesVisit());
				buffer = new StringBuffer(r.getLugar());
				buffer.setLength(20);
				file.writeChars(buffer.toString());
				String fechaStr = r.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				buffer = new StringBuffer(fechaStr);
				buffer.setLength(10);
				file.writeChars(buffer.toString());
			}
			file.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }
	
}
