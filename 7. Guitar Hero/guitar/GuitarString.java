/*******************************************************************************
 *
 *  This is a template file for GuitarString.java. It lists the constructors
 *  and methods you need, along with descriptions of what they're supposed
 *  to do.
 *
 *  Note: it won't compile until you fill in the constructors and methods
 *        (or at least commment out the ones whose return type is non-void).
 *
 ******************************************************************************/

public class GuitarString {
    // YOUR INSTANCE VARIABLES HERE
    private RingBuffer rb;

    // creates a guitar string of the specified frequency,
    // using sampling rate of 44,100
    public GuitarString(double frequency) {
        // YOUR CODE HERE
        int n = (int) Math.ceil(44100 / frequency);
        rb = new RingBuffer(n);
        for (int i = 0; i < n; i++) {
            rb.enqueue(0);
        }
    }

    // creates a guitar string whose size and initial values are given by
    // the specified array
    public GuitarString(double[] init) {
        // YOUR CODE HERE
        int n = init.length;
        rb = new RingBuffer(n);
        for (int i = 0; i < n; i++) {
            rb.enqueue(init[i]);
        }
    }

    // returns the number of samples in the ring buffer
    public int length() {
        // YOUR CODE HERE
        return rb.size();
    }

    // plucks the guitar string (by replacing the buffer with white noise)
    public void pluck() {
        // YOUR CODE HERE
        for (int i = 0; i < length(); i++) {
            rb.dequeue();
            rb.enqueue(StdRandom.uniform(-0.5, 0.5));
        }
    }

    // advances the Karplus-Strong simulation one time step
    public void tic() {
        // YOUR CODE HERE
        double n1 = rb.dequeue();
        double n2 = rb.peek();
        rb.enqueue(0.996 * (n1 + n2) / 2);
    }

    // returns the current sample
    public double sample() {
        // YOUR CODE HERE
        return rb.peek();
    }


    // tests and calls every constructor and instance method in this class
    public static void main(String[] args) {
        // YOUR CODE HERE
        // GuitarString g = new GuitarString(10);
        // System.out.println(g.length());
        // System.out.println(g.sample());
        // g.pluck();
        // System.out.println(g.length());
        // System.out.println(g.sample());
        double[] samples = { 0.2, 0.4, 0.5, 0.3, -0.2, 0.4, 0.3, 0.0, -0.1, -0.3 };
        GuitarString testString = new GuitarString(samples);
        int m = 25; // 25 tics
        for (int i = 0; i < m; i++) {
            double sample = testString.sample();
            StdOut.printf("%6d %8.4f\n", i, sample);
            testString.tic();
        }

    }

}
