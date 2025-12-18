public class Products {
    private int id;
    private String titulo;
    private float precio;
    private String descripcion;
    private String categoria;
    private String img;

    public Products(int id, String titulo, float precio, String descripcion, String categoria, String img) {
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.img = img;
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public float getPrecio() {
		return precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getImg() {
		return img;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", titulo=" + titulo + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", categoria=" + categoria + ", img=" + img + "]";
	}

	

}
