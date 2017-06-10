package view;

import static java.awt.GridBagConstraints.CENTER;
import static java.awt.GridBagConstraints.NONE;
import static java.awt.GridBagConstraints.RELATIVE;
import static java.awt.GridBagConstraints.REMAINDER;
import static java.awt.GridBagConstraints.WEST;

import controller.GitHubHunterController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Displays search form for user input in panel.
 *
 * @author Holy Lovenia - 13515113
 * @version 1.0
 * @since 2017-06-09
 */
public class FormPanel extends JPanel {

  /**
   * Determines width of the panel.
   */
  private final int FORM_WIDTH = 1800;

  /**
   * Determines height of the panel.
   */
  private final int FORM_HEIGHT = 280;

  /**
   * Determines text color of the components in panel.
   */
  private final Color foregroundColor = Color.BLACK;

  /**
   * Determines background color of the components in panel.
   */
  private final Color backgroundColor = Color.WHITE;

  /**
   * Manages position of the components.
   */
  private GridBagLayout layout;

  /**
   * Defines regulation of the layout.
   */
  private GridBagConstraints constraints;

  /**
   * Displays search title in label.
   */
  private JLabel searchLabel;

  /**
   * Displays keyword text in label.
   */
  private JLabel keywordLabel;

  /**
   * Displays keyword text field for user input.
   */
  private JTextField keywordField;

  /**
   * Displays category text in label.
   */
  private JLabel categoryLabel;

  /**
   * Displays category choices with a dropdown list.
   */
  private JComboBox categoryChoices;

  /**
   * Displays filter title in label.
   */
  private JLabel filterLabel;

  /**
   * Displays checkbox for repository filter usage.
   */
  private JCheckBox repoCheckbox;

  /**
   * Displays operator choices for repository filter with a dropdown list.
   */
  private JComboBox repoOperatorChoices;

  /**
   * Displays repository filter bound number text field for user input.
   */
  private JFormattedTextField repoField;

  /**
   * Displays checkbox for followers filter usage.
   */
  private JCheckBox followersCheckbox;

  /**
   * Displays operator choices for followers filter with a dropdown list.
   */
  private JComboBox followersOperatorChoices;

  /**
   * Displays followers filter bound number text field for user input.
   */
  private JFormattedTextField followersField;

  /**
   * Receives submit signal from user.
   */
  private JButton searchButton;

  /**
   * Instantiation of <code>GitHubHunterController</code>.
   *
   * @see GitHubHunterController
   */
  private GitHubHunterController controller;

  /**
   * Constructor.
   *
   * <p>Sets size and background. Constructs and prepares <code>layout</code> and
   * <code>constraints</code>. Creates and adds components needed to panel.</p>
   */
  public FormPanel() {
    setPreferredSize(new Dimension(FORM_WIDTH, FORM_HEIGHT));
    setBackground(backgroundColor);
    layout = new GridBagLayout();
    setLayout(layout);
    constraints = new GridBagConstraints();
    constraints.anchor = WEST;
    createComponents();
    addComponents();
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
   * Creates components needed.
   */
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

  /**
   * Adds components needed to panel.
   */
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

  /**
   * Creates and organizes <code>searchLabel</code>.
   */
  public void createSearchText() {
    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.fill = REMAINDER;
    constraints.insets = new Insets(0, 0, 0, 0);
    JLabel searchText = new JLabel("SEARCH", JLabel.LEFT);
    searchText.setForeground(foregroundColor);
    searchText.setFont(ProcessedAsset.robotoBlack.deriveFont(20f));
    layout.setConstraints(searchText, constraints);
    searchLabel = searchText;
  }

  /**
   * Creates and organizes <code>keywordLabel</code>.
   */
  public void createKeywordText() {
    constraints.gridx = 0;
    constraints.gridy = 1;
    constraints.fill = NONE;
    constraints.insets = new Insets(0, 0, 0, 80);
    JLabel keywordText = new JLabel("Keyword: ", JLabel.LEFT);
    keywordText.setForeground(foregroundColor);
    keywordText.setFont(ProcessedAsset.robotoRegular.deriveFont(20f));
    layout.setConstraints(keywordText, constraints);
    keywordLabel = keywordText;
  }

  /**
   * Creates and organizes <code>keywordField</code>.
   */
  public void createKeywordField() {
    constraints.gridx = 1;
    constraints.gridy = 1;
    constraints.fill = RELATIVE;
    constraints.insets = new Insets(0, 0, 0, 150);
    JTextField keywordTextField = new JTextField(25);
    keywordTextField.setFont(ProcessedAsset.openSansItalic.deriveFont(20f));
    layout.setConstraints(keywordTextField, constraints);
    keywordField = keywordTextField;
  }

  /**
   * Creates and organizes <code>categoryLabel</code>.
   */
  public void createCategoryText() {
    constraints.gridx = 2;
    constraints.gridy = 1;
    constraints.fill = RELATIVE;
    constraints.insets = new Insets(0, 50, 0, 100);
    JLabel categoryText = new JLabel("Category: ", JLabel.LEFT);
    categoryText.setForeground(foregroundColor);
    categoryText.setFont(ProcessedAsset.robotoRegular.deriveFont(20f));
    layout.setConstraints(categoryText, constraints);
    categoryLabel = categoryText;
  }

  /**
   * Creates and organizes <code>categoryChoices</code>.
   */
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
    _categoryChoices.setFont(ProcessedAsset.robotoRegular.deriveFont(20f));
    _categoryChoices.setSelectedIndex(0);
    layout.setConstraints(_categoryChoices, constraints);
    categoryChoices = _categoryChoices;
  }

