package view;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Static class which processes image and font retrieval.
 *
 * @author Holy Lovenia - 13515113
 * @version 1.0
 * @since 2017-06-07
 */
public final class ProcessedAsset {

  /**
   * Contains Open Sans Italic font.
   */
  public static Font openSansItalic;

  /**
   * Contains Roboto Regular font.
   */
  public static Font robotoRegular;

  /**
   * Contains Roboto Black font.
   */
  public static Font robotoBlack;

  /**
   * Constructor.
   *
   * <p>Initializes <code>openSansItalic</code>, <code>robotoRegular</code>, and
   * <code>robotoBlack</code>.</p>
   */
  public ProcessedAsset() {
    openSansItalic = ProcessedAsset.getFont(getClass(), "opensans-italic");
    robotoRegular = ProcessedAsset.getFont(getClass(), "roboto-regular");
    robotoBlack = ProcessedAsset.getFont(getClass(), "roboto-black");
  }

  /**
   * Generator for image.
   *
   * <p>Static method to retrieve image.</p>
   *
   * @param _class Class which requests the image
   * @param _imagePath Relative image path
   * @return Image from <code>_imagePath</code>
   */
  public static Image getImage(Class _class, String _imagePath) {
    URL imgPath = _class.getResource(_imagePath);
    ImageIcon imageIcon = new ImageIcon(imgPath);
    Image image = imageIcon.getImage();
    return image;
  }

  /**
   * Generator for image.
   *
   * <p>Static method to retrieve image.</p>
   *
   * @param link Image URL
   * @return Image from <code>link</code>
   */
  public static Image getImage(String link) {
    Image image = null;
    try {
      URL url = new URL(link);
      image = ImageIO.read(url);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return image;
  }

  /**
   * Generator for image.
   *
   * <p>Static method to retrieve scaled image with specified dimension.</p>
   *
   * @param srcImg Original image
   * @param w Width requested
   * @param h Height requested
   * @return Scaled image with <code>w</code> x <code>h</code> dimension
   */
  public static Image getScaledImage(Image srcImg, int w, int h) {
    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = resizedImg.createGraphics();
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
        RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(srcImg, 0, 0, w, h, null);
    g2.dispose();
    return resizedImg;
  }

  /**
   * Generator for font.
   *
   * <p>Static method to retrieve specified font.</p>
   *
   * @param _class Class which requests the image
   * @param _fontName Name of the font
   * @return Specified font
   */
  public static Font getFont(Class _class, String _fontName) {
    Font chosenFont = null;
    try {
      chosenFont = Font.createFont(Font.TRUETYPE_FONT,
          _class.getResource("\\assets\\font\\" + _fontName.toLowerCase() + ".ttf").openStream());
    } catch (FontFormatException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return chosenFont;
  }
}
