import java.io.File;
import java.io.IOException;
import java.util.*;

public class SomeAssociativeArrays {
    public static void main(String[] args) throws IOException {
        System.out.println(charCounter("banana"));
        System.out.println(charCounterIndex("banana"));
        frequencyDictionary("text.txt");
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

    private static void frequencyDictionary(String filename) throws IOException {
        Map<String, Integer> dictionary1 = new HashMap<>();
        Map<String, Integer> dictionary2 = new TreeMap<>();
        Map<String, Integer> dictionary3 = new LinkedHashMap<>();
        try (Scanner in = new Scanner(new File(filename), "utf-8")) {
            in.useDelimiter("[«»—.,:;()?!\\s]+");
            while (in.hasNext()) {
                String word = in.next().toLowerCase();
                if (dictionary1.containsKey(word)) {
                    dictionary1.put(word, dictionary1.get(word) + 1);
                    dictionary2.put(word, dictionary2.get(word) + 1);
                    dictionary3.put(word, dictionary3.get(word) + 1);
                } else {
                    dictionary1.put(word, 1);
                    dictionary2.put(word, 1);
                    dictionary3.put(word, 1);
                }
            }
        }

        sortDictionary(dictionary1);
        sortDictionary(dictionary2);
        sortDictionary(dictionary3);
    }

    private static void sortDictionary(Map<String, Integer> dict) {
        List<Map.Entry<String, Integer>> dictionary = new ArrayList<>(dict.entrySet());
        Comparator<Map.Entry<String, Integer>> comparator =
                (v1, v2) -> v2.getValue().compareTo(v1.getValue());
        Collections.sort(dictionary, comparator);
        System.out.println(dictionary);
    }


}
