package SomethingPrintable;

public class SomePrintableString implements SomethingPrintable {
    String x;

    public SomePrintableString(String x) {
        this.x = x;
    }

    @Override
    public void print() {
        System.out.println(x);
    }
}
