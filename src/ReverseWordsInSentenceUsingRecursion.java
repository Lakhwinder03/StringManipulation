public class ReverseWordsInSentenceUsingRecursion {

    public static String reverseWords(String sentence) {
        String[] words = sentence.split(" ");
        return reverseHelper(words, words.length - 1);
    }

    private static String reverseHelper(String[] words, int i) {
        if (i < 0) {
            return "";
        }
        String currentWord = words[i];
        String restReversed = reverseHelper(words, i - 1);
        if (restReversed.isEmpty()) {
            return currentWord;
        } else {
            return currentWord + " " + restReversed;
        }
    }

    public static void main(String[] args) {
        String sentence = "Hello World from Java";
        String reversed = reverseWords(sentence);
        System.out.println(reversed);
    }
}