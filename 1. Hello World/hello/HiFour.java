public class HiFour {
    public static void main(String[] args) {
        if (args.length == 4) {
            System.out.println(
                    "Hi " + args[3] + ", " + args[2] + ", " + args[1] + ", and " + args[0] + ".");
        }
        else {
            System.out.println(
                    "Error as number of names provided are " + args.length + ", while we need 4.");
        }
    }
}
