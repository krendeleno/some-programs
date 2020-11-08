package SomeInheritance;

public abstract class SomeParallelogram implements SomeFigure {
    public double a;
    public double b;

    public SomeParallelogram(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double perimiter() {
        return (a + b) * 2;
    }

    public abstract double area();
}
