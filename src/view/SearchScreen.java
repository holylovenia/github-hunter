package view;

import static java.awt.GridBagConstraints.BOTH;
import static java.awt.GridBagConstraints.NONE;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Created by Holy on 09-Jun-17.
 */
public class SearchScreen extends JFrame {
  private FormPanel formPanel;
  private ResultsSplitPane resultsSplitPane;
  private GridBagLayout layout;
  private GridBagConstraints constraints;

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

  public void createComponents() {
    createFormPanel();
    createResultsSplitPane();
  }

  public void addComponents() {
    add(formPanel);
    add(resultsSplitPane);
  }

  public void createFormPanel() {
    formPanel = new FormPanel();
    constraints.gridx = 0;
    constraints.gridy = 0;
    layout.setConstraints(formPanel, constraints);
  }

  public void createResultsSplitPane() {
    resultsSplitPane = new ResultsSplitPane();
    constraints.gridx = 0;
    constraints.gridy = 1;
    layout.setConstraints(resultsSplitPane, constraints);
  }

  public FormPanel getFormPanel() {
    return formPanel;
  }

  public ResultsSplitPane getResultsSplitPane() {
    return resultsSplitPane;
  }
}
