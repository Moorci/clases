package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.controladorMensajes;
import Modelo.mensaje;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.Date;
import java.awt.event.ActionEvent;

public class frame2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField añoFecha;
	private JTextField txtremitente;
	private JTextField txtreceptor;
	private JTextField txtasunto;
	/**
	 * Create the frame.
	 */
	public frame2(controladorMensajes ctr) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fecha");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		añoFecha = new JTextField();
		añoFecha.setBounds(65, 8, 46, 20);
		contentPane.add(añoFecha);
		añoFecha.setColumns(10);
		
		JComboBox mesFecha = new JComboBox();
		mesFecha.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		mesFecha.setBounds(155, 7, 122, 22);
		contentPane.add(mesFecha);
		
		JComboBox diaFecha = new JComboBox();
		diaFecha.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		diaFecha.setBounds(333, 7, 71, 22);
		contentPane.add(diaFecha);
		
		JLabel lblNewLabel_1 = new JLabel("Hora");
		lblNewLabel_1.setBounds(10, 56, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox horaHora = new JComboBox();
		horaHora.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "00"}));
		horaHora.setBounds(70, 52, 56, 22);
		contentPane.add(horaHora);
		
		JComboBox minutoHora = new JComboBox();
		minutoHora.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"}));
		minutoHora.setBounds(136, 52, 56, 22);
		contentPane.add(minutoHora);
		
		JLabel lblNewLabel_2 = new JLabel(":");
		lblNewLabel_2.setBounds(130, 56, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("De :");
		lblNewLabel_3.setBounds(10, 96, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtremitente = new JTextField();
		txtremitente.setBounds(65, 93, 173, 20);
		contentPane.add(txtremitente);
		txtremitente.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Para :");
		lblNewLabel_4.setBounds(10, 121, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		txtreceptor = new JTextField();
		txtreceptor.setBounds(65, 118, 173, 20);
		contentPane.add(txtreceptor);
		txtreceptor.setColumns(10);
		
		JLabel lblNewLabel_4_1 = new JLabel("Asunto :");
		lblNewLabel_4_1.setBounds(10, 146, 46, 14);
		contentPane.add(lblNewLabel_4_1);
		
		txtasunto = new JTextField();
		txtasunto.setColumns(10);
		txtasunto.setBounds(65, 143, 173, 20);
		contentPane.add(txtasunto);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Contenido :");
		lblNewLabel_4_1_1.setBounds(10, 171, 64, 14);
		contentPane.add(lblNewLabel_4_1_1);
		
		JTextArea txtcontenido = new JTextArea();
		txtcontenido.setBounds(75, 174, 163, 46);
		contentPane.add(txtcontenido);
		
		JButton btnConfirmar = new JButton("OK");
		btnConfirmar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		        	// Validar campos de texto
		            if (añoFecha.getText().trim().isEmpty() ||
		                txtremitente.getText().trim().isEmpty() ||
		                txtreceptor.getText().trim().isEmpty() ||
		                txtasunto.getText().trim().isEmpty() ||
		                txtcontenido.getText().trim().isEmpty()) {

		                javax.swing.JOptionPane.showMessageDialog(
		                    contentPane,
		                    "Por favor, complete todos los campos antes de guardar."
		                );
		                return;
		            }

		            // Validar selección de combos
		            if (diaFecha.getSelectedItem() == null ||
		                mesFecha.getSelectedItem() == null ||
		                horaHora.getSelectedItem() == null ||
		                minutoHora.getSelectedItem() == null) {

		                javax.swing.JOptionPane.showMessageDialog(
		                    contentPane,
		                    "Por favor, seleccione día, mes, hora y minutos."
		                );
		                return;
		            }
		        	
		            int dia = Integer.parseInt((String) diaFecha.getSelectedItem());
		            int mes = mesFecha.getSelectedIndex() + 1; // Enero = 0
		            int año = Integer.parseInt(añoFecha.getText());
		            int hora = Integer.parseInt((String) horaHora.getSelectedItem());
		            int minutos = Integer.parseInt((String) minutoHora.getSelectedItem());

		            java.time.LocalDate fechaIntroducida = java.time.LocalDate.of(año, mes, dia);
		            Date fecha = java.util.Date.from(fechaIntroducida.atStartOfDay(java.time.ZoneId.systemDefault()).toInstant());
		            LocalTime horaIngresada = LocalTime.of(hora, minutos);

		            String remitente = txtremitente.getText();
		            String receptor = txtreceptor.getText();
		            String asunto = txtasunto.getText();
		            String contenido = txtcontenido.getText();

		            mensaje mensaje = new mensaje();
		            mensaje.setFecha(fecha);
		            mensaje.setHora(horaIngresada);
		            mensaje.setRemitente(remitente);
		            mensaje.setReceptor(receptor);
		            mensaje.setAsunto(asunto);
		            mensaje.setContenido(contenido);
		            
		            ctr.añadirMensaje(mensaje);

		            javax.swing.JOptionPane.showMessageDialog(contentPane, "El mensaje se ha guardado correctamente.");
		        } catch (Exception ex) {
		            javax.swing.JOptionPane.showMessageDialog(contentPane, "Error al guardar el mensaje: " + ex.getMessage());
		        }
		    }
		});

		btnConfirmar.setBounds(286, 227, 56, 23);
		contentPane.add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(345, 227, 79, 23);
		contentPane.add(btnCancelar);

	}
}
