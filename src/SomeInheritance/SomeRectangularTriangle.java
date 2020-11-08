package SomeInheritance;

public class SomeRectangularTriangle extends SomeTriangle {

    public SomeRectangularTriangle(double a, double b) {
        super(a, b, Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)));
    }

    @Override
    public double area() {
        return a * b / 2;
    }

    @Override
    public String info() {
        return "Прямоугольный треугольник с катетами: " + a + " и " + b;
    }
}
