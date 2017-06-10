package view;

import static java.awt.GridBagConstraints.BOTH;
import static java.awt.GridBagConstraints.CENTER;
import static java.awt.GridBagConstraints.HORIZONTAL;
import static java.awt.GridBagConstraints.NONE;
import static java.awt.GridBagConstraints.RELATIVE;
import static java.awt.GridBagConstraints.REMAINDER;
import static java.awt.GridBagConstraints.WEST;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


/**
 * Created by Holy on 10-Jun-17.
 */
public class DisclaimerScreen extends JFrame {

  private final int SCREEN_WIDTH = 1800;
  private final int SCREEN_HEIGHT = 900;
  private DisclaimerPanel disclaimerPanel;

  public DisclaimerScreen() {
    setTitle("GitHub Hunter");
    setResizable(false);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    disclaimerPanel = new DisclaimerPanel();
    disclaimerPanel.setUpDisclaimerPanel();
    add(disclaimerPanel);
    pack();
  }

  public static void main(String[] args) {
    ProcessedAsset processedAsset = new ProcessedAsset();
    DisclaimerScreen disclaimerScreen = new DisclaimerScreen();
    disclaimerScreen.setVisible(true);
  }

  private class DisclaimerPanel extends JPanel {

    private GridBagLayout layout;
    private GridBagConstraints constraints;
    private JLabel disclaimerLabel;
    private JLabel octocatLabel;
    private JLabel contentLabel;

    public void setUpDisclaimerPanel() {
      setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
      setBackground(Color.WHITE);
      layout = new GridBagLayout();
      setLayout(layout);
      constraints = new GridBagConstraints();
      constraints.fill = BOTH;
      constraints.weightx = 0;
      constraints.weighty = 0;
      createComponents();
      addComponents();
    }

    public void createComponents() {
      createDisclaimerText();
      createOctocatLogo();
      createContentLabel();
    }

    public void addComponents() {
      add(disclaimerLabel);
      add(octocatLabel);
      add(contentLabel);
    }

    public void createDisclaimerText() {
      constraints.gridx = 0;
      constraints.gridy = 0;
      constraints.fill = REMAINDER;
      constraints.anchor = CENTER;
      constraints.insets = new Insets(-75, 350, 100, -205);
      disclaimerLabel = new JLabel("About GitHub Hunter", JLabel.CENTER);
      disclaimerLabel.setForeground(Color.BLACK);
      disclaimerLabel.setFont(ProcessedAsset.robotoBlack.deriveFont(120f));
      layout.setConstraints(disclaimerLabel, constraints);
    }

    public void createOctocatLogo() {
      constraints.gridx = 0;
      constraints.gridy = 1;
      constraints.fill = RELATIVE;
      constraints.anchor = WEST;
      constraints.insets = new Insets(0, 120, -50, 0);
      ImageIcon imageIcon = new ImageIcon(
          ProcessedAsset.getImage(getClass(), "\\assets\\octocat.gif"));
      octocatLabel = new JLabel();
      octocatLabel.setIcon(imageIcon);
      layout.setConstraints(octocatLabel, constraints);
    }

    public void createContentLabel() {
      constraints.gridx = 1;
      constraints.gridy = 1;
      constraints.fill = HORIZONTAL;
      constraints.anchor = WEST;
      constraints.insets = new Insets(0, -650, -50, 150);
      contentLabel = new JLabel();
      String htmlText = "<html><p align=\"right\">All images are obtained from Google.<br>GitHub Hunter is not "
          + "commercially associated with GitHub.<br><br>Created by <b>Holy Lovenia</b>.</p></html>";
      contentLabel.setText(htmlText);
      contentLabel.setFont(ProcessedAsset.openSansItalic.deriveFont(40f));
      layout.setConstraints(contentLabel, constraints);
    }
  }
}
