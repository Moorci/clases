package Ejercicio7;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cheatFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPrioridadCaballo1;
	private JTextField txtPrioridadCaballo2;
	private JTextField txtPrioridadCaballo3;
	private JTextField txtPrioridadCaballo4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cheatFrame frame = new cheatFrame();
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
	public cheatFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Caballo 1:");
		lblNewLabel.setBounds(38, 71, 79, 17);
		contentPane.add(lblNewLabel);
		
		txtPrioridadCaballo1 = new JTextField();
		txtPrioridadCaballo1.setText("6");
		txtPrioridadCaballo1.setBounds(135, 69, 114, 21);
		contentPane.add(txtPrioridadCaballo1);
		txtPrioridadCaballo1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Caballo 2:");
		lblNewLabel_1.setBounds(38, 107, 60, 17);
		contentPane.add(lblNewLabel_1);
		
		txtPrioridadCaballo2 = new JTextField();
		txtPrioridadCaballo2.setText("6");
		txtPrioridadCaballo2.setBounds(135, 105, 114, 21);
		contentPane.add(txtPrioridadCaballo2);
		txtPrioridadCaballo2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Caballo 3:");
		lblNewLabel_2.setBounds(38, 150, 60, 17);
		contentPane.add(lblNewLabel_2);
		
		txtPrioridadCaballo3 = new JTextField();
		txtPrioridadCaballo3.setText("6");
		txtPrioridadCaballo3.setBounds(135, 148, 114, 21);
		contentPane.add(txtPrioridadCaballo3);
		txtPrioridadCaballo3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Caballo 4");
		lblNewLabel_3.setBounds(38, 192, 60, 17);
		contentPane.add(lblNewLabel_3);
		
		txtPrioridadCaballo4 = new JTextField();
		txtPrioridadCaballo4.setText("6");
		txtPrioridadCaballo4.setBounds(135, 190, 114, 21);
		contentPane.add(txtPrioridadCaballo4);
		txtPrioridadCaballo4.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            int priCaballo1 = Integer.parseInt(txtPrioridadCaballo1.getText());
		            int priCaballo2 = Integer.parseInt(txtPrioridadCaballo2.getText());
		            int priCaballo3 = Integer.parseInt(txtPrioridadCaballo3.getText());
		            int priCaballo4 = Integer.parseInt(txtPrioridadCaballo4.getText());

		            carrera frame = new carrera(priCaballo1, priCaballo2, priCaballo3, priCaballo4);
		            frame.setVisible(true);
		            
		            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		            dispose();
		        } catch (NumberFormatException ex) {
		            System.out.println("Debes ingresar números válidos.");
		        }
			}
		});
		btnGuardar.setBounds(135, 224, 105, 27);
		contentPane.add(btnGuardar);

	}
}
