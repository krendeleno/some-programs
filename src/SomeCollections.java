import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static java.lang.Character.isDigit;

public class SomeCollections {
    public static void main(String[] args) throws IOException {
        List<Integer> list100 = create100();
        System.out.println("list100 = " + list100); // [1, 2, 3, ..., 100]

        List<String> list1 = List.of("abc", "xyz", "ooo");
        printList(list1);

        List<String> list2 = List.of("abc", "xyz", "ooo");
        printListWithIndexes(list2);

        List<String> list3 = List.of("aaa", "bbb", "ccc");
        List<String> list4 = List.of("xxx", "yyy", "zzz");
        List<String> list3plusList4 = concatenateLists(list3, list4);
        System.out.println(list3plusList4);
        System.out.println(list3);
        System.out.println(list4);

        List<String> list5 = new ArrayList<>(List.of("first", "middle", "last"));
        List<String> list5rev = reverseList(list5);
        System.out.println("list5rev = " + list5rev + ", but list5 = " + list5);

        reverseListInPlace(list5);
        System.out.println("list5 = " + list5);

        List<String> ints = List.of("11", "22", "33", "55", "66", "88", "100", "3", "4");

        System.out.println("ints = " + ints);
        System.out.println("ints no even indices = " + filterEvenIndices(ints)); //["22", "55", "88", "3"]
        System.out.println("ints without even = " + filterEven(ints)); //["11", "33", "55", "3"]
        List<Integer> ints2 = List.of(11, 22, 33, 55, 66, 88, 100, 3, 4);
        System.out.println("ints without even = " + filterEven2(ints2)); //[11, 33, 55, 3]

        System.out.println(" ============= mutable lists =================== ");

        List<String> mutableInts = new ArrayList<>(ints);
        mutableFilterEvenIndices(mutableInts);
        System.out.println("ints no even indices = " + mutableInts); //["22", "55", "88", "3"]

        mutableInts = new ArrayList<>(ints);
        mutableFilterEven(mutableInts);
        System.out.println("ints without even = " + mutableInts); //["11", "33", "55", "3"]

        List<Integer> mutableInts2 = new ArrayList<>(ints2);
        mutableFilterEven2(mutableInts2);
        System.out.println("ints without even = " + mutableInts2); //[11, 33, 55, 3]

        Reading("text.txt");
    }
    
    private static List<Integer> create100() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 100; i++)
            nums.add(i);
        return nums;
    }

    private static void printList(List<String> a) {
        System.out.println("Количество элементов в списке: " + a.size());
        for (String elem : a)
            System.out.println(elem);
    }

    private static void printListWithIndexes(List<String> a) {
        System.out.println("Количество элементов в списке: " + a.size());
        for (int i = 0; i < a.size(); i++)
            System.out.println((i + 1) + ": " + a.get(i));
    }


    private static List<String> concatenateLists(List<String> a, List<String> b) {
        List<String> c = new ArrayList<>();
        c.addAll(a);
        c.addAll(b);
        return c;
    }

    private static List<String> reverseList(List<String> a) {
        List<String> b = new ArrayList<>(a);
        for (int i = 0, j = b.size() - 1; i < j; i++, j--)
            Collections.swap(b, i, j);
        return b;
    }

    private static void reverseListInPlace(List<String> a) {
        if (a.size() > 1) {
            String elem = a.remove(0);
            reverseListInPlace(a);
            a.add(elem);
        }
    }

    private static void mutableFilterEvenIndices(List<String> a) {
        List<String> b = new ArrayList<>();
        for (int i = 0; i < a.size(); i++)
            if (i % 2 == 0)
                b.add(a.get(i));
            a.removeAll(b);
    }

    private static List<String> filterEvenIndices(List<String> a) {
        List<String> b = new ArrayList<>();
        for (int i = 0; i < a.size(); i++)
            if (i % 2 != 0)
                b.add(a.get(i));
        return b;
    }

    private static boolean isNumber(String s) {
        char[] sArray = s.toCharArray();
        for (char c : sArray)
            if (!isDigit(c))
                return false;
        return true;
    }

    private static void mutableFilterEven(List<String> a) {
        List<String> b = new ArrayList<>();
        for (int i = 0; i < a.size(); i++)
            if (isNumber(a.get(i)))
                if (Integer.parseInt(a.get(i)) % 2 == 0)
                    b.add(a.get(i));
                a.removeAll(b);
    }

    private static List<String> filterEven(List<String> a) {
        List<String> b = new ArrayList<>();
        for (String elem : a)
            if (isNumber(elem)) {
                if (Integer.parseInt(elem) % 2 != 0)
                    b.add(elem);
            }
        return b;
    }

    private static void mutableFilterEven2(List<Integer> a) {
        a.removeIf(x -> x % 2 == 0);
    }

    private static List<Integer> filterEven2(List<Integer> a) {
        List<Integer> b = new ArrayList<>();
        for (Integer elem : a)
            if (elem % 2 != 0)
                b.add(elem);
        return b;
    }

    private static void Reading(String filename) throws IOException {
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        doReadWordsInFile(filename, hashSet);
        doReadWordsInFile(filename, linkedHashSet);
        doReadWordsInFile(filename, treeSet);

        System.out.println(hashSet);
        System.out.println(linkedHashSet);
        System.out.println(treeSet);
    }

    private static void doReadWordsInFile(String filename, Set<String> set) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File(filename), "utf-8")) {
            String word;
            while (in.hasNext()) {
                word = in.next().toLowerCase().replaceAll("[^а-я/-]", "");
                if (!(word.equals(" ") || word.equals("")))
                    set.add(word);
            }
        }
    }
}
