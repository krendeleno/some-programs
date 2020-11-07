package SomeInheritance;

public class SomeEquilateralTriangle implements SomeFigure {
    private double a;

    public SomeEquilateralTriangle(double a) {
        this.a = a;
    }

    @Override
    public double area() {
        return Math.sqrt(3) / 4 * Math.pow(a, 2);
    }

    @Override
    public double perimiter() {
        return a * 3;
    }

    @Override
    public String info() {
        return "Правильный треугольник со стороной: " + a;
    }
}
