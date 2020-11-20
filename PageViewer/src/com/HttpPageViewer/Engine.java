package com.HttpPageViewer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Engine {

    public static String getTextFrom(URL url) {
        var buffer = new StringBuilder();

        try {
            var connection = (HttpURLConnection) url.openConnection();
            var br = new BufferedReader(new InputStreamReader(url.openStream()));
            buffer.append("Response Code: ").append(connection.getResponseCode()).append("\n");
            buffer.append("Response method: ").append(connection.getRequestMethod()).append("\n");
            buffer.append("Response Message: ").append(connection.getResponseMessage()).append("\n");
            buffer.append("Content: \n").append(connection.getContent());

            //read the contents
            String line;
            while ((line = br.readLine()) != null) {
                buffer.append(line);
                buffer.append(System.lineSeparator());
            }

        } catch (IOException e) {
            return "An error occurred";
        }
        return buffer.toString();
    }
}
