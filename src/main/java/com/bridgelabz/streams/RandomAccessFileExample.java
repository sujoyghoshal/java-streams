package com.bridgelabz.streams;

import java.io.*;

public class RandomAccessFileExample {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("data.txt", "rw")) {
            // Writing data at specific positions
            raf.writeUTF("Hello, World!");
            raf.writeInt(123);
            raf.writeDouble(456.78);
            
            // Move to the beginning of the file
            raf.seek(0);

            // Reading data
            System.out.println("String: " + raf.readUTF());
            System.out.println("Integer: " + raf.readInt());
            System.out.println("Double: " + raf.readDouble());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
