package controller;

import static java.awt.GridBagConstraints.NONE;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import view.FormPanel;
import view.RepositoriesPane;
import view.ResultsSplitPane;
import view.SearchResultPane;
import view.SearchScreen;
import view.StartScreen;

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
  private StartScreen startScreen;
  private SearchScreen searchScreen;

  public GitHubHunterController() {
    startScreen = new StartScreen();
    searchScreen = new SearchScreen();
  }

  public void searchUsers() {
    SearchController searchController = new SearchController(type, keyword, repoUsed,
        repoBoundOperator, repoBoundNumber, followersUsed, followersBoundOperator,
        followersBoundNumber);
    searchScreen.getResultsSplitPane().getSearchResultPane().updateResults(searchController.getSearchResults());
    searchScreen.showResultsCountDialog();
    System.out.println("SELESAI");
  }

  public StartScreen getStartScreen() {
    return startScreen;
  }

  public SearchScreen getSearchScreen() {
    return searchScreen;
  }

  public static void main(String[] args) {
    GitHubHunterController controller = new GitHubHunterController();
    controller.getStartScreen().setVisible(true);
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    controller.getStartScreen().dispose();
    controller.getSearchScreen().setVisible(true);
    controller.getSearchScreen().getFormPanel().setController(controller);
    controller.getSearchScreen().getResultsSplitPane().getSearchResultPane().setController(controller);
    controller.getSearchScreen().getResultsSplitPane().getRepositoriesPane().setController(controller);
  }

}
