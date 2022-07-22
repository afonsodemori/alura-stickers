import java.util.List;

// TODO: Look for naming conventions in Java.
//       Should it be named ContentExtractorInterface instead? Maybe ExtractableContent? idk
public interface ContentExtractor {
    List<Content> extract(String json);
    // TODO: This method was static, so I didn't have to instantiate the class in order to use it.
    //       While static, I had to implement it here, as static methods in interfaces must have a body. Didn't know it.
    //       Is it like this in PHP? O.o -- What's the best "default" implementation? Had "return null" here.
    //       New: Had to change it to non static while implementing API enum, otherwise I couldn't call .extract() from
    //       the instance. Get more info about all these things.
}
