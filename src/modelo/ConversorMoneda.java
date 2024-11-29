package modelo;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConversorMoneda {

    private HttpClient client;
    private Gson gson;
    private String apiKey;

    //Se crea el constructor
    public ConversorMoneda(String apiKey){
        this.client = HttpClient.newHttpClient();
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.apiKey = apiKey;
    }

    public moneda convertir(String codigoBase, String codigoFinal, double cantidad) throws Exception{

        String direccion = "https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + codigoBase + "/" + codigoFinal + "/" + cantidad;

        HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .GET()
                    .build();
        
        HttpResponse <String> response = client
        .send (request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();//Se crea una variable String llamada json para contener la respuesta de la API
        monedas miMonedaApi = gson.fromJson(json, monedas.class); 

        return new moneda(miMonedaApi, cantidad);
    }
}
