package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static String FILEPATH = "./src/day1/day01-input.txt";

    public static void main(String[] args) {
        firstTask();
        secondTask();
    }

    public static void firstTask() {
        Integer result = getLinesFromFile().stream().mapToInt(line -> {
            List<String> digits = findDigitsFirstTask(line);
            String combined = digits.get(0) + digits.get(digits.size() - 1);
            return Integer.parseInt(combined);
        }).sum();
        System.out.println(result);
    }

    public static void secondTask() {
        Integer result = getLinesFromFile().stream().mapToInt(line -> {
            int[] digits = findDigitsSecondTask(line);
            return Integer.parseInt(digits[0] + Integer.toString(digits[1]));
        }).sum();
        System.out.println(result);
    }

    private static List<String> findDigitsFirstTask(String input) {
        List<String> digits = new ArrayList<>();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.add(Character.toString(c));
            }
        }
        return digits;
    }

    private static int[] findDigitsSecondTask(String input) {
        String[] wordDigits = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int firstDigitIndex = -1, lastDigitIndex = -1, firstDigit = -1, lastDigit = -1;
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                if (firstDigitIndex == -1) {
                    firstDigitIndex = input.indexOf(c);
                    firstDigit = Character.getNumericValue(c);
                }
                lastDigitIndex = input.lastIndexOf(c);
                lastDigit = Character.getNumericValue(c);
            }
        }
        for (String wordDigit : wordDigits) {
            if (input.contains(wordDigit)) {
                if (input.indexOf(wordDigit) < firstDigitIndex || firstDigitIndex == -1) {
                    firstDigitIndex = input.indexOf(wordDigit);
                    firstDigit = mapToDigit(wordDigit);
                }
                if (input.lastIndexOf(wordDigit) > lastDigitIndex || firstDigitIndex == -1) {
                    lastDigitIndex = input.lastIndexOf(wordDigit);
                    lastDigit = mapToDigit(wordDigit);
                }
            }
        }
        return new int[]{firstDigit, lastDigit};
    }

    private static int mapToDigit(String input) {
        return switch (input) {
            case "one" -> 1;
            case "two" -> 2;
            case "three" -> 3;
            case "four" -> 4;
            case "five" -> 5;
            case "six" -> 6;
            case "seven" -> 7;
            case "eight" -> 8;
            default -> 9;
        };
    }

    private static List<String> getLinesFromFile() {
        try {
            Path path = Paths.get(FILEPATH);
            return Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
