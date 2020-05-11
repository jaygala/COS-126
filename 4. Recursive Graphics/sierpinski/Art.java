public class Art {

    private static void drawFlake(double x, double y, double length) {
        //  x and y are the coordinates of the centre of the snowflake
        double[] x_coordinates = new double[6];
        double[] y_coordinates = new double[6];
        x_coordinates[0] = x + length;
        y_coordinates[0] = y;
        x_coordinates[1] = x - length;
        y_coordinates[1] = y;
        x_coordinates[2] = x + length / 2;
        y_coordinates[2] = y + (length / 2) * Math.sqrt(3);
        x_coordinates[3] = x + length / 2;
        y_coordinates[3] = y - (length / 2) * Math.sqrt(3);
        x_coordinates[4] = x - length / 2;
        y_coordinates[4] = y + (length / 2) * Math.sqrt(3);
        x_coordinates[5] = x - length / 2;
        y_coordinates[5] = y - (length / 2) * Math.sqrt(3);

        for (int i = 0; i < 6; i++) {
            StdDraw.line(x, y, x_coordinates[i], y_coordinates[i]);
        }

    }

    private static void snowflake(int n, double x, double y, double length) {
        drawFlake(x, y, length);
        if (n > 1) {
            snowflake(n - 1, x + length, y, length / 3);
            snowflake(n - 1, x - length, y, length / 3);
            snowflake(n - 1, x + length / 2, y + (length / 2) * Math.sqrt(3), length / 3);
            snowflake(n - 1, x + length / 2, y - (length / 2) * Math.sqrt(3), length / 3);
            snowflake(n - 1, x - length / 2, y + (length / 2) * Math.sqrt(3), length / 3);
            snowflake(n - 1, x - length / 2, y - (length / 2) * Math.sqrt(3), length / 3);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        snowflake(n, 0.5, 0.5, 0.125);
    }
}
