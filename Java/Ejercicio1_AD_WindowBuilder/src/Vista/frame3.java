package Vista;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.controladorMensajes;
import Modelo.mensaje;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frame3 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    /**
     * Create the frame.
     */
    public frame3(controladorMensajes ctr) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Crear JScrollPane para la tabla
        javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane();
        scrollPane.setBounds(10, 11, 660, 283);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        ArrayList<mensaje> lista = ctr.getMensajes();

        // Crear modelo de tabla
        DefaultTableModel model = new DefaultTableModel(
            new String[] { "De", "Para", "Fecha", "Hora", "Asunto", "Contenido" },
            0
        );

        for (mensaje m : lista) {
            Object[] fila = {
                m.getRemitente(),
                m.getReceptor(),
                m.getFecha(),
                m.getHora(),
                m.getAsunto(),
                m.getContenido()
            };
            model.addRow(fila);
        }

        table.setModel(model);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnSalir.setBounds(581, 338, 89, 23);
        contentPane.add(btnSalir);
    }
}
