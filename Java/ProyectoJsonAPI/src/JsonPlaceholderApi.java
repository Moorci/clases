import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface JsonPlaceholderApi {
    @GET("/products")
    Call<List<Products>> obtenerProductos();

    @POST("/products")
    Call<Products> crearProductos(@Body Products post);
}
