package SomeInheritance;

public class SomeRhombus implements SomeFigure {
    private double d1;
    private double d2;

    public SomeRhombus(double d1, double d2) {
        this.d1 = d1;
        this.d2 = d2;
    }

    @Override
    public double area() {
        return 0.5 * d1 * d2;
    }

    @Override
    public double perimiter() {
        return 4 * Math.sqrt(Math.pow((d1 / 2), 2) + Math.pow((d2 / 2), 2));
    }

    @Override
    public String info() {
        return "Ромб со сторонами: " + d1 + " и " + d2;
    }
}
