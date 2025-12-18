import java.io.IOException;
import java.util.List;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Principal {

	public static void main(String[] args) {

		// --- Crear instancia de Retrofit ---

		Retrofit retrofit = new Retrofit.Builder().baseUrl("https://fakestoreapi.com") // URL base de la API

				.addConverterFactory(GsonConverterFactory.create()) // Conversor JSON <-> objetos Java

				.build();

		// --- Crear la interfaz de la API ---

		JsonPlaceholderApi api = retrofit.create(JsonPlaceholderApi.class);

		// --- PETICIÓN GET ---

		Call<List<Products>> llamadaGet = api.obtenerProductos();

		try {

			Response<List<Products>> respuestaGet = llamadaGet.execute();

			if (respuestaGet.isSuccessful() && respuestaGet.body() != null) {

				System.out.println("GET /products:");

				List<Products> listaProducts = respuestaGet.body();

				for (Products product : listaProducts) {

					System.out.println(product);

				}

				/*
				 * for(Product p: listaProducts) {
				 * 
				 * p.setTitle(p.getTitle());
				 * 
				 * p.setPrice(p.getPrice());
				 * 
				 * p.setDescription(p.getDescription());
				 * 
				 * p.setCategory(p.getCategory());
				 * 
				 * p.setImage(p.getImage());
				 * 
				 * Gson gson = new Gson();
				 * 
				 * String json = gson.toJson(p);
				 * 
				 * try (FileWriter writer = new FileWriter("productos.json")) {
				 * 
				 * gson.toJson(p, writer);
				 * 
				 * }
				 */

			}

		} catch (IOException e) {

			e.printStackTrace();

		}

		// Guardar esa lista JSON en un fichero local llamado productos.json.

		// --- PETICIÓN POST ---

		Products nuevoProduct = new Products(101, "Nuevo Producto", 29.99f, "Descripción del nuevo producto",

				"categoría ejemplo", "https://example.com/imagen.jpg");

		Call<Products> llamadaProduct = api.crearProductos(nuevoProduct);

		try {

			Response<Products> respuestaProduct = llamadaProduct.execute();

			if (respuestaProduct.isSuccessful() && respuestaProduct.body() != null) {

				System.out.println("\nPRODUCT /products:");

				System.out.println(respuestaProduct.body());

				System.out.println(respuestaProduct.code());

			}

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}