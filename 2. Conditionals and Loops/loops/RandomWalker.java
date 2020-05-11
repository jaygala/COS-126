public class RandomWalker {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int INITIAL_X_COORDINATE = 0;
        int INITIAL_Y_COORDINATE = 0;
        int x_coordinate = INITIAL_X_COORDINATE;
        int y_coordinate = INITIAL_Y_COORDINATE;
        System.out.println("(" + INITIAL_X_COORDINATE + ", " + INITIAL_Y_COORDINATE + ")");
        while (n > 0) {
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

            System.out.println("(" + x_coordinate + ", " + y_coordinate + ")");
            n--;
        }

        double distance = Math.pow((double) (x_coordinate - INITIAL_X_COORDINATE), 2) + Math
                .pow((double) (y_coordinate - INITIAL_Y_COORDINATE), 2);

        System.out.println("squared distance: " + distance);
    }
}
