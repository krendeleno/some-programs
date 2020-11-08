package SomeInheritance;

public interface SomeFigure {
    double area();

    double perimiter();

    String info();

    static double capacity(SomeFigure f) {
        return f.area() / Math.pow(f.perimiter(), 2);
    }

    default double capacity() {
        return area() / Math.pow(perimiter(), 2);
    }
}
