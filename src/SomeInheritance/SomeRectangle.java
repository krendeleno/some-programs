package SomeInheritance;

public class SomeRectangle implements SomeFigure {
    public double a;
    public double b;

    public SomeRectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return a * b;
    }

    @Override
    public double perimiter() {
        return 2 * (a + b);
    }

    @Override
    public String info() {
        return "Прямоугольник со сторонами: " + a + " и " + b;
    }
}
