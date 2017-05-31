package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Holy on 31-May-17.
 */
public class JsonRequest {
    String message;
    int status;
    String link;
    String rawJson;

    public JsonRequest(String url) {
        link = url;
        rawJson = generateJson();
    }
    public String getMessage() {
        return message;
    }
    public int getStatus() {
        return status;
    }
    public String getLink() {
        return link;
    }
    public String getRawJson() {
        return rawJson;
    }
    public String generateJson() {
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(link);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            status = urlConnection.getResponseCode();
            message = urlConnection.getResponseMessage();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder jsonResult = new StringBuilder();
            String line;
            while((line = br.readLine()) != null) {
                jsonResult.append(line);
            }
            br.close();
            return jsonResult.toString();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if(urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }
    public static void main(String[] args) {
        JsonRequest request = new JsonRequest("https://api.github.com/search/users?q=holy&page=2");
        System.out.println(request.getRawJson());
    }
}
