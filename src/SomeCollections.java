import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SomeCollections {
    public static void main(String[] args) {
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
        task41(c);
        System.out.println(task41(c));
        ArrayList<Integer> d = new ArrayList<>();
        d.add(12);
        d.add(10);
        d.add(9);
        task42(d);
        System.out.println(d);
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
}
