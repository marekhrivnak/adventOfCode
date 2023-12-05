package day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        firstTask();
        secondTask();
    }

    private static void firstTask() {
        // TODO
    }

    private static void secondTask() {
        // TODO
    }

    private static List<String> getLinesFromFile() {
        try {
            String FILEPATH = "./src/day3/day03-input.txt";
            Path path = Paths.get(FILEPATH);
            return Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
