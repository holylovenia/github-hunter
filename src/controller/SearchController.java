package controller;

import java.util.ArrayList;
import model.Search;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Manages search and generates search result based on JSON data.
 *
 * @author Holy Lovenia - 13515113
 * @version 1.0
 * @since 2017-06-02
 */
public class SearchController {

  /**
   * Contains every user whose identity shows up in search result.
   *
   * @see UserController
   */
  private static ArrayList<UserController> searchResults;

  /**
   * Instantiation of <code>Search</code> class.
   *
   * @see Search
   */
  private Search search;

  /**
   * Constructor.
   *
   * <p>Constructs <code>search</code> and initializes <code>searchResults</code> with null.</p>
   */
  public SearchController() {
    search = new Search();
    searchResults = null;
  }

  /**
   * Getter for <code>searchResults</code>.
   *
   * @return Attribute <code>searchResults</code>.
   */
  public ArrayList<UserController> getSearchResults() {
    return searchResults;
  }

  /**
   * Getter for <code>searchResults</code>.
   *
   * @param index Specifies position of the required <code>searchResults</code>.
   * @return <code>UserController</code> at the specified position in <code>searchResults</code>.
   */
  public static UserController getSearchResult(int index) {
    return searchResults.get(index);
  }

  /**
   * <p>Sets the parameters as the attributes of <code>search</code>. Generates search results.</p>
   *
   * @param category Restricts search into certain fields.
   * @param query Contains keyword used for searching.
   * @param repoUsed Determines whether the repository filter will be used in searching or not.
   * @param repoBoundOperator Determines what mathematical operator used to filter repositories.
   * @param repoBoundNumber Determines limit of the repository filter.
   * @param followersUsed Determines the usage of followers filter in searching.
   * @param followersBoundOperator Determines what mathematical operator used to filter followers.
   * @param followersBoundNumber Determines limit of the followers filter.
   */
  public void setUpSearchController(int category, String query, boolean repoUsed,
      String repoBoundOperator, int repoBoundNumber, boolean followersUsed,
      String followersBoundOperator, int followersBoundNumber) {
    search.setCategory(category);
    search.setQuery(query);
    search.setRepositoriesFilter(repoUsed, repoBoundOperator, repoBoundNumber);
    search.setFollowersFilter(followersUsed, followersBoundOperator, followersBoundNumber);
    search.generateSearchUrl();
    setSearchResults();
  }

  /**
   * Setter for <code>searchResults</code>.
   *
   * <p>Generates <code>searchResults</code> based on JSON data from <code>searchUrl</code> in
   * <code>search</code>.</p>
   */
  public void setSearchResults() {
    if (searchResults != null) {
      searchResults.clear();
    }
    JsonRequest searchRequest = new JsonRequest(search.getSearchUrl());
    JSONObject searchJsonObj = new JSONObject(searchRequest.getRawJson());
    JSONArray searchJsonArray = searchJsonObj.getJSONArray("items");
    int totalResults = (int) searchJsonObj.get("total_count");
    int baseSearchUrlLength = search.getSearchUrl().length();
    int pageNumber = 0;
    int count = 1;
    searchResults = new ArrayList<>(totalResults);
    // Maximum number of results is 1000
    while ((count <= totalResults) && (count <= 1000)) {
      if ((count - 1) % 30 == 0) {
        pageNumber++;
        search.setSearchUrl(search.getSearchUrl().substring(0, baseSearchUrlLength) + pageNumber);
        searchRequest = new JsonRequest(search.getSearchUrl());
        searchJsonObj = new JSONObject(searchRequest.getRawJson());
        searchJsonArray = searchJsonObj.getJSONArray("items");
      }
      for (int i = 0; i < searchJsonArray.length(); i++) {
        JSONObject result = (JSONObject) searchJsonArray.get(i);
        String username = result.getString("login");
        searchResults.add(new UserController(username));
        count++;
      }
    }
  }
}
