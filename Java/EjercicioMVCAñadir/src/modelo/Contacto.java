package modelo;




import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import conexion.Conexion;

public class Contacto {
	
	//*** Atributos ***
	
	private String idContacto;
	private String nombre;
	private double telefono;
	private String email;
	
	private static String collectionName = "contactos";
	private static String fieldNombre = "nombre";
	private static String fieldTelefono = "telefono";
	private static String fieldEmail = "email";
	
	//*** Constructores ***
	
	public Contacto(){
		
	}
	
	public Contacto(String pNombre, double pTelefono, String pEmail){
		this.nombre = pNombre;
		this.telefono = pTelefono;
		this.email = pEmail;
	}
	
	
	
	
	//*** M�todos get-set ***
	
	public String getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(String idContacto) {
		this.idContacto = idContacto;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getTelefono() {
		return telefono;
	}
	
	public void setTelefono(double telefono) {
		this.telefono = telefono;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	//*** M�todos CRUD ***
	


	public Contacto mObtenerContacto(int idContacto) {
		Firestore co =null;
		
		try {			
			co= Conexion.conectar();
			
			DocumentSnapshot contacto = co.collection(collectionName).document(String.valueOf(idContacto)).get().get();
			
			setIdContacto(contacto.getId());
			setNombre(contacto.getString(fieldNombre));
			setTelefono(contacto.getDouble(fieldTelefono));
			setEmail(contacto.getString(fieldEmail));
			
			
		} catch ( InterruptedException | ExecutionException e) {
			System.out.println("Error: Clase Contacto, metodo mObtenerContactos");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this;
	}
		
	public ArrayList<Contacto> mObtenerContactos() {
		Firestore co =null;
	
		
		ArrayList<Contacto> listaContactos = new 	ArrayList<Contacto>();
		
		try {			
			co= Conexion.conectar();
			
			ApiFuture<QuerySnapshot> query = co.collection(collectionName).get();
			
			QuerySnapshot querySnapshot = query.get();
			List<QueryDocumentSnapshot> contactos = querySnapshot.getDocuments();
			for (QueryDocumentSnapshot contacto : contactos) {
			
				Contacto c=new Contacto();
				c.setIdContacto(contacto.getId());
				c.setNombre(contacto.getString(fieldNombre));
				c.setTelefono(contacto.getDouble(fieldTelefono));
				c.setEmail(contacto.getString(fieldEmail));
				listaContactos.add(c);
			}
			
		
		} catch ( InterruptedException | ExecutionException e) {
			System.out.println("Error: Clase Contacto, metodo mObtenerContactos");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaContactos;
	}
	
	public boolean mInsertarContacto() {
	    Firestore db = null;

	    try {
	        db = Conexion.conectar();

	        // Crear un mapa con los datos del contacto
	        Map<String, Object> datosContacto = new HashMap<>();
	        datosContacto.put(fieldNombre, this.nombre);
	        datosContacto.put(fieldTelefono, this.telefono);
	        datosContacto.put(fieldEmail, this.email);

	        // Insertar el documento en la colección
	        ApiFuture<com.google.cloud.firestore.DocumentReference> resultado = db.collection(collectionName).add(datosContacto);

	        // Obtener el ID generado y asignarlo al objeto
	        this.idContacto = resultado.get().getId();
	        System.out.println("ID generado: " + this.idContacto);
	        System.out.println("Insertando contacto: " + this.nombre + ", " + this.telefono + ", " + this.email);

	        return true;

	    } catch (InterruptedException | ExecutionException | IOException e) {
	        System.out.println("Error: Clase Contacto, método mInsertarContacto");
	        e.printStackTrace();
	        return false;
	    }
	}

	

	
	

}
