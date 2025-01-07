package org.example;


import random.tests.RNGTester;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String filePath = "/Users/avyukt/Documents/projects/random-tester/src/main/resources/binary_output.txt";
        try {
            String content = Files.readString(Paths.get(filePath));
            System.out.println(content.length());
            System.out.println(RNGTester.runFrequencyTest(content));
            System.out.println(RNGTester.runFrequencyBlockTest(content, 20000));
            System.out.println(RNGTester.runRunsTest(content));
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}