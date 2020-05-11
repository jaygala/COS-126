public class Sierpinski {
    //  Height of an equilateral triangle whose sides are of the specified length.
    public static double height(double length) {
        return (length / 2) * Math.sqrt(3);
    }

    //  Draws a filled equilateral triangle whose bottom vertex is (x, y)
    //  of the specified side length.
    public static void filledTriangle(double x, double y, double length) {
        double[] x_coordinates = new double[3];
        double[] y_cooridnates = new double[3];
        x_coordinates[0] = x;
        y_cooridnates[0] = y;
        x_coordinates[1] = x + length / 2;
        x_coordinates[2] = x - length / 2;
        y_cooridnates[1] = y + height(length);
        y_cooridnates[2] = y + height(length);
        // for (int i = 0; i < 3; i++) {
        //     System.out.println(
        //             "x[" + i + "]: " + x_coordinates[i] + " and y[" + i + "]: " + y_cooridnates[i]);
        // }
        StdDraw.filledPolygon(x_coordinates, y_cooridnates);
    }

    //  Draws a Sierpinski triangle of order n, such that the largest filled
    //  triangle has bottom vertex (x, y) and sides of the specified length.
    public static void sierpinski(int n, double x, double y, double length) {
        //  Recursice equation = T(n) = 3*T(n-1) + 1
        filledTriangle(x, y, length);
        if (n > 1) {
            sierpinski(n - 1, x + length / 2, y, length / 2);
            sierpinski(n - 1, x - length / 2, y, length / 2);
            sierpinski(n - 1, x, y + height(length), length / 2);
        }
    }

    //  Takes an integer command-line argument n;
    //  draws the outline of an equilateral triangle (pointed upwards) of length 1;
    //  whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and
    //  draws a Sierpinski triangle of order n that fits snugly inside the outline.
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double[] x_cor = new double[3];
        double[] y_cor = new double[3];
        x_cor[0] = 0;
        y_cor[0] = 0;
        x_cor[1] = 1;
        y_cor[1] = 0;
        x_cor[2] = 0.5;
        y_cor[2] = Math.sqrt(3) / 2;
        StdDraw.polygon(x_cor, y_cor);
        sierpinski(n, 0.5, 0, 0.5);
    }
}
