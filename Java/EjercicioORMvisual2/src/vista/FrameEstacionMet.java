package vista;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.MedicionesCentroMet;
import modelo.MedicionesCentroMetId;

public class FrameEstacionMet extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;

    public FrameEstacionMet(List<MedicionesCentroMet> medicion, List<MedicionesCentroMetId> idMedicion) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 913, 490);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        String[] columnas = {
            "Fecha",
            "Hora",
            "ICA",
            "Dir Viento",
            "H Relativa",
            "P Atmos",
            "Precip",
            "Rad Solar",
            "Temp Am",
            "V Viento"
        };

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (int i = 0; i < medicion.size() && i < idMedicion.size(); i++) {
            MedicionesCentroMet m = medicion.get(i);
            MedicionesCentroMetId id = idMedicion.get(i);

            Object[] fila = {
                id.getFecha(),
                id.getHora(),
                m.getIca(),
                m.getDirViento(),
                m.getHRelativa(),
                m.getPAtmosferica(),
                m.getPrecip(),
                m.getRadSolar(),
                m.getTempAmbiente(),
                m.getVViento()
            };
            modelo.addRow(fila);
        }

        table = new JTable(modelo);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 880, 430);
        contentPane.add(scrollPane);
    }
}