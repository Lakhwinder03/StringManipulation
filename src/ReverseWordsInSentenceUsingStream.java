public class ReverseWordsInSentenceUsingStream {

    public static String reverseWords(String sentence) {
        return String.join(" ",
                java.util.Arrays.stream(sentence.split(" "))
                        .toList()
                        .stream()
                        .sorted((a, b) -> -1)
                        .toArray(String[]::new)
        );
    }

    public static void main(String[] args) {
        String sentence = "Hello World from Java";
        String reversed = reverseWords(sentence);
        System.out.println("Reverse Sentence : " + reversed);
    }
}