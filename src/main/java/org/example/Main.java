package org.example;


import random.tests.RNGTester;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        Path path = Path.of(Main.class.getResource("/binary_output.txt").toURI());
        try {
            String content = Files.readString(path);
            System.out.println(content.length());
            System.out.println(RNGTester.runFrequencyTest(content));
            System.out.println(RNGTester.runFrequencyBlockTest(content, 20000));
            System.out.println(RNGTester.runRunsTest(content));
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}