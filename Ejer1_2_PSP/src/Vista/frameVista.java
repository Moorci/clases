package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class frameVista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameVista frame = new frameVista();
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
	public frameVista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(167, 30, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(325, 30, 86, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(471, 30, 86, 20);
		contentPane.add(textField_3);
		
		JButton btnStart_3 = new JButton("Start");
		btnStart_3.setBounds(471, 63, 89, 23);
		contentPane.add(btnStart_3);
		
		JLabel lblNewLabel = new JLabel("PID:");
		lblNewLabel.setBounds(36, 115, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPidPadre = new JLabel("PID padre:");
		lblPidPadre.setBounds(36, 143, 86, 14);
		contentPane.add(lblPidPadre);
		
		JLabel lblNewLabel_1 = new JLabel("Resultado");
		lblNewLabel_1.setBounds(36, 168, 72, 14);
		contentPane.add(lblNewLabel_1);
		
		JTextArea textArea2 = new JTextArea();
		textArea2.setBounds(457, 212, 149, 226);
		contentPane.add(textArea2);
		
		JLabel lblid = new JLabel("");
		lblid.setBounds(167, 115, 72, 14);
		contentPane.add(lblid);
		
		JLabel lblid_2 = new JLabel("");
		lblid_2.setBounds(325, 115, 86, 14);
		contentPane.add(lblid_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(298, 212, 149, 226);
		contentPane.add(scrollPane);
		
		JTextArea textArea1 = new JTextArea();
		scrollPane.setViewportView(textArea1);
		
		JLabel lblidParent_2 = new JLabel("");
		lblidParent_2.setBounds(325, 143, 72, 14);
		contentPane.add(lblidParent_2);
		
		JButton btnStart_2 = new JButton("Start");
		btnStart_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long id = 0;
				long IDparent = 0;
				String comando = textField_2.getText();
				ProcessBuilder pb = new ProcessBuilder("cmd","/C",comando);
				try {
				Process proces = pb.start();
				id = proces.pid();
				ProcessHandle ph = proces.toHandle();
				IDparent = ph.parent().get().pid();
				InputStream is = proces.getInputStream();
				BufferedReader bis = new BufferedReader(new InputStreamReader(is));
				String linea = "";
					while((linea = bis.readLine()) != null) {
						textArea1.append(linea + "\n");
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				lblid_2.setText(id+"");
				lblidParent_2.setText(IDparent+"");
			}
		});
		btnStart_2.setBounds(322, 63, 89, 23);
		contentPane.add(btnStart_2);
		
		JLabel lblidParent = new JLabel("");
		lblidParent.setBounds(167, 143, 72, 14);
		contentPane.add(lblidParent);
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long id = 0;
				long IDparent = 0;
				String nombrePrograma = textField_1.getText();
				ProcessBuilder pb = new ProcessBuilder(nombrePrograma);
				
				try {
					Process proces = pb.start();;
					ProcessHandle ph = proces.toHandle();
					id = proces.pid();
					IDparent = ph.parent().get().pid();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				lblid.setText(id+"");
				lblidParent.setText(IDparent+"");
			}
		});
		btnStart.setBounds(164, 63, 89, 23);
		contentPane.add(btnStart);
		
		
	}
}
