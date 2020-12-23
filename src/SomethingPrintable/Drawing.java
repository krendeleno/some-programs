package SomethingPrintable;

import java.util.Arrays;

public class Drawing implements SomethingPrintable {
    public static void main(String[] args) {
        Drawing a = new Drawing(4, 5, '.');
        a.print();
        a.setPoint(1, 2, '0');
        a.print();
        a.drawVerticalLine(1, 3, 2, '|');
        a.print();
        a.drawHorizontalLine(0, 4, 0, '-');
        a.print();
        a.drawRectangle(0, 0, 3, 4, '*');
        a.print();
        a.drawRandomLine(0, 0, 1, 3, '?');
        a.print();
        a.drawRandomLine(0, 0, 3, 3, 'o');
        a.print();
        Drawing b = new Drawing(11, 11, '.');
        b.drawCircle(5, 5, 4, '*');
        b.drawRing(5, 5, 4, '?');
        b.print();
        b.draw(5, 5, a);
        b.print();
    }

    private char[][] d;

    public Drawing(int n, int m, char c) {
        d = new char[n][m];
        for (int i = 0; i < d.length; i++)
            Arrays.fill(d[i], c);
    }

    public void print() {
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[i].length; j++)
                System.out.print(d[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public void setPoint(int x, int y, char c) {
        d[y][x] = c;
    }

    public void drawVerticalLine(int firstIndex, int lastIndex, int Column, char c) {
        for (int k = firstIndex; k <= lastIndex; k++)
            d[k][Column] = c;
    }

    public void drawHorizontalLine(int firstIndex, int lastIndex, int Line, char c) {
        Arrays.fill(d[Line], firstIndex, lastIndex + 1, c);
    }

    public void drawRectangle(int x1, int y1, int x2, int y2, char c) {
        drawHorizontalLine(y1, y2, x1, c);
        drawHorizontalLine(y1, y2, x2, c);
        drawVerticalLine(x1, x2, y1, c);
        drawVerticalLine(x1, x2, y2, c);
    }

    // Правда он умеет нормально рисовать только те линии, расстояние между крайними точками которых четное
    public void drawRandomLine(int x1, int y1, int x2, int y2, char c) {
        if (Math.abs(x2 - x1) < Math.abs(y2 - y1)) {
            int N = Math.abs(y2 - y1) + 1;
            int N1 = N / (Math.abs(x2 - x1) + 1);
            if (y1 < y2)
                for (int i = 0; i <= Math.abs(x2 - x1); i++)
                    drawVerticalLine(y1 + N1 * i, y1 + N1 * (i + 1) - 1, x1 + sign(x2 - x1) * i, c);
            else for (int i = 0; i <= Math.abs(x2 - x1); i++)
                drawVerticalLine(y2 + N1 * i, y2 + N1 * (i + 1) - 1, x2 - sign(x2 - x1) * i, c);
        } else {
            int N = Math.abs(x2 - x1) + 1;
            int N1 = N / (Math.abs(y2 - y1) + 1);
            if (x1 < x2)
                for (int i = 0; i <= Math.abs(y2 - y1); i++)
                    drawHorizontalLine(x1 + N1 * i, x1 + N1 * (i + 1) - 1, y1 + sign(y2 - y1) * i, c);
            else for (int i = 0; i <= Math.abs(y2 - y1); i++)
                drawHorizontalLine(x2 + N1 * i, x2 + N1 * (i + 1) - 1, y2 - sign(y2 - y1) * i, c);
        }
    }

    public void drawCircle(int x, int y, int R, char c) {
        for (int i = 0; i < d.length; i++)
            for (int j = 0; j < d[i].length; j++)
                if (Math.pow((i - x), 2) + Math.pow((j - y), 2) <= R * R)
                    d[i][j] = c;
    }

    //    Эта штука проверяет, является ли клетка граничной: если является, то у нее есть хотя бы один сосед, который
    //    не удовлетворяет "условию вхождения в круг"
    public void drawRing(int x, int y, int R, char c) {
        for (int i = 0; i < d.length; i++)
            for (int j = 0; j < d[i].length; j++)
                if (Math.pow((i - x), 2) + Math.pow((j - y), 2) == R * R)
                    d[i][j] = c;
                else if (Math.pow((i - x), 2) + Math.pow((j - y), 2) < R * R &&
                        (Math.pow((i - (x - 1)), 2) + Math.pow((j - y), 2) > R * R ||
                                Math.pow((i - (x + 1)), 2) + Math.pow((j - y), 2) > R * R ||
                                Math.pow((i - x), 2) + Math.pow((j - y + 1), 2) > R * R ||
                                Math.pow((i - x), 2) + Math.pow((j - y - 1), 2) > R * R))
                    d[i][j] = c;
    }

    public void draw(int x, int y, Drawing a) {
        int iA = 0;
        for (int i = x; (i - x) < a.d.length; i++, iA++) {
            int jA = 0;
            for (int j = y; (j - y) < a.d[i - x].length; j++, jA++)
                d[i][j] = a.d[iA][jA];
        }
    }

    public int sign(int x) {
        if (x < 0) return -1;
        else return 1;
    }
}
