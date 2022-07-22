import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImdbContentExtractor {
    public static List<Content> extract(String json) {
        List<Map<String, String>> attributes = JsonParser.parse(json);

        List<Content> contents = new ArrayList<>();

        for (Map<String, String> attribute : attributes) {
            contents.add(new Content(attribute.get("title"), attribute.get("image")));
        }

        return contents;
    }
}
