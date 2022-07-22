import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;

abstract public class StickerGenerator {
    private static final int STICKER_WIDTH = 300;
    private static final int TEXT_AREA_SIZE = 50;
    private static final int FONT_SIZE = 40;
    private static final int PADDING_BOTTOM = 10;

    public static void generate(InputStream stream, String rating, String filename) throws Exception {
        // STEP 1: Reading the original image
        // Can create the image (ImageIO.read) from a File (new File("/path")), from an URL (new URL("https://...")), etc
        // URL url = new URL(urlString); -- replaced with InputStream (new URL(url).openStream())
        BufferedImage originalImage = ImageIO.read(stream);

        // Images have different size. Calculate the desired height for the image...
        int originalResizedHeight = (originalImage.getHeight() * STICKER_WIDTH) / originalImage.getWidth();
        int stickerHeight = originalResizedHeight + TEXT_AREA_SIZE;

        // STEP 2: Creating a new image (a blank canvas to draw in)
        BufferedImage sticker = new BufferedImage(STICKER_WIDTH, stickerHeight, BufferedImage.TRANSLUCENT);

        // STEP 3: Insert the original image in the new one
        Graphics2D graphics = (Graphics2D) sticker.getGraphics();
        graphics.drawImage(originalImage, 0, 0, STICKER_WIDTH, originalResizedHeight, null);

        // TODO: REVIEW IT, REFACTOR IT, WORST CODE EVER. REVIEW THE WHOLE COMMIT.
        Font font;
        if (rating != null) {
            BufferedImage star = ImageIO.read(new FileInputStream("src/star.png"));
            graphics.drawImage(star, STICKER_WIDTH - 85, -45, null);

            // STEP 4: Write text in the image
            font = new Font("Impact", Font.BOLD, FONT_SIZE);
            graphics.setFont(font);

            graphics.setColor(Color.BLACK);
            graphics.drawString(rating, STICKER_WIDTH - 58, 45);

            graphics.setColor(Color.ORANGE);
            graphics.drawString(rating, STICKER_WIDTH - 60, 42);
        }

        /*
            Day 2, challenge 5: Use another font like Comic Sans or Impact, the font used in memes
         */
        String[] fonts = {"Comic Sans MS", "Impact"};
        Random random = new Random();
        font = new Font(fonts[random.nextInt(fonts.length)], Font.BOLD, FONT_SIZE);
        graphics.setFont(font);
        /*
            Day 2, challenge 2: Center the text on the sticker
         */
        String text;
        if (rating == null) {
            text = "Topzera";
        } else {
            try {
                float ratingFloat = Float.parseFloat(rating);
                if (ratingFloat >= 9) {
                    text = "EXCELLENT";
                } else if (ratingFloat > 7) {
                    text = "Good";
                } else if(ratingFloat > 5) {
                    text = "Average";
                } else {
                    // TODO: REFACTOR! REFACTOR! REFACTOR! REFACTOR! REFACTOR! REFACTOR!
                    text = "Melhor ver o Pelé";
                    font = new Font("Impact", Font.BOLD, FONT_SIZE);
                    graphics.setFont(font);
                }
            } catch (NumberFormatException ignored) {
                text = "unrated";
            }
        }

        graphics.setColor(Color.BLUE);
        FontMetrics metrics = graphics.getFontMetrics();
        float coordinateX = ((float) sticker.getWidth() / 2) - ((float) metrics.stringWidth(text) / 2);
        graphics.drawString(text, coordinateX, sticker.getHeight() - PADDING_BOTTOM);

        /*
            Day 2, challenge 4: Create output directory for images if it does not already exist
         */
        File outputFile = new File("out/stickers/%s.png".formatted(filename));
        outputFile.mkdirs();

        ImageIO.write(sticker, "png", outputFile);
    }
}
