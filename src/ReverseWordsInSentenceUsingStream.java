public class ReverseWordsInSentenceUsingStream {

    public static String reverseWords(String sentence) {
        if (sentence == null) {
            return null;
        }
        String trimmed = sentence.trim();
        if (trimmed.isEmpty()) {
            return "";
        }

        java.util.List<String> words = java.util.Arrays.stream(trimmed.split("\\s+"))
                .collect(java.util.stream.Collectors.toCollection(java.util.ArrayList::new));

        java.util.Collections.reverse(words);
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        String sentence = "Hello World from Java";
        String reversed = reverseWords(sentence);
        System.out.println("Reverse Sentence : " + reversed);
    }
}