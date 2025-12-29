public class ReverseWordsInSentenceMultipleWays {

    public static void main(String[] args) {
        String sentence = "Hello World from Java";

        System.out.println("Input : " + sentence);
        // using split method
        System.out.println("Reverse word sentence using split \t\t\t\t\t: " + reverseWordsUsingSplit(sentence));
        // using manual splitting without split method
        System.out.println("Reverse word sentence using manually split\t\t\t: " + manualSplittingWithoutSplit(sentence));
        // using recursion
        System.out.println("Reverse word sentence using Recursion \t\t\t\t: " + reverseWordsUsingRecursion(sentence));
        // using stack
        System.out.println("Reverse word sentence using Stack \t\t\t\t\t: " + reverseWordsUsingStack(sentence));
        // using two pointer technique
        System.out.println("Reverse word sentence using Two pointer techniques\t: " + reverseWordsUsingTwoPointerTechnique(sentence));
        // using stream API
        System.out.println("Reverse word sentence using Stream \t\t\t\t\t: " + reverseWordsUsingStream(sentence));
    }

    public static String reverseWordsUsingSplit(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder reversedSentence = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedSentence.append(words[i]);
            if (i != 0) {
                reversedSentence.append(" ");
            }
        }
        return reversedSentence.toString();
    }

    public static String manualSplittingWithoutSplit(String sentence) {
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

    public static String reverseWordsUsingStack(String sentence) {
        java.util.Stack<String> stack = new java.util.Stack<>();
        StringBuilder word = new StringBuilder();

        for (char c : sentence.toCharArray()) {
            if (c == ' ') {
                if (!word.isEmpty()) {
                    stack.push(word.toString());
                    word.setLength(0);
                }
            } else {
                word.append(c);
            }
        }
        if (!word.isEmpty()) {
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

    public static String reverseWordsUsingTwoPointerTechnique(String sentence) {
        char[] charArray = sentence.toCharArray();
        int n = charArray.length;

        // Step 1: Reverse the entire sentence
        reverse(charArray, 0, n - 1);

        // Step 2: Reverse each word in the reversed sentence
        int start = 0;
        for (int end = 0; end <= n; end++) {
            if (end == n || charArray[end] == ' ') {
                reverse(charArray, start, end - 1);
                start = end + 1;
            }
        }
        return new String(charArray);
    }

    private static void reverse(char[] array, int left, int right) {
        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    public static String reverseWordsUsingStream(String sentence) {
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

    public static String reverseWordsUsingRecursion(String sentence) {
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
}