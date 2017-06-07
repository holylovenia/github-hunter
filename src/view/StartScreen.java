package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Created by Holy on 07-Jun-17.
 */
public class StartScreen extends JFrame {

  private final int SCREEN_WIDTH = 1800;
  private final int SCREEN_HEIGHT = 900;
  private StartPanel startPanel;
  public StartScreen() {
    setTitle("GitHub Hunter");
    setResizable(false);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    startPanel = new StartPanel();
    startPanel.setUpStartPanel();
    add(startPanel);
    pack();
  }

  public static void main(String[] args) {
    StartScreen startScreen = new StartScreen();
    startScreen.setVisible(true);
  }

  private class StartPanel extends JPanel {

    public void setUpStartPanel() {
      setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
      setBackground(Color.WHITE);
      repaint();
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Image logo = ProcessedAsset
          .getScaledImage(ProcessedAsset.getImage(getClass(), "\\assets\\logo.png"), 800, 600);
      g.drawImage(logo, 500, 150, this);
      g.dispose();
    }
  }
}
