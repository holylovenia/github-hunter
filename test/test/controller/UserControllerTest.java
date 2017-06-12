package test.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import main.controller.UserController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Unit test for <code>UserController</code> class.
 *
 * @author Holy Lovenia - 13515113
 * @version 1.0
 * @see UserController
 * @since 2017-06-12
 */
class UserControllerTest {

  /**
   * Determines username used.
   */
  private static final String username = "holylovenia";

  /**
   * Instantiation of <code>UserController</code> class.
   */
  private static UserController userController;

  /**
   * Actual e-mail of the user.
   */
  private final String email = "holy.lovenia@gmail.com";

  /**
   * Actual full name of the user.
   */
  private final String fullname = "Holy Lovenia";

  /**
   * Actual avatar URL of the user.
   */
  private final String avatarUrl = "https://avatars1.githubusercontent.com/u/25114282?v=3";

  /**
   * Prepares <code>userController</code> and performs <code>initiate()</code> method before the
   * tests are run.
   */
  @BeforeAll
  static void setUp() {
    userController = new UserController(username);
  }

  /**
   * Checks if properties of <code>userController</code> matches the actual data.
   */
  @Test
  void testInitiate() {
    assertEquals(email, userController.getEmail(), "Email should match");
    assertEquals(fullname, userController.getFullname(), "Full name should match");
    assertEquals(avatarUrl, userController.getAvatarUrl(), "Avatar URL should match");
  }
}