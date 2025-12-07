package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.CentrosMeteorologicos;
import modelo.EspaciosNaturales; // suponiendo que tienes esta clase
import modelo.MedicionesCentroMet;
import modelo.MedicionesCentroMetId;

import java.util.List;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrameDatosMuni extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tableEstacionesMed;
    private JTable tableEspaciosNat;

    /**
     * Create the frame.
     * @param ctr
     * @param municipioNombre
     */
    public FrameDatosMuni(String municipioNombre, Controlador ctr) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 845, 484);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        DefaultTableModel modelEstaciones = new DefaultTableModel(
            new Object[][] {},
            new String[] { "Nombre Estación" }
        );
        tableEstacionesMed = new JTable(modelEstaciones);
        JScrollPane scrollPane = new JScrollPane(tableEstacionesMed);
        scrollPane.setBounds(51, 49, 240, 323);
        contentPane.add(scrollPane);

        DefaultTableModel modelEspacios = new DefaultTableModel(
            new Object[][] {},
            new String[] { "Nombre Espacio Natural" }
        );
        tableEspaciosNat = new JTable(modelEspacios);
        JScrollPane scrollPane_1 = new JScrollPane(tableEspaciosNat);
        scrollPane_1.setBounds(392, 60, 402, 316);
        contentPane.add(scrollPane_1);
        
        JButton btnNewButton = new JButton("Volver");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		FrameMunicipios frameMuni = new FrameMunicipios(ctr.obtenerProvinciaDeMunicipio(municipioNombre), ctr);
        		frameMuni.setVisible(true);
        		dispose();
        	}
        });
        btnNewButton.setBounds(276, 411, 89, 23);
        contentPane.add(btnNewButton);
        
        JButton btnSeleccionar = new JButton("Seleccionar Estacion Met");
        btnSeleccionar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String nombreEstacion = modelEstaciones.getValueAt(tableEstacionesMed.getSelectedRow(), 0).toString();
        		CentrosMeteorologicos estacion = ctr.obtenerEstacionMeteorologica(nombreEstacion);
        		List<MedicionesCentroMetId> idMedicion = ctr.obtenerMasDatosMedicion(estacion.getIdCentroMet());
        		List<MedicionesCentroMet> medicion = ctr.obtenerMedicionesCentroMet(estacion.getIdCentroMet());
        		FrameEstacionMet frame = new FrameEstacionMet(medicion, idMedicion);
        		frame.setVisible(true);
        		dispose();
        	}
        });
        btnSeleccionar.setBounds(375, 411, 161, 23);
        contentPane.add(btnSeleccionar);

        List<CentrosMeteorologicos> estaciones = ctr.cargarEstacionesMed(municipioNombre);
        for (CentrosMeteorologicos est : estaciones) {
            modelEstaciones.addRow(new Object[] { est.getNombre() });
        }

        List<EspaciosNaturales> espacios = ctr.cargarEspaciosNat(municipioNombre);
        for (EspaciosNaturales esp : espacios) {
            modelEspacios.addRow(new Object[] { esp.getNombre() });
        }
    }
}