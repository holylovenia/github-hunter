package model;

/**
 * Created by Holy on 31-May-17.
 */
public class User {

  private String username;
  private String avatarUrl;
  private String email;
  private String fullname;
  private Repository[] repositories;
  private int repositoriesCount;
  private int followers;

  public User() {
    username = null;
    avatarUrl = null;
    email = null;
    fullname = null;
    repositoriesCount = 0;
    followers = 0;
    repositories = null;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String _avatarUrl) {
    avatarUrl = _avatarUrl;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String _username) {
    username = _username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String _email) {
    email = _email;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String _fullname) {
    fullname = _fullname;
  }

  public Repository getRepository(int index) {
    return repositories[index];
  }

  public void setRepositories(Repository[] _repositories) {
    repositories = _repositories;
  }

  public int getRepositoriesCount() {
    return repositoriesCount;
  }

  public void setRepositoriesCount(int _repositoriesCount) {
    repositoriesCount = _repositoriesCount;
  }

  public int getFollowers() {
    return followers;
  }

  public void setFollowers(int _followers) {
    followers = _followers;
  }
}
