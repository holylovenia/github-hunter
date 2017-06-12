package main.controller;

import main.model.Repository;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Generates <code>Repository</code> based on JSON Array.
 *
 * @author Holy Lovenia - 13515113
 * @version 1.0
 * @since 2017-06-01
 */
public class RepositoryController {

  /**
   * Instantiation of <code>Repository</code> class.
   *
   * @see Repository
   */
  private Repository repo;

  /**
   * Built from JSON data specified for the repository.
   */
  private JSONObject repositoryJsonObj;

  /**
   * Constructor.
   *
   * <p>Initializes <code>repositoryJsonObj</code> with element in <code>repositoriesJsonArray
   * </code> at <code>index</code> position. Constructs <code>repo</code> and set the
   * attributes of it according to data from <code>repositoryJsonObj</code>.</p>
   *
   * @param repositoriesJsonArray Contains JSON Data for all repositories the user has.
   * @param index Determines the position of specified element.
   */
  public RepositoryController(JSONArray repositoriesJsonArray, int index) {
    repositoryJsonObj = (JSONObject) repositoriesJsonArray.get(index);
    repo = new Repository();
    setName();
    setDescription();
    setUrl();
  }

  /**
   * Initializes the repository name with JSON data retrieved from <code>repositoryJsonObj</code>.
   */
  public void setName() {
    String name = repositoryJsonObj.getString("name");
    repo.setName(name);
  }

  /**
   * Initializes the repository description with JSON data retrieved from
   * <code>repositoryJsonObj</code>.
   */
  public void setDescription() {
    if (!(repositoryJsonObj.isNull("description") || repositoryJsonObj.getString("description")
        .equals(""))) {
      String description = repositoryJsonObj.getString("description");
      repo.setDescription(description);
    }
  }

  /**
   * Initializes the repository HTML URL with JSON data retrieved from
   * <code>repositoryJsonObj</code>.
   */
  public void setUrl() {
    String url = repositoryJsonObj.getString("html_url");
    repo.setUrl(url);
  }

  /**
   * Getter for <code>repo</code>.
   *
   * @return Attribute <code>repo</code>.
   */
  public Repository getRepository() {
    return repo;
  }
}
