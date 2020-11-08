package SomeInheritance;

public class SomeRectangle extends SomeParallelogram {

    public SomeRectangle(double a, double b) {
        super(a, b);
    }

    @Override
    public double area() {
        return a * b;
    }

    @Override
    public String info() {
        return "Прямоугольник со сторонами: " + a + " и " + b;
    }
}
