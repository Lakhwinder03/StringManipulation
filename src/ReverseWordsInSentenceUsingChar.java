public class ReverseWordsInSentenceUsingChar {
    public static String reverseWords(String sentence) {
        char[] charArray = sentence.toCharArray();
        reverse(charArray, 0, charArray.length - 1);

        int start = 0;
        for (int end = 0; end <= charArray.length; end++) {
            if (end == charArray.length || charArray[end] == ' ') {
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

    public static void main(String[] args) {
        String sentence = "Hello World from Java";
        String reversed = reverseWords(sentence);
        System.out.println("Reverse Sentence : " + reversed);
    }
}