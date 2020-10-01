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
        c.add(8);
        System.out.println(task41(c));
        ArrayList<Integer> d = new ArrayList<>();
        d.add(12);
        d.add(10);
        d.add(9);
        task42(d);
        System.out.println(d);
        System.out.println("Пятые задачи");

        ArrayList<String> e = new ArrayList<>();
        e.add("a");
        e.add("b");
        e.add("c");
        e.add("g");
        task511(e);
        ArrayList<String> k = new ArrayList<>();
        k.add("a");
        k.add("b");
        k.add("c");
        k.add("c");
        System.out.println("512: " + task512(k));

        ArrayList<String> t = new ArrayList<>();
        t.add("a");
        t.add("12");
        t.add("c");
        t.add("14");
        task521(t);
        System.out.println("521: " + t);

        ArrayList<Integer> h1 = new ArrayList<>();
        h1.add(1);
        h1.add(22);
        h1.add(32);
        h1.add(5);
        task531(h1);
        System.out.println(h1);

        ArrayList<Integer> h2 = new ArrayList<>();
        h2.add(1);
        h2.add(22);
        h2.add(3);
        h2.add(52);
        System.out.println(task532(h2));
        System.out.println("Конец пятых задач");

        task6("text.txt");
    }

    private static List<Integer> task1() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 100; i++)
            nums.add(i);
        return nums;
    }

    private static List<String> task2(List<String> a, List<String> b) {
        List<String> c = new ArrayList<>();
        c.addAll(a);
        c.addAll(b);
        return c;
    }

    private static List<Integer> task41(List<Integer> a) {
        List<Integer> b = new ArrayList<>(a);
        for (int i = 0, j = b.size() - 1; i < j; i++, j--)
            Collections.swap(b, i, j);
        return b;
    }

    private static void task42(List<Integer> a) {
        if (a.size() > 1) {
            int elem = a.remove(0);
            task42(a);
            a.add(elem);
        }
    }

    private static void task511(List<String> a) {
        for (int i = 0; i < a.size(); i++)
            if (i % 2 == 0)
                a.remove(a.get(i));
    }

    private static List<String> task512(List<String> a) {
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

    private static void task521(List<String> a) {
        for (int i = 0; i < a.size(); i++)
            if (isNumber(a.get(i)))
                if (Integer.parseInt(a.get(i)) % 2 == 0)
                    a.remove(a.get(i));
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
        a.removeIf(x -> x % 2 == 0);
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
