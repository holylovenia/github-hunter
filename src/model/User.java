package model;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Holy on 31-May-17.
 */
public class User {
    private String username;
    private String email;
    private String fullname;
    private Repository[] repositories;
    private int repositoriesCount;
    private int followers;
    private final String defaultUserUrl = "https://api.github.com/users/";

    public User(String _username) {
        JsonRequest userJson = new JsonRequest(defaultUserUrl + _username);
        JSONObject userJsonObj = new JSONObject(userJson.getRawJson());
        username = userJsonObj.getString("login");
        if(!(userJsonObj.isNull("email") || userJsonObj.get("email").equals(""))) {
            email = userJsonObj.getString("email");
        }
        if(!(userJsonObj.isNull("name") || userJsonObj.get("name").equals(""))) {
            fullname = userJsonObj.getString("name");
        }
        String repositoriesUrl = userJsonObj.getString("repos_url");
        JsonRequest repositoriesJson = new JsonRequest(repositoriesUrl);
        JSONArray repositoriesJsonArray = new JSONArray(repositoriesJson.getRawJson());
        repositoriesCount = repositoriesJsonArray.length();
        String followersUrl = userJsonObj.getString("followers_url");
        JsonRequest followersJson = new JsonRequest(followersUrl);
        JSONArray followersJsonArray = new JSONArray(followersJson.getRawJson());
        followers = followersJsonArray.length();
    }
    public void setUsername(String _username) {
        username = _username;
    }
    public void setEmail(String _email) {
        email = _email;
    }
    public void setFullname(String _fullname) {
        fullname = _fullname;
    }
    public void setRepositories(Repository[] _repositories) {
        repositories = _repositories;
    }
    public void setRepositoriesCount(int _repositoriesCount) {
        repositoriesCount = _repositoriesCount;
    }
    public void setFollowers(int _followers) {
        followers = _followers;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getFullname() {
        return fullname;
    }
    public Repository[] getRepositories() {
        return repositories;
    }
    public int getRepositoriesCount() {
        return repositoriesCount;
    }
    public int getFollowers() {
        return followers;
    }
    public static void main(String[] args) {
        User user = new User("holylovenia");
        System.out.println(user.getUsername());
        System.out.println(user.getEmail());
        System.out.println(user.getFullname());
        System.out.println(user.getRepositoriesCount());
        System.out.println(user.getFollowers());
    }
}
