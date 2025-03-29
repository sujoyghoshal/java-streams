package com.bridgelabz.streams;

import java.util.*;
public class BufferedFileCopy {
    public static void main(String[] args) {
        File sourceFile = new File("largefile.txt");
        File destFileBuffered = new File("copiedBuffered.txt");
        File destFileUnbuffered = new File("copiedUnbuffered.txt");

        long start, end;

        // Buffered Stream Copy
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFileBuffered))) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            start = System.nanoTime();
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            end = System.nanoTime();
            System.out.println("Buffered Stream Copy Time: " + (end - start) / 1_000_000 + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Unbuffered Stream Copy
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFileUnbuffered)) {

            int byteContent;
            start = System.nanoTime();
            while ((byteContent = fis.read()) != -1) {
                fos.write(byteContent);
            }
            end = System.nanoTime();
            System.out.println("Unbuffered Stream Copy Time: " + (end - start) / 1_000_000 + " ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}