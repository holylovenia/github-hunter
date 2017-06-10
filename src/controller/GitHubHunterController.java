package controller;

import view.DisclaimerScreen;
import view.ProcessedAsset;
import view.SearchScreen;
import view.StartScreen;

/**
 * Main controller for GUI and search data flow.
 *
 * @author Holy Lovenia - 13515113
 * @version 1.0
 * @since 2017-06-10
 */
public class GitHubHunterController {

  /**
   * Keyword from user input.
   */
  public static String keyword;

  /**
   * Category from user input.
   */
  public static int category;

  /**
   * Determined repository filter usage from user input.
   */
  public static boolean repoUsed;

  /**
   * Determined repository filter bound operator from user input.
   */
  public static String repoBoundOperator;

  /**
   * Determined repository filter bound number from user input.
   */
  public static int repoBoundNumber;

  /**
   * Determined followers filter usage from user input.
   */
  public static boolean followersUsed;

  /**
   * Determined followers filter bound operator from user input.
   */
  public static String followersBoundOperator;

  /**
   * Determined followers filter bound number from user input.
   */
  public static int followersBoundNumber;

  /**
   * Instatiation of StartScreen class.
   *
   * @see StartScreen
   */
  private StartScreen startScreen;

  /**
   * Instatiation of DisclaimerScreen class.
   *
   * @see DisclaimerScreen
   */
  private DisclaimerScreen disclaimerScreen;

  /**
   * Instatiation of SearchScreen class.
   *
   * @see SearchScreen
   */
  private SearchScreen searchScreen;

  /**
   * Constructor.
   *
   * <p>Sets <code>ProcessedAsset</code> up as static class. Constructs <code>startScreen</code>,
   * <code>disclaimerScreen</code>, and <code>searchScreen</code>. Displays GUI. Prepares
   * controller.</p>
   */
  public GitHubHunterController() {
    ProcessedAsset processedAsset = new ProcessedAsset();
    startScreen = new StartScreen();
    disclaimerScreen = new DisclaimerScreen();
    searchScreen = new SearchScreen();
    showGraphicUserInterface();
    setUpController();
  }

  /**
   * Organizes the display order and visibility of frames.
   */
  public void showGraphicUserInterface() {
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

  /**
   * Sets controller usage up for other objects.
   */
  public void setUpController() {
    searchScreen.getFormPanel().setController(this);
    searchScreen.getResultsSplitPane().getSearchResultPane()
        .setController(this);
    searchScreen.getResultsSplitPane().getRepositoriesPane()
        .setController(this);
  }

  /**
   * Prepares the search and display the results.
   */
  public void searchUsers() {
    SearchController searchController = new SearchController(category, keyword, repoUsed,
        repoBoundOperator, repoBoundNumber, followersUsed, followersBoundOperator,
        followersBoundNumber);
    searchScreen.getResultsSplitPane().getSearchResultPane()
        .updateResults(SearchController.getSearchResults());
    searchScreen.showResultsCountDialog();
    System.out.println("SELESAI");
  }

  /**
   * Getter for <code>startScreen</code>.
   *
   * @return Attribute <code>startScreen</code>.
   */
  public StartScreen getStartScreen() {
    return startScreen;
  }

  /**
   * Getter for <code>disclaimerScreen</code>.
   *
   * @return Attribute <code>disclaimerScreen</code>.
   */
  public DisclaimerScreen getDisclaimerScreen() {
    return disclaimerScreen;
  }

  /**
   * Getter for <code>searchScreen</code>.
   *
   * @return Attribute <code>searchScreen</code>.
   */
  public SearchScreen getSearchScreen() {
    return searchScreen;
  }
}
