package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

import controlador.Controlador;
import modelo.Municipios;

import java.util.List;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameMunicipios extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableMunicipios;

    public FrameMunicipios(String provincia, Controlador ctr) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 797, 473);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Modelo de la tabla
        DefaultTableModel model = new DefaultTableModel(
            new Object[][] {},
            new String[] { "Nombre" }
        );

        tableMunicipios = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(tableMunicipios);
        scrollPane.setBounds(165, 80, 463, 269);
        contentPane.add(scrollPane);

        List<Municipios> municipios = ctr.cargarMunicipios(provincia);
        for (Municipios m : municipios) {
            model.addRow(new Object[] { m.getNombre() });
        }

        JButton btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		int selectedRow = tableMunicipios.getSelectedRow();
				if (selectedRow != -1) {
					String municipioNombre = (String) tableMunicipios.getValueAt(selectedRow, 0);
					FrameDatosMuni frameDatos = new FrameDatosMuni(municipioNombre, ctr);
					frameDatos.setVisible(true);
					dispose();
				}
        	}
        });
        btnSeleccionar.setBounds(408, 379, 89, 23);
        contentPane.add(btnSeleccionar);
        
        JLabel lblNewLabel = new JLabel("Selecciona un municipio");
        lblNewLabel.setBounds(345, 33, 129, 14);
        contentPane.add(lblNewLabel);
        
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		FramePrincipal framePrincipal = new FramePrincipal();
				framePrincipal.setVisible(true);
				dispose();
        	}
        });
        btnVolver.setBounds(309, 379, 89, 23);
        contentPane.add(btnVolver);
    }
}