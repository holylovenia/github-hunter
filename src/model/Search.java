package model;

/**
 * Created by Holy on 01-Jun-17.
 */
public class Search {
    private String query;
    private Filter repositoriesFilter;
    private Filter followersFilter;
    private String searchUrl;
    private final String defaultSearchUrl = "https://api.github.com/search/users?q=";

    public Search() {
        query = null;
        repositoriesFilter = new Filter();
        followersFilter = new Filter();
        searchUrl = null;
    }
    public void setQuery(String _query) {
        query = _query;
    }
    public void setRepositoriesFilter(boolean _used) {
        repositoriesFilter.setFilter(_used);
    }
    public void setRepositoriesFilter(boolean _used, String _boundOperator, int _boundNumber) {
        repositoriesFilter.setFilter(_used, _boundOperator, _boundNumber);
    }
    public void setFollowersFilter(boolean _used) {
        followersFilter.setFilter(_used);
    }
    public void setFollowersFilter(boolean _used, String _boundOperator, int _boundNumber) {
        followersFilter.setFilter(_used, _boundOperator, _boundNumber);
    }
    public void setSearchUrl(String _searchUrl) {
        searchUrl = _searchUrl;
    }
    public void generateSearchUrl() {
        String processedQueryUrl = query.trim().replace(" ", "+");
        searchUrl = defaultSearchUrl + processedQueryUrl;
        if(getRepositoriesFilter().getUsed()) {
            String processedRepositoriesFilterUrl = "+repos:" + getRepositoriesFilter().getBoundOperator() + getRepositoriesFilter().getBoundNumber();
            searchUrl += processedRepositoriesFilterUrl;
        }
        if(getFollowersFilter().getUsed()) {
            String processedFollowersFilterUrl = "+followers:" + getFollowersFilter().getBoundOperator() + getFollowersFilter().getBoundNumber();
            searchUrl += processedFollowersFilterUrl;
        }
        searchUrl += "&page=";
    }
    public String getQuery() {
        return query;
    }
    public Filter getRepositoriesFilter() {
        return repositoriesFilter;
    }
    public Filter getFollowersFilter() {
        return followersFilter;
    }
    public String getSearchUrl() {
        return searchUrl;
    }
    public static void main(String[] args) {
        Search search = new Search();
        search.setQuery("holy lovenia");
        search.setRepositoriesFilter(true, "*", 5000);
        search.setFollowersFilter(false, ">", 2);
        search.generateSearchUrl();
        System.out.println(search.getSearchUrl());
    }
}
