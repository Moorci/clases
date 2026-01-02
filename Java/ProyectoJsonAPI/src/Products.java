public class Products {

	private int id;
	private String title;
	private float price;
	private String description;
	private String category;
	private String image;

	public Products(int id, String title, float price, String description, String category, String image) {
		this.id = id;
		this.title = title;
		this.price = price;
		this.description = description;
		this.category = category;
		this.image = image;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public float getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}

	public String getCategory() {
		return category;
	}

	public String getImage() {
		return image;
	}

	@Override
	public String toString() {
		return "Products{" + "id=" + id + ", title='" + title + '\'' + ", price=" + price + ", description='"
				+ description + '\'' + ", category='" + category + '\'' + ", image='" + image + '\'' + '}';
	}
}
