package view;

import java.awt.Dimension;
import javax.swing.JSplitPane;

/**
 * Created by Holy on 09-Jun-17.
 */
public class ResultsSplitPane extends JSplitPane {
  private final int RESULTS_SPLIT_PANE_WIDTH = 1800;
  private final int RESULTS_SPLIT_PANE_HEIGHT = 620;
  private SearchResultPane searchResultPane;
  private RepositoriesPane repositoriesPane;

  public ResultsSplitPane() {
    super();
    setOrientation(HORIZONTAL_SPLIT);
    searchResultPane = new SearchResultPane();
    repositoriesPane = new RepositoriesPane();
    setLeftComponent(searchResultPane);
    setRightComponent(repositoriesPane);
    setOneTouchExpandable(false);
    setDividerLocation(492);
    setPreferredSize(new Dimension(RESULTS_SPLIT_PANE_WIDTH, RESULTS_SPLIT_PANE_HEIGHT));
  }

  public SearchResultPane getSearchResultPane() {
    return searchResultPane;
  }

  public RepositoriesPane getRepositoriesPane() {
    return repositoriesPane;
  }
}
