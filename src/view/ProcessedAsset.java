package view;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * Created by Holy on 07-Jun-17.
 */
public final class ProcessedAsset {
  public ProcessedAsset() {}

  public static Image getImage(Class _class, String _imagePath) {
    URL imgPath = _class.getResource(_imagePath);
    ImageIcon imageIcon = new ImageIcon(imgPath);
    Image image = imageIcon.getImage();
    return image;
  }

  public static Image getScaledImage(Image srcImg, int w, int h) {
    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = resizedImg.createGraphics();
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(srcImg, 0, 0, w, h, null);
    g2.dispose();
    return resizedImg;
  }
}
