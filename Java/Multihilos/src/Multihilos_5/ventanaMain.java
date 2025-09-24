package Multihilos_5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ventanaMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblPrioridadHilo1;
	private JLabel lblPrioridadHilo2;
	private JLabel lblPrioridadHilo3;
	private JLabel lblContadorHilo1;
	private JLabel lblContadorHilo2;
	private JLabel lblContadorHilo3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaMain frame = new ventanaMain();
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
	public ventanaMain() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hilo 1");
		lblNewLabel.setBounds(191, 11, 34, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnMenosHilo1 = new JButton("--");
		btnMenosHilo1.addActionListener(new ActionListener() {
			int prioridad = Integer.parseInt(lblPrioridadHilo1.getText());
			public void actionPerformed(ActionEvent e) {
				lblPrioridadHilo1.setText(String.valueOf(prioridad--));
			}
		});
		btnMenosHilo1.setBounds(126, 7, 55, 23);
		contentPane.add(btnMenosHilo1);
		
		JButton btnMasHilo1 = new JButton("++");
		btnMasHilo1.addActionListener(new ActionListener() {
			int prioridad = Integer.parseInt(lblPrioridadHilo1.getText());
			public void actionPerformed(ActionEvent e) {
				lblPrioridadHilo1.setText(String.valueOf(prioridad++));
			}
		});
		btnMasHilo1.setBounds(230, 7, 55, 23);
		contentPane.add(btnMasHilo1);
		
		JLabel lblHilo = new JLabel("Hilo 2");
		lblHilo.setBounds(191, 45, 34, 14);
		contentPane.add(lblHilo);
		
		JButton btnMenosHilo2 = new JButton("--");
		btnMenosHilo2.addActionListener(new ActionListener() {
			int prioridad = Integer.parseInt(lblPrioridadHilo2.getText());
			public void actionPerformed(ActionEvent e) {
				lblPrioridadHilo2.setText(String.valueOf(prioridad--));
			}
		});
		btnMenosHilo2.setBounds(126, 41, 55, 23);
		contentPane.add(btnMenosHilo2);
		
		JButton btnMasHilo2 = new JButton("++");
		btnMasHilo2.addActionListener(new ActionListener() {
			int prioridad = Integer.parseInt(lblPrioridadHilo2.getText());
			public void actionPerformed(ActionEvent e) {
				lblPrioridadHilo2.setText(String.valueOf(prioridad++));
			}
		});
		btnMasHilo2.setBounds(230, 41, 55, 23);
		contentPane.add(btnMasHilo2);
		
		JLabel lblHilo_2 = new JLabel("Hilo 3");
		lblHilo_2.setBounds(191, 76, 34, 14);
		contentPane.add(lblHilo_2);
		
		JButton btnMenosHilo3 = new JButton("--");
		btnMenosHilo3.addActionListener(new ActionListener() {
			int prioridad = Integer.parseInt(lblPrioridadHilo3.getText());
			public void actionPerformed(ActionEvent e) {
				lblPrioridadHilo3.setText(String.valueOf(prioridad++));
			}
		});
		btnMenosHilo3.setBounds(126, 72, 55, 23);
		contentPane.add(btnMenosHilo3);
		
		JButton btnMasHilo3 = new JButton("++");
		btnMasHilo3.addActionListener(new ActionListener() {
			int prioridad = Integer.parseInt(lblPrioridadHilo3.getText());
			public void actionPerformed(ActionEvent e) {
				lblPrioridadHilo3.setText(String.valueOf(prioridad++));
			}
		});
		btnMasHilo3.setBounds(230, 72, 55, 23);
		contentPane.add(btnMasHilo3);
		
		lblContadorHilo1 = new JLabel("0");
		lblContadorHilo1.setBounds(168, 124, 44, 14);
		contentPane.add(lblContadorHilo1);
		
		lblContadorHilo2 = new JLabel("0");
		lblContadorHilo2.setBounds(168, 149, 44, 14);
		contentPane.add(lblContadorHilo2);
		
		lblContadorHilo3 = new JLabel("0");
		lblContadorHilo3.setBounds(168, 174, 44, 14);
		contentPane.add(lblContadorHilo3);
		
		lblPrioridadHilo1 = new JLabel("0");
		lblPrioridadHilo1.setBounds(303, 124, 44, 14);
		contentPane.add(lblPrioridadHilo1);
		
		lblPrioridadHilo2 = new JLabel("0");
		lblPrioridadHilo2.setBounds(303, 149, 44, 14);
		contentPane.add(lblPrioridadHilo2);
		
		lblPrioridadHilo3 = new JLabel("0");
		lblPrioridadHilo3.setBounds(303, 174, 44, 14);
		contentPane.add(lblPrioridadHilo3);
		
		JLabel lblNewLabel_1 = new JLabel("Prioridad: ");
		lblNewLabel_1.setBounds(232, 124, 61, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prioridad: ");
		lblNewLabel_1_1.setBounds(230, 149, 61, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Prioridad: ");
		lblNewLabel_1_2.setBounds(230, 174, 61, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("Hilo1: ");
		lblNewLabel_2.setBounds(112, 124, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Hilo2: ");
		lblNewLabel_2_1.setBounds(112, 149, 46, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Hilo3: ");
		lblNewLabel_2_2.setBounds(112, 174, 46, 14);
		contentPane.add(lblNewLabel_2_2);

	}
	
}
