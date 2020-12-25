package Exam;

import java.io.*;
import java.util.*;

public class DictionaryTest {
    public static void main(String[] args) throws Exception {
        dictReader("data2020/dictionary.txt");
        if (!dict.isEmpty()) {
            questionAnswerer("data2020/strict-queries.txt", "data2020/out.txt");
            questionAnswerer2("data2020/full-text-search.txt", "data2020/out2.txt");
        }
    }

    private static List<DictionaryEntry> dict = new ArrayList<>();

    private static void dictReader(String filename) throws Exception {
        try (Scanner in = new Scanner(new File(filename), "utf-8")) {
            while (in.hasNextLine()) {
                String[] words = in.nextLine().split(" ", 2);
                DictionaryEntry newWord = new DictionaryEntry(words[0], words[1]);
                dict.add(newWord);
            }
        } catch (Exception e) {
            System.out.println("проблема при чтении файла");
        }
    }

    private static void questionAnswerer(String fileIn, String fileOut) throws IOException {
        try (Scanner in = new Scanner(new File(fileIn), "utf-8");
             PrintStream out = new PrintStream(fileOut, "utf8")) {
            Set<String> setTranslations = new HashSet<>();
            for (int i = 0; i < 10; i++) {
                String word = in.next().toUpperCase();
                for (DictionaryEntry d : dict) {
                    if (d.getWord().equals(word))
                        setTranslations.add(d.getTranslation());
                }
                if (setTranslations.isEmpty())
                    out.println("Нет такого слова");
                else
                    for (String s : setTranslations)
                        out.println(s);
            }
        }
    }

    private static void questionAnswerer2(String fileIn, String fileOut) throws Exception {
        try (Scanner in = new Scanner(new File(fileIn), "utf-8");
             PrintStream out = new PrintStream(fileOut, "utf8")) {
            Set<String> setTranslations = new HashSet<>();
            for (int i = 0; i < 10; i++) {
                String word = in.next().toUpperCase();
                for (DictionaryEntry d : dict) {
                    if (d.getWord().contains(word))
                        setTranslations.add(d.getWord() + " " + d.getTranslation());
                }
                if (setTranslations.isEmpty())
                    out.println("Нет такого слова");
                else
                    for (String s : setTranslations)
                        out.println(s);
            }
        }
    }
}
