package CharacterFrequency;

import java.util.*;
import java.util.stream.Collectors;

public class StringCharacterFrequency {

    public static void main(String[] args) {
        String inputString = "hello world";

        System.out.println("Input String : " + inputString);
        //Using `HashMap<Character, Integer>`
        System.out.println("Character Frequency using HashMap : "+ charFrequencyHashMap(inputString));
        //Using an Array (ASCII assumption)
        System.out.println("Character Frequency using Array : "+ charFrequencyUsingArray(inputString));
        //Using `Collections.frequency()`
        System.out.println("Character Frequency using Collections.frequency : "+ charFrequencyUsingCollectionsFrequency(inputString));
        //Using Java 8 Streams
        System.out.println("Character Frequency using Java 8 Streams : "+ charFrequencyUsingStreams(inputString));
        //Using `TreeMap` (Sorted Output)
        System.out.println("Character Frequency using TreeMap : "+ charFrequencyUsingTreeMap(inputString));

    }

    private static String charFrequencyUsingTreeMap(String inputString) {
        TreeMap<Character, Integer> charCountMap = new TreeMap<>();

        for (char c : inputString.toCharArray()) {
            if (c != ' ') { // Ignoring spaces
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }
        }
        return charCountMap.toString();
    }

    private static String charFrequencyUsingStreams(String inputString) {
        Map<Character, Long> frequencyMap = inputString.chars()
                .filter(c -> c != ' ') // Ignoring spaces
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return frequencyMap.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(", "));
    }

    private static String charFrequencyUsingCollectionsFrequency(String inputString) {
        List<Character> charList = new ArrayList<>();
        for (char c : inputString.toCharArray()) {
            if (c != ' ') { // Ignoring spaces
                charList.add(c);
            }
        }

        Set<Character> uniqueChars = new HashSet<>(charList);
        StringBuilder result = new StringBuilder();
        for (char c : uniqueChars) {
            int frequency = Collections.frequency(charList, c);
            result.append(c).append(": ").append(frequency).append(", ");
        }
        // Remove trailing comma and space
        if (!result.isEmpty()) {
            result.setLength(result.length() - 2);
        }
        return result.toString();
    }

    private static String charFrequencyUsingArray(String inputString) {
        int[] charCountArray = new int[256]; // Assuming ASCII character set

        for (char c : inputString.toCharArray()) {
            if (c != ' ') { // Ignoring spaces
                charCountArray[c]++;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < charCountArray.length; i++) {
            if (charCountArray[i] > 0) {
                result.append((char) i).append(": ").append(charCountArray[i]).append(", ");
            }
        }
        // Remove trailing comma and space
        if (!result.isEmpty()) {
            result.setLength(result.length() - 2);
        }
        return result.toString();
    }

    private static String charFrequencyHashMap(String inputString) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        for (char c : inputString.toCharArray()) {
            if (c != ' ') { // Ignoring spaces
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            }
        }
        return charCountMap.toString();
    }
}
