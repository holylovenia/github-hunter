package view;

import static java.awt.GridBagConstraints.BOTH;
import static java.awt.GridBagConstraints.CENTER;
import static java.awt.GridBagConstraints.HORIZONTAL;
import static java.awt.GridBagConstraints.RELATIVE;
import static java.awt.GridBagConstraints.REMAINDER;
import static java.awt.GridBagConstraints.WEST;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


/**
 * Displays disclaimer message in frame.
 *
 * @author Holy Lovenia - 13515113
 * @version 1.0
 * @since 2017-06-10
 */
public class DisclaimerScreen extends JFrame {

  /**
   * Determines width of the screen.
   */
  private final int SCREEN_WIDTH = 1800;

  /**
   * Determines height of the screen.
   */
  private final int SCREEN_HEIGHT = 900;

  /**
   * Instantiation of <code>DisclaimerPanel</code>.
   *
   * @see DisclaimerPanel
   */
  private DisclaimerPanel disclaimerPanel;

  /**
   * Constructor.
   *
   * <p>Sets title, ability to resize, and close operation. Constructs and prepares
   * <code>disclaimerPanel</code>. Adds <code>disclaimerPanel</code> to frame.</p>
   */
  public DisclaimerScreen() {
    setTitle("GitHub Hunter");
    setResizable(false);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    disclaimerPanel = new DisclaimerPanel();
    disclaimerPanel.setUpDisclaimerPanel();
    add(disclaimerPanel);
    pack();
  }

  /**
   * Displays disclaimer message in panel.
   */
  private class DisclaimerPanel extends JPanel {

    /**
     * Manages position of the components.
     */
    private GridBagLayout layout;

    /**
     * Defines regulation of the layout.
     */
    private GridBagConstraints constraints;

    /**
     * Displays disclaimer title in label.
     */
    private JLabel disclaimerLabel;

    /**
     * Displays animated octocat in label.
     */
    private JLabel octocatLabel;

    /**
     * Displays contents of disclaimer in label.
     */
    private JLabel contentLabel;

    /**
     * Prepares components and attributes of the panel.
     */
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

    /**
     * Creates components needed.
     */
    public void createComponents() {
      createDisclaimerText();
      createOctocatLogo();
      createContentLabel();
    }

    /**
     * Adds components needed to panel.
     */
    public void addComponents() {
      add(disclaimerLabel);
      add(octocatLabel);
      add(contentLabel);
    }

    /**
     * Creates and organizes <code>disclaimerLabel</code>.
     */
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

    /**
     * Creates and organizes <code>octocatLabel</code>.
     */
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

    /**
     * Creates and organizes <code>contentLabel</code>.
     */
    public void createContentLabel() {
      constraints.gridx = 1;
      constraints.gridy = 1;
      constraints.fill = HORIZONTAL;
      constraints.anchor = WEST;
      constraints.insets = new Insets(0, -650, -50, 150);
      contentLabel = new JLabel();
      String htmlText =
          "<html><p align=\"right\">All images are obtained from Google.<br>GitHub Hunter is not "
              + "commercially associated with GitHub.<br><br>Created by <b>Holy Lovenia</b>.</p></html>";
      contentLabel.setText(htmlText);
      contentLabel.setFont(ProcessedAsset.openSansItalic.deriveFont(40f));
      layout.setConstraints(contentLabel, constraints);
    }
  }
}
