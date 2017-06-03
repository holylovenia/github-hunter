package model;

/**
 * Created by Holy on 01-Jun-17.
 */
public class Search {

  private final String defaultSearchUrl = "https://api.github.com/search/users?q=";
  private int type;
  private String query;
  private Filter repositoriesFilter;
  private Filter followersFilter;
  private String searchUrl;

  public Search() {
    type = 0;
    query = null;
    repositoriesFilter = new Filter();
    followersFilter = new Filter();
    searchUrl = null;
  }

  public static void main(String[] args) {
    Search search = new Search();
    search.setQuery("holy lovenia");
    search.setRepositoriesFilter(true, "*", 5000);
    search.setFollowersFilter(false, ">", 2);
    search.generateSearchUrl();
    System.out.println(search.getSearchUrl());
  }

  public void setRepositoriesFilter(boolean _used, String _boundOperator, int _boundNumber) {
    repositoriesFilter.setFilter(_used, _boundOperator, _boundNumber);
  }

  public void setFollowersFilter(boolean _used, String _boundOperator, int _boundNumber) {
    followersFilter.setFilter(_used, _boundOperator, _boundNumber);
  }

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
    switch (type) {
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

  public int getType() {
    return type;
  }

  public void setType(int _type) {
    if ((_type > 0) && (_type <= 3)) {
      type = _type;
    } else {
      type = 0;
    }
  }

  public String getQuery() {
    return query;
  }

  public void setQuery(String _query) {
    query = _query;
  }

  public Filter getRepositoriesFilter() {
    return repositoriesFilter;
  }

  public void setRepositoriesFilter(boolean _used) {
    repositoriesFilter.setFilter(_used);
  }

  public Filter getFollowersFilter() {
    return followersFilter;
  }

  public void setFollowersFilter(boolean _used) {
    followersFilter.setFilter(_used);
  }

  public String getSearchUrl() {
    return searchUrl;
  }

  public void setSearchUrl(String _searchUrl) {
    searchUrl = _searchUrl;
  }
}
