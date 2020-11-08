package SomeInheritance;

public class SomeTriangle implements SomeFigure {
    public double a;
    public double b;
    public double c;

    public SomeTriangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        double p = perimiter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double perimiter() {
        return a + b + c;
    }

    @Override
    public String info() {
        return "Треугольник со сторонами: " + a + ", " + b + " и " + c;
    }
}
