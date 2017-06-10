package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/**
 * Manages JSON request from a specified URL through REST API access.
 *
 * @author Holy Lovenia - 13515113
 * @version 1.0
 * @since 2017-05-31
 */
public class JsonRequest {

  /**
   * Encrypted token used for authenticated access.
   */
  private final String token = "9bm3nqJ2RZi90Z6L6Cu1qvvKuxlxILBEgBMFtQaDp+VFGq+pewXhRypHA5ZDEUqVCjFmEDrnOg4=";

  /**
   * Response message retrieved from the connection.
   */
  private String message;

  /**
   * Response code retrieved from the connection.
   */
  private int status;

  /**
   * Determines URL used for JSON request.
   */
  private String link;

  /**
   * Contatins retrieved JSON data.
   */
  private String rawJson;

  /**
   * Constructor.
   *
   * <p>Initializes <code>link</code> with <code>url</code> and <code>rawJson</code> with the return
   * value of <code>generateJson()</code> method.</p>
   *
   * @param url Determines URL used for JSON request.
   * @see #generateJson()
   */
  public JsonRequest(String url) {
    link = url;
    rawJson = generateJson();
  }

  /**
   * Decrypt <code>token</code>.
   *
   * @return Decrypted <code>string</code> from <code>token</code>.
   */
  public String generateDecryptedToken() {
    StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
    encryptor.setPassword("holy-github-hunter");
    String decryptedToken = encryptor.decrypt(token);
    return decryptedToken;
  }

  /**
   * Getter for <code>message</code>.
   *
   * @return Attribute <code>message</code>.
   */
  public String getMessage() {
    return message;
  }

  /**
   * Getter for <code>status</code>.
   *
   * @return Attribute <code>status</code>.
   */
  public int getStatus() {
    return status;
  }

  /**
   * Getter for <code>link</code>.
   *
   * @return Attribute <code>link</code>.
   */
  public String getLink() {
    return link;
  }

  /**
   * Getter for <code>rawJson</code>.
   *
   * @return Attribute <code>rawJson</code>.
   */
  public String getRawJson() {
    return rawJson;
  }

  /**
   * Generates JSON data.
   *
   * @return JSON data retrieved from <code>link</code>.
   */
  public String generateJson() {
    HttpURLConnection urlConnection = null;
    try {
      URL url = new URL(link);
      urlConnection = (HttpURLConnection) url.openConnection();
      urlConnection.setRequestProperty("Authorization", "token " + generateDecryptedToken());
      urlConnection.setRequestMethod("GET");
      status = urlConnection.getResponseCode();
      message = urlConnection.getResponseMessage();
      BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
      StringBuilder jsonResult = new StringBuilder();
      String line;
      while ((line = br.readLine()) != null) {
        jsonResult.append(line);
      }
      br.close();
      return jsonResult.toString();
    } catch (java.io.IOException e) {
      e.printStackTrace();
      return null;
    } finally {
      if (urlConnection != null) {
        urlConnection.disconnect();
      }
    }
  }
}
