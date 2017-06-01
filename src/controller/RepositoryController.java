package controller;

import model.Repository;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Holy on 01-Jun-17.
 */
public class RepositoryController {
    private Repository repo;
    private JSONObject repositoryJsonObj;

    public RepositoryController(JSONArray repositoriesJsonArray, int index) {
        repositoryJsonObj = (JSONObject) repositoriesJsonArray.get(index);
        repo = new Repository();
        setName();
        setDescription();
        setUrl();
    }
    public void setName() {
        String _name = repositoryJsonObj.getString("name");
        repo.setName(_name);
    }
    public void setDescription() {
        if(!(repositoryJsonObj.isNull("description") || repositoryJsonObj.getString("description").equals(""))) {
            String _description = repositoryJsonObj.getString("description");
            repo.setDescription(_description);
        }
    }
    public void setUrl() {
        String _url = repositoryJsonObj.getString("html_url");
        repo.setUrl(_url);
    }
    public String getName() {
        return repo.getName();
    }
    public String getDescription() {
        return repo.getDescription();
    }
    public String getUrl() {
        return repo.getUrl();
    }
    public Repository getRepository() {
        return repo;
    }
    public static void main(String[] args) {
        JsonRequest reposRequest = new JsonRequest("https://api.github.com/users/holylovenia/repos");
        JSONArray repositoriesJsonArray = new JSONArray(reposRequest.getRawJson());
        RepositoryController repo = new RepositoryController(repositoriesJsonArray, 1);
        System.out.println(repo.getRepository().getName());
        System.out.println(repo.getRepository().getDescription());
        System.out.println(repo.getRepository().getUrl());
    }
}