  /**
   * Creates and organizes <code>filterLabel</code>.
   */
  public void createFilterText() {
    constraints.gridx = 0;
    constraints.gridy = 2;
    constraints.fill = REMAINDER;
    constraints.insets = new Insets(20, 0, 0, 0);
    JLabel filterText = new JLabel("FILTER", JLabel.LEFT);
    filterText.setForeground(foregroundColor);
    filterText.setFont(ProcessedAsset.robotoBlack.deriveFont(20f));
    layout.setConstraints(filterText, constraints);
    filterLabel = filterText;
  }

  /**
   * Creates and organizes <code>repoCheckbox</code>.
   */
  public void createFilterRepositoryCheckBox() {
    constraints.gridx = 0;
    constraints.gridy = 3;
    constraints.fill = NONE;
    constraints.insets = new Insets(0, 0, 0, 0);
    JCheckBox _repoCheckbox = new JCheckBox("Repository: ");
    _repoCheckbox.setFont(ProcessedAsset.robotoRegular.deriveFont(20f));
    _repoCheckbox.setForeground(foregroundColor);
    _repoCheckbox.setBackground(backgroundColor);
    layout.setConstraints(_repoCheckbox, constraints);
    repoCheckbox = _repoCheckbox;
  }

  /**
   * Creates and organizes <code>repoOperatorChoices</code>.
   */
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
    repoOperators.setFont(ProcessedAsset.robotoRegular.deriveFont(20f));
    layout.setConstraints(repoOperators, constraints);
    repoOperatorChoices = repoOperators;
  }

  /**
   * Creates and organizes <code>repoField</code>.
   */
  public void createFilterRepositoryField() {
    constraints.gridx = 2;
    constraints.gridy = 3;
    constraints.fill = RELATIVE;
    constraints.insets = new Insets(0, -495, 0, 0);
    JFormattedTextField _repoField = new JFormattedTextField();
    _repoField.setColumns(20);
    int repo = 0;
    _repoField.setValue(new Integer(repo));
    _repoField.setFont(ProcessedAsset.openSansItalic.deriveFont(20f));
    _repoField
        .setToolTipText("Fill it with integer, otherwise it will be automatically filled by 0");
    layout.setConstraints(_repoField, constraints);
    repoField = _repoField;
  }

  /**
   * Creates and organizes <code>followersCheckbox</code>.
   */
  public void createFilterFollowersCheckBox() {
    constraints.gridx = 3;
    constraints.gridy = 3;
    constraints.fill = RELATIVE;
    constraints.insets = new Insets(0, -190, 0, 0);
    JCheckBox _followersCheckbox = new JCheckBox("Followers: ");
    _followersCheckbox.setFont(ProcessedAsset.robotoRegular.deriveFont(20f));
    _followersCheckbox.setForeground(foregroundColor);
    _followersCheckbox.setBackground(backgroundColor);
    layout.setConstraints(_followersCheckbox, constraints);
    followersCheckbox = _followersCheckbox;
  }

  /**
   * Creates and organizes <code>followersOperatorChoices</code>.
   */
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
        .setFont(ProcessedAsset.robotoRegular.deriveFont(20f));
    layout.setConstraints(followersOperators, constraints);
    followersOperatorChoices = followersOperators;
  }

  /**
   * Creates and organizes <code>followersField</code>.
   */
  public void createFilterFollowersField() {
    constraints.gridx = 5;
    constraints.gridy = 3;
    constraints.fill = REMAINDER;
    constraints.insets = new Insets(0, -190, 0, 0);
    JFormattedTextField _followersField = new JFormattedTextField();
    _followersField.setColumns(20);
    int followers = 0;
    _followersField.setValue(new Integer(followers));
    _followersField.setFont(ProcessedAsset.openSansItalic.deriveFont(20f));
    _followersField
        .setToolTipText("Fill it with integer, otherwise it will be automatically filled by 0");
    layout.setConstraints(_followersField, constraints);
    followersField = _followersField;
  }

  /**
   * Creates and organizes <code>searchButton</code>.
   */
  public void createSearchButton() {
    constraints.gridx = 0;
    constraints.gridy = 4;
    constraints.fill = REMAINDER;
    constraints.anchor = CENTER;
    constraints.insets = new Insets(30, 0, 0, -1250);
    ImageIcon searchIcon = new ImageIcon(
        ProcessedAsset.getImage(getClass(), "\\assets\\search.png"));
    JButton _searchButton = new JButton(searchIcon);
    _searchButton.setFont(ProcessedAsset.robotoRegular.deriveFont(20f));
    layout.setConstraints(_searchButton, constraints);
    _searchButton.addActionListener((ActionEvent e) -> {
      if (keywordField.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Error: keyword is missing");
      } else {
        controller.keyword = keywordField.getText();
        controller.category = categoryChoices.getSelectedIndex();
        controller.repoUsed = repoCheckbox.isSelected();
        controller.repoBoundOperator = (String) repoOperatorChoices.getSelectedItem();
        controller.repoBoundNumber = (Integer) repoField.getValue();
        controller.followersUsed = followersCheckbox.isSelected();
        controller.followersBoundOperator = (String) followersOperatorChoices.getSelectedItem();
        controller.followersBoundNumber = (Integer) followersField.getValue();
        controller.searchUsers();
      }
    });
    searchButton = _searchButton;
  }
}
