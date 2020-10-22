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
        Map<String, Integer> dictionary3 = new  LinkedHashMap<>();
        try (Scanner in = new Scanner(new File(filename), "utf-8")) {
            String word;
            in.useDelimiter("[«»—.,:;()?!\\s]+");
            while (in.hasNext()) {
                word = in.next().toLowerCase();
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

        List<Map.Entry<String, Integer>> a = new ArrayList<>(dictionary1.entrySet());
        List<Map.Entry<String, Integer>> b = new ArrayList<>(dictionary2.entrySet());
        List<Map.Entry<String, Integer>> c = new ArrayList<>(dictionary3.entrySet());
        Comparator<Map.Entry<String, Integer>> comparator = (v1, v2) -> v1.getValue().compareTo(v2.getValue());
        Collections.sort(a, comparator.reversed());
        Collections.sort(b, comparator.reversed());
        Collections.sort(c, comparator.reversed());
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
