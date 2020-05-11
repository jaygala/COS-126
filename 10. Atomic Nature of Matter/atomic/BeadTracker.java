public class BeadTracker {

    public static void main(String[] args) {

        int min = Integer.parseInt(args[0]);
        double tau = Double.parseDouble(args[1]);
        double delta = Double.parseDouble(args[2]);
        for (int i = 3; i < args.length - 1; i++) {
            Picture frame_t = new Picture(args[i]);
            Picture frame_t_1 = new Picture(args[i + 1]);

            BeadFinder bf_t = new BeadFinder(frame_t, tau);
            BeadFinder bf_t_1 = new BeadFinder(frame_t_1, tau);

            Blob[] b_t = bf_t.getBeads(min);
            Blob[] b_t_1 = bf_t_1.getBeads(min);

            for (int j = 0; j < b_t_1.length; j++) {
                double min_dist = Double.MAX_VALUE;
                for (int k = 0; k < b_t.length; k++) {
                    double dist = b_t_1[j].distanceTo(b_t[k]);
                    if (dist < min_dist && dist < delta) {
                        min_dist = dist;
                    }
                }
                if (min_dist != Double.MAX_VALUE) {
                    System.out.printf("%.4f\n", min_dist);
                }
            }

        }
    }
}
