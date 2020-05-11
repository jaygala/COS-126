public class RGBtoCMYK {
    public static void main(String[] args) {
        int ired = Integer.parseInt(args[0]);
        int igreen = Integer.parseInt(args[1]);
        int iblue = Integer.parseInt(args[2]);

        double white = Math.max(ired, Math.max(igreen, (double) iblue)) / 255;
        double cyan = (white - (double) ired / 255) / white;
        double magenta = (white - (double) igreen / 255) / white;
        double yellow = (white - (double) iblue / 255) / white;
        double black = 1 - white;

        System.out.println("red         = " + ired);
        System.out.println("green       = " + igreen);
        System.out.println("blue        = " + iblue);
        //System.out.println("white : " + white);
        System.out.println("cyan        = " + cyan);
        System.out.println("magenta     = " + magenta);
        System.out.println("yellow      = " + yellow);
        System.out.println("black       = " + black);
    }
}
