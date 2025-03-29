package com.bridgelabz.streams;

import java.io.*;

public class ImageByteArray {
    public static void main(String[] args) {
        File sourceImage = new File("source.jpg");
        File destImage = new File("output.jpg");

        try (FileInputStream fis = new FileInputStream(sourceImage);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }

            byte[] imageBytes = baos.toByteArray();

            // Write back the image
            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 FileOutputStream fos = new FileOutputStream(destImage)) {

                while ((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
                System.out.println("Image copied successfully.");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}