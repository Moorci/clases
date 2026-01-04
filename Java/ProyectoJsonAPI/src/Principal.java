import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Principal {

    public static void main(String[] args) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fakestoreapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceholderApi api = retrofit.create(JsonPlaceholderApi.class);

        List<Products> listaProducts = null;

        try {
            Call<List<Products>> llamadaGet = api.obtenerProductos();
            Response<List<Products>> respuestaGet = llamadaGet.execute();

            System.out.println("Código GET: " + respuestaGet.code());

            if (respuestaGet.isSuccessful() && respuestaGet.body() != null) {
                listaProducts = respuestaGet.body();

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String json = gson.toJson(listaProducts);

                File archivo = new File("productos.json");
                try (FileWriter writer = new FileWriter(archivo)) {
                    writer.write(json);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Products copia = null;

        try (FileReader reader = new FileReader("productos.json")) {

            Gson gson = new Gson();
            Products[] productosArray = gson.fromJson(reader, Products[].class);

            System.out.println("\nPrimer producto: " + productosArray[0].getTitle());

            copia = new Products(
                    productosArray[0].getId(),
                    "Copia " + productosArray[0].getTitle(),
                    productosArray[0].getPrice(),
                    productosArray[0].getDescription(),
                    productosArray[0].getCategory(),
                    productosArray[0].getImage()
            );

        } catch (Exception e) {
            e.printStackTrace();
        }

        int nuevoId = 21;

        try {
            Call<ResponseBody> llamadaPost = api.crearProductos(copia);
            Response<ResponseBody> respuestaPost = llamadaPost.execute();

            System.out.println("\nPOST código: " + respuestaPost.code());
            System.out.println("POST body: " + respuestaPost.body().string());

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            copia.setTitle("UPDATED");

            Call<ResponseBody> llamadaPut = api.actualizarProducto(nuevoId, copia);
            Response<ResponseBody> respuestaPut = llamadaPut.execute();

            System.out.println("\nPUT código: " + respuestaPut.code());
            System.out.println("PUT body: " + respuestaPut.body().string());

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Call<ResponseBody> llamadaDelete = api.borrarProducto(nuevoId);
            Response<ResponseBody> respuestaDelete = llamadaDelete.execute();

            System.out.println("\nDELETE código: " + respuestaDelete.code());
            System.out.println("DELETE body: " + respuestaDelete.body().string());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
