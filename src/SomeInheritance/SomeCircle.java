package SomeInheritance;

public class SomeCircle implements SomeFigure {
    private double r;

    public SomeCircle(double r) {
        this.r = r;
    }

    @Override
    public double area() {
        return r * r * Math.PI;
    }

    @Override
    public double perimiter() {
        return 2 * r * Math.PI;
    }

    @Override
    public String info() {
        return "Круг радиуса: " + r;
    }
}
