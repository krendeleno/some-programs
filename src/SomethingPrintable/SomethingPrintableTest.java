package SomethingPrintable;

import java.util.Arrays;

public class SomethingPrintableTest {
    public static void main(String[] args) {
        SomePrintableLetter pl = new SomePrintableLetter('x', 10);
        pl.print(); //печатает букву x 10 раз

        SomePrintableString ps = new SomePrintableString("asdf");
        ps.print(); //печатает asdf

        SomethingPrintable[] somePrints = {
                new SomePrintableLetter('z', 3),
                new SomePrintableString("I am a string"),
                new SomethingPrintable() {
                    @Override
                    public void print() {
                        System.out.println("Я просто анонимный класс");
                    }
                },
                () -> System.out.println("Я просто лямбда-выражение")};


        Arrays.stream(somePrints).forEach(x -> x.print());
    }
}
