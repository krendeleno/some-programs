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
        for (int i = 0; i < 10; i++)
            System.out.println(x);
    }
}
