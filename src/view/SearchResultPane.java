package view;

import controller.GitHubHunterController;
import controller.SearchController;
import controller.UserController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Displays users from search result in a pane.
 *
 * @author Holy Lovenia - 13515113
 * @version 1.0
 * @since 2017-06-09
 */
public class SearchResultPane extends JScrollPane implements ListSelectionListener {

  /**
   * Contains the list of users.
   */
  private JList usersList;

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
  public SearchResultPane() {
    super();
    listModel = new DefaultListModel();
    usersList = new JList(listModel);
    usersList.setCellRenderer(new SearchResultListRenderer());
    usersList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    usersList.addListSelectionListener(this);
    setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
    setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
    setPreferredSize(new Dimension(490, 550));
    setViewportView(usersList);
  }

  /**
   * List selection event.
   *
   * <p>Displays repositories of the selected user in <code>RepositoriesPane</code>.</p>
   *
   * @param e List selected event
   */
  @Override
  public void valueChanged(ListSelectionEvent e) {
    int selectedIndex = usersList.getSelectedIndex();
    if (selectedIndex == -1) {
      usersList.setSelectedIndex(0);
      selectedIndex = 0;
    }
    UserController user = SearchController.getSearchResult(selectedIndex);
    if (((user.getRepositories() == null) && (user.getRepositoriesCount() > 0)) || (
        (user.getRepositories() != null) && (user.getRepositories().size() != user
            .getRepositoriesCount()))) {
      user.setRepositories();
    }
    controller.getSearchScreen().getResultsSplitPane().getRepositoriesPane()
        .updateRepositories(user.getRepositories());
  }

  /**
   * Setter for <code>controller</code>.
   *
   * <p>Initializes <code>controller</code> with <code>controller</code>.</p>
   *
   * @param controller Controls GUI and search data flow.
   */
  public void setController(GitHubHunterController controller) {
    this.controller = controller;
  }

  /**
   * <p>Updates <code>usersList</code> according to <code>users</code>.</p>
   *
   * @param users Requested users from search result.
   */
  public void updateResults(ArrayList<UserController> users) {
    listModel.clear();
    for (int i = 0; i < users.size(); i++) {
      listModel.addElement(users.get(i));
    }
    usersList.setModel(listModel);
  }

  /**
   * Getter for <code>usersList</code>.
   *
   * @return Attribute <code>usersList</code>
   */
  public JList getUsersList() {
    return usersList;
  }

  /**
   * Defines list renderer.
   */
  private class SearchResultListRenderer extends DefaultListCellRenderer {

    /**
     * Determines user avatar width.
     */
    private final int avatarWidth = 150;

    /**
     * Determines user avatar height.
     */
    private final int avatarHeight = 150;

    /**
     * Determines the text color when selected.
     */
    private final Color textSelectionColor = Color.WHITE;

    /**
     * Determines the background color when selected.
     */
    private final Color backgroundSelectionColor = Color.BLACK;

    /**
     * Determines the text color when not selected.
     */
    private final Color textNonSelectionColor = Color.BLACK;

    /**
     * Determines the backgroud color when not selected.
     */
    private final Color backgroundNonSelectionColor = Color.WHITE;

    /**
     * Generator for list renderer.
     *
     * <p>Customizes component which would be added to list.</p>
     *
     * @param value Processed component
     * @param selected Whether the component is selected or not
     * @return Label which contains user data
     */
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index,
        boolean selected, boolean expanded) {
      JLabel label = new JLabel();
      UserController user = (UserController) value;
      label.setText(getHtmlText(user));
      label.setFont(ProcessedAsset.robotoRegular.deriveFont(20f));
      label.setIcon(new ImageIcon(ProcessedAsset
          .getScaledImage(ProcessedAsset.getImage(user.getAvatarUrl()), avatarWidth,
              avatarHeight)));
      label.setHorizontalAlignment(JLabel.LEFT);
      label.setBorder(BorderFactory.createLoweredSoftBevelBorder());
      if (selected) {
        label.setBackground(backgroundSelectionColor);
        label.setForeground(textSelectionColor);
      } else {
        label.setBackground(backgroundNonSelectionColor);
        label.setForeground(textNonSelectionColor);
      }
      label.setOpaque(true);
      return label;
    }

    /**
     * Generates HTML text from data contained in <code>user</code>.
     *
     * @param user Requested user
     * @return HTML text
     */
    public String getHtmlText(UserController user) {
      String htmlText = "<html>";
      htmlText += "Username: <b>" + user.getUsername() + "</b><br>";
      htmlText += "Full name: " + user.getFullname() + "<br>";
      htmlText += "E-mail: " + user.getEmail() + "<br>";
      htmlText += "Repositories: " + user.getRepositoriesCount() + "<br>";
      htmlText += "Followers: " + user.getFollowers() + "</html>";
      return htmlText;
    }
  }
}
