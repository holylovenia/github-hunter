package main.model;

/**
 * Represents GitHub user search.
 *
 * @author Holy Lovenia - 13515113
 * @version 1.0
 * @since 2017-06-01
 */
public class Search {

  /**
   * Determines the base URL used for searching with GitHub API.
   */
  private final String defaultSearchUrl = "https://api.github.com/search/users?q=";

  /**
   * Restricts search into certain fields.
   * 0: All.
   * 1: Username.
   * 2: E-mail.
   * 3: Full name.
   */
  private int category;

  /**
   * Contains keyword used for searching.
   */
  private String query;

  /**
   * Determines filter regulation for number of repositories in searching.
   *
   * @see Filter
   */
  private Filter repositoriesFilter;

  /**
   * Determines filter regulation for number of followers in searching.
   *
   * @see Filter
   */
  private Filter followersFilter;

  /**
   * Determines URL used for searching with GitHub API.
   */
  private String searchUrl;

  /**
   * Constructor.
   *
   * <p>Initializes <code>category</code> with 0, <code>query</code> with <code>null</code>, and
   * <code>searchUrl</code> with <code>null</code>. Constructs <code>repositoriesFilter</code> and
   * <code>followersFilter</code>.</p>
   */
  public Search() {
    category = 0;
    query = null;
    repositoriesFilter = new Filter();
    followersFilter = new Filter();
    searchUrl = null;
  }

  /**
   * Setter for repository filter.
   *
   * <p>Initializes <code>used</code> with <code>used</code>, <code>boundOperator</code> with
   * <code>boundOperator</code>, and <code>boundNumber</code> with <code>boundNumber</code>.</p>
   *
   * @param used Determines whether the repository filter will be used in searching or not.
   * @param boundOperator Determines what mathematical operator used to filter repositories.
   * @param boundNumber Determines limit of the repository filter.
   */
  public void setRepositoriesFilter(boolean used, String boundOperator, int boundNumber) {
    repositoriesFilter.setFilter(used, boundOperator, boundNumber);
  }

  /**
   * Setter for followers filter.
   *
   * <p>Initializes <code>used</code> with <code>used</code>, <code>boundOperator</code> with
   * <code>boundOperator</code>, and <code>boundNumber</code> with <code>boundNumber</code>.</p>
   *
   * @param used Determines whether the followers filter will be used in searching or not.
   * @param boundOperator Determines what mathematical operator used to filter followers.
   * @param boundNumber Determines limit of the followers filter.
   */
  public void setFollowersFilter(boolean used, String boundOperator, int boundNumber) {
    followersFilter.setFilter(used, boundOperator, boundNumber);
  }

  /**
   * Generates <code>searchUrl</code> according to search qualifiers as parameters.
   */
  public void generateSearchUrl() {
    String processedQueryUrl = query.trim().replace(" ", "+");
    searchUrl = defaultSearchUrl + processedQueryUrl;
    if (getRepositoriesFilter().getUsed()) {
      String processedRepositoriesFilterUrl =
          "+repos:" + getRepositoriesFilter().getBoundOperator() + getRepositoriesFilter()
              .getBoundNumber();
      searchUrl += processedRepositoriesFilterUrl;
    }
    if (getFollowersFilter().getUsed()) {
      String processedFollowersFilterUrl =
          "+followers:" + getFollowersFilter().getBoundOperator() + getFollowersFilter()
              .getBoundNumber();
      searchUrl += processedFollowersFilterUrl;
    }
    switch (category) {
      case 1:
        searchUrl += "+in:login";
        break;
      case 2:
        searchUrl += "+in:email";
        break;
      case 3:
        searchUrl += "+in:fullname";
        break;
      default:
        break;
    }
    searchUrl += "&page=";
  }

  /**
   * Getter for <code>category</code>.
   *
   * @return Attribute <code>category</code>.
   */
  public int getCategory() {
    return category;
  }

  /**
   * Setter for <code>category</code>.
   *
   * <p>Initializes <code>category</code> with <code>category</code>.</p>
   *
   * @param category Restricts search into certain fields.
   */
  public void setCategory(int category) {
    if ((category > 0) && (category <= 3)) {
      this.category = category;
    } else {
      this.category = 0;
    }
  }

  /**
   * Getter for <code>query</code>.
   *
   * @return Attribute <code>query</code>.
   */
  public String getQuery() {
    return query;
  }

  /**
   * Setter for <code>query</code>.
   *
   * <p>Initializes <code>query</code> with <code>query</code>.</p>
   *
   * @param query Contains keyword used for searching.
   */
  public void setQuery(String query) {
    this.query = query;
  }

  /**
   * Getter for <code>repositoriesFilter</code>.
   *
   * @return Attribute <code>repositoriesFilter</code>.
   */
  public Filter getRepositoriesFilter() {
    return repositoriesFilter;
  }

  /**
   * Getter for <code>followersFilter</code>.
   *
   * @return Attribute <code>followersFilter</code>.
   */
  public Filter getFollowersFilter() {
    return followersFilter;
  }

  /**
   * Getter for <code>searchUrl</code>.
   *
   * @return Attribute <code>searchUrl</code>.
   */
  public String getSearchUrl() {
    return searchUrl;
  }

  /**
   * Setter for <code>searchUrl</code>.
   *
   * <p>Initializes <code>searchUrl</code> with <code>searchUrl</code>.</p>
   *
   * @param searchUrl Determines URL used for searching with GitHub API.
   */
  public void setSearchUrl(String searchUrl) {
    this.searchUrl = searchUrl;
  }
}
