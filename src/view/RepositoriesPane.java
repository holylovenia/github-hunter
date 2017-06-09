package view;

import controller.UserController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import model.Repository;

/**
 * Created by Holy on 09-Jun-17.
 */
public class RepositoriesPane extends JScrollPane {
  private JList reposList;
  private DefaultListModel listModel;

  public RepositoriesPane() {
    super();
    listModel = new DefaultListModel();
    reposList = new JList(listModel);
    reposList.setCellRenderer(new RepositoriesListRenderer());
    reposList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS);
    setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
    setPreferredSize(new Dimension(1310, 550));
    setViewportView(reposList);
  }

  public void updateRepositories(Repository[] repositories) {
    listModel.clear();
    if(repositories != null) {
      for (int i = 0; i < repositories.length; i++) {
        listModel.addElement(repositories[i]);
      }
    }
    reposList.setModel(listModel);
  }

  private class RepositoriesListRenderer extends DefaultListCellRenderer {

    private final Color textColor = Color.BLACK;
    private final Color backgroundColor = Color.WHITE;

    public Component getListCellRendererComponent(JList list, Object value, int index,
        boolean selected, boolean expanded) {
      JLabel label = new JLabel();
      Repository repo = (Repository) value;
      label.setText(getHtmlText(repo));
      label.setFont(ProcessedAsset.getFont(getClass(), "roboto-regular").deriveFont(20f));
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
