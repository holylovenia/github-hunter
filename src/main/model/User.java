package main.model;

import java.util.ArrayList;

/**
 * Represents GitHub user.
 *
 * @author Holy Lovenia - 13515113
 * @version 1.0
 * @since 2017-05-31
 */
public class User {

  /**
   * Determines the username of user.
   */
  private String username;

  /**
   * Determines the avatar URL of user.
   */
  private String avatarUrl;

  /**
   * Determines the e-mail of user.
   */
  private String email;

  /**
   * Determines the full name of user.
   */
  private String fullname;

  /**
   * Contains the repositories owned by user.
   *
   * @see Repository
   */
  private ArrayList<Repository> repositories;

  /**
   * Determines the number of repositories owned by user.
   */
  private int repositoriesCount;

  /**
   * Determines the number of followers of user.
   */
  private int followers;

  /**
   * Constructor.
   *
   * <p>Initializes <code>username</code> with <code>null</code>, <code>avatarUrl</code> with
   * <code>null</code>, <code>email</code> with <code>null</code>, <code>fullname</code> with
   * <code>null</code>, <code>repositoriesCount</code> with 0, <code>followers</code> with 0, and
   * <code>repositories</code> with <code>null</code>.</p>
   */
  public User() {
    username = null;
    avatarUrl = null;
    email = null;
    fullname = null;
    repositoriesCount = 0;
    followers = 0;
    repositories = null;
  }

  /**
   * Getter for <code>avatarUrl</code>.
   *
   * @return Attribute <code>avatarUrl</code>.
   */
  public String getAvatarUrl() {
    return avatarUrl;
  }

  /**
   * Setter for <code>avatarUrl</code>.
   *
   * <p>Initializes <code>avatarUrl</code> with <code>avatarUrl</code>.</p>
   *
   * @param avatarUrl Determines the avatar URL of user.
   */
  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  /**
   * Getter for <code>username</code>.
   *
   * @return Attribute <code>username</code>.
   */
  public String getUsername() {
    return username;
  }

  /**
   * Setter for <code>username</code>.
   *
   * <p>Initializes <code>username</code> with <code>username</code>.</p>
   *
   * @param username Determines the username of user.
   */
  public void setUsername(String username) {
    this.username = username;
  }

  /**
   * Getter for <code>email</code>.
   *
   * @return Attribute <code>email</code>.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Setter for <code>email</code>.
   *
   * <p>Initializes <code>email</code> with <code>email</code>.</p>
   *
   * @param email Determines the e-mail of user.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Getter for <code>fullname</code>.
   *
   * @return Attribute <code>fullname</code>.
   */
  public String getFullname() {
    return fullname;
  }

  /**
   * Setter for <code>fullname</code>.
   *
   * <p>Initializes <code>fullname</code> with <code>fullname</code>.</p>
   *
   * @param fullname Determines the full name of user.
   */
  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  /**
   * Getter for <code>repositories</code>.
   *
   * @return Attribute <code>repositories</code>.
   */
  public ArrayList<Repository> getRepositories() {
    return repositories;
  }

  /**
   * Setter for <code>repositories</code>.
   *
   * <p>Initializes <code>repositories</code> with <code>repositories</code>.</p>
   *
   * @param repositories Contains the repositories owned by user.
   */
  public void setRepositories(ArrayList<Repository> repositories) {
    this.repositories = repositories;
  }

  /**
   * Getter for <code>repositories</code>.
   *
   * @param index Specifies position of the required <code>Repository</code>.
   * @return <code>Repository</code> at the specified position in <code>repositories</code>.
   */
  public Repository getRepository(int index) {
    return repositories.get(index);
  }

  /**
   * Getter for <code>repositoriesCount</code>.
   *
   * @return Attribute <code>repositoriesCount</code>.
   */
  public int getRepositoriesCount() {
    return repositoriesCount;
  }

  /**
   * Setter for <code>repositoriesCount</code>.
   *
   * <p>Initializes <code>repositoriesCount</code> with <code>repositoriesCount</code>.</p>
   *
   * @param repositoriesCount Determines the number of repositories owned by user.
   */
  public void setRepositoriesCount(int repositoriesCount) {
    this.repositoriesCount = repositoriesCount;
  }

  /**
   * Getter for <code>followers</code>.
   *
   * @return Attribute <code>followers</code>.
   */
  public int getFollowers() {
    return followers;
  }

  /**
   * Setter for <code>followers</code>.
   *
   * <p>Initializes <code>followers</code> with <code>followers</code>.</p>
   *
   * @param followers Determines the number of followers of user.
   */
  public void setFollowers(int followers) {
    this.followers = followers;
  }
}
