package SomeInheritance;

public class SomeRectangularTriangle implements SomeFigure {
    private double a;
    private double b;

    public SomeRectangularTriangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return a * b / 2;
    }

    @Override
    public double perimiter() {
        return a + b + Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    @Override
    public String info() {
        return "Прямоугольный треугольник с катетами: " + a + " и " + b;
    }
}
