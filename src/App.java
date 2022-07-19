import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    private static final String API_TOKEN = "some_token_here";

    public static void main(String[] args) throws Exception {
        // Endpoint to connect to
        String url = selectEndpoint();

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

    /**
     * CHALLENGE 001: Consume the most popular movies' endpoint from IMDB API. Also look in the IMDB API documentation
     * for the endpoint that returns the best series and the one that returns the most popular series.
     */
    private static String selectEndpoint() {
        System.out.print("""
                Select an option:
                [1] Top 250 Movies
                [2] Most Popular Movies
                [3] Top 250 TVs
                [4] Most Popular TVs
                >\s"""
        );

        List<String> options = new ArrayList<>();
        options.add("Top250Movies");
        options.add("MostPopularMovies");
        options.add("Top250TVs");
        options.add("MostPopularTVs");

        Scanner scanner = new Scanner(System.in);

        int optionIndex = -1;
        while (optionIndex == -1) {
            String option = scanner.nextLine();
            try {
                optionIndex = Integer.parseInt(option) - 1;
            } catch (NumberFormatException ignored) {
            } finally {
                if (optionIndex < 0 || optionIndex >= options.size()) {
                    System.out.printf("Invalid option. Choose a number between 1 and %d:%n> ", options.size());
                    optionIndex = -1;
                }
            }
        }

        return "https://imdb-api.com/en/API/%s/%s".formatted(options.get(optionIndex), API_TOKEN);
    }
}
