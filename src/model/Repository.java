package model;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Holy on 31-May-17.
 */
public class Repository {
    private String username;
    private String name;
    private String description;
    private String url;

    public Repository(String repositoriesJson, int index) {
        JSONArray repositoriesJsonArray = new JSONArray(repositoriesJson);
        JSONObject repositoryJsonObj = (JSONObject) repositoriesJsonArray.get(index);
        username = repositoryJsonObj.getJSONObject("owner").getString("login");
        name = repositoryJsonObj.getString("name");
        url = repositoryJsonObj.getString("html_url");
    }
    public void setUsername(String _username) {
        username = _username;
    }
    public void setName(String _name) {
        name = _name;
    }
    public void setDescription(String _description) {
        description = _description;
    }
    public void setUrl(String _url) {
        url = _url;
    }
    public String getUsername() {
        return username;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getUrl() {
        return url;
    }
    public static void main(String[] args) {
        JsonRequest reposRequest = new JsonRequest("https://api.github.com/users/holylovenia/repos");
        Repository repo = new Repository(reposRequest.getRawJson(), 1);
        System.out.println(repo.getUsername());
    }
}
