package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Controlador;
import modelo.Provincias;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FramePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal frame = new FramePrincipal();
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
	public FramePrincipal() {
		Controlador ctr = new Controlador();
		ctr.cargarProvincias();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(259, 195, 277, 22);
		contentPane.add(comboBox);
		
		for (Provincias provincia : ctr.provinciasList) {
			comboBox.addItem(provincia.getNombre());
		}
		
		JButton btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String provincia = (String) comboBox.getSelectedItem();
				FrameMunicipios frame = new FrameMunicipios(provincia, ctr);
				frame.setVisible(true);
				dispose();
			}
		});
		btnSeleccionar.setBounds(331, 414, 144, 23);
		contentPane.add(btnSeleccionar);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.removeAllItems();
				ctr.incluir();
				ctr.cargarProvincias();
				for (Provincias provincia : ctr.provinciasList) {
					comboBox.addItem(provincia.getNombre());
				}
			}
		});
		btnIncluir.setBounds(10, 11, 89, 23);
		contentPane.add(btnIncluir);

	}
}
