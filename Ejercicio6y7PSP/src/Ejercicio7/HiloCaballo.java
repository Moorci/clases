package Ejercicio7;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class HiloCaballo extends Thread{
	
	private JProgressBar barra;
    private String nombreCaballo;
    private JLabel ganador;
    private boolean corriendo = true;
    static boolean hayganador = false;
    
	public HiloCaballo (JProgressBar barra, String nombreCaballo, JLabel ganador) {
		this.barra = barra;
		this.nombreCaballo = nombreCaballo;
		this.ganador = ganador;
	}
	
	public void terminar () {
		corriendo = false;
	}
	
	@Override
	public void run() {
		while(corriendo && barra.getValue() < 100 && !hayganador) {
			int progreso = (int) (Math.random()*11);
			int nuevoValor = barra.getValue() + progreso;
			barra.setValue(Math.min(nuevoValor, 100)); // para no pasarse de 100
			if (barra.getValue() >= 100) {
	            synchronized (HiloCaballo.class) {
	                if (!hayganador) {
	                    hayganador = true;
	                    ganador.setText("Ganador: " + nombreCaballo);
	                }
	            }
	        }try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
			
		}
	}

}
