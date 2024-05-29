package org.example;

import java.util.*;

public class HttpImageStatusCli {
    public static void askStatus(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code:");
        String input = scanner.nextLine();
        try {
            int code = Integer.parseInt(input);
            try {
                HttpStatusImageDownloader.downloadStatusImage(code);
                System.out.println("Image downloaded for HTTP status code: " + code);
            } catch (Exception e) {
                System.out.println("There is not image for HTTP status " + code);
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid number");
        }
    }
}
