import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class TopWordsFinder {

    public static List<Map.Entry<String, Long>> findTopWords(File file, int topN) throws IOException {
        Map<String, Long> wordCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.toLowerCase()
                        .replaceAll("[^a-zA-Z]", " ") // remove punctuation
                        .split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0L) + 1);
                    }
                }
            }
        }

        // Sort by frequency and return top N
        return wordCount.entrySet().stream()
                .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                .limit(topN)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        File file = new File("src/largeTextFile.txt");
        List<Map.Entry<String, Long>> topWords = findTopWords(file, 10);

        System.out.println("Top 10 most frequent words:");
        topWords.forEach(e -> System.out.println(e.getKey() + " -> " + e.getValue()));
    }
}