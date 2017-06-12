package test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Random;
import main.controller.JsonRequest;
import main.model.Search;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Unit test for <code>Search</code> class.
 *
 * @author Holy Lovenia - 13515113
 * @version 1.0
 * @see Search
 * @since 2017-06-12
 */
class SearchTest {

  /**
   * Instantiation of <code>Search</code> class.
   */
  private static Search search;

  /**
   * Instantiation of <code>Random</code> class from <code>java.util</code> library.
   *
   * @see Random
   */
  private static Random randomizer;

  /**
   * Prepares <code>search</code> and fills in the parameters randomly before the tests are run.
   */
  @BeforeAll
  static void setUp() {
    search = new Search();
    randomizer = new Random();
    int keywordLength = randomizer.nextInt(100) + 1;
    String keyword = RandomStringUtils.randomAlphabetic(keywordLength);
    int category = (randomizer.nextInt() + 1) % 4;
    ArrayList<String> operatorChoices = new ArrayList<>(4);
    operatorChoices.add("<");
    operatorChoices.add("<=");
    operatorChoices.add("<");
    operatorChoices.add("<=");
    boolean repoUsed = randomizer.nextBoolean();
    int repoBoundOperatorIndex = randomizer.nextInt(4);
    String repoBoundOperator = operatorChoices.get(repoBoundOperatorIndex);
    int repoBoundNumber = randomizer.nextInt() + 1;
    boolean followersUsed = randomizer.nextBoolean();
    int followersBoundOperatorIndex = randomizer.nextInt(4);
    String followersBoundOperator = operatorChoices.get(followersBoundOperatorIndex);
    int followersBoundNumber = randomizer.nextInt() + 1;
    search.setQuery(keyword);
    search.setCategory(category);
    search.setRepositoriesFilter(repoUsed, repoBoundOperator, repoBoundNumber);
    search.setFollowersFilter(followersUsed, followersBoundOperator, followersBoundNumber);
  }

  /**
   * Tests whether the generated URL is valid or not.
   */
  @Test
  void testGenerateSearchUrl() {
    search.generateSearchUrl();
    JsonRequest request = new JsonRequest(search.getSearchUrl());
    // Response code 200 means the request has succeeded
    assertEquals(200, request.getStatus(), "Search URL should match given"
        + " regular expression");
  }
}