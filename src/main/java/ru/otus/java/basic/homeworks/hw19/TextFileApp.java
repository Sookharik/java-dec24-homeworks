package ru.otus.java.basic.homeworks.hw19;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileApp {

    public static List<String> getTextFiles(String directoryPath) throws IOException {
        List<String> textFiles = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(directoryPath))) {
            for (Path path : stream) {
                String fileName = path.getFileName().toString();
                if (fileName.endsWith(".txt") || fileName.endsWith(".md")) {
                    textFiles.add(fileName);
                }
            }
        }
        return textFiles;
    }

    public static List<String> readFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    public static void appendToFile(String filePath, String line) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(line);
            writer.newLine();
        }
    }
}