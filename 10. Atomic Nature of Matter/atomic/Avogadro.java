public class Avogadro {
    public static void main(String[] args) {

        double meters_to_pixels = 0.175e-6;
        double dt = 0.5;
        double T = 297;
        double eta = 9.135e-4;
        double rho = 0.5e-6;
        double R = 8.31446;

        double variance = 0.0;
        int n = 0;
        double D;
        double k;
        double A;

        while (!StdIn.isEmpty()) {
            double value = StdIn.readDouble();
            value *= meters_to_pixels;
            n++;
            variance += (value * value);
        }
        variance /= (2 * n);
        D = variance / (2 * dt);
        k = (6 * Math.PI * eta * rho * D) / T;
        A = R / k;
        System.out.printf("Boltzmann = %.4e\nAvogadro = %.4e\n", k, A);

    }
}

// public class Avogadro {
//     public static final double METERPERPIXEL = 0.175e-6;
//     public static final double TEMP = 297;
//     public static final double VISCOSITY = 9.135e-4;
//     public static final double RAD = 0.5e-6;
//     public static final double R = 8.31446;
//
//     public static void main(String[] args) {
//         int numP = 0;
//         double varSum = 0.0;
//         double k;
//         double D;
//         double NA;
//         while (!StdIn.isEmpty()) {
//             // takes radial displacents as input form StdIn
//             double value = (METERPERPIXEL) * StdIn.readDouble();
//             numP += 1;
//             varSum += value * value;
//         }
//         D = varSum / (2 * numP);
//         k = (6 * D * (Math.PI) * (VISCOSITY) * (RAD)) / TEMP;
//         NA = R / k;
//
//         StdOut.printf("Boltzmann = %.4e\n", k);
//         StdOut.printf("Avogadro  = %.4e", NA);
//         System.out.println();
//     }
// }
