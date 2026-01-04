import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

import java.util.List;

import okhttp3.ResponseBody;

public interface JsonPlaceholderApi {

    @GET("/products")
    Call<List<Products>> obtenerProductos();

    @POST("/products")
    Call<ResponseBody> crearProductos(@Body Products product);

    @PUT("/products/{id}")
    Call<ResponseBody> actualizarProducto(@Path("id") int id, @Body Products product);

    @DELETE("/products/{id}")
    Call<ResponseBody> borrarProducto(@Path("id") int id);
}


