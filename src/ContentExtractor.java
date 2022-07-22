import java.util.List;

// TODO: Look for naming conventions in Java.
//       Should it be named ContentExtractorInterface instead? Maybe ExtractableContent? idk
public interface ContentExtractor {
    static List<Content> extract(String json) {
        // TODO: Static methods in interfaces must have a body. Didn't know. Is it like this in PHP? O.o
        //       What's the best "default" implementation? "null" is enough for now.
        return null;
    }
}
