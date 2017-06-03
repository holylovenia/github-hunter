package controller;

import model.Repository;
import model.User;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Holy on 01-Jun-17.
 */
public class UserController {

  private final String defaultUserUrl = "https://api.github.com/users/";
  private User user;
  private JSONObject userJsonObj;

  public UserController(String _username) {
    user = new User();
    JsonRequest userRequest = new JsonRequest(defaultUserUrl + _username);
    userJsonObj = new JSONObject(userRequest.getRawJson());
    initiate(_username);
  }

  public static void main(String[] args) {
    UserController user = new UserController("holylovenia");
    System.out.println(user.getUsername());
    System.out.println(user.getEmail());
    System.out.println(user.getFullname());
    System.out.println(user.getRepositoriesCount());
    System.out.println(user.getFollowers());
    user.setRepositories();
    for (int i = 0; i < user.getRepositoriesCount(); i++) {
      System.out.println(user.getRepository(i).getName());
    }
  }

  public void initiate(String _username) {
    setUsername(_username);
    setEmail();
    setFullname();
    setRepositoriesCount();
    setFollowers();
  }

  public void setEmail() {
    if (!(userJsonObj.isNull("email") || userJsonObj.get("email").equals(""))) {
      String _email = userJsonObj.getString("email");
      user.setEmail(_email);
    }
  }

  public void setFullname() {
    if (!(userJsonObj.isNull("name") || userJsonObj.get("name").equals(""))) {
      String _fullname = userJsonObj.getString("name");
      user.setFullname(_fullname);
    }
  }

  public void setRepositories() {
    String repositoriesUrl = defaultUserUrl + getUsername() + "/repos";
    JsonRequest repositoriesRequest = new JsonRequest(repositoriesUrl);
    JSONArray repositoriesJsonArray = new JSONArray(repositoriesRequest.getRawJson());
    Repository[] tempRepositories = new Repository[getRepositoriesCount()];
    for (int i = 0; i < getRepositoriesCount(); i++) {
      RepositoryController repoController = new RepositoryController(repositoriesJsonArray, i);
      tempRepositories[i] = repoController.getRepository();
    }
    user.setRepositories(tempRepositories);
  }

  public void setRepositoriesCount() {
    String repositoriesUrl = userJsonObj.getString("repos_url");
    JsonRequest repositoriesJson = new JsonRequest(repositoriesUrl);
    JSONArray repositoriesJsonArray = new JSONArray(repositoriesJson.getRawJson());
    user.setRepositoriesCount(repositoriesJsonArray.length());
  }

  public void setFollowers() {
    String followersUrl = userJsonObj.getString("followers_url");
    JsonRequest followersJson = new JsonRequest(followersUrl);
    JSONArray followersJsonArray = new JSONArray(followersJson.getRawJson());
    user.setFollowers(followersJsonArray.length());
  }

  public String getUsername() {
    return user.getUsername();
  }

  public void setUsername(String _username) {
    user.setUsername(_username);
  }

  public String getEmail() {
    return user.getEmail();
  }

  public String getFullname() {
    return user.getFullname();
  }

  public Repository getRepository(int index) {
    return user.getRepository(index);
  }

  public int getRepositoriesCount() {
    return user.getRepositoriesCount();
  }

  public int getFollowers() {
    return user.getFollowers();
  }
}
