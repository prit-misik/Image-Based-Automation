import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
//from   ww  w  .  j  a v  a2s .c om
import javax.imageio.ImageIO;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedImage img1 = ImageIO.read(new File("C:\\test\\img1.png"));
    BufferedImage img2 = ImageIO.read(new File("C:\\test\\img2.png"));
    BufferedImage joinedImg = joinBufferedImage(img1, img2);
    ImageIO.write(joinedImg, "png", new File("c:/test/result.png"));
  }

  public static BufferedImage joinBufferedImage(BufferedImage img1,
      BufferedImage img2) {
    int offset = 2;
    int width = img1.getWidth() + img2.getWidth() + offset;
    int height = Math.max(img1.getHeight(), img2.getHeight()) + offset;
    BufferedImage newImage = new BufferedImage(width, height,
        BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = newImage.createGraphics();
    Color oldColor = g2.getColor();
    g2.setPaint(Color.BLACK);
    g2.fillRect(0, 0, width, height);
    g2.setColor(oldColor);
    g2.drawImage(img1, null, 0, 0);
    g2.drawImage(img2, null, img1.getWidth() + offset, 0);
    g2.dispose();
    return newImage;
  }
}