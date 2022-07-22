import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final String API_TOKEN = System.getenv("API_TOKEN");

    public static void main(String[] args) throws Exception {
        // Endpoint to connect to
        String url = selectEndpoint();
        // String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2022-06-12&end_date=2022-06-14";
        String body = HttpClient.get(url);

        // Handling the Response
        // List<Content> contents = NasaContentExtractor.extract(body);
        List<Content> contents = ImdbContentExtractor.extract(body);

        for (Content content : contents) {
            System.out.println("\u001b[30m\u001b[46m " + content.getTitle() + " \u001b[m");
            String image = content.getImageUrl();

            // TODO: * Refactor this logic
            //       * THIS is only for IMDb, to get the image with a better resolution
            int position = image.indexOf("@.");
            if (position != -1) {
                image = image.substring(0, position + 1) + ".jpg";
            }

            System.out.println(image);
            StickerGenerator.generate(
                    new URL(image).openStream(),
                    "9.8", // TODO: New API without "rating". movie.get("imDbRating"),
                    content.getSlug()
            );

            /* TODO: In order to use other APIs, without "rating", we are getting rid of this part of the code for now
            try {
                double rating = Double.parseDouble(movie.get("imDbRating"));
                System.out.println("IMDB rating: " + "⭐".repeat((int) Math.round(rating)) + " " + rating + "/10");
            } catch (NumberFormatException nfe) {
                System.out.println("IMDB rating: \u001b[3m\u001b[31m*no rating available\u001b[m");
            }
             */

            System.out.println();
        }
    }

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
