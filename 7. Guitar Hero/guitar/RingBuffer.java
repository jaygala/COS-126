/*******************************************************************************
 *
 *  This is a template file for RingBuffer.java. It lists the constructors
 *  and methods you need to implement, along with descriptions of what they're
 *  supposed to do.
 *
 *  Note: it won't compile until you fill in the constructors and methods
 *        (or at least commment out the ones whose return type is non-void).
 *
 ******************************************************************************/

public class RingBuffer {
    // YOUR INSTANCE VARIABLES HERE
    private int capacity;
    private int size;
    private int first;
    private int last;
    private double[] rb;

    // creates an empty ring buffer with the specified capacity
    public RingBuffer(int capacity) {
        // YOUR CODE HERE
        this.capacity = capacity;
        this.size = 0;
        this.first = 0;
        this.last = 0;
        this.rb = new double[capacity];
    }

    // return the capacity of this ring buffer
    public int capacity() {
        // YOUR CODE HERE
        return capacity;
    }

    // return number of items currently in this ring buffer
    public int size() {
        // YOUR CODE HERE
        return size;
    }

    // is this ring buffer empty (size equals zero)?
    public boolean isEmpty() {
        // YOUR CODE HERE
        return size == 0;
    }

    // is this ring buffer full (size equals capacity)?
    public boolean isFull() {
        // YOUR CODE HERE
        return size == capacity;
    }

    // adds item x to the end of this ring buffer
    public void enqueue(double x) {
        // YOUR CODE HERE
        if (isFull()) {
            throw new RuntimeException("Cannot enqueue as ring buffer is full");
        }
        rb[last] = x;
        last = (last + 1) % capacity;
        size++;
    }

    // deletes and returns the item at the front of this ring buffer
    public double dequeue() {
        // YOUR CODE HERE
        if (isEmpty()) {
            throw new RuntimeException("Cannot dequeue as ring buffer is empty");
        }
        double temp = rb[first];
        size--;
        first = (first + 1) % capacity;
        return temp;
    }

    // returns the item at the front of this ring buffer
    public double peek() {
        // YOUR CODE HERE
        if (isEmpty()) {
            throw new RuntimeException("Cannot dequeue as ring buffer is empty");
        }
        return rb[first];
    }

    // tests and calls every instance method in this class
    public static void main(String[] args) {
        // YOUR CODE HERE
        int n = Integer.parseInt(args[0]);
        RingBuffer buffer = new RingBuffer(n);
        for (int i = 1; i <= n; i++) {
            buffer.enqueue(i);
        }
        double t = buffer.dequeue();
        buffer.enqueue(t);
        StdOut.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) {
            double x = buffer.dequeue();
            double y = buffer.dequeue();
            buffer.enqueue(x + y);
        }
        StdOut.println(buffer.peek());

    }

}
