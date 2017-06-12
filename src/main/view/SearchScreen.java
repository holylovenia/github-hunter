package main.view;

import static java.awt.GridBagConstraints.BOTH;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import main.controller.GitHubHunterController;

/**
 * Displays search form and search results in a frame.
 *
 * @author Holy Lovenia - 13515113
 * @version 1.0
 * @since 2017-06-10
 */
public class SearchScreen extends JFrame {

  /**
   * Instantiation of <code>FormPanel</code>.
   *
   * @see FormPanel
   */
  private FormPanel formPanel;

  /**
   * Instantiation of <code>ResultSplitPane</code>.
   *
   * @see ResultsSplitPane
   */
  private ResultsSplitPane resultsSplitPane;

  /**
   * Manages position of the components.
   */
  private GridBagLayout layout;

  /**
   * Defines regulation of the layout.
   */
  private GridBagConstraints constraints;

  /**
   * Instantiation of <code>GitHubHunterController</code>.
   *
   * @see GitHubHunterController
   */
  private GitHubHunterController controller;

  /**
   * Constructor.
   *
   * <p>Sets title, ability to resize, and close operation. Constructs, prepares, and adds
   * components needed.</p>
   */
  public SearchScreen() {
    setTitle("GitHub Hunter");
    setResizable(false);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    layout = new GridBagLayout();
    setLayout(layout);
    constraints = new GridBagConstraints();
    constraints.fill = BOTH;
    createComponents();
    addComponents();
    pack();
  }

  /**
   * Creates components needed.
   */
  public void createComponents() {
    createFormPanel();
    createResultsSplitPane();
  }

  /**
   * Adds components needed to panel.
   */
  public void addComponents() {
    add(formPanel);
    add(resultsSplitPane);
  }

  /**
   * Setter for <code>main.test.controller</code>.
   *
   * <p>Initializes <code>main.test.controller</code> with <code>main.test.controller</code>.</p>
   *
   * @param controller Controls GUI and search data flow.
   */
  public void setController(GitHubHunterController controller) {
    this.controller = controller;
  }

  /**
   * Creates and organizes <code>formPanel</code>.
   */
  public void createFormPanel() {
    formPanel = new FormPanel();
    constraints.gridx = 0;
    constraints.gridy = 0;
    layout.setConstraints(formPanel, constraints);
  }

  /**
   * Creates and organizes <code>resultsSplitPane</code>.
   */
  public void createResultsSplitPane() {
    resultsSplitPane = new ResultsSplitPane();
    constraints.gridx = 0;
    constraints.gridy = 1;
    layout.setConstraints(resultsSplitPane, constraints);
  }

  /**
   * Displays results count using option pane.
   */
  public void showResultsCountDialog() {
    JOptionPane.showMessageDialog(null,
        controller.getSearchController().getSearchResults().size() + " users found",
        "Hunter's preys", JOptionPane.INFORMATION_MESSAGE);
  }

  /**
   * Getter for <code>formPanel</code>.
   *
   * @return Attribute <code>formPanel</code>
   */
  public FormPanel getFormPanel() {
    return formPanel;
  }

  /**
   * Getter for <code>resultsSplitPanel</code>.
   *
   * @return Attribute <code>resultsSplitPanel</code>
   */
  public ResultsSplitPane getResultsSplitPane() {
    return resultsSplitPane;
  }
}
