package controller;

import model.Search;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Scanner;

/**
 * Created by Holy on 01-Jun-17.
 */
public class SearchController {
    private Search search;
    private UserController[] searchResults;

    public SearchController(String _query) {
        search = new Search();
        search.setQuery(_query);
        search.generateSearchUrl();
        setSearchResults();
    }
    public SearchController(String _query, boolean _repoUsed, boolean _followersUsed) {
        search = new Search();
        search.setQuery(_query);
        search.setRepositoriesFilter(_repoUsed);
        search.setFollowersFilter(_followersUsed);
        search.generateSearchUrl();
        setSearchResults();
    }
    public SearchController(String _query, boolean _repoUsed, String _repoBoundOperator, int _repoBoundNumber, boolean _followersUsed) {
        search = new Search();
        search.setQuery(_query);
        search.setRepositoriesFilter(_repoUsed, _repoBoundOperator, _repoBoundNumber);
        search.setFollowersFilter(_followersUsed);
        search.generateSearchUrl();
        setSearchResults();
    }
    public SearchController(String _query, boolean _repoUsed, boolean _followersUsed, String _followersBoundOperator, int _followersBoundNumber) {
        search = new Search();
        search.setQuery(_query);
        search.setRepositoriesFilter(_repoUsed);
        search.setFollowersFilter(_followersUsed, _followersBoundOperator, _followersBoundNumber);
        search.generateSearchUrl();
        setSearchResults();
    }
    public SearchController(String _query, boolean _repoUsed, String _repoBoundOperator, int _repoBoundNumber, boolean _followersUsed, String _followersBoundOperator, int _followersBoundNumber) {
        search = new Search();
        search.setQuery(_query);
        search.setRepositoriesFilter(_repoUsed, _repoBoundOperator, _repoBoundNumber);
        search.setFollowersFilter(_followersUsed, _followersBoundOperator, _followersBoundNumber);
        search.generateSearchUrl();
        setSearchResults();
    }
    public void setSearchResults() {
        JsonRequest searchRequest = new JsonRequest(search.getSearchUrl());
        JSONObject searchJsonObj = new JSONObject(searchRequest.getRawJson());
        JSONArray searchJsonArray = searchJsonObj.getJSONArray("items");
        int totalResults = (int) searchJsonObj.get("total_count");
        int baseSearchUrlLength = search.getSearchUrl().length();
        int pageNumber = 0;
        int count = 1;
        searchResults = new UserController[totalResults];
        while(count <= totalResults) {
            if((count-1) % 30 == 0) {
                pageNumber++;
                search.setSearchUrl(search.getSearchUrl().substring(0, baseSearchUrlLength) + pageNumber);
                searchRequest = new JsonRequest(search.getSearchUrl());
                searchJsonObj = new JSONObject(searchRequest.getRawJson());
                searchJsonArray = searchJsonObj.getJSONArray("items");
                System.out.println(search.getSearchUrl());
            }
            for (int i = 0; i < searchJsonArray.length(); i++) {
                JSONObject result = (JSONObject) searchJsonArray.get(i);
                String username = result.getString("login");
                searchResults[count-1] = new UserController(username);
                count++;
            }
        }
    }
    public UserController[] getSearchResults() {
        return searchResults;
    }
    public UserController getSearchResult(int index) {
        return searchResults[index];
    }
    public static void main(String[] args) {
        SearchController searchController = new SearchController("holy", true, ">", 15, true, "<", 1000);
        System.out.println(searchController.getSearchResults().length + "");
        for(int i = 0; i < searchController.getSearchResults().length; i++) {
            System.out.print(i + " ");
            System.out.println(searchController.getSearchResult(i).getUsername() + " " + searchController.getSearchResult(i).getRepositoriesCount() + " " + searchController.getSearchResult(i).getFollowers());
        }
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        searchController.getSearchResult(input).setRepositories();
        for(int i = 0; i < searchController.getSearchResult(input).getRepositoriesCount(); i++) {
            System.out.println(searchController.getSearchResult(input).getRepository(i).getName());
        }
    }
}
