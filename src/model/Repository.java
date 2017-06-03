package model;

/**
 * Created by Holy on 31-May-17.
 */
public class Repository {

  private String name;
  private String description;
  private String url;

  public Repository() {
    name = null;
    description = null;
    url = null;
  }

  public String getName() {
    return name;
  }

  public void setName(String _name) {
    name = _name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String _description) {
    description = _description;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String _url) {
    url = _url;
  }
}
