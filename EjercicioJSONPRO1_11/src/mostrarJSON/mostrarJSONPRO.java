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

public class mostrarJSONPRO {

	public static void main(String[] args) {
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
				verificacionesDelValor(valor);
				
				System.out.println("Atributo: descripcion");
				JsonPrimitive valor2 = iter2.next().getValue().getAsJsonPrimitive();
				verificacionesDelValor(valor2);
				
				System.out.println("Atributo: initial_price");
				JsonPrimitive valor3 = iter2.next().getValue().getAsJsonPrimitive();
				verificacionesDelValor(valor3);
				
				System.out.println("Atributo: price_2002");
				JsonPrimitive valor4 = iter2.next().getValue().getAsJsonPrimitive();
				verificacionesDelValor(valor4);
				
				System.out.println("Atributo: price_2007");
				JsonPrimitive valor5 = iter2.next().getValue().getAsJsonPrimitive();
				verificacionesDelValor(valor5);
				
				System.out.println("Atributo: symbol");
				JsonPrimitive valor6 = iter2.next().getValue().getAsJsonPrimitive();
				verificacionesDelValor(valor6);

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static void verificacionesDeElemento(JsonElement elemento) {
		
	}

	private static void verificacionesDelValor(JsonPrimitive valor) {
		if(valor.isBoolean()) {
			System.out.println("\tBoolean: " + valor.getAsBoolean());
		}else if(valor.isNumber()) {
			System.out.println("\tBoolean: " + valor.getAsNumber());
		}else {
			System.out.println("\tBoolean: " + valor.getAsString());
		}
		
	}

}
