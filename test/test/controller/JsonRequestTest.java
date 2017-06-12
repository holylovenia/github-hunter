package test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import main.controller.JsonRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Unit test for <code>JsonRequest</code> class.
 *
 * @author Holy Lovenia - 13515113
 * @version 1.0
 * @see JsonRequest
 * @since 2017-06-12
 */
class JsonRequestTest {

  /**
   * Defines URL that is used to retrieve JSON data.
   */
  private final static String url = "https://api.github.com/users/holylovenia";

  /**
   * Instantiation of <code>JsonRequest</code> class.
   */
  private static JsonRequest jsonRequest;

  /**
   * Actual JSON data.
   */
  private final String expectedRawJson = "{\"login\":\"holylovenia\",\"id\":25114282,"
      + "\"avatar_url\":\"https://avatars1.githubusercontent.com/u/25114282?v=3\",\"gravatar_id\""
      + ":\"\",\"url\":\"https://api.github.com/users/holylovenia\",\"html_url\":\"https://git"
      + "hub.com/holylovenia\",\"followers_url\":\"https://api.github.com/users/holylovenia/f"
      + "ollowers\",\"following_url\":\"https://api.github.com/users/holylovenia/following{/oth"
      + "er_user}\",\"gists_url\":\"https://api.github.com/users/holylovenia/gists{/gist_id}\""
      + ",\"starred_url\":\"https://api.github.com/users/holylovenia/starred{/owner}{/repo}\","
      + "\"subscriptions_url\":\"https://api.github.com/users/holylovenia/subscriptions\",\"or"
      + "ganizations_url\":\"https://api.github.com/users/holylovenia/orgs\",\"repos_url\":\"ht"
      + "tps://api.github.com/users/holylovenia/repos\",\"events_url\":\"https://api.github.com"
      + "/users/holylovenia/events{/privacy}\",\"received_events_url\":\"https://api.github.com"
      + "/users/holylovenia/received_events\",\"type\":\"User\",\"site_admin\":false,\"name\":\""
      + "Holy Lovenia\",\"company\":null,\"blog\":\"\",\"location\":null,\"email\":\"holy.loveni"
      + "a@gmail.com\",\"hireable\":null,\"bio\":null,\"public_repos\":11,\"public_gists\":0,\"f"
      + "ollowers\":4,\"following\":4,\"created_at\":\"2017-01-14T04:29:02Z\",\"updated_at\":\"2"
      + "017-05-26T02:51:07Z\",\"private_gists\":0,\"total_private_repos\":3,\"owned_private_rep"
      + "os\":3,\"disk_usage\":146019,\"collaborators\":0,\"two_factor_authentication\":false,\""
      + "plan\":{\"name\":\"developer\",\"space\":976562499,\"collaborators\":0,\"private_repos\""
      + ":9999}}";

  /**
   * Prepares <code>jsonRequest</code> before the tests are run. JSON data retrieval is performed
   * through GET operation.
   */
  @BeforeAll
  static void setUp() {
    jsonRequest = new JsonRequest(url);
  }

  /**
   * Tests if retrieved JSON data matches the actual data.
   */
  @Test
  void testGenerateJson() {
    assertEquals(expectedRawJson, jsonRequest.getRawJson(), "JSON data mismatch");
  }
}