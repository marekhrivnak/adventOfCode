package day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    private static final int RED_CUBES = 12;
    private static final int GREEN_CUBES = 13;
    private static final int BLUE_CUBES = 14;


    public static void main(String[] args) {
        firstTask();
    }

    public static void firstTask() {
        List<String> lines = getLinesFromFile();
        assert lines != null;
        long result = IntStream.range(1, lines.size()+1)
                .filter(index -> isGamePossible(lines.get(index-1)))
                .sum();
        System.out.println(result);
    }

    private static boolean isGamePossible(String line) {
        String[] game = line.split(":");
        String[] subsets = game[1].split(";");

        for (String subset : subsets) {
            for (String cubes : subset.split(",")) {
                if (cubes.contains("red") && hasEnoughCubes(cubes, RED_CUBES)) {
                    return false;
                }
                if (cubes.contains("blue") && hasEnoughCubes(cubes, BLUE_CUBES)) {
                    return false;
                }
                if (cubes.contains("green") && hasEnoughCubes(cubes, GREEN_CUBES)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean hasEnoughCubes(String cubes, int maxCubes) {
        String[] splitedCubes = cubes.strip().split(" ");
        int numberOfCubes = Integer.parseInt(splitedCubes[0]);

        return numberOfCubes > maxCubes;
    }


    private static List<String> getLinesFromFile() {
        try {
            String FILEPATH = "./src/day2/day02-input.txt";
            Path path = Paths.get(FILEPATH);
            return Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
