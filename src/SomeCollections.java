import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.lang.Character.isDigit;

public class SomeCollections {
    public static void main(String[] args) throws IOException {
        System.out.println(task1());
        List<String> a = new ArrayList<>();

        a.add("aaa");
        List<String> b = new ArrayList<>();
        b.add("bbb");
        task2(a, b);
        System.out.println(b);

        ArrayList<Integer> c = new ArrayList<>();
        c.add(12);
        c.add(10);
        c.add(9);
        System.out.println(task41(c));
        ArrayList<Integer> d = new ArrayList<>();
        d.add(12);
        d.add(10);
        d.add(9);
        task42(d);
        System.out.println(d);

        ArrayList<String> e = new ArrayList<>();
        e.add("a");
        e.add("b");
        e.add("c");
        task511(e);
        System.out.println(d);
        ArrayList<String> k = new ArrayList<>();
        k.add("a");
        k.add("b");
        k.add("c");
        System.out.println(task512(k));

        ArrayList<String> t = new ArrayList<>();
        t.add("a");
        t.add("12");
        t.add("c");
        task521(t);
        System.out.println(t);

        task6("text.txt");
    }

    private static List<Integer> task1() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i < 101; i++)
            nums.add(i);
        return nums;
    }

    private static void task2(List<String> a, List<String> b) {
        b.addAll(a);
    }

    private static List<Integer> task41(List<Integer> a) {
        List<Integer> b = new ArrayList<>();
        for (Integer elem : a)
            b.add(0, elem);
        return b;
    }

    private static void task42(ArrayList<Integer> a) {
        Collections.reverse(a);
    }

    private static void task511 (List<String> a) {
        int count = 1;
        for (String elem : a) {
            if (count % 2 == 0)
                a.remove(elem);
            count++;
        }
    }

    private static List<String> task512(List<String> a) {
        List<String> b = new ArrayList<>();
        int count = 1;
        for (String elem : a) {
            if (count % 2 != 0)
                b.add(elem);
            count++;
        }
        return b;
    }

    private static Boolean isNumber(String s) {
        char[] sArray = s.toCharArray();
        for (char c: sArray)
            if (!isDigit(c))
                    return false;
            return true;
    }

    private static void task521(List<String> a) {
        for (String elem : a)
            if (isNumber(elem))
                if (Integer.parseInt(elem) % 2 == 0)
                    a.remove(elem);
    }

    private static List<String> task522(List<String> a) {
        List<String> b = new ArrayList<>();
        for (String elem : a)
            if (isNumber(elem)) {
                if (Integer.parseInt(elem) % 2 != 0)
                    b.add(elem);
            }
        return b;
    }

    private static void task531(List<Integer> a) {
        for (Integer elem : a)
            if (elem % 2 == 0)
                a.remove(elem);
    }

    private static List<Integer> task532(List<Integer> a) {
        List<Integer> b = new ArrayList<>();
        for (Integer elem : a)
            if (elem % 2 != 0)
                b.add(elem);

        return b;
    }

    private static void task6(String filename) throws IOException {
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new TreeSet<>();
        Set<String> s3 = new LinkedHashSet<>();
        try (Scanner in = new Scanner(new File(filename), "utf-8")) {
            String word;
            while (in.hasNext()) {
                word = in.next().toLowerCase().replaceAll("[^а-я/-]", "");
                if (!(word.equals(" ") || word.equals(""))) {
                    s1.add(word);
                    s2.add(word);
                    s3.add(word);
                }
            }
        }
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
