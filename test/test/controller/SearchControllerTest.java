package test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import main.controller.JsonRequest;
import main.controller.SearchController;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Unit test for <code>SearchController</code> class.
 *
 * @author Holy Lovenia - 13515113
 * @version 1.0
 * @see SearchController
 * @since 2017-06-12
 */
class SearchControllerTest {

  /**
   * Defines URL that is used to retrieve search result.
   */
  private static final String url = "https://api.github.com/search/users?q=holylove";

  /**
   * Instantiation of <code>SearchController</code> class.
   */
  private static SearchController searchController;

  /**
   * Total results found in search.
   */
  private static int totalResults;

  /**
   * Keyword inputted for <code>searchController</code>.
   */
  private final String query = "holylove";

  /**
   * Category inputted for <code>searchController</code>.
   */
  private final int category = 0;

  /**
   * Repository filter usage inputted for <code>searchController</code>.
   */
  private final boolean repoUsed = false;

  /**
   * Repository filter bound operator inputted for <code>searchController</code>.
   */
  private final String repoBoundOperator = ">";

  /**
   * Repository filter bound number inputted for <code>searchController</code>.
   */
  private final int repoBoundNumber = 15;

  /**
   * Followers filter usage inputted for <code>searchController</code>.
   */
  private final boolean followersUsed = false;

  /**
   * Followers filter bound operator inputted for <code>searchController</code>.
   */
  private final String followersBoundOperator = "<";

  /**
   * Followers filter bound number inputted for <code>searchController</code>.
   */
  private final int followersBoundNumber = 1000;

  /**
   * Prepares <code>searchController</code> before the tests are run. JSON data retrieval is
   * performed through GET operation.
   */
  @BeforeAll
  static void setUp() {
    searchController = new SearchController();
    JsonRequest jsonRequest = new JsonRequest(url);
    JSONObject jsonObj = new JSONObject(jsonRequest.getRawJson());
    totalResults = (int) jsonObj.get("total_count");
    if (totalResults > 1000) {
      totalResults = 1000;
    }
  }

  /**
   * Checks if the search results generated through <code>setUpSearchController()</code> method
   * matches the actual total results.
   */
  @Test
  void testSetUpSearchController() {
    searchController
        .setUpSearchController(category, query, repoUsed, repoBoundOperator, repoBoundNumber,
            followersUsed, followersBoundOperator, followersBoundNumber);
    assertEquals(totalResults, searchController.getSearchResults().size(),
        "Total users found in search should be equal");
  }
}