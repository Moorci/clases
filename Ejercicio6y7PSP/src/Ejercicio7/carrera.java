package Ejercicio7;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class carrera extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					carrera frame = new carrera();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public carrera() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCaballoGanador = new JLabel("Caballo ganador: 0");
		lblCaballoGanador.setBounds(156, 12, 227, 17);
		contentPane.add(lblCaballoGanador);
		
		JLabel lblNewLabel_1 = new JLabel("Caballo: 1");
		lblNewLabel_1.setBounds(36, 83, 60, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Caballo: 2");
		lblNewLabel_1_1.setBounds(36, 112, 60, 17);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Caballo: 3");
		lblNewLabel_1_1_1.setBounds(36, 141, 60, 17);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Caballo: 4");
		lblNewLabel_1_1_2.setBounds(36, 170, 60, 17);
		contentPane.add(lblNewLabel_1_1_2);
		
		JProgressBar progressBarCaballo1 = new JProgressBar();
		progressBarCaballo1.setBounds(144, 83, 148, 14);
		contentPane.add(progressBarCaballo1);
		
		JProgressBar progressBarCaballo2 = new JProgressBar();
		progressBarCaballo2.setBounds(144, 115, 148, 14);
		contentPane.add(progressBarCaballo2);
		
		JProgressBar progressBarCaballo3 = new JProgressBar();
		progressBarCaballo3.setBounds(144, 141, 148, 14);
		contentPane.add(progressBarCaballo3);
		
		JProgressBar progressBarCaballo4 = new JProgressBar();
		progressBarCaballo4.setBounds(144, 170, 148, 14);
		contentPane.add(progressBarCaballo4);
		
		JButton btnEmpezarCarrera = new JButton("Empezar");
		btnEmpezarCarrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Establecemos los valores de los jprogressbar a 0
				progressBarCaballo1.setValue(0);
				progressBarCaballo2.setValue(0);
				progressBarCaballo3.setValue(0);
				progressBarCaballo4.setValue(0);
				HiloCaballo.hayganador = false;
				
				HiloCaballo caballo1 = new HiloCaballo(progressBarCaballo1, "1", lblCaballoGanador);
				HiloCaballo caballo2 = new HiloCaballo(progressBarCaballo2, "2", lblCaballoGanador);
				HiloCaballo caballo3 = new HiloCaballo(progressBarCaballo3, "3", lblCaballoGanador);
				HiloCaballo caballo4 = new HiloCaballo(progressBarCaballo4, "4", lblCaballoGanador);
				
				caballo1.start();
				caballo2.start();
				caballo3.start();
				caballo4.start();
			}
		});
		btnEmpezarCarrera.setBounds(156, 220, 105, 27);
		contentPane.add(btnEmpezarCarrera);

	}
}
