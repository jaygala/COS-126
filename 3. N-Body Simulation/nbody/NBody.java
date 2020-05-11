public class NBody {
    public static void main(String[] args) {

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);

        int n = StdIn.readInt();
        double radius = StdIn.readDouble();
        double G = 6.67e-11;
        // System.out.println("radius - " + radius);

        double[] px = new double[n];
        double[] py = new double[n];
        double[] vx = new double[n];
        double[] vy = new double[n];
        double[] mass = new double[n];
        String[] image = new String[n];
        // int sun;

        //  Taking inputs:
        for (int i = 0; i < n; i++) {
            px[i] = StdIn.readDouble();
            py[i] = StdIn.readDouble();
            vx[i] = StdIn.readDouble();
            vy[i] = StdIn.readDouble();
            mass[i] = StdIn.readDouble();
            image[i] = StdIn.readString();
            // if (px[i] == 0.0 && py[i] == 0.0) {     //Identifying the sun
            //     sun = i;
            // }
        }

        //  Setting scale:
        StdDraw.setXscale(-radius, radius);
        StdDraw.setYscale(-radius, radius);
        StdDraw.enableDoubleBuffering();
        // StdDraw.picture(0.0, 0.0, "starfield.jpg");

        //  Playing audio:
        StdAudio.play("2001.wav");

        //  SIMULATING THE UNIVERSE:
        double[] Fx = new double[n];
        double[] Fy = new double[n];
        double[] ax = new double[n];
        double[] ay = new double[n];

        for (double t = 0.0; t < T; t += dt) {

            //  Step A:
            for (int i = 0; i < n; i++) {
                Fx[i] = 0;
                Fy[i] = 0;
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        continue;
                    }
                    double dx = px[j] - px[i];
                    double dy = py[j] - py[i];
                    double dr = Math.sqrt((dx * dx) + (dy * dy));
                    double F = (G * mass[i] * mass[j]) / (dr * dr);
                    Fx[i] += F * (dx / dr);
                    Fy[i] += F * (dy / dr);
                }
            }

            //  Step B:
            for (int i = 0; i < n; i++) {
                ax[i] = Fx[i] / mass[i];
                ay[i] = Fy[i] / mass[i];

                vx[i] += (dt * ax[i]);
                vy[i] += (dt * ay[i]);

                px[i] += (dt * vx[i]);
                py[i] += (dt * vy[i]);
            }

            //Step C:
            // System.out.println("Starting Step C");
            StdDraw.picture(0.0, 0.0, "starfield.jpg");
            for (int i = 0; i < n; i++) {
                StdDraw.picture(px[i], py[i], image[i]);
            }
            StdDraw.show(20);
        }


        //  Printing the output:
        StdOut.printf("%d\n", n);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < n; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          px[i], py[i], vx[i], vy[i], mass[i], image[i]);
        }
    }
}
