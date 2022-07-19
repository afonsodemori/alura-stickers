import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class App {
    private static final String API_TOKEN = "some_token_here";

    public static void main(String[] args) throws Exception {
        // Endpoint to connect to
        String url = "https://imdb-api.com/en/API/Top250Movies/" + API_TOKEN;

        // Generating and sending the Request
        URI uri = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        // Handling the Response
        List<Map<String, String>> moviesList = JsonParser.parse(body);

        System.out.printf("\n= %d items found%n%n", moviesList.size());

        for (Map<String, String> movie : moviesList) {
            System.out.println(movie.get("title"));
            System.out.println(movie.get("image"));
            System.out.println(movie.get("imDbRating"));
            System.out.println();
        }
    }
}
