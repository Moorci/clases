package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

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
		gestorResultado gestor = new gestorResultado();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 430);
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
		txtFecha.setText("yyyy-MM-DD");
		txtFecha.setColumns(10);
		txtFecha.setBounds(119, 151, 99, 20);
		contentPane.add(txtFecha);
		
		JButton btnAñadir = new JButton("Añadir");
		btnAñadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadirResultado(gestor);
				actualizarTabla(gestor.resultados);
			}
		});
		btnAñadir.setBounds(20, 193, 89, 23);
		contentPane.add(btnAñadir);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestor.cargarResultados();
				actualizarTabla(gestor.resultados);
			}
		});
		btnCargar.setBounds(119, 193, 89, 23);
		contentPane.add(btnCargar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestor.guardarResultados(gestor.resultados);
			}
		});
		btnGuardar.setBounds(218, 193, 89, 23);
		contentPane.add(btnGuardar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 242, 571, 138);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
	}
	public void añadirResultado(gestorResultado gestor) {
		String fechaTexto = txtFecha.getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Resultados resultado = new Resultados();
		resultado.setNombreLocal(txtEquipoLocal.getText());
		resultado.setNombreVisit(txtEquipoVisitante.getText());
		resultado.setGolesLocal((Integer.parseInt(txtGolesLocales.getText())));
		resultado.setGolesVisit(Integer.parseInt(txtGolesVisitante.getText()));
		resultado.setLugar(txtLugar.getText());
        try {
            Date fecha = sdf.parse(fechaTexto);
            resultado.setFecha(fecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
		gestor.añadirResultado(resultado);
	}
	
	public void actualizarTabla(ArrayList<Resultados> listaResultados) {
	    String[] columnas = {"Local", "Visitante", "Goles Local", "Goles Visitante", "Lugar", "Fecha"};
	    DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	    for (Resultados res : listaResultados) {
	        Object[] fila = {
	            res.getNombreLocal(),
	            res.getNombreVisit(),
	            res.getGolesLocal(),
	            res.getGolesVisit(),
	            res.getLugar(),
	            res.getFecha() != null ? sdf.format(res.getFecha()) : ""
	        };
	        modelo.addRow(fila);
	    }

	    table.setModel(modelo);
	}
	
	public void verificar() {
		String nomLocal = txtEquipoLocal.getText();
		String nomVisit = txtEquipoLocal.getText();
		String golLoc = txtGolesLocales.getText();
	}
}
