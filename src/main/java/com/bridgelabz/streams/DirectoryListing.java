package com.bridgelabz.streams;

import java.io.File;

public class DirectoryListing {
    public static void main(String[] args) {
        File directory = new File(".");

        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                System.out.println("Files and directories in " + directory.getAbsolutePath() + ":");
                for (File file : files) {
                    System.out.println(file.getName() + (file.isDirectory() ? " (Folder)" : " (File)"));
                }
            } else {
                System.out.println("Failed to retrieve directory contents.");
            }
        } else {
            System.out.println("Not a directory.");
        }
    }
}
