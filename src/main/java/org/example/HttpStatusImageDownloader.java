package org.example;

import lombok.*;

import java.io.*;
import java.net.*;

public class HttpStatusImageDownloader {
    @SneakyThrows
    public static void downloadStatusImage(int code){
        URL url = new URL(HttpStatusChecker.getStatusImage(code));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        InputStream inputStream = connection.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(code + ".jpg");
        byte[] buffer = new byte[2048];
        int byteRead;
        while ((byteRead = inputStream.read(buffer)) != -1){
            fileOutputStream.write(buffer, 0, byteRead);
        }
    }
}
