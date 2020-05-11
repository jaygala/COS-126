public class Blob {

    private double cx;
    private double cy;
    private int mass;

    //  creates an empty blob
    public Blob() {
        cx = 0;
        cy = 0;
        mass = 0;
    }

    //  adds pixel (x, y) to this blob
    public void add(int x, int y) {
        cx = ((cx * mass) + x) / (mass + 1);
        cy = ((cy * mass) + y) / (mass + 1);
        mass++;
    }

    //  mass of pixels added to this blob
    public int mass() {
        return mass;
    }

    //  Euclidean distance between the center of masses of the two blobs
    public double distanceTo(Blob that) {
        double sqdist = Math.pow(cx - that.cx, 2) + Math.pow(cy - that.cy, 2);
        return Math.sqrt(sqdist);
    }

    //  string representation of this blob (see below)
    public String toString() {
        return String.format("%2d (%8.4f, %8.4f)", mass, cx, cy);
    }

    //  tests this class by directly calling all instance methods
    public static void main(String[] args) {
        Blob b1 = new Blob();
        b1.add(1, 1);
        b1.add(2, 2);
        b1.add(3, 3);
        Blob b2 = new Blob();
        b2.add(1, 5);
        // b2.add(2, 5);
        b2.add(3, 5);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println("Mass of b1 is - " + b1.mass());
        System.out.println("Mass of b2 is - " + b2.mass());
        System.out.println("Dist between them is - " + b1.distanceTo(b2));
    }
}
