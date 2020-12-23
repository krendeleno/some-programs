package SomethingPrintable;

public class SomePrintableLetter implements SomethingPrintable {
    char x;
    int i;

    public SomePrintableLetter(char x, int i) {
        this.x = x;
        this.i = i;
    }

    @Override
    public void print() {
        for (int k = 0; k < i; k++)
            System.out.println(x);
    }
}
