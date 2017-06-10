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
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import model.Repository;

/**
 * Created by Holy on 09-Jun-17.
 */
public class RepositoriesPane extends JScrollPane implements MouseListener {

  private JList reposList;
  private DefaultListModel listModel;
  private GitHubHunterController controller;

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

  public void setController(GitHubHunterController _controller) {
    controller = _controller;
  }

  public void updateRepositories(Repository[] repositories) {
    listModel.clear();
    if (repositories != null) {
      for (int i = 0; i < repositories.length; i++) {
        listModel.addElement(repositories[i]);
      }
    }
    reposList.setModel(listModel);
  }

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

  public void mouseEntered(MouseEvent e) {
    setCursor(getPredefinedCursor(HAND_CURSOR));
  }

  public void mouseExited(MouseEvent e) {
    setCursor(getDefaultCursor());
  }

  public void mouseReleased(MouseEvent e) {
  }

  public void mousePressed(MouseEvent e) {
  }

  private class RepositoriesListRenderer extends DefaultListCellRenderer {

    private final Color textColor = Color.BLACK;
    private final Color backgroundColor = Color.WHITE;

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
