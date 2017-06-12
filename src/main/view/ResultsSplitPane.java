package main.view;

import java.awt.Dimension;
import javax.swing.JSplitPane;

/**
 * Displays both users and their repositories from search result in a split pane.
 *
 * @author Holy Lovenia - 13515113
 * @version 1.0
 * @since 2017-06-10
 */
public class ResultsSplitPane extends JSplitPane {

  /**
   * Determines width of the split pane.
   */
  private final int resultsSplitPaneWidth = 1800;

  /**
   * Determines height of the split pane.
   */
  private final int resultsSplitPaneHeight = 620;

  /**
   * Determines the location of split pane divider.
   */
  private final int dividerLocation = 600;

  /**
   * Instantiation of <code>SearchResultPane</code>.
   *
   * @see SearchResultPane
   */
  private SearchResultPane searchResultPane;

  /**
   * Instantiation of <code>RepositoriesPane</code>.
   *
   * @see RepositoriesPane
   */
  private RepositoriesPane repositoriesPane;

  /**
   * Constructor.
   *
   * <p>Constructs and prepares the attributes and components needed.</p>
   */
  public ResultsSplitPane() {
    super();
    setOrientation(HORIZONTAL_SPLIT);
    searchResultPane = new SearchResultPane();
    repositoriesPane = new RepositoriesPane();
    setLeftComponent(searchResultPane);
    setRightComponent(repositoriesPane);
    setOneTouchExpandable(false);
    setDividerLocation(dividerLocation);
    setPreferredSize(new Dimension(resultsSplitPaneWidth, resultsSplitPaneHeight));
  }

  /**
   * <p>Specifies last divider location to disable the divider from moving.</p>
   *
   * @return Attribute <code>dividerLocation</code>
   */
  @Override
  public int getLastDividerLocation() {
    return dividerLocation;
  }

  /**
   * <p>Specifies divider location to disable the divider from moving.</p>
   *
   * @return Attribute <code>dividerLocation</code>
   */
  @Override
  public int getDividerLocation() {
    return dividerLocation;
  }

  /**
   * Getter for <code>searchResultPane</code>.
   *
   * @return Attribute <code>searchResultPane</code>
   */
  public SearchResultPane getSearchResultPane() {
    return searchResultPane;
  }

  /**
   * Getter for <code>repositoriesPane</code>.
   *
   * @return Attribute <code>repositoriesPane</code>
   */
  public RepositoriesPane getRepositoriesPane() {
    return repositoriesPane;
  }
}
