package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import modelo.Contacto;
import vista.Principal;


public class ControladorContacto implements ActionListener, ListSelectionListener {

	private vista.Principal vistaPrincipal;
	
	
	/*
	 * *** CONSTRUCTORES ***
	 */
	
	/*
	 * Contructor del objeto controlador
	 * @param vistaPrincipal Objeto vista.
	 */
	public ControladorContacto(vista.Principal vistaPrincipal) {
		this.vistaPrincipal = vistaPrincipal;
		
		this.inicializarControlador();
		
	}

	
	
	private void inicializarControlador() {


		// Acciones del men� izquierdo
		this.vistaPrincipal.getBtnConsultarContactos().addActionListener(this);
		this.vistaPrincipal.getBtnConsultarContactos()
				.setActionCommand(Principal.enumAcciones.CARGAR_PANEL_CONSULTA.toString());

		this.vistaPrincipal.getBtnInsertarContacto().addActionListener(this);
		this.vistaPrincipal.getBtnInsertarContacto()
				.setActionCommand(Principal.enumAcciones.CARGAR_PANEL_INSERTAR.toString());

		this.vistaPrincipal.getBtnModificarContacto().addActionListener(this);
		this.vistaPrincipal.getBtnModificarContacto()
				.setActionCommand(Principal.enumAcciones.CARGAR_PANEL_MODIFICAR.toString());
		
		this.vistaPrincipal.getBtnEliminarContacto().addActionListener(this);
		this.vistaPrincipal.getBtnEliminarContacto()
				.setActionCommand(Principal.enumAcciones.CARGAR_PANEL_ELIMINAR.toString());
		
		this.vistaPrincipal.getPanelInsertar().getBtnAñadir().addActionListener(this);
		this.vistaPrincipal.getPanelInsertar().getBtnAñadir().setActionCommand(Principal.enumAcciones.INSERTAR_CONTACTO.toString());

		
		// Acciones del panel Insertar
	

		// Acciones del panel Modificar
	
		//Acciones del panel Eliminar
}


	
	/*** Tratamiento de las acciones ***/
	
	@Override
	public void actionPerformed(ActionEvent e) {

		Principal.enumAcciones accion = Principal.enumAcciones.valueOf(e.getActionCommand());

		switch (accion) {
			case CARGAR_PANEL_CONSULTA:
				this.vistaPrincipal.mVisualizarPaneles(Principal.enumAcciones.CARGAR_PANEL_CONSULTA);
				this.mCargarContactos(accion);
				break;
			case CARGAR_PANEL_INSERTAR:
				this.vistaPrincipal.mVisualizarPaneles(Principal.enumAcciones.CARGAR_PANEL_INSERTAR);
				this.mCargarContactos(accion);
				break;
			case CARGAR_PANEL_MODIFICAR:
				this.vistaPrincipal.mVisualizarPaneles(Principal.enumAcciones.CARGAR_PANEL_MODIFICAR);
				this.mCargarContactos(accion);
				break;
			case CARGAR_PANEL_ELIMINAR:
				this.vistaPrincipal.mVisualizarPaneles(Principal.enumAcciones.CARGAR_PANEL_ELIMINAR);
				this.mCargarContactos(accion);
				break;
			case INSERTAR_CONTACTO:
			    mInsertarNuevoContacto();
			    break;
			default:
				break;
				
		}
	}

	

	
	
	/*** Llamados a m�todos CRUD ***/
	
	

	
	/*** Otros metodos ***/
	

	private void mCargarContactos(Principal.enumAcciones accion) {

		Contacto contactos = new Contacto();
		
		
		mLimpiarTabla(accion);

		ArrayList<Contacto> listaContactos = contactos.mObtenerContactos();

		String matrizInfo[][] = new String[listaContactos.size()][4];

		for (int i = 0; i < listaContactos.size(); i++) {
			matrizInfo[i][0] = listaContactos.get(i).getIdContacto();
			matrizInfo[i][1] = listaContactos.get(i).getNombre();
			matrizInfo[i][2] = String.valueOf(listaContactos.get(i).getTelefono());
			matrizInfo[i][3] = listaContactos.get(i).getEmail();

			switch (accion) {
			case CARGAR_PANEL_CONSULTA:
				this.vistaPrincipal.getPanelConsultar().getDefaultTableModel().addRow(matrizInfo[i]);
				break;
			case CARGAR_PANEL_INSERTAR:
				this.vistaPrincipal.getPanelInsertar().getDefaultTableModel().addRow(matrizInfo[i]);
				break;
				
			default:
				break;
			
			}
		}

	}
	
	private void mInsertarNuevoContacto() {
	    String nombre = vistaPrincipal.getPanelInsertar().getTxtNombre().getText();
	    String telefonoStr = vistaPrincipal.getPanelInsertar().getTxtTelefono().getText();
	    String email = vistaPrincipal.getPanelInsertar().getTxtEmail().getText();

	    try {
	        double telefono = Double.parseDouble(telefonoStr);
	        Contacto nuevo = new Contacto(nombre, telefono, email);
	        if (nuevo.mInsertarContacto()) {
	            System.out.println("Contacto insertado correctamente.");
	            mCargarContactos(Principal.enumAcciones.CARGAR_PANEL_INSERTAR);
	            limpiarCamposInsertar();
	        } else {
	            System.out.println("Error al insertar el contacto.");
	        }
	    } catch (NumberFormatException e) {
	        System.out.println("Teléfono inválido.");
	    }
	}
	
	private void limpiarCamposInsertar() {
	    vistaPrincipal.getPanelInsertar().getTxtNombre().setText("");
	    vistaPrincipal.getPanelInsertar().getTxtTelefono().setText("");
	    vistaPrincipal.getPanelInsertar().getTxtEmail().setText("");
	}

	private void mLimpiarTabla(Principal.enumAcciones accion) {

		switch (accion) {
		case CARGAR_PANEL_CONSULTA:
			if (this.vistaPrincipal.getPanelConsultar().getDefaultTableModel().getRowCount() > 0) {
				this.vistaPrincipal.getPanelConsultar().getDefaultTableModel().setRowCount(0);
			}
			break;
			
		case CARGAR_PANEL_INSERTAR:
			if (this.vistaPrincipal.getPanelInsertar().getDefaultTableModel().getRowCount() > 0) {
				this.vistaPrincipal.getPanelInsertar().getDefaultTableModel().setRowCount(0);
			}
            break;

		default:
			break;
		}
		
	}

		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Cambiar valor");
		}



}



