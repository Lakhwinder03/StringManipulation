public class ReverseWordsInSentenceUsingManualSplittingWithoutSplit {
    public static String reverseWords(String sentence) {
        StringBuilder reversedSentence = new StringBuilder();
        int end = sentence.length();

        for (int i = sentence.length() - 1; i >= 0; i--) {
            if (sentence.charAt(i) == ' ') {
                reversedSentence.append(sentence, i + 1, end).append(" ");
                end = i;
            }
        }
        reversedSentence.append(sentence, 0, end);
        return reversedSentence.toString();
    }

    public static void main(String[] args) {
        String sentence = "Hello World from Java";
        String reversed = reverseWords(sentence);
        System.out.println(reversed);
    }
}


