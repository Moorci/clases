package mostrarJSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class mostrarJSONmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JsonParser parser = new JsonParser();
		final String url = "resources/stocks.json";

		try {

			FileReader fr = new FileReader(url);
			JsonElement datos = parser.parse(fr);

			JsonArray array = datos.getAsJsonArray();
			System.out.println("Array. Numero de elementos :" + array.size());
			Iterator<JsonElement> iter = array.iterator();
			while (iter.hasNext()) {
				JsonElement entrada = iter.next();
				System.out.println("\nObjeto");
				JsonObject objeto = entrada.getAsJsonObject();
				Iterator<Map.Entry<String, JsonElement>> iter2 = objeto.entrySet().iterator();
				
				System.out.println("Atributo: Company");
				JsonPrimitive valor = iter2.next().getValue().getAsJsonPrimitive();
				System.out.println("\tTexto: " + valor.getAsString());
				
				System.out.println("Atributo: descripcion");
				JsonPrimitive valor2 = iter2.next().getValue().getAsJsonPrimitive();
				System.out.println("\tTexto: : " + valor2.getAsString());
				
				System.out.println("Atributo: initial_price");
				JsonPrimitive valor3 = iter2.next().getValue().getAsJsonPrimitive();
				System.out.println("\tNumero:  " + valor3.getAsNumber());
				
				System.out.println("Atributo: price_2002");
				JsonPrimitive valor4 = iter2.next().getValue().getAsJsonPrimitive();
				System.out.println("\tNumero: " + valor4.getAsNumber());
				
				System.out.println("Atributo: price_2007");
				JsonPrimitive valor5 = iter2.next().getValue().getAsJsonPrimitive();
				System.out.println("\tNumero: " + valor5.getAsNumber());
				
				System.out.println("Atributo: symbol");
				JsonPrimitive valor6 = iter2.next().getValue().getAsJsonPrimitive();
				System.out.println("\tTexto: " + valor6.getAsString());
				

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
