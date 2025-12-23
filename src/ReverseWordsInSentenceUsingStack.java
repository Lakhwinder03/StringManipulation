public class ReverseWordsInSentenceUsingStack {
    public static String reverseWords(String sentence) {
        java.util.Stack<String> stack = new java.util.Stack<>();
        StringBuilder word = new StringBuilder();

        for (char c : sentence.toCharArray()) {
            if (c == ' ') {
                if (word.length() > 0) {
                    stack.push(word.toString());
                    word.setLength(0);
                }
            } else {
                word.append(c);
            }
        }
        if (word.length() > 0) {
            stack.push(word.toString());
        }

        StringBuilder reversedSentence = new StringBuilder();
        while (!stack.isEmpty()) {
            reversedSentence.append(stack.pop());
            if (!stack.isEmpty()) {
                reversedSentence.append(" ");
            }
        }
        return reversedSentence.toString();
    }

    public static void main(String[] args) {
        String sentence = "Hello World from Java";
        String reversed = reverseWords(sentence);
        System.out.println("Reverse Sentence : " + reversed);
    }
}