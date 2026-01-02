import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
				
				//creo el fichero productos.json y meto todos los productos ahi				 
				 Gson gson = new GsonBuilder().setPrettyPrinting().create();
				 String json = gson.toJson(listaProducts);

				 File archivo = new File("productos.json");

				 try (FileWriter writer = new FileWriter(archivo)) {
				     writer.write(json);
				     System.out.println("\nArchivo productos.json creado correctamente.");
				 } catch (IOException e) {
				     e.printStackTrace();
				 }
				
			}

		} catch (IOException e) {

			e.printStackTrace();

		}

		//leo el fichero
		try (FileReader reader = new FileReader("productos.json")) {

		    Gson gson = new Gson();

		    // convertimos a products
		    Products[] productosArray = gson.fromJson(reader, Products[].class);

		    System.out.println("\nPrimero: " + productosArray[0].getTitle());
		    
		    productosArray[0].setTitle("Copia");

		} catch (Exception e) {
		    e.printStackTrace();
		}

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