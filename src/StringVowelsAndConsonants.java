import java.util.HashSet;
import java.util.Set;

public class StringVowelsAndConsonants {

    public static void main(String[] args) {
        String inputString = "Hello World from Java";
        System.out.println("Input String: " + inputString);

       // Using a Simple Loop (Basic Approach)
        System.out.println("Count Vowels and Consonants using Simple Loop: " + countVowelsAndConsonantsLoop(inputString));
        // Using Regular Expressions
        System.out.println("Count Vowels and Consonants using Regular Expressions: " + countVowelsAndConsonantsRegex(inputString));
        // Using Java Streams (Functional Style)
        System.out.println("Count Vowels and Consonants using Java Streams: " + countVowelsAndConsonantsStreams(inputString));
        //Using `Set` for Faster Lookup
        System.out.println("Count Vowels and Consonants using Set for Faster Lookup: " + countVowelsAndConsonantsUsingSet(inputString));
    }

    private static String countVowelsAndConsonantsUsingSet(String inputString) {
        Set<Character> vowelsSet = new HashSet<>();
        for (char ch : "aeiouAEIOU".toCharArray()) {
            vowelsSet.add(ch);
        }

        int vowelCount = 0;
        int consonantCount = 0;

        for (char ch : inputString.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (vowelsSet.contains(ch)) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }
        return "Vowels: " + vowelCount + ", Consonants: " + consonantCount;
    }

    private static String countVowelsAndConsonantsStreams(String inputString) {
        long vowelCount = inputString.chars()
                .filter(ch -> "aeiouAEIOU".indexOf(ch) != -1)
                .count();

        long consonantCount = inputString.chars()
                .filter(ch -> Character.isLetter(ch) && "aeiouAEIOU".indexOf(ch) == -1)
                .count();

        return "Vowels: " + vowelCount + ", Consonants: " + consonantCount;
    }

    private static String countVowelsAndConsonantsRegex(String inputString) {
        String vowelsOnly = inputString.replaceAll("(?i)[^aeiou]", "");
        String consonantsOnly = inputString.replaceAll("(?i)[^b-df-hj-np-tv-z]", "");

        int vowelCount = vowelsOnly.length();
        int consonantCount = consonantsOnly.length();

        return "Vowels: " + vowelCount + ", Consonants: " + consonantCount;
    }

    private static String countVowelsAndConsonantsLoop(String inputString) {
        int vowelCount = 0;
        int consonantCount = 0;
        String vowels = "aeiouAEIOU";

        for (char ch : inputString.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (vowels.indexOf(ch) != -1) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }
        return "Vowels: " + vowelCount + ", Consonants: " + consonantCount;
    }
}
