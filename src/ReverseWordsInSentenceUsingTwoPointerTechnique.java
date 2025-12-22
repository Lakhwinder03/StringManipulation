public class ReverseWordsInSentenceUsingTwoPointerTechnique {

    public static String reverseWords(String sentence) {
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

    public static void main(String[] args) {
        String sentence = "Hello World from Java";
        String reversed = reverseWords(sentence);
        System.out.println(reversed);
    }
}