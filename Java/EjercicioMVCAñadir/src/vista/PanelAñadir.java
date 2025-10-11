package vista;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.JButton;

public class PanelAñadir extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtEmail;

	private JTable tablaContactos;
	private DefaultTableModel defaultTableModel;
	private JButton btnAñadir;
	/**
	 * Create the panel.
	 */
	public PanelAñadir() {
		setLayout(null);
		
		setBackground(Color.orange);
		setBounds(288, 11, 688, 541);
		setLayout(null);

		
		
		JScrollPane jScrollPanel;
		jScrollPanel = new JScrollPane();
		jScrollPanel.setBounds(40, 150, 508, 267);
		add(jScrollPanel);
		
		

		String columnas[] = { "Id", "Nombre", "Teléfono", "E-mail" };

		defaultTableModel = new DefaultTableModel(columnas, 0);

		 tablaContactos = new JTable(defaultTableModel);
		tablaContactos.setAutoCreateRowSorter(true);
		tablaContactos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaContactos.setRowSelectionAllowed(false);
		tablaContactos.setCellSelectionEnabled(false);

		
		tablaContactos.setDefaultEditor(Object.class, null); //Anulamos la edici�n en la propia celda


		jScrollPanel.setViewportView(tablaContactos);
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(32, 31, 77, 14);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(125, 28, 322, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(32, 73, 77, 14);
		add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(125, 70, 101, 20);
		add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(251, 73, 46, 14);
		add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(291, 70, 156, 20);
		add(txtEmail);
		txtEmail.setColumns(10);
		
		btnAñadir = new JButton("Añadir");
		btnAñadir.setBounds(208, 101, 89, 23);
		add(btnAñadir);

	}
	
	
	
	public JButton getBtnAñadir() {
		return btnAñadir;
	}



	public void setBtnAñadir(JButton btnAñadir) {
		this.btnAñadir = btnAñadir;
	}



	public JTextField getTxtNombre() {
		return txtNombre;
	}



	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}



	public JTextField getTxtTelefono() {
		return txtTelefono;
	}



	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}



	public JTextField getTxtEmail() {
		return txtEmail;
	}



	public void setTxtEmail(JTextField txtEmail) {
		this.txtEmail = txtEmail;
	}



	public DefaultTableModel getDefaultTableModel() {
		return defaultTableModel;
	}
	public void setDefaultTableModel(DefaultTableModel defaultTableModel) {
		this.defaultTableModel = defaultTableModel;
	}

	
}
