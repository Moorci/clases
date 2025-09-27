package mostrarJSON;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class mostrarJSONPRO {

    public static void main(String[] args) {
        String url = "resources/stocks.json";

        try {
            JsonParser parser = new JsonParser();
            JsonElement datos = parser.parse(new FileReader(url));

            if (datos.isJsonArray()) {
                JsonArray array = datos.getAsJsonArray();
                System.out.println("Array con " + array.size() + " elementos");
                for (JsonElement item : array) {
                    procesarElemento(item);
                }
            } else {
                System.out.println("Elemento raíz no es un array");
                procesarElemento(datos);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + url);
            e.printStackTrace();
        } catch (JsonIOException | JsonSyntaxException e) {
            System.err.println("Error al leer o interpretar el JSON.");
            e.printStackTrace();
        }
    }

    private static void procesarElemento(JsonElement elemento) {
        if (elemento.isJsonArray()) {
            JsonArray array = elemento.getAsJsonArray();
            for (JsonElement item : array) {
                procesarElemento(item);
            }
        } else if (elemento.isJsonObject()) {
            JsonObject objeto = elemento.getAsJsonObject();
            System.out.println("\nObjeto:");
            for (Map.Entry<String, JsonElement> entry : objeto.entrySet()) {
                System.out.println("Atributo: " + entry.getKey());
                procesarElemento(entry.getValue());
            }
        } else if (elemento.isJsonPrimitive()) {
            JsonPrimitive valor = elemento.getAsJsonPrimitive();
            System.out.println("\t" + tipoDeValor(valor) + ": " + valor.toString());
        } else if (elemento.isJsonNull()) {
            System.out.println("Valor nulo");
        } else {
            System.out.println("Tipo de elemento desconocido");
        }
    }

    private static String tipoDeValor(JsonPrimitive valor) {
        if (valor.isBoolean()) return "Boolean";
        if (valor.isNumber()) return "Número";
        if (valor.isString()) return "Texto";
        return "Primitivo desconocido";
    }
}
