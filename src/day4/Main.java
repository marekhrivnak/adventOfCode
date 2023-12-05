package day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        firstTask();
        secondTask();
    }

    private static void firstTask() {
        List<String> lines = getLinesFromFile();
        assert lines != null;
        int winningPoints = 0;
        for (String line : lines) {
            winningPoints += getWinningPoints(line);
        }
        System.out.println(winningPoints);
    }

    private static void secondTask() {
        // TODO
    }

    private static int getWinningPoints(String line) {
        String[] game = line.split(":");
        String[] subsets = game[1].split("\\|");
        String[] winningNumbers = subsets[0].strip().split("\\s+");
        String[] myNumbers = subsets[1].strip().split("\\s+");
        int winningPoints = 0;

        Set<String> winningSet = new HashSet<>(Arrays.asList(winningNumbers));
        for (String myNumber : myNumbers) {
            if (winningSet.contains(myNumber)) {
                winningPoints = winningPoints == 0 ? 1 : winningPoints * 2;
            }
        }
        return winningPoints;
    }

    private static List<String> getLinesFromFile() {
        try {
            String FILEPATH = "./src/day4/day04-input.txt";
            Path path = Paths.get(FILEPATH);
            return Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
