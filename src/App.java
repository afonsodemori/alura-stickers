import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    /*
         Day 1, challenge 3: Place the IMDB API key somewhere outside the code like a configuration file (eg a
         .properties file) or an environment variable.
     */
    private static final String API_TOKEN = System.getenv("API_TOKEN");

    public static void main(String[] args) throws Exception {
        // Endpoint to connect to
        String url = selectEndpoint();
        String body = HttpClient.get(url);

        // Handling the Response
        List<Map<String, String>> moviesList = JsonParser.parse(body);

        System.out.printf("\n= %d items found%n%n", moviesList.size());

        /*
             Day 1, challenge 2: Use your creativity to make the output cuter: use emojis with UTF-8 code, show the movie
             note as little stars, decorate the terminal with colors, bold and italics using ANSI codes, and more!
         */
        for (Map<String, String> movie : moviesList) {
            System.out.println("\u001b[30m\u001b[46m " + movie.get("title") + " \u001b[m");
            String image = movie.get("image");

            // TODO: REVIEW IT, REFACTOR IT, WORST CODE EVER. REVIEW THE WHOLE COMMIT.
            int position = image.indexOf("@.");
            if (position != -1) {
                image = image.substring(0, position + 1) + ".jpg";
            }

            System.out.println(image);
            StickerGenerator.generate(
                    new URL(image).openStream(),
                    movie.get("imDbRating"),
                    movie.get("id")
            );

            try {
                double rating = Double.parseDouble(movie.get("imDbRating"));
                System.out.println("IMDB rating: " + "⭐".repeat((int) Math.round(rating)) + " " + rating + "/10");
            } catch (NumberFormatException nfe) {
                System.out.println("IMDB rating: \u001b[3m\u001b[31m*no rating available\u001b[m");
            }

            System.out.println();
        }
    }

    /*
        Day 1, challenge 1: Consume the most popular movies' endpoint from IMDB API. Also look in the IMDB API
        documentation for the endpoint that returns the best series and the one that returns the most popular series.
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
