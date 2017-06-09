package view;

import static java.awt.GridBagConstraints.CENTER;
import static java.awt.GridBagConstraints.EAST;
import static java.awt.GridBagConstraints.NONE;
import static java.awt.GridBagConstraints.RELATIVE;
import static java.awt.GridBagConstraints.REMAINDER;
import static java.awt.GridBagConstraints.WEST;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * Created by Holy on 08-Jun-17.
 */
public class FormPanel extends JPanel {

  private final int FORM_WIDTH = 1800;
  private final int FORM_HEIGHT = 280;
  private GridBagLayout layout;
  private GridBagConstraints constraints;

  public FormPanel() {
    setPreferredSize(new Dimension(FORM_WIDTH, FORM_HEIGHT));
    setBackground(Color.WHITE);
    layout = new GridBagLayout();
    setLayout(layout);
    constraints = new GridBagConstraints();
    constraints.fill = GridBagConstraints.BOTH;
    constraints.anchor = WEST;
    add(createSearchText());
    add(createKeywordText());
    add(createKeywordField());
    add(createCategoryText());
    add(createCategoryChoices());
    add(createFilterText());
    add(createFilterRepositoryCheckBox());
    add(createFilterRepositoryOperator());
    add(createFilterRepositoryField());
    add(createFilterFollowersCheckBox());
    add(createFilterFollowersOperator());
    add(createFilterFollowersField());
    add(createSearchButton());
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setTitle("Form");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    FormPanel formPanel = new FormPanel();
    frame.add(formPanel);
    frame.pack();
    frame.setVisible(true);
  }

  public JLabel createSearchText() {
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.fill = REMAINDER;
    constraints.insets = new Insets(0, 0, 0, 0);
    JLabel searchText = new JLabel("SEARCH", JLabel.LEFT);
    searchText.setForeground(Color.black);
    searchText.setFont(ProcessedAsset.getFont(getClass(), "roboto-black").deriveFont(20f));
    layout.setConstraints(searchText, constraints);
    return searchText;
  }

  public JLabel createKeywordText() {
    constraints.gridx = 0;
    constraints.gridy = 1;
    constraints.fill = NONE;
    constraints.insets = new Insets(0, 0, 0, 80);
    JLabel keywordText = new JLabel("Keyword: ", JLabel.LEFT);
    keywordText.setForeground(Color.black);
    keywordText.setFont(ProcessedAsset.getFont(getClass(), "roboto-regular").deriveFont(20f));
    layout.setConstraints(keywordText, constraints);
    return keywordText;
  }

  public JTextField createKeywordField() {
    constraints.gridx = 1;
    constraints.gridy = 1;
    constraints.fill = RELATIVE;
    constraints.insets = new Insets(0, 0, 0, 150);
    JTextField keywordField = new JTextField(25);
    keywordField.setFont(ProcessedAsset.getFont(getClass(), "opensans-italic").deriveFont(20f));
    layout.setConstraints(keywordField, constraints);
    return keywordField;
  }

  public JLabel createCategoryText() {
    constraints.gridx = 2;
    constraints.gridy = 1;
    constraints.fill = RELATIVE;
    constraints.insets = new Insets(0, 50, 0, 100);
    JLabel categoryText = new JLabel("Category: ", JLabel.LEFT);
    categoryText.setForeground(Color.black);
    categoryText.setFont(ProcessedAsset.getFont(getClass(), "roboto-regular").deriveFont(20f));
    layout.setConstraints(categoryText, constraints);
    return categoryText;
  }

  public JComboBox createCategoryChoices() {
    constraints.gridx = 3;
    constraints.gridy = 1;
    constraints.fill = REMAINDER;
    constraints.insets = new Insets(0, 0, 0, -150);
    String[] choices = {"Username", "E-mail", "Full name", "All"};
    JComboBox categoryChoices = new JComboBox(choices);
    DefaultListCellRenderer listCellRenderer = new DefaultListCellRenderer();
    listCellRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
    categoryChoices.setRenderer(listCellRenderer);
    categoryChoices.setPrototypeDisplayValue("123456789012345678901234567890123456");
    categoryChoices.setFont(ProcessedAsset.getFont(getClass(), "roboto-regular").deriveFont(20f));
    categoryChoices.setSelectedIndex(3);
    layout.setConstraints(categoryChoices, constraints);
    return categoryChoices;
  }

  public JLabel createFilterText() {
    constraints.gridx = 0;
    constraints.gridy = 2;
    constraints.fill = REMAINDER;
    constraints.insets = new Insets(20, 0, 0, 0);
    JLabel filterText = new JLabel("FILTER", JLabel.LEFT);
    filterText.setForeground(Color.black);
    filterText.setFont(ProcessedAsset.getFont(getClass(), "roboto-black").deriveFont(20f));
    layout.setConstraints(filterText, constraints);
    return filterText;
  }

