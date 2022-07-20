import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

abstract public class StickerGenerator {
    public static void generate(InputStream stream, String text, String filename) throws Exception {
        // STEP 1: Reading the original image
        // Can create the image (ImageIO.read) from a File (new File("/path")), from an URL (new URL("https://...")), etc
        // URL url = new URL(urlString); -- replaced with InputStream (new URL(url).openStream())
        BufferedImage originalImage = ImageIO.read(stream);

        // STEP 2: Creating a new image (a blank canvas to draw in)
        BufferedImage newImage = new BufferedImage(
                originalImage.getWidth(),
                originalImage.getHeight() + 30,
                BufferedImage.TRANSLUCENT
        );

        // STEP 3: Insert the original image in the new one
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        // STEP 4: Write text in the image
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        graphics.setColor(Color.YELLOW);
        graphics.drawString(text, 10, newImage.getHeight() - 10);

        ImageIO.write(newImage, "png", new File("out/stickers/%s.png".formatted(filename)));
    }
}
