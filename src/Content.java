import java.util.Locale;

public class Content {
    private final String title;
    private final String imageUrl;

    public Content(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getSlug() {
        return title
                .replaceAll("[^a-zA-z0-9]", "-") // replace non-alphanumeric characters with "-"
                .replaceAll("-+", "-") // remove duplicated dashes (eg: M51: The => M51--The => M51-The)
                .toLowerCase();
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
