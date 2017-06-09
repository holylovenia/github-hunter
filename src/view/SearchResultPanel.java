package view;

import controller.UserController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

/**
 * Created by Holy on 09-Jun-17.
 */
public class SearchResultPanel extends JPanel {

  private final int SEARCH_RESULT_WIDTH = 1800;
  private final int SEARCH_RESULT_HEIGHT = 620;
  private JList usersList;
  private DefaultListModel listModel;


  public SearchResultPanel() {
    setBackground(Color.WHITE);
    setPreferredSize(new Dimension(SEARCH_RESULT_WIDTH, SEARCH_RESULT_HEIGHT));
    listModel = new DefaultListModel();
    usersList = new JList(listModel);
    usersList.setCellRenderer(new SearchResultListRenderer());
    usersList.setVisibleRowCount(36);
    usersList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
    usersList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    JScrollPane jScrollPane = new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
        ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane.setPreferredSize(new Dimension(500, 550));
    jScrollPane.setViewportView(usersList);
    add(jScrollPane, BorderLayout.EAST);
    //add(usersList);
  }

  public static void main(String[] args) {
    //frame.dispose();
  }

  public void updateWithResults(UserController[] users) {
    listModel.clear();
    //userLabels = new SearchResultListRenderer[users.length];
    for (int i = 0; i < users.length; i++) {
      listModel.addElement(users[i]);
      //userLabels[i] = new SearchResultListRenderer(users[i]);
    }
    usersList.setModel(listModel);
    //usersList = new JList(userLabels);
    //add(usersList);
  }

  private class SearchResultListRenderer extends DefaultListCellRenderer {

    private final int AVATAR_WIDTH = 150;
    private final int AVATAR_HEIGHT = 150;
    private Color textSelectionColor = Color.BLACK;
    private Color backgroundSelectionColor = Color.CYAN;
    private Color textNonSelectionColor = Color.BLACK;
    private Color backgroundNonSelectionColor = Color.WHITE;

    public SearchResultListRenderer() {
    }

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
