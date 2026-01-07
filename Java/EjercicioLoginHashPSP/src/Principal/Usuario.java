package Principal;

public class Usuario {
	
	String user;
	String nombre;
	String contraseña;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	public Usuario() {
		super();
		this.user = "";
		this.nombre = "";
		this.contraseña = "";
	}
	
	public Usuario(String user, String nombre, String contraseña) {
		super();
		this.user = user;
		this.nombre = nombre;
		this.contraseña = contraseña;
	}

	
}
