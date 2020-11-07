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
    public double perimiter() {
        return a * 4;
    }

    @Override
    public String info() {
        return "Квадрат со стороной: " + a;
    }
}
