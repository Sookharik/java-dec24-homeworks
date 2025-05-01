package ru.otus.java.basic.homeworks.hw19;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static ru.otus.java.basic.homeworks.hw19.TextFileApp.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rootDirectory = System.getProperty("user.dir");

        try {
            List<String> textFiles = getTextFiles(rootDirectory);

            if (textFiles.isEmpty()) {
                System.out.println("Текстовые файлы не найдены в корневом каталоге.");
                return;
            }

            System.out.println("Список текстовых файлов:");
            for (int i = 0; i < textFiles.size(); i++) {
                System.out.println((i + 1) + ". " + textFiles.get(i));
            }

            System.out.print("Введите номер файла, с которым хотите работать: ");
            int fileIndex = scanner.nextInt();
            scanner.nextLine();

            if (fileIndex < 1 || fileIndex > textFiles.size()) {
                System.out.println("Неверный номер файла.");
                return;
            }

            String selectedFile = textFiles.get(fileIndex - 1);
            String filePath = rootDirectory + File.separator + selectedFile;

            List<String> fileContent = readFile(filePath);
            System.out.println("\nСодержимое файла '" + selectedFile + "':");
            for (String line : fileContent) {
                System.out.println(line);
            }

            System.out.println("\nВведите строки для добавления в файл (пустая строка завершает ввод):");
            while (true) {
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    break;
                }
                appendToFile(filePath, input);
                System.out.println("Строка успешно добавлена.");
            }

            System.out.println("Работа с файлом завершена.");

        } catch (IOException e) {
            System.err.println("Произошла ошибка при работе с файлами: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}