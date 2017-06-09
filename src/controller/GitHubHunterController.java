package controller;

import static java.awt.GridBagConstraints.BOTH;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import view.FormPanel;
import view.SearchResultPanel;

/**
 * Created by Holy on 09-Jun-17.
 */
public class GitHubHunterController {

  public static String keyword;
  public static int type;
  public static boolean repoUsed;
  public static String repoBoundOperator;
  public static int repoBoundNumber;
  public static boolean followersUsed;
  public static String followersBoundOperator;
  public static int followersBoundNumber;
  private FormPanel formPanel;
  private SearchResultPanel searchResultPanel;

  public GitHubHunterController() {
    JFrame frame = new JFrame();
    frame.setTitle("Form");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    GridBagLayout layout = new GridBagLayout();
    frame.setLayout(layout);
    GridBagConstraints constraints = new GridBagConstraints();
    constraints.fill = BOTH;
    formPanel = new FormPanel();
    constraints.gridx = 0;
    constraints.gridy = 0;
    layout.setConstraints(formPanel, constraints);
    frame.add(formPanel);
    searchResultPanel = new SearchResultPanel();
    constraints.gridx = 0;
    constraints.gridy = 1;
    layout.setConstraints(searchResultPanel, constraints);
    frame.add(searchResultPanel);
    frame.pack();
    frame.setVisible(true);
  }

  public void searchUsers() {
    SearchController searchController = new SearchController(type, keyword, repoUsed,
        repoBoundOperator, repoBoundNumber, followersUsed, followersBoundOperator,
        followersBoundNumber);
    searchResultPanel.updateWithResults(searchController.getSearchResults());
    System.out.println("SELESAI");
  }

  public FormPanel getFormPanel() {
    return formPanel;
  }

  public SearchResultPanel getSearchResultPanel() {
    return searchResultPanel;
  }

  public static void main(String[] args) {
    GitHubHunterController controller = new GitHubHunterController();
    controller.getFormPanel().setController(controller);
  }

}
