package main.model;

/**
 * Represents GitHub repository.
 *
 * @author Holy Lovenia - 13515113
 * @version 1.0
 * @since 2017-06-01
 */
public class Repository {

  /**
   * Determines the name of repository.
   */
  private String name;

  /**
   * Contains the description of repository.
   */
  private String description;

  /**
   * Contains the HTML URL of repository.
   */
  private String url;

  /**
   * Constructor.
   *
   * <p>Initializes <code>name</code> with <code>null</code>, <code>description</code> with
   * <code>null</code>, and <code>url</code> with <code>null</code>.</p>
   */
  public Repository() {
    name = null;
    description = null;
    url = null;
  }

  /**
   * Getter for <code>name</code>.
   *
   * @return Attribute <code>name</code>.
   */
  public String getName() {
    return name;
  }

  /**
   * Setter for <code>name</code>.
   *
   * <p>Initializes <code>name</code> with <code>name</code>.</p>
   *
   * @param name Determines the name of repository.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for <code>description</code>.
   *
   * @return Attribute <code>description</code>.
   */
  public String getDescription() {
    return description;
  }

  /**
   * Setter for <code>description</code>.
   *
   * <p>Initializes <code>description</code> with <code>description</code>.</p>
   *
   * @param description Contains the description of repository.
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Getter for <code>url</code>.
   *
   * @return Attribute <code>url</code>.
   */
  public String getUrl() {
    return url;
  }

  /**
   * Setter for <code>url</code>.
   *
   * <p>Initializes <code>url</code> with <code>url</code>.</p>
   *
   * @param url Contains the HTML URL of repository.
   */
  public void setUrl(String url) {
    this.url = url;
  }
}
