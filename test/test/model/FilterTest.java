package test.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import main.model.Filter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Unit test for <code>Filter</code> class.
 *
 * @author Holy Lovenia - 13515113
 * @version 1.0
 * @see Filter
 * @since 2017-06-12
 */
class FilterTest {

  /**
   * Instantiation of <code>Filter</code> class.
   */
  private static Filter filter;

  /**
   * Prepares <code>filter</code> before the tests are run.
   */
  @BeforeAll
  static void setUp() {
    filter = new Filter();
  }

  /**
   * Tests if the method performs validation correctly.
   */
  @Test
  void testIsBoundOperatorValid() {
    assertTrue(filter.isBoundOperatorValid("<"), "Should be valid");
    assertTrue(filter.isBoundOperatorValid("<="), "Should be valid");
    assertTrue(filter.isBoundOperatorValid(">"), "Should be valid");
    assertTrue(filter.isBoundOperatorValid("<="), "Should be valid");
    assertFalse(filter.isBoundOperatorValid("="), "Should be invalid");
    assertFalse(filter.isBoundOperatorValid("<>"), "Should be invalid");
    assertFalse(filter.isBoundOperatorValid("=="), "Should be invalid");
    assertFalse(filter.isBoundOperatorValid("!="), "Should be invalid");
  }
}