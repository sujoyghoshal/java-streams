package com.bridgelabz.streams;

import java.io.*;

public class CharacterStreamCopy {
    public static void main(String[] args) {
        File sourceFile = new File("source.txt");
        File destFile = new File("destination.txt");

        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist.");
            return;
        }

        try (FileReader fr = new FileReader(sourceFile);
             FileWriter fw = new FileWriter(destFile)) {

            int character;
            while ((character = fr.read()) != -1) {
                fw.write(character);
            }
            System.out.println("File copied successfully using character streams.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
