package model;

/**
 * Created by Holy on 01-Jun-17.
 */
public class Filter {

  private boolean used;
  private String boundOperator;
  private int boundNumber;

  public Filter() {
    used = false;
    boundOperator = null;
    boundNumber = 0;
  }

  public void setFilter(boolean _used) {
    used = _used;
  }

  public void setFilter(boolean _used, String _boundOperator, int _boundNumber) {
    used = _used;
    if (isBoundOperatorValid(_boundOperator)) {
      boundOperator = _boundOperator;
    } else {
      boundOperator = "<=";
    }
    boundNumber = _boundNumber;
  }

  public boolean isBoundOperatorValid(String _boundOperator) {
    return (_boundOperator == "<" || _boundOperator == "<=" || _boundOperator == ">"
        || _boundOperator == ">=");
  }

  public boolean getUsed() {
    return used;
  }

  public String getBoundOperator() {
    return boundOperator;
  }

  public int getBoundNumber() {
    return boundNumber;
  }
}
