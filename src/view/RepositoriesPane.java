package view;

import static java.awt.Cursor.HAND_CURSOR;
import static java.awt.Cursor.getDefaultCursor;
import static java.awt.Cursor.getPredefinedCursor;

import controller.GitHubHunterController;
import controller.SearchController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import model.Repository;

/**
 * Displays the repositories of selected user in a pane.
 *
 * @author Holy Lovenia - 13515113
 * @version 1.0
 * @since 2017-06-10
 */
public class RepositoriesPane extends JScrollPane implements MouseListener {

  /**
   * Contains the list of repositories.
   */
  private JList reposList;

  /**
   * Supports <code>reposList</code>.
   */
  private DefaultListModel listModel;

  /**
   * Instantiation of <code>GitHubHunterController</code>.
   *
   * @see GitHubHunterController
   */
  private GitHubHunterController controller;

  /**
   * Constructor.
   *
   * <p>Constructs and prepares the attributes and components needed.</p>
   */
  public RepositoriesPane() {
    super();
    listModel = new DefaultListModel();
    reposList = new JList(listModel);
    reposList.setCellRenderer(new RepositoriesListRenderer());
    reposList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    reposList.addMouseListener(this);
    setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
    setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
    setPreferredSize(new Dimension(1310, 550));
    setViewportView(reposList);
  }

  /**
   * Setter for <code>controller</code>.
   *
   * <p>Initializes <code>controller</code> with <code>_controller</code>.</p>
   *
   * @param _controller Controls GUI and search data flow.
   */
  public void setController(GitHubHunterController _controller) {
    controller = _controller;
  }

  /**
   * <p>Updates <code>reposList</code> according to <code>repositories</code>.</p>
   *
   * @param repositories Requested repositories of a certain user.
   */
  public void updateRepositories(ArrayList<Repository> repositories) {
    listModel.clear();
    if (repositories != null) {
      for (int i = 0; i < repositories.size(); i++) {
        listModel.addElement(repositories.get(i));
      }
    }
    reposList.setModel(listModel);
  }

  /**
   * Mouse event.
   *
   * <p>Directs user to the specified URL using web browser.</p>
   *
   * @param e Mouse clicked event
   */
  @Override
  public void mouseClicked(MouseEvent e) {
    if (e.getClickCount() == 1) {
      int repoSelectedIndex = reposList.locationToIndex(e.getPoint());
      int userSelectedIndex = controller.getSearchScreen().getResultsSplitPane()
          .getSearchResultPane().getUsersList().getSelectedIndex();
      String url = SearchController.getSearchResult(userSelectedIndex)
          .getRepository(repoSelectedIndex).getUrl();
      try {
        Desktop.getDesktop().browse(new URI(url));
      } catch (IOException e1) {
        e1.printStackTrace();
      } catch (URISyntaxException e1) {
        e1.printStackTrace();
      }
    }
  }

  /**
   * Mouse event.
   *
   * @param e Mouse pressed event
   */
  @Override
  public void mousePressed(MouseEvent e) {
  }

  /**
   * Mouse event.
   *
   * @param e Mouse released event
   */
  @Override
  public void mouseReleased(MouseEvent e) {
  }

  /**
   * Mouse event.
   *
   * <p>Sets cursor with a specified icon.</p>
   *
   * @param e Mouse entered event
   */
  @Override
  public void mouseEntered(MouseEvent e) {
    setCursor(getPredefinedCursor(HAND_CURSOR));
  }

  /**
   * Mouse event.
   *
   * <p>Sets cursor with a specified icon.</p>
   *
   * @param e Mouse exited event
   */
  @Override
  public void mouseExited(MouseEvent e) {
    setCursor(getDefaultCursor());
  }

  /**
   * Defines list renderer.
   */
  private class RepositoriesListRenderer extends DefaultListCellRenderer {

    /**
     * Determines text color for the components in list.
     */
    private final Color textColor = Color.BLACK;

    /**
     * Determines background color for the components in list.
     */
    private final Color backgroundColor = Color.WHITE;

    /**
     * Generator for list renderer.
     *
     * <p>Customizes component which would be added to list.</p>
     *
     * @param value Processed component
     * @return Label which contains repository data
     */
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index,
        boolean selected, boolean expanded) {
      JLabel label = new JLabel();
      Repository repo = (Repository) value;
      label.setText(getHtmlText(repo));
      label.setFont(ProcessedAsset.robotoRegular.deriveFont(20f));
      label.setHorizontalAlignment(JLabel.LEFT);
      label.setBorder(BorderFactory.createLoweredSoftBevelBorder());
      label.setForeground(textColor);
      label.setBackground(backgroundColor);
      label.setOpaque(true);
      return label;
    }

    /**
     * Generates HTML text from data contained in <code>repo</code>.
     *
     * @param repo Requested repository
     * @return HTML text
     */
    public String getHtmlText(Repository repo) {
      String htmlText = "<html>";
      htmlText += "<b>" + repo.getName() + "</b><br>";
      htmlText += "<i>" + repo.getDescription() + "</i><br>";
      htmlText += "URL: <a href=\"" + repo.getUrl() + "\" target=\"_blank\">" + repo.getUrl()
          + "</a></html>";
      return htmlText;
    }
  }
}
