package SomeInheritance;

public class SomeEquilateralTriangle extends SomeTriangle {
    public SomeEquilateralTriangle(double a) {
        super(a, a, a);
    }

    @Override
    public double area() {
        return Math.sqrt(3) / 4 * Math.pow(a, 2);
    }

    @Override
    public String info() {
        return "Правильный треугольник со стороной: " + a;
    }

    @Override
    public double capacity() {
        return 1 / (4 * 3 * Math.sqrt(3));
    }
}
