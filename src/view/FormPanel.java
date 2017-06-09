package view;

import static java.awt.GridBagConstraints.CENTER;
import static java.awt.GridBagConstraints.NONE;
import static java.awt.GridBagConstraints.RELATIVE;
import static java.awt.GridBagConstraints.REMAINDER;
import static java.awt.GridBagConstraints.WEST;
import static java.awt.event.MouseEvent.MOUSE_CLICKED;

import controller.GitHubHunterController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
  private JLabel searchLabel;
  private JLabel keywordLabel;
  private JTextField keywordField;
  private JLabel categoryLabel;
  private JComboBox categoryChoices;
  private JLabel filterLabel;
  private JCheckBox repoCheckbox;
  private JComboBox repoOperatorChoices;
  private JFormattedTextField repoField;
  private JCheckBox followersCheckbox;
  private JComboBox followersOperatorChoices;
  private JFormattedTextField followersField;
  private JButton searchButton;
  public static boolean formFilled;
  private GitHubHunterController controller;

  public FormPanel() {
    setPreferredSize(new Dimension(FORM_WIDTH, FORM_HEIGHT));
    setBackground(Color.WHITE);
    layout = new GridBagLayout();
    setLayout(layout);
    constraints = new GridBagConstraints();
    constraints.anchor = WEST;
    createComponents();
    addComponents();
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

  public void setController(GitHubHunterController _controller) {
    controller = _controller;
  }

  public void createComponents() {
    createSearchText();
    createKeywordText();
    createKeywordField();
    createCategoryText();
    createCategoryChoices();
    createFilterText();
    createFilterRepositoryCheckBox();
    createFilterRepositoryOperator();
    createFilterRepositoryField();
    createFilterFollowersCheckBox();
    createFilterFollowersOperator();
    createFilterFollowersField();
    createSearchButton();
  }

  public void addComponents() {
    add(searchLabel);
    add(keywordLabel);
    add(keywordField);
    add(categoryLabel);
    add(categoryChoices);
    add(filterLabel);
    add(repoCheckbox);
    add(repoOperatorChoices);
    add(repoField);
    add(followersCheckbox);
    add(followersOperatorChoices);
    add(followersField);
    add(searchButton);
  }

  public void createSearchText() {
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.fill = REMAINDER;
    constraints.insets = new Insets(0, 0, 0, 0);
    JLabel searchText = new JLabel("SEARCH", JLabel.LEFT);
    searchText.setForeground(Color.black);
    searchText.setFont(ProcessedAsset.getFont(getClass(), "roboto-black").deriveFont(20f));
    layout.setConstraints(searchText, constraints);
    searchLabel = searchText;
  }

  public void createKeywordText() {
    constraints.gridx = 0;
    constraints.gridy = 1;
    constraints.fill = NONE;
    constraints.insets = new Insets(0, 0, 0, 80);
    JLabel keywordText = new JLabel("Keyword: ", JLabel.LEFT);
    keywordText.setForeground(Color.black);
    keywordText.setFont(ProcessedAsset.getFont(getClass(), "roboto-regular").deriveFont(20f));
    layout.setConstraints(keywordText, constraints);
    keywordLabel = keywordText;
  }

  public void createKeywordField() {
    constraints.gridx = 1;
    constraints.gridy = 1;
    constraints.fill = RELATIVE;
    constraints.insets = new Insets(0, 0, 0, 150);
    JTextField keywordTextField = new JTextField(25);
    keywordTextField.setFont(ProcessedAsset.getFont(getClass(), "opensans-italic").deriveFont(20f));
    layout.setConstraints(keywordTextField, constraints);
    keywordField = keywordTextField;
  }

  public void createCategoryText() {
    constraints.gridx = 2;
    constraints.gridy = 1;
    constraints.fill = RELATIVE;
    constraints.insets = new Insets(0, 50, 0, 100);
    JLabel categoryText = new JLabel("Category: ", JLabel.LEFT);
    categoryText.setForeground(Color.black);
    categoryText.setFont(ProcessedAsset.getFont(getClass(), "roboto-regular").deriveFont(20f));
    layout.setConstraints(categoryText, constraints);
    categoryLabel = categoryText;
  }

  public void createCategoryChoices() {
    constraints.gridx = 3;
    constraints.gridy = 1;
    constraints.fill = REMAINDER;
    constraints.insets = new Insets(0, 0, 0, -150);
    String[] choices = {"All", "Username", "E-mail", "Full name"};
    JComboBox _categoryChoices = new JComboBox(choices);
    DefaultListCellRenderer listCellRenderer = new DefaultListCellRenderer();
    listCellRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);
    _categoryChoices.setRenderer(listCellRenderer);
    _categoryChoices.setPrototypeDisplayValue("123456789012345678901234567890123456");
    _categoryChoices.setFont(ProcessedAsset.getFont(getClass(), "roboto-regular").deriveFont(20f));
    _categoryChoices.setSelectedIndex(0);
    layout.setConstraints(_categoryChoices, constraints);
    categoryChoices = _categoryChoices;
  }

  public void createFilterText() {
    constraints.gridx = 0;
    constraints.gridy = 2;
    constraints.fill = REMAINDER;
    constraints.insets = new Insets(20, 0, 0, 0);
    JLabel filterText = new JLabel("FILTER", JLabel.LEFT);
    filterText.setForeground(Color.black);
    filterText.setFont(ProcessedAsset.getFont(getClass(), "roboto-black").deriveFont(20f));
    layout.setConstraints(filterText, constraints);
    filterLabel = filterText;
  }

  public void createFilterRepositoryCheckBox() {
    constraints.gridx = 0;
    constraints.gridy = 3;
    constraints.fill = NONE;
    constraints.insets = new Insets(0, 0, 0, 0);
    JCheckBox _repoCheckbox = new JCheckBox("Repository: ");
    _repoCheckbox.setFont(ProcessedAsset.getFont(getClass(), "roboto-regular").deriveFont(20f));
    _repoCheckbox.setForeground(Color.BLACK);
    _repoCheckbox.setBackground(Color.WHITE);
    layout.setConstraints(_repoCheckbox, constraints);
    repoCheckbox = _repoCheckbox;
  }

  public void createFilterRepositoryOperator() {
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
    repoOperatorChoices = repoOperators;
  }

  public void createFilterRepositoryField() {
    constraints.gridx = 2;
    constraints.gridy = 3;
    constraints.fill = RELATIVE;
    constraints.insets = new Insets(0, -495, 0, 0);
    JFormattedTextField _repoField = new JFormattedTextField();
    _repoField.setColumns(20);
    int repo = 0;
    _repoField.setValue(new Integer(repo));
    _repoField.setFont(ProcessedAsset.getFont(getClass(), "opensans-italic").deriveFont(20f));
    _repoField.setToolTipText("Fill it with integer, otherwise it will be automatically filled by 0");
    layout.setConstraints(_repoField, constraints);
    repoField = _repoField;
  }

  public void createFilterFollowersCheckBox() {
    constraints.gridx = 3;
    constraints.gridy = 3;
    constraints.fill = RELATIVE;
    constraints.insets = new Insets(0, -190, 0, 0);
    JCheckBox _followersCheckbox = new JCheckBox("Followers: ");
    _followersCheckbox.setFont(ProcessedAsset.getFont(getClass(), "roboto-regular").deriveFont(20f));
    _followersCheckbox.setForeground(Color.BLACK);
    _followersCheckbox.setBackground(Color.WHITE);
    layout.setConstraints(_followersCheckbox, constraints);
    followersCheckbox = _followersCheckbox;
  }

  public void createFilterFollowersOperator() {
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
    followersOperatorChoices = followersOperators;
  }

  public void createFilterFollowersField() {
    constraints.gridx = 5;
    constraints.gridy = 3;
    constraints.fill = REMAINDER;
    constraints.insets = new Insets(0, -190, 0, 0);
    JFormattedTextField _followersField = new JFormattedTextField();
    _followersField.setColumns(20);
    int followers = 0;
    _followersField.setValue(new Integer(followers));
    _followersField.setFont(ProcessedAsset.getFont(getClass(), "opensans-italic").deriveFont(20f));
    _followersField.setToolTipText("Fill it with integer, otherwise it will be automatically filled by 0");
    layout.setConstraints(_followersField, constraints);
    followersField = _followersField;
  }

  public void createSearchButton(){
    constraints.gridx = 0;
    constraints.gridy = 4;
    constraints.fill = REMAINDER;
    constraints.anchor = CENTER;
    constraints.insets = new Insets(30, 0, 0, -1250);
    ImageIcon searchIcon = new ImageIcon(
        ProcessedAsset.getImage(getClass(), "\\assets\\search.png"));
    JButton _searchButton = new JButton(searchIcon);
    _searchButton.setFont(ProcessedAsset.getFont(getClass(), "roboto-regular").deriveFont(20f));
    layout.setConstraints(_searchButton, constraints);
    _searchButton.addActionListener((ActionEvent e) -> {
      if(keywordField.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Error: keyword is missing");
      } else {
        controller.keyword = keywordField.getText();
        controller.type = categoryChoices.getSelectedIndex();
        controller.repoUsed = repoCheckbox.isSelected();
        controller.repoBoundOperator = (String) repoOperatorChoices.getSelectedItem();
        controller.repoBoundNumber = (Integer) repoField.getValue();
        controller.followersUsed = followersCheckbox.isSelected();
        controller.followersBoundOperator = (String) followersOperatorChoices.getSelectedItem();
        controller.followersBoundNumber = (Integer) followersField.getValue();
        controller.searchUsers();
        formFilled = true;
      }
    });
    searchButton = _searchButton;
  }
}
