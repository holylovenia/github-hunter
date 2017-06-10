package view;

import controller.GitHubHunterController;
import controller.SearchController;
import controller.UserController;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
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
 * Created by Holy on 09-Jun-17.
 */
public class SearchResultPane extends JScrollPane implements ListSelectionListener {
  private JList usersList;
  private DefaultListModel listModel;
  private GitHubHunterController controller;

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

  public void valueChanged(ListSelectionEvent e) {
    int selectedIndex = usersList.getSelectedIndex();
    UserController user = SearchController.getSearchResult(selectedIndex);
    if (((user.getRepositories() == null) &&  (user.getRepositoriesCount() > 0)) || ((user.getRepositories() != null) && (user.getRepositories().length != user.getRepositoriesCount()))) {
      user.setRepositories();
    }
    controller.getSearchScreen().getResultsSplitPane().getRepositoriesPane().updateRepositories(user.getRepositories());
  }

  public void setController(GitHubHunterController _controller) {
    controller = _controller;
  }

  public void updateResults(UserController[] users) {
    listModel.clear();
    for (int i = 0; i < users.length; i++) {
      listModel.addElement(users[i]);
    }
    usersList.setModel(listModel);
  }

  public JList getUsersList() {
    return usersList;
  }

  private class SearchResultListRenderer extends DefaultListCellRenderer {

    private final int AVATAR_WIDTH = 150;
    private final int AVATAR_HEIGHT = 150;
    private final Color textSelectionColor = Color.WHITE;
    private final Color backgroundSelectionColor = Color.BLACK;
    private final Color textNonSelectionColor = Color.BLACK;
    private final Color backgroundNonSelectionColor = Color.WHITE;

    public Component getListCellRendererComponent(JList list, Object value, int index,
        boolean selected, boolean expanded) {
      JLabel label = new JLabel();
      UserController user = (UserController) value;
      label.setText(getHtmlText(user));
      label.setFont(ProcessedAsset.getFont(getClass(), "roboto-regular").deriveFont(20f));
      label.setIcon(new ImageIcon(ProcessedAsset
          .getScaledImage(ProcessedAsset.getImage(user.getAvatarUrl()), AVATAR_WIDTH,
              AVATAR_HEIGHT)));
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
