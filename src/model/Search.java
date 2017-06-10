package model;

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
   * <p>Initializes <code>used</code> with <code>_used</code>, <code>boundOperator</code> with
   * <code>_boundOperator</code>, and <code>boundNumber</code> with <code>_boundNumber</code>.</p>
   *
   * @param _used Determines whether the repository filter will be used in searching or not.
   * @param _boundOperator Determines what mathematical operator used to filter repositories.
   * @param _boundNumber Determines limit of the repository filter.
   */
  public void setRepositoriesFilter(boolean _used, String _boundOperator, int _boundNumber) {
    repositoriesFilter.setFilter(_used, _boundOperator, _boundNumber);
  }

  /**
   * Setter for followers filter.
   *
   * <p>Initializes <code>used</code> with <code>_used</code>, <code>boundOperator</code> with
   * <code>_boundOperator</code>, and <code>boundNumber</code> with <code>_boundNumber</code>.</p>
   *
   * @param _used Determines whether the followers filter will be used in searching or not.
   * @param _boundOperator Determines what mathematical operator used to filter followers.
   * @param _boundNumber Determines limit of the followers filter.
   */
  public void setFollowersFilter(boolean _used, String _boundOperator, int _boundNumber) {
    followersFilter.setFilter(_used, _boundOperator, _boundNumber);
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
   * <p>Initializes <code>category</code> with <code>_category</code>.</p>
   *
   * @param _category Restricts search into certain fields.
   */
  public void setCategory(int _category) {
    if ((_category > 0) && (_category <= 3)) {
      category = _category;
    } else {
      category = 0;
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
   * <p>Initializes <code>query</code> with <code>_query</code>.</p>
   *
   * @param _query Contains keyword used for searching.
   */
  public void setQuery(String _query) {
    query = _query;
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
   * <p>Initializes <code>searchUrl</code> with <code>_searchUrl</code>.</p>
   *
   * @param _searchUrl Determines URL used for searching with GitHub API.
   */
  public void setSearchUrl(String _searchUrl) {
    searchUrl = _searchUrl;
  }
}
