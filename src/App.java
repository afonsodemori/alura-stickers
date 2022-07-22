import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class App {
    // TODO: Changed to public as now I need to use it from API enum. Think of a better way or place to put it.
    public static final String API_TOKEN = System.getenv("API_TOKEN");

    public static void main(String[] args) throws Exception {
        // API to connect to
        API api = selectEndpoint();
        String body = HttpClient.get(api.url());

        // Handling the Response
        List<Content> contents = api.extractor().extract(body);

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
                    content.getRating(),
                    content.getSlug()
            );

            // TODO: Implement different sticker renderers for different APIs, like we do with ContentExtractor (?) or
            //       write this inside the sticker generator? (ugly)
            if (content.getRating() != null) {
                try {
                    double rating = Double.parseDouble(content.getRating());
                    System.out.println("IMDB rating: " + "⭐".repeat((int) Math.round(rating)) + " " + rating + "/10");
                } catch (NumberFormatException nfe) {
                    System.out.println("IMDB rating: \u001b[3m\u001b[31m*no rating available\u001b[m");
                }
            }

            System.out.println();
        }
    }

    private static API selectEndpoint() {
        API[] options = API.values();

        System.out.println("Select an option:");
        for (int optionId = 1; optionId <= options.length; optionId++) {
            System.out.printf("[%d] %s%n", optionId, options[optionId - 1].description());
        }

        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);

        int optionIndex = -1;
        while (optionIndex == -1) {
            String option = scanner.nextLine();
            try {
                optionIndex = Integer.parseInt(option) - 1;
            } catch (NumberFormatException ignored) {
            } finally {
                if (optionIndex < 0 || optionIndex >= options.length) {
                    System.out.printf("Invalid option. Choose a number between 1 and %d:%n> ", options.length);
                    optionIndex = -1;
                }
            }
        }

        return API.values()[optionIndex];
    }
}
