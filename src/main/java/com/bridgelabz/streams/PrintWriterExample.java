package com.bridgelabz.streams;

import java.io.*;
import java.util.Scanner;

public class PrintWriterExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter your country: ");
        scanner.nextLine(); // Consume newline
        String country = scanner.nextLine();

        try (PrintWriter pw = new PrintWriter("user_info.txt")) {
            pw.printf("Name: %s%n", name);
            pw.printf("Age: %d%n", age);
            pw.printf("Country: %s%n", country);
            System.out.println("User information written successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
