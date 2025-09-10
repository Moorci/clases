package Controlador;

import java.util.ArrayList;
import Modelo.gestorMensajes;
import Modelo.mensaje;

public class controladorMensajes {

    private gestorMensajes gm;

    public controladorMensajes() {
        gm = new gestorMensajes();
    }

    public void añadirMensaje(mensaje m) {
        gm.añadirMensaje(m);
    }
    
    public int contadorMensajes() {
    	return gm.contadorMensajes();
    }

    public void leerMensajesDesdeFichero() {
        gm.leerMensajesDesdeFichero();
    }

    public ArrayList<mensaje> getMensajes() {
        return gm.getMensajes(); // devuelve la lista interna
    }
    public void guardarMensajesEnFichero() {
    	gm.guardarMensajesEnFichero();
    }
}
