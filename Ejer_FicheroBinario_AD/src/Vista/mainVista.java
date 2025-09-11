package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class mainVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEquipoLocal;
	private JTextField txtEquipoVisitante;
	private JTextField txtGolesLocales;
	private JTextField txtGolesVisitante;
	private JTextField txtLugar;
	private JTextField txtFecha;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainVista frame = new mainVista();
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
	public mainVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblequipoLocal = new JLabel("Equipo Local: ");
		lblequipoLocal.setBounds(10, 25, 99, 14);
		contentPane.add(lblequipoLocal);
		
		JLabel lblEquipoVisitante = new JLabel("Equipo Visitante: ");
		lblEquipoVisitante.setBounds(10, 50, 99, 14);
		contentPane.add(lblEquipoVisitante);
		
		JLabel lblGolesLocal = new JLabel("Goles Local: ");
		lblGolesLocal.setBounds(10, 79, 99, 14);
		contentPane.add(lblGolesLocal);
		
		JLabel lblGolesVisitante = new JLabel("Goles Visitante: ");
		lblGolesVisitante.setBounds(10, 104, 99, 14);
		contentPane.add(lblGolesVisitante);
		
		JLabel lblLugar = new JLabel("Lugar: ");
		lblLugar.setBounds(10, 129, 99, 14);
		contentPane.add(lblLugar);
		
		JLabel lblFecha = new JLabel("Fecha: ");
		lblFecha.setBounds(10, 154, 99, 14);
		contentPane.add(lblFecha);
		
		txtEquipoLocal = new JTextField();
		txtEquipoLocal.setBounds(119, 22, 205, 20);
		contentPane.add(txtEquipoLocal);
		txtEquipoLocal.setColumns(10);
		
		txtEquipoVisitante = new JTextField();
		txtEquipoVisitante.setColumns(10);
		txtEquipoVisitante.setBounds(119, 47, 205, 20);
		contentPane.add(txtEquipoVisitante);
		
		txtGolesLocales = new JTextField();
		txtGolesLocales.setColumns(10);
		txtGolesLocales.setBounds(119, 76, 64, 20);
		contentPane.add(txtGolesLocales);
		
		txtGolesVisitante = new JTextField();
		txtGolesVisitante.setColumns(10);
		txtGolesVisitante.setBounds(119, 101, 64, 20);
		contentPane.add(txtGolesVisitante);
		
		txtLugar = new JTextField();
		txtLugar.setColumns(10);
		txtLugar.setBounds(119, 126, 205, 20);
		contentPane.add(txtLugar);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(119, 151, 99, 20);
		contentPane.add(txtFecha);
		
		JButton btnAñadir = new JButton("Añadir");
		btnAñadir.setBounds(20, 193, 89, 23);
		contentPane.add(btnAñadir);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.setBounds(119, 193, 89, 23);
		contentPane.add(btnCargar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(218, 193, 89, 23);
		contentPane.add(btnGuardar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 242, 404, 138);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

	}
}