  public JCheckBox createFilterRepositoryCheckBox() {
    constraints.gridx = 0;
    constraints.gridy = 3;
    constraints.fill = NONE;
    constraints.insets = new Insets(0, 0, 0, 0);
    JCheckBox repoCheckBox = new JCheckBox("Repository: ");
    repoCheckBox.setFont(ProcessedAsset.getFont(getClass(), "roboto-regular").deriveFont(20f));
    repoCheckBox.setForeground(Color.BLACK);
    repoCheckBox.setBackground(Color.WHITE);
    layout.setConstraints(repoCheckBox, constraints);
    return repoCheckBox;
  }

  public JComboBox createFilterRepositoryOperator() {
    constraints.gridx = 1;
    constraints.gridy = 3;
    constraints.fill = RELATIVE;
    constraints.insets = new Insets(0, 0, 0, 0);
    String[] operators = {"<", "<=", ">", ">="};
    JComboBox repoOperators = new JComboBox(operators);
    DefaultListCellRenderer listCellRenderer = new DefaultListCellRenderer();
    listCellRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
    repoOperators.setRenderer(listCellRenderer);
    repoOperators.setPrototypeDisplayValue("123");
    repoOperators.setFont(ProcessedAsset.getFont(getClass(), "roboto-regular").deriveFont(20f));
    layout.setConstraints(repoOperators, constraints);
    return repoOperators;
  }

  public JFormattedTextField createFilterRepositoryField() {
    constraints.gridx = 2;
    constraints.gridy = 3;
    constraints.fill = RELATIVE;
    constraints.insets = new Insets(0, -495, 0, 0);
    JFormattedTextField repoField = new JFormattedTextField();
    repoField.setColumns(20);
    int repo = 0;
    repoField.setValue(new Integer(repo));
    repoField.setFont(ProcessedAsset.getFont(getClass(), "opensans-italic").deriveFont(20f));
    layout.setConstraints(repoField, constraints);
    return repoField;
  }

  public JCheckBox createFilterFollowersCheckBox() {
    constraints.gridx = 3;
    constraints.gridy = 3;
    constraints.fill = RELATIVE;
    constraints.insets = new Insets(0, -190, 0, 0);
    JCheckBox followersCheckBox = new JCheckBox("Followers: ");
    followersCheckBox.setFont(ProcessedAsset.getFont(getClass(), "roboto-regular").deriveFont(20f));
    followersCheckBox.setForeground(Color.BLACK);
    followersCheckBox.setBackground(Color.WHITE);
    layout.setConstraints(followersCheckBox, constraints);
    return followersCheckBox;
  }

  public JComboBox createFilterFollowersOperator() {
    constraints.gridx = 4;
    constraints.gridy = 3;
    constraints.fill = RELATIVE;
    constraints.insets = new Insets(0, -275, 0, 0);
    String[] operators = {"<", "<=", ">", ">="};
    JComboBox followersOperators = new JComboBox(operators);
    DefaultListCellRenderer listCellRenderer = new DefaultListCellRenderer();
    listCellRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
    followersOperators.setRenderer(listCellRenderer);
    followersOperators.setPrototypeDisplayValue("123");
    followersOperators.setSize(20, followersOperators.getPreferredSize().height);
    followersOperators
        .setFont(ProcessedAsset.getFont(getClass(), "roboto-regular").deriveFont(20f));
    layout.setConstraints(followersOperators, constraints);
    return followersOperators;
  }

  public JFormattedTextField createFilterFollowersField() {
    constraints.gridx = 5;
    constraints.gridy = 3;
    constraints.fill = REMAINDER;
    constraints.insets = new Insets(0, -190, 0, 0);
    JFormattedTextField followersField = new JFormattedTextField();
    followersField.setColumns(20);
    int followers = 0;
    followersField.setValue(new Integer(followers));
    followersField.setFont(ProcessedAsset.getFont(getClass(), "opensans-italic").deriveFont(20f));
    layout.setConstraints(followersField, constraints);
    return followersField;
  }

  public JButton createSearchButton() {
    constraints.gridx = 0;
    constraints.gridy = 4;
    constraints.fill = REMAINDER;
    constraints.anchor = CENTER;
    constraints.insets = new Insets(30, 0, 0, -1250);
    ImageIcon searchIcon = new ImageIcon(ProcessedAsset.getImage(getClass(), "\\assets\\search.png"));
    JButton searchButton = new JButton(searchIcon);
    searchButton.setFont(ProcessedAsset.getFont(getClass(), "roboto-regular").deriveFont(20f));
    layout.setConstraints(searchButton, constraints);
    return searchButton;
  }
}
