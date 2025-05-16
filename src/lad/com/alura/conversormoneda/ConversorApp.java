package lad.com.alura.conversormoneda;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class ConversorApp {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/2dc80d30c2d6ff722ec22a92/latest/USD";

    public static Map<String, Moneda> obtenerMonedasFiltradas() {
        Map<String, Moneda> monedas = new HashMap<>();

        try {
            // Petición HTTP
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());//espera la respuesta en un formato String

            // Parsear JSON en objetos manipulables
            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject tasas = json.getAsJsonObject("conversion_rates");

            // Monedas que nos interesan
            String[] codigos = {"USD", "ARS", "BOB", "BRL", "CLP", "COP"};

            //ARS = 900.12, Y REC
            for (String codigo : codigos) {
                double tasa = tasas.get(codigo).getAsDouble();
                monedas.put(codigo, new Moneda(codigo, tasa));//crea objetos moneda y los guarda en el map
            }

        } catch (Exception e) {
            System.out.println("Error al obtener datos de la API: " + e.getMessage());
        }

        return monedas;
    }
}



