package backend;

import com.google.gson.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

public class WithPlate extends MeansOfTransport {

    @Override
    public int coTwee() {
        return (int) (requestDistance()/ 1000 * requestCoKm());
    }

    private int requestCoKm() {
        Client client = ClientBuilder.newClient();
        Response response = client.target("https://opendata.rdw.nl/resource/8ys7-d773.json?kenteken=" + medium)
                .request(MediaType.TEXT_PLAIN_TYPE)
                .header("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8")
                .get();
        String resp = response.readEntity(String.class);
        Gson gson = new Gson();
        JsonArray jsonArray = gson.fromJson(resp, JsonArray.class);
        JsonElement jsonElement = jsonArray.get(0);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        return Integer.parseInt(jsonObject.get("co2_uitstoot_gecombineerd").getAsString());
    }

    private JsonObject requestDirections(ArrayList<ArrayList<String>> cords) {
        Client client = ClientBuilder.newClient();
        Response response = client.target("https://api.openrouteservice.org/v2/directions/" +
                        "driving-car" + "?api_key=5b3ce3597851110001cf6248d5fc015bca0c493b824fe5f5bf5730c3&start=" +
                        cords.get(0).get(0) + "," + cords.get(0).get(1) + "&end=" +
                        cords.get(1).get(0) + "," + cords.get(1).get(1))
                .request(MediaType.TEXT_PLAIN_TYPE)
                .header("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8")
                .get();
        String resp = response.readEntity(String.class);
        Gson gson = new Gson();
        return gson.fromJson(resp, JsonObject.class);
    }

    private ArrayList<String> requestSearch(String input) {
        input = input.replace(" ", "%20");
        Client client = ClientBuilder.newClient();
        Response response = client.target("https://api.openrouteservice.org/geocode/search?api_key=5b3ce3597851110001cf6248d5fc015bca0c493b824fe5f5bf5730c3&text=" + input)
                .request(MediaType.TEXT_PLAIN_TYPE)
                .header("Accept", "application/json, application/geo+json, application/gpx+xml, img/png; charset=utf-8")
                .get();

        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response.readEntity(String.class), JsonObject.class);
        ArrayList<String> output = new ArrayList<>();
        output.add(String.valueOf(jsonObject.getAsJsonArray("bbox").get(0)));
        output.add(String.valueOf(jsonObject.getAsJsonArray("bbox").get(1)));
        return output;
    }

    private double requestDistance(){
        ArrayList<ArrayList<String>> cords = new ArrayList<>();
        cords.add(requestSearch(start));
        cords.add(requestSearch(eind));
        JsonObject jsonObject = requestDirections(cords);
        JsonArray jsonArray = jsonObject.getAsJsonArray("features");
        jsonObject = (JsonObject) jsonArray.get(0);
        jsonObject = jsonObject.getAsJsonObject("properties");
        jsonObject = (JsonObject) jsonObject.getAsJsonArray("segments").get(0);
        JsonPrimitive jsonPrimitive = jsonObject.getAsJsonPrimitive("distance");
        return jsonPrimitive.getAsDouble();
    }
}
