package com.bridgelabz.streams;

import java.io.File;
import java.util.Scanner;

public class FileDeletion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the filename to delete: ");
        String filename = scanner.nextLine();

        File file = new File(filename);

        if (file.exists()) {
            System.out.print("Are you sure you want to delete " + filename + "? (yes/no): ");
            String confirmation = scanner.nextLine();

            if (confirmation.equalsIgnoreCase("yes")) {
                if (file.delete()) {
                    System.out.println("File deleted successfully.");
                } else {
                    System.out.println("Failed to delete the file.");
                }
            } else {
                System.out.println("File deletion cancelled.");
            }
        } else {
            System.out.println("File does not exist.");
        }

        scanner.close();
    }
}
