import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String input = "swiss";
        // using Naive Approach (Brute Force)
        System.out.println("First non-repeating character using Native approach: " + findFirstNonRepeatingUsingNaive(input));

        // using HashMap Approach
        System.out.println("First non-repeating character using Hashmap approach: " + findFirstNonRepeatingUsingHashMap(input));

        // LinkedHashMap (Preserve Order)   
        System.out.println("First non-repeating character using LinkedHashMap approach: " + findFirstNonRepeatingUsingLinkedHashMap(input));

        // ASCII Array (Fastest for Limited Charset)
        System.out.println("First non-repeating character using ASCII Array approach: " + findFirstNonRepeatingUsingASCIIArray(input));

        //Streaming Approach (Large Data / Logs)
        System.out.println("First non-repeating character using Streaming approach: " + findFirstNonRepeatingUsingStreams1(input));

        // Using Java 8 Streams
        System.out.println("First non-repeating character using Java 8 Streams approach: " + findFirstNonRepeatingUsingJava8Streams(input));
    }

    private static Character findFirstNonRepeatingUsingJava8Streams(String input) {
        Map<Character, Long> frequencyMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(java.util.stream.Collectors.groupingBy(c -> c, java.util.stream.Collectors.counting()));

        return input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> frequencyMap.get(c) == 1)
                .findFirst()
                .orElse(null); // All characters are repeating
    }

    private static Character findFirstNonRepeatingUsingStreams1(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> input.indexOf(c) == input.lastIndexOf(c))
                .findFirst()
                .orElse(null); // All characters are repeating
    }

    private static Character findFirstNonRepeatingUsingASCIIArray(String input) {
        int[] charCount = new int[256]; // Assuming ASCII character set

        // First pass: Count occurrences of each character
        for (char c : input.toCharArray()) {
            charCount[c]++;
        }

        // Second pass: Find the first non-repeating character
        for (char c : input.toCharArray()) {
            if (charCount[c] == 1) {
                return c;
            }
        }
        return null; // All characters are repeating
    }

    private static Character findFirstNonRepeatingUsingLinkedHashMap(String input) {
        LinkedHashMap<Character, Integer> charCountMap = new LinkedHashMap<>();

        // First pass: Count occurrences of each character
        for (char c : input.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Second pass: Find the first non-repeating character
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null; // All characters are repeating
    }

    private static Character findFirstNonRepeatingUsingHashMap(String input) {
        java.util.HashMap<Character, Integer> charCountMap = new java.util.HashMap<>();

        // First pass: Count occurrences of each character
        for (char c : input.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Second pass: Find the first non-repeating character
        for (char c : input.toCharArray()) {
            if (charCountMap.get(c) == 1) {
                return c;
            }
        }
        return null; // All characters are repeating
    }

    private static Character findFirstNonRepeatingUsingNaive(String input) {
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            boolean isRepeating = false;
            for (int j = 0; j < input.length(); j++) {
                if (i != j && currentChar == input.charAt(j)) {
                    isRepeating = true;
                    break;
                }
            }
            if (!isRepeating) {
                return currentChar;
            }
        }
        return null; // All characters are repeating
    }
}
