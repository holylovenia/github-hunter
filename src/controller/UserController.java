package controller;

import java.util.ArrayList;
import model.Repository;
import model.User;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Generates <code>User</code> based on JSON data.
 *
 * @author Holy Lovenia - 13515113
 * @version 1.0
 * @since 2017-06-01
 */
public class UserController {

  /**
   * Base URL used for user JSON request.
   */
  private final String defaultUserUrl = "https://api.github.com/users/";

  /**
   * Instantiation of <code>User</code>.
   *
   * @see User
   */
  private User user;

  /**
   * Built from JSON data specified for the user.
   */
  private JSONObject userJsonObj;

  /**
   * Constructor.
   *
   * <p>Constructs <code>user</code>. Initializes <code>userJsonObj</code> with JSON data retrieved
   * from specified URL. Initializes the attributes (except <code>repositories</code>) of user with
   * JSON data from <code>userJsonObj</code>.</p>
   *
   * @param _username Determines username of the user.
   */
  public UserController(String _username) {
    user = new User();
    JsonRequest userRequest = new JsonRequest(defaultUserUrl + _username);
    userJsonObj = new JSONObject(userRequest.getRawJson());
    initiate(_username);
  }

  /**
   * <p>Initializes the attributes (except <code>repositories</code>) of user with
   * JSON data from <code>userJsonObj</code>.</p>
   *
   * @param _username Determines username of the user.
   */
  public void initiate(String _username) {
    setUsername(_username);
    setAvatarUrl();
    setEmail();
    setFullname();
    setRepositoriesCount();
    setFollowers();
  }

  /**
   * Initializes the avatar URL of user with JSON data from <code>userJsonObj</code>.
   */
  public void setAvatarUrl() {
    if (!(userJsonObj.isNull("avatar_url") || userJsonObj.get("avatar_url").equals(""))) {
      String _avatarUrl = userJsonObj.getString("avatar_url");
      user.setAvatarUrl(_avatarUrl);
    }
  }

  /**
   * Initializes the e-mail of user with JSON data from <code>userJsonObj</code>.
   */
  public void setEmail() {
    if (!(userJsonObj.isNull("email") || userJsonObj.get("email").equals(""))) {
      String _email = userJsonObj.getString("email");
      user.setEmail(_email);
    }
  }

  /**
   * Initializes the full name of user with JSON data from <code>userJsonObj</code>.
   */
  public void setFullname() {
    if (!(userJsonObj.isNull("name") || userJsonObj.get("name").equals(""))) {
      String _fullname = userJsonObj.getString("name");
      user.setFullname(_fullname);
    }
  }

  /**
   * Initializes the repositories of user with JSON data from specified URL.
   */
  public void setRepositories() {
    String repositoriesUrl = defaultUserUrl + getUsername() + "/repos";
    JsonRequest repositoriesRequest = new JsonRequest(repositoriesUrl);
    JSONArray repositoriesJsonArray = new JSONArray(repositoriesRequest.getRawJson());
    ArrayList<Repository> tempRepositories = new ArrayList<>(getRepositoriesCount());
    for (int i = 0; i < getRepositoriesCount(); i++) {
      RepositoryController repoController = new RepositoryController(repositoriesJsonArray, i);
      tempRepositories.add(repoController.getRepository());
    }
    user.setRepositories(tempRepositories);
  }

  /**
   * Initializes the number of repositories of user with JSON data from <code>userJsonObj</code>.
   */
  public void setRepositoriesCount() {
    String repositoriesUrl = userJsonObj.getString("repos_url");
    JsonRequest repositoriesJson = new JsonRequest(repositoriesUrl);
    JSONArray repositoriesJsonArray = new JSONArray(repositoriesJson.getRawJson());
    user.setRepositoriesCount(repositoriesJsonArray.length());
  }

  /**
   * Initializes the number of followers of user with JSON data from <code>userJsonObj</code>.
   */
  public void setFollowers() {
    String followersUrl = userJsonObj.getString("followers_url");
    JsonRequest followersJson = new JsonRequest(followersUrl);
    JSONArray followersJsonArray = new JSONArray(followersJson.getRawJson());
    user.setFollowers(followersJsonArray.length());
  }

  /**
   * Getter for the username from <code>user</code>.
   *
   * @return Getter for <code>username</code>.
   */
  public String getUsername() {
    return user.getUsername();
  }

  /**
   * Initializes username of user with <code>_username</code>.
   *
   * @param _username Determines the username of user.
   */
  public void setUsername(String _username) {
    user.setUsername(_username);
  }

  /**
   * Getter for avatar URL from <code>user</code>.
   *
   * @return Getter for <code>avatarUrl</code>.
   */
  public String getAvatarUrl() {
    return user.getAvatarUrl();
  }

  /**
   * Getter for e-mail from <code>user</code>.
   *
   * @return Getter for <code>email</code>.
   */
  public String getEmail() {
    return user.getEmail();
  }

  /**
   * Getter for full name from <code>user</code>.
   *
   * @return Getter for <code>fullname</code>.
   */
  public String getFullname() {
    return user.getFullname();
  }

  /**
   * Getter for repositories from <code>user</code>.
   *
   * @return Getter for <code>repositories</code>.
   */
  public ArrayList<Repository> getRepositories() {
    return user.getRepositories();
  }

  /**
   * Getter for a certain repository from <code>user</code>.
   *
   * @param index Specified position of the required <code>Repository</code>.
   * @return Getter for <code>repositories</code> with parameter.
   */
  public Repository getRepository(int index) {
    return user.getRepository(index);
  }

  /**
   * Getter for number of repositories from <code>user</code>.
   *
   * @return Getter for <code>repositoriesCount</code>.
   */
  public int getRepositoriesCount() {
    return user.getRepositoriesCount();
  }

  /**
   * Getter for number of followers from <code>user</code>.
   *
   * @return Getter for <code>followers</code>.
   */
  public int getFollowers() {
    return user.getFollowers();
  }
}
