package Multihilos_5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
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
		
		HiloContador hilo1 = new HiloContador(0);
		HiloContador hilo2 = new HiloContador(0);
		HiloContador hilo3 = new HiloContador(0);
		
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
		JButton btnMenosHilo1 = new JButton("--");
		btnMenosHilo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo1.setPriority(1);
				lblPrioridadHilo1.setText("Pri: " + hilo1.getPriority());
			}
		});
		btnMenosHilo1.setBounds(100, 7, 55, 23);
		contentPane.add(btnMenosHilo1);
		
		JButton btnMasHilo1 = new JButton("++");
		btnMasHilo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo1.setPriority(10);
				lblPrioridadHilo1.setText("Pri: " + hilo1.getPriority());
			}
		});
		btnMasHilo1.setBounds(260, 7, 55, 23);
		contentPane.add(btnMasHilo1);
		
		JButton btnMenosHilo2 = new JButton("--");
		btnMenosHilo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo2.setPriority(1);
				lblPrioridadHilo2.setText("Pri: " + hilo2.getPriority());
			}
		});
		btnMenosHilo2.setBounds(100, 41, 55, 23);
		contentPane.add(btnMenosHilo2);
		
		JButton btnMasHilo2 = new JButton("++");
		btnMasHilo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo2.setPriority(10);
				lblPrioridadHilo2.setText("Pri: " + hilo2.getPriority());
			}
		});
		btnMasHilo2.setBounds(260, 41, 55, 23);
		contentPane.add(btnMasHilo2);
		
		JButton btnMenosHilo3 = new JButton("--");
		btnMenosHilo3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo3.setPriority(1);
				lblPrioridadHilo3.setText("Pri: " + hilo3.getPriority());
			}
		});
		btnMenosHilo3.setBounds(100, 72, 55, 23);
		contentPane.add(btnMenosHilo3);
		
		JButton btnMasHilo3 = new JButton("++");
		btnMasHilo3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo3.setPriority(10);
				lblPrioridadHilo3.setText("Pri: " + hilo3.getPriority());
			}
		});
		btnMasHilo3.setBounds(260, 75, 55, 23);
		contentPane.add(btnMasHilo3);
		
		lblContadorHilo1 = new JLabel("Hilo1: 0");
		lblContadorHilo1.setBounds(100, 156, 94, 14);
		contentPane.add(lblContadorHilo1);
		
		lblContadorHilo2 = new JLabel("Hilo2: 0");
		lblContadorHilo2.setBounds(100, 181, 94, 14);
		contentPane.add(lblContadorHilo2);
		
		lblContadorHilo3 = new JLabel("Hilo3: 0");
		lblContadorHilo3.setBounds(100, 206, 94, 14);
		contentPane.add(lblContadorHilo3);
		
		lblPrioridadHilo1 = new JLabel("Pri: 0");
		lblPrioridadHilo1.setBounds(277, 156, 44, 14);
		contentPane.add(lblPrioridadHilo1);
		
		lblPrioridadHilo2 = new JLabel("Pri: 0");
		lblPrioridadHilo2.setBounds(277, 181, 44, 14);
		contentPane.add(lblPrioridadHilo2);
		
		lblPrioridadHilo3 = new JLabel("Pri: 0");
		lblPrioridadHilo3.setBounds(277, 206, 44, 14);
		contentPane.add(lblPrioridadHilo3);
		
		JButton btnFinHilo1 = new JButton("Fin Hilo 1");
		btnFinHilo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo1.detener();
			}
		});
		btnFinHilo1.setBounds(161, 7, 89, 23);
		contentPane.add(btnFinHilo1);
		
		JButton btnFinHilo2 = new JButton("Fin Hilo 2");
		btnFinHilo2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo2.detener();
			}
		});
		btnFinHilo2.setBounds(161, 41, 89, 23);
		contentPane.add(btnFinHilo2);
		
		JButton btnNewButton = new JButton("Fin Hilo 3");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo3.detener();
			}
		});
		btnNewButton.setBounds(161, 72, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnFinTodos = new JButton("Finalizar Todos");
		btnFinTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hilo1.detener();
				hilo2.detener();
				hilo3.detener();
			}
		});
		btnFinTodos.setBounds(100, 106, 215, 23);
		contentPane.add(btnFinTodos);
		
		Timer timer = new Timer(200, e -> {
			lblContadorHilo1.setText("Hilo1: " + hilo1.getContador());
			lblContadorHilo2.setText("Hilo2: " + hilo2.getContador());
			lblContadorHilo3.setText("Hilo3: " + hilo3.getContador());
		});
		timer.start();

	}

}
