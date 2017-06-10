package controller;

import view.DisclaimerScreen;
import view.ProcessedAsset;
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
  private DisclaimerScreen disclaimerScreen;
  private SearchScreen searchScreen;

  public GitHubHunterController() {
    ProcessedAsset processedAsset = new ProcessedAsset();
    startScreen = new StartScreen();
    disclaimerScreen = new DisclaimerScreen();
    searchScreen = new SearchScreen();
    showGitHubHunter();
    setUpController();
  }

  public void showGitHubHunter() {
    startScreen.setVisible(true);
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    disclaimerScreen.setVisible(true);
    startScreen.dispose();
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    searchScreen.setVisible(true);
    disclaimerScreen.dispose();
  }

  public void setUpController() {
    searchScreen.getFormPanel().setController(this);
    searchScreen.getResultsSplitPane().getSearchResultPane()
        .setController(this);
    searchScreen.getResultsSplitPane().getRepositoriesPane()
        .setController(this);
  }

  public void searchUsers() {
    SearchController searchController = new SearchController(type, keyword, repoUsed,
        repoBoundOperator, repoBoundNumber, followersUsed, followersBoundOperator,
        followersBoundNumber);
    searchScreen.getResultsSplitPane().getSearchResultPane()
        .updateResults(SearchController.getSearchResults());
    searchScreen.showResultsCountDialog();
    System.out.println("SELESAI");
  }

  public StartScreen getStartScreen() {
    return startScreen;
  }

  public DisclaimerScreen getDisclaimerScreen() {
    return disclaimerScreen;
  }

  public SearchScreen getSearchScreen() {
    return searchScreen;
  }

}
