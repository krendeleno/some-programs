package SomeInheritance;

public class SomeSquare extends SomeRectangle {

    public SomeSquare(double a) {
        super(a, a);
    }

    @Override
    public double area() {
        return a * a;
    }


    @Override
    public String info() {
        return "Квадрат со стороной: " + a;
    }

    @Override
    public double capacity() {
        return 1 / (double) 16;
    }
}
