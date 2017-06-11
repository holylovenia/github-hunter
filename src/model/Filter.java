package model;

/**
 * Represents filter applied in searching.
 *
 * @author Holy Lovenia - 13515113
 * @version 1.0
 * @since 2017-06-01
 */
public class Filter {

  /**
   * Determines whether the filter will be used in searching or not.
   */
  private boolean used;

  /**
   * Determines what mathematical operator used to filter.
   */
  private String boundOperator;

  /**
   * Determines limit of the filter.
   */
  private int boundNumber;

  /**
   * Constructor.
   *
   * <p>Initializes <code>used</code> with <code>false</code>, <code>boundOperator</code> with
   * <code>null</code>, and <code>boundNumber</code> with 0.</p>
   */
  public Filter() {
    used = false;
    boundOperator = null;
    boundNumber = 0;
  }

  /**
   * Setter for filter.
   *
   * <p>Initializes <code>used</code> with <code>used</code>, <code>boundOperator</code> with
   * <code>boundOperator</code>, and <code>boundNumber</code> with <code>boundNumber</code>.</p>
   *
   * @param used Determines whether the filter will be used in searching or not.
   * @param boundOperator Determines what mathematical operator used to filter.
   * @param boundNumber Determines limit of the filter.
   */
  public void setFilter(boolean used, String boundOperator, int boundNumber) {
    this.used = used;
    if (isBoundOperatorValid(boundOperator)) {
      this.boundOperator = boundOperator;
    } else {
      this.boundOperator = "<=";
    }
    this.boundNumber = boundNumber;
  }

  /**
   * Validation for bound operator.
   *
   * <p>Examines whether <code>operator</code> is a suitable mathematical operator or not.</p>
   *
   * @param operator Determines what mathematical operator used to filter.
   * @return <code>true</code> if suitable, otherwise <code>false</code>.
   */
  public boolean isBoundOperatorValid(String operator) {
    return (operator == "<" || operator == "<=" || operator == ">"
        || operator == ">=");
  }

  /**
   * Getter for <code>used</code>.
   *
   * @return Attribute <code>used</code>.
   */
  public boolean getUsed() {
    return used;
  }

  /**
   * Getter for <code>boundOperator</code>.
   *
   * @return Attribute <code>boundOperator</code>.
   */
  public String getBoundOperator() {
    return boundOperator;
  }

  /**
   * Getter for <code>boundNumber</code>.
   *
   * @return Attribute <code>boundNumber</code>.
   */
  public int getBoundNumber() {
    return boundNumber;
  }
}
