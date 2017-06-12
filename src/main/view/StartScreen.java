package main.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Displays start up of application in a frame.
 *
 * @author Holy Lovenia - 13515113
 * @version 1.0
 * @since 2017-06-07
 */
public class StartScreen extends JFrame {

  /**
   * Determines width of the frame.
   */
  private final int screenWidth = 1800;

  /**
   * Determines height of the frame.
   */
  private final int screenHeight = 900;

  /**
   * Instantiation of <code>StartPanel</code>.
   *
   * @see StartPanel
   */
  private StartPanel startPanel;

  /**
   * Constructor.
   *
   * <p>Sets title, ability to resize, and close operation. Constructs, prepares, and adds
   * components needed.</p>
   */
  public StartScreen() {
    setTitle("GitHub Hunter");
    setResizable(false);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    startPanel = new StartPanel();
    startPanel.setUpStartPanel();
    add(startPanel);
    pack();
  }

  /**
   * Displays start up of application in a panel.
   */
  private class StartPanel extends JPanel {

    /**
     * Prepares and paints panel.
     */
    public void setUpStartPanel() {
      setPreferredSize(new Dimension(screenWidth, screenHeight));
      setBackground(Color.WHITE);
      repaint();
    }

    /**
     * <p>Paints the panel with application logo.</p>
     */
    @Override
    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Image logo = ProcessedAsset
          .getScaledImage(ProcessedAsset.getImage(getClass(), "\\assets\\logo.png"), 800, 600);
      g.drawImage(logo, 500, 150, this);
      g.dispose();
    }
  }
}
