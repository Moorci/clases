package Ejercicio7;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class HiloCaballo extends Thread{
	
	private JProgressBar barra;
    private String nombreCaballo;
    private JLabel ganador;
    private boolean corriendo = true;
    static boolean hayganador = false;
    private int prioridad;
    
	public HiloCaballo (JProgressBar barra, String nombreCaballo, JLabel ganador, int prioridad) {
		this.barra = barra;
		this.nombreCaballo = nombreCaballo;
		this.ganador = ganador;
		this.prioridad = prioridad;
	}
	
	public void terminar () {
		corriendo = false;
	}
	
	@Override
	public void run() {
		while(corriendo && barra.getValue() < 100 && !hayganador) {
			int progreso = (int) (Math.random() * prioridad);
			int nuevoValor = barra.getValue() + progreso;
			barra.setValue(nuevoValor);
			if (barra.getValue() == 100) {
	            synchronized (HiloCaballo.class) {
	                if (!hayganador) {
	                    hayganador = true;
	                    ganador.setText("Ganador: " + nombreCaballo);
	                }
	            }
	        }try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
			
		}
	}

}
