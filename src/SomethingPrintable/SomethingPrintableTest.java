package SomethingPrintable;

public class SomethingPrintableTest {
    public static void main(String[] args) {
        SomePrintableLetter pl = new SomePrintableLetter('x', 10);
        pl.print(); //печатает букву x 10 раз

        SomePrintableString ps = new SomePrintableString("asdf");
        ps.print(); //печатает asdf
    }
}
