package org.example;

import lombok.*;
import java.net.*;

public class HttpStatusChecker {
    @SneakyThrows
    public static String getStatusImage(int code) {
        URI uri = new URI("https", "http.cat", "/" + code + ".jpg", null);
        URL url = uri.toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == 404) {
            throw new IllegalArgumentException("Image was not founded for status code: " + code);
        }
        return url.toString();
    }
}
