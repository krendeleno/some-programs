import java.io.File;
import java.io.IOException;
import java.util.*;

public class SomeAssociativeArrays {
    public static void main(String[] args) throws IOException {
        System.out.println(charCounter("banana"));
        System.out.println(charCounterIndex("banana"));
        System.out.println(frequencyDictionary("text.txt"));
    }

    private static Map<Character, Integer> charCounter(String word) {
        Map<Character, Integer> a = new HashMap<>();
        char[] cWord = word.toCharArray();
        for (char c : cWord) {
            if (a.containsKey(c))
                a.put(c, a.get(c) + 1);
            else
                a.put(c, 1);
        }
        return a;
    }

    private static Map<Character, List<Integer>> charCounterIndex(String word) {
        Map<Character, List<Integer>> a = new HashMap<>();
        char[] cWord = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (a.containsKey(cWord[i]))
                a.get(cWord[i]).add(i);
            else
                a.put(cWord[i], new ArrayList<>(List.of(i)));
        }
            return a;
    }

    private static List<Map.Entry<String, Integer>> frequencyDictionary(String filename) throws IOException {
        Map<String, Integer> dictionary = new HashMap<>();
        try (Scanner in = new Scanner(new File(filename), "utf-8")) {
            String word;
            in.useDelimiter("[!,?.:—]*\\s*[!,?.:—]*\\s+");
            while (in.hasNext()) {
                word = in.next().toLowerCase();
                if (dictionary.containsKey(word))
                    dictionary.put(word, dictionary.get(word) + 1);
                else
                    dictionary.put(word, 1);
            }
        }
        Comparator<Map.Entry<String, Integer>> comparator = Comparator.comparing(Map.Entry::getValue);
        List<Map.Entry<String, Integer>> a = new ArrayList<>(dictionary.entrySet());
        Collections.sort(a, comparator.reversed());
        return a;
    }
}
