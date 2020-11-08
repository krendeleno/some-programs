package SomeInheritance;

public class SomeInheritanceExamples {
    public static void main(String[] args) {
        SomeCircle c = new SomeCircle(5.2);
        SomeSquare s = new SomeSquare(2.5);
        SomeRectangle r = new SomeRectangle(4, 5.8);
        SomeRhombus rh = new SomeRhombus(6, 8);
        SomeEquilateralTriangle e = new SomeEquilateralTriangle(15);
        SomeRectangularTriangle re = new SomeRectangularTriangle(5, 4);
        SomeTriangle t = new SomeTriangle(4, 4, 6);


        SomeFigure[] figures = {c, s, r, rh, e, re, t};

        for (SomeFigure f : figures) {
            System.out.println(f.info() + " , площадь: " + f.area() + ", периметр: " + f.perimiter());
            System.out.println("Емкость№1: " + f.capacity() + ", емкость№2: " + SomeFigure.capacity(f));
        }
    }

}
