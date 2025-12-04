package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;

public class FrameMunicipios extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableMunicipios;

	/**
	 * Create the frame.
	 * @param provincia 
	 * @param ctr 
	 */
	public FrameMunicipios(String provincia, Controlador ctr) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tableMunicipios = new JTable();
		tableMunicipios.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre"
			}
		));
		tableMunicipios.setBounds(165, 80, 463, 269);
		contentPane.add(tableMunicipios);
		
		JButton btnSeleccionar = new JButton("New button");
		btnSeleccionar.setBounds(355, 379, 89, 23);
		contentPane.add(btnSeleccionar);
		
		
	}
}
