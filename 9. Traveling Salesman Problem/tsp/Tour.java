public class Tour {

    private class Node {
        private Point p;
        private Node next;
    }

    private int size;
    private double length;
    // private Node[] list;
    private Node first;

    // creates an empty tour
    public Tour() {
        first = new Node();
        size = 0;
        length = 0;
    }

    // creates the 4-point tour a->b->c->d->a (for debugging)
    public Tour(Point a, Point b, Point c, Point d) {
        first = new Node();
        Node second = new Node();
        Node third = new Node();
        Node fourth = new Node();
        first.p = a;
        second.p = b;
        third.p = c;
        fourth.p = d;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        size = 4;
        length = a.distanceTo(b) + b.distanceTo(c) + c.distanceTo(d) + d.distanceTo(a);
    }

    // returns the number of points in this tour
    public int size() {
        return size;
    }

    // returns the length of this tour
    public double length() {
        return length;
    }

    // returns a string representation of this tour
    public String toString() {
        String result = "";
        Node current = first;
        do {
            result += current.p.toString();
            result += '\n';
            current = current.next;
        } while (!current.equals(first));
        return result;
    }

    // draws this tour to standard drawing
    public void draw() {
        Node current = first;
        do {
            current.p.draw();
            current.p.drawTo(current.next.p);
            current = current.next;
        } while (!current.equals(first));

    }

    // inserts p using the nearest neighbor heuristic
    public void insertNearest(Point p) {
        Node where_to_insert = new Node();
        Node current = first;
        if (size == 0) {
            first.p = p;
            first.next = first;
            size++;
        }
        else if (size == 1) {
            Node second = new Node();
            first.next = second;
            second.p = p;
            second.next = first;
            size++;
            length += 2 * first.p.distanceTo(p);
        }
        else {
            double min_dist = Double.MAX_VALUE;
            do {
                double current_dist = current.p.distanceTo(p);
                if (current_dist < min_dist) {
                    min_dist = current_dist;
                    where_to_insert = current;
                }
                current = current.next;
            } while (!current.equals(first));
            length -= where_to_insert.p.distanceTo(where_to_insert.next.p);
            length += min_dist + where_to_insert.next.p.distanceTo(p);
            Node add_new = new Node();
            add_new.p = p;
            add_new.next = where_to_insert.next;
            where_to_insert.next = add_new;
            size++;

        }

    }

    // inserts p using the smallest increase heuristic
    public void insertSmallest(Point p) {
        Node where_to_insert = new Node();
        Node current = first;
        if (size == 0) {
            first.p = p;
            first.next = first;
            size++;
        }
        else if (size == 1) {
            Node second = new Node();
            first.next = second;
            second.p = p;
            second.next = first;
            size++;
            length += 2 * first.p.distanceTo(p);
        }
        else {
            double min_inc = Double.MAX_VALUE;
            do {
                double delta = 0;
                delta += current.p.distanceTo(p) + current.next.p.distanceTo(p);
                delta -= current.p.distanceTo(current.next.p);
                if (delta < min_inc) {
                    min_inc = delta;
                    where_to_insert = current;
                }
                current = current.next;
            } while (!current.equals(first));
            // System.out.println("delta is - " + min_inc);
            // System.out.println(
            //         "Subtrating - " + where_to_insert.p.distanceTo(where_to_insert.next.p));
            // System.out.println(
            //         "Adding - " + min_inc + " and " + where_to_insert.next.p.distanceTo(p));
            length -= where_to_insert.p.distanceTo(where_to_insert.next.p);
            length += where_to_insert.p.distanceTo(p) + where_to_insert.next.p.distanceTo(p);
            Node add_new = new Node();
            add_new.p = p;
            add_new.next = where_to_insert.next;
            where_to_insert.next = add_new;
            size++;
        }

    }

    // tests this class by calling all constructors and instance methods
    public static void main(String[] args) {
        // define 4 points, corners of a square
        Point a = new Point(1.0, 1.0);
        Point b = new Point(1.0, 4.0);
        Point c = new Point(4.0, 4.0);
        Point d = new Point(4.0, 1.0);

        // create the tour a -> b -> c -> d -> a
        Tour squareTour = new Tour(a, b, c, d);

        StdDraw.setXscale(0, 6);
        StdDraw.setYscale(0, 6);

        Point e = new Point(5.0, 6.0);
        squareTour.insertSmallest(e);
        squareTour.draw();


        // print the size to standard output
        int size = squareTour.size();
        StdOut.println("# of points = " + size);
        // print the tour length to standard output
        double length = squareTour.length();
        StdOut.println("Tour length = " + length);
        StdOut.println(squareTour);

        // squareTour.draw();

    }

}
