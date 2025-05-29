package ru.otus.java.basic.homeworks.projectwork;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class FileManager {
    private static Path currentDir = Paths.get(".").toAbsolutePath().normalize();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        printHelp();

        while (running) {
            System.out.print("\n" + currentDir + "> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;

            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            try {
                switch (command) {
                    case "help":
                        printHelp();
                        break;
                    case "pwd":
                        System.out.println(currentDir);
                        break;
                    case "cd":
                        if (tokens.length < 2) {
                            System.out.println("Укажите путь.");
                        } else {
                            changeDirectory(tokens[1]);
                        }
                        break;
                    case "ls":
                        listDirectory();
                        break;
                    case "info":
                        if (tokens.length < 2) {
                            System.out.println("Укажите имя файла или папки.");
                        } else {
                            showFileInfo(tokens[1]);
                        }
                        break;
                    case "mkdir":
                        if (tokens.length < 2) {
                            System.out.println("Укажите имя папки.");
                        } else {
                            createDirectory(tokens[1]);
                        }
                        break;
                    case "touch":
                        if (tokens.length < 2) {
                            System.out.println("Укажите имя файла.");
                        } else {
                            createFile(tokens[1]);
                        }
                        break;
                    case "rm":
                        if (tokens.length < 2) {
                            System.out.println("Укажите имя файла или папки.");
                        } else {
                            delete(tokens[1]);
                        }
                        break;
                    case "cp":
                        if (tokens.length < 3) {
                            System.out.println("Укажите источник и цель.");
                        } else {
                            boolean recursive = false;
                            int offset = 0;
                            if (tokens.length > 1 && tokens[1].equals("-r")) {
                                recursive = true;
                                offset = 1;
                            }
                            copy(tokens[1 + offset], tokens[2 + offset], recursive);
                        }
                        break;
                    case "mv":
                        if (tokens.length < 3) {
                            System.out.println("Укажите исходный и целевой путь.");
                        } else {
                            move(tokens[1], tokens[2]);
                        }
                        break;
                    case "find":
                        if (tokens.length < 2) {
                            System.out.println("Укажите имя файла для поиска.");
                        } else {
                            findFile(tokens[1]);
                        }
                        break;
                    case "exit":
                        running = false;
                        System.out.println("Выход из программы.");
                        break;
                    default:
                        System.out.println("Неизвестная команда. Введите 'help' для помощи.");
                }
            } catch (Exception e) {
                System.err.println("Ошибка: " + e.getMessage());
            }
        }

        scanner.close();
    }

    private static void printHelp() {
        System.out.println("""
                Доступные команды:
                help            - все команды
                pwd             - показать текущий путь
                cd <путь>       - изменить директорию
                ls              - список файлов в текущей директории
                info <файл>     - информация о файле или папке
                mkdir <имя>     - создать папку
                touch <имя>     - создать файл
                rm <файл>       - удалить файл или папку
                cp <от> <кому>  - копировать файл
                cp -r <от> <кому> - рекурсивно копировать папку
                mv <от> <кому>  - переместить файл или папку
                find <имя>      - найти файл в текущей директории и подпапках
                exit            - выход из программы""");
    }

    private static void changeDirectory(String pathStr) {
        Path newPath = currentDir.resolve(pathStr).normalize();
        if (Files.exists(newPath) && Files.isDirectory(newPath)) {
            currentDir = newPath;
        } else {
            System.out.println("Директория не найдена: " + pathStr);
        }
    }

    private static void listDirectory() throws IOException {
        System.out.println("Содержимое директории:");
        Files.list(currentDir).forEach(p -> {
            try {
                BasicFileAttributes attr = Files.readAttributes(p, BasicFileAttributes.class);
                System.out.printf("%s\t%s\t%s%n",
                        p.getFileName(),
                        attr.isDirectory() ? "[Папка]" : "[Файл]",
                        attr.size());
            } catch (IOException ignored) {}
        });
    }

    private static void showFileInfo(String name) throws IOException {
        Path path = currentDir.resolve(name);
        if (!Files.exists(path)) {
            System.out.println("Файл или папка не найдены: " + name);
            return;
        }

        BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println("Имя: " + path.getFileName());
        System.out.println("Тип: " + (attrs.isDirectory() ? "Папка" : "Файл"));
        System.out.println("Полный путь: " + path.toAbsolutePath());
        System.out.println("Размер: " + attrs.size() + " байт");
        System.out.println("Время создания: " + attrs.creationTime());
        System.out.println("Последнее изменение: " + attrs.lastModifiedTime());
    }

    private static void createDirectory(String name) throws IOException {
        Path path = currentDir.resolve(name);
        if (Files.exists(path)) {
            System.out.println("Папка уже существует: " + name);
            return;
        }

        Files.createDirectory(path);
        System.out.println("Папка создана: " + name);
    }

    private static void createFile(String name) throws IOException {
        Path path = currentDir.resolve(name);
        if (Files.exists(path)) {
            System.out.println("Файл уже существует: " + name);
            return;
        }

        Files.createFile(path);
        System.out.println("Файл создан: " + name);
    }

    private static void delete(String name) throws IOException {
        Path path = currentDir.resolve(name);
        if (!Files.exists(path)) {
            System.out.println("Файл или папка не найдены: " + name);
            return;
        }

        if (Files.isDirectory(path)) {
            Files.walkFileTree(path, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    if (exc != null) throw exc;
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }
            });
        } else {
            Files.delete(path);
        }

        System.out.println("Удалено: " + name);
    }

    private static void copy(String source, String target, boolean recursive) throws IOException {
        Path src = currentDir.resolve(source);
        Path dst = currentDir.resolve(target);

        if (!Files.exists(src)) {
            System.out.println("Источник не найден: " + source);
            return;
        }

        if (Files.isDirectory(src) && !recursive) {
            System.out.println("Для копирования папок используйте ключ -r");
            return;
        }

        if (Files.isDirectory(src)) {
            copyDirectory(src, dst);
        } else {
            Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
        }

        System.out.println("Скопировано: " + source + " -> " + target);
    }

    private static void copyDirectory(Path source, Path target) throws IOException {
        if (Files.exists(target)) {
            System.out.println("Целевая папка уже существует: " + target);
            return;
        }

        Files.walkFileTree(source, new SimpleFileVisitor<>() {
            private Path currentTarget;

            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                currentTarget = target.resolve(source.relativize(dir));
                Files.createDirectory(currentTarget);
                return FileVisitResult.CONTINUE;
            }

            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.copy(file, target.resolve(source.relativize(file)), StandardCopyOption.REPLACE_EXISTING);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    private static void move(String source, String target) throws IOException {
        Path src = currentDir.resolve(source);
        Path dst = currentDir.resolve(target);

        if (!Files.exists(src)) {
            System.out.println("Источник не найден: " + source);
            return;
        }

        Files.move(src, dst, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Перемещено: " + source + " -> " + target);
    }

    private static void findFile(String fileName) throws IOException {
        System.out.println("Поиск файла: " + fileName);
        final int[] count = {0};

        Files.walkFileTree(currentDir, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                if (file.getFileName().toString().equalsIgnoreCase(fileName)) {
                    System.out.println("Найдено: " + file.toAbsolutePath());
                    count[0]++;
                }
                return FileVisitResult.CONTINUE;
            }
        });

        if (count[0] == 0) {
            System.out.println("Файл не найден.");
        } else {
            System.out.println("Найдено совпадений: " + count[0]);
        }
    }
}