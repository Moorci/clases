package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.controladorMensajes;
import Modelo.mensaje;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame frame = new frame();
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
	public frame() {
		controladorMensajes ctr = new controladorMensajes();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCargarmsg = new JButton("Cargar Mensajes");
		btnCargarmsg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctr.leerMensajesDesdeFichero();
				int numeroDeMensajes = ctr.contadorMensajes();
				javax.swing.JOptionPane.showMessageDialog(contentPane, "Se han cargado " + numeroDeMensajes + " mensajes correctamente.");
			}
		});
		btnCargarmsg.setBounds(46, 47, 142, 23);
		contentPane.add(btnCargarmsg);
		
		JButton btnGuardarmsg = new JButton("Guardar mensajes");
		btnGuardarmsg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctr.guardarMensajesEnFichero();
			}
		});
		btnGuardarmsg.setBounds(261, 47, 148, 23);
		contentPane.add(btnGuardarmsg);
		
		JButton btnImprimirmsg = new JButton("Imprimir mensajes");
		btnImprimirmsg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame3 ventana = new frame3(ctr);
				ventana.setVisible(true);
			}
		});
		btnImprimirmsg.setBounds(261, 81, 148, 23);
		contentPane.add(btnImprimirmsg);
		
		JButton btnAñadirmsg = new JButton("Añadir mensajes");
		btnAñadirmsg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame2 ventana = new frame2(ctr);
				ventana.setVisible(true);
			}
		});
		btnAñadirmsg.setBounds(46, 147, 148, 23);
		contentPane.add(btnAñadirmsg);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(335, 227, 89, 23);
		contentPane.add(btnSalir);

	}
}
