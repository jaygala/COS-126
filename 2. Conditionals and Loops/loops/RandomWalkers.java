public class RandomWalkers {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int i = trials;
        double total_dist = 0;
        while (i > 0) {
            int j = n;
            int INITIAL_X_COORDINATE = 0;
            int INITIAL_Y_COORDINATE = 0;
            int x_coordinate = INITIAL_X_COORDINATE;
            int y_coordinate = INITIAL_Y_COORDINATE;
            while (j > 0) {
                double rand_no = Math.random();

                if (rand_no < 0.25) {   //  Drone moves NORTH
                    y_coordinate++;
                }

                else if (rand_no < 0.5) {   //  Drone moves SOUTH
                    y_coordinate--;
                }

                else if (rand_no < 0.75) {   //  Drone moves EAST
                    x_coordinate--;
                }

                else {      //  Drone moves WEST
                    x_coordinate++;
                }

                // System.out.println("(" + x_coordinate + ", " + y_coordinate + ")");
                j--;
            }
            total_dist += (Math.pow((double) (x_coordinate - INITIAL_X_COORDINATE), 2) + Math
                    .pow((double) (y_coordinate - INITIAL_Y_COORDINATE), 2));
            i--;
        }
        System.out.println("mean squared distance = " + total_dist / trials);
    }
}
