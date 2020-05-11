/* *****************************************************************************
 * Name:
 * NetID:
 * Precept:
 *
 * Description:
 *
 **************************************************************************** */

public class LFSR {

    String s;   //  For seed
    int t;    //  For tap

    // creates an LFSR with the specified seed and tap
    public LFSR(String seed, int tap) {
        // PUT YOUR CODE HERE
        s = seed;
        t = tap;
    }

    // returns the number of bits in this LFSR
    public int length() {
        // PUT YOUR CODE HERE
        return s.length();
    }

    // returns the ith bit of this LFSR (as 0 or 1)
    public int bitAt(int i) {
        // PUT YOUR CODE HERE
        return Integer.parseInt(String.valueOf(s.charAt(s.length() - i)));
    }

    // returns a string representation of this LFSR
    public String toString() {
        // PUT YOUR CODE HERE
        return s;
    }

    // simulates one step of this LFSR and returns the new bit (as 0 or 1)
    public int step() {
        // PUT YOUR CODE HERE
        int[] lfsr = new int[s.length()];
        // lfsr[0] = 0;      //  dummy
        for (int i = 0; i < s.length(); i++) {
            lfsr[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        int lfsr_bit = lfsr[0] ^ lfsr[s.length() - t];
        // int lfsr_bit = s.charAt(0) ^ s.charAt(s.length() - t);
        for (int i = 0; i < s.length() - 1; i++) {
            lfsr[i] = lfsr[i + 1];
        }
        lfsr[s.length() - 1] = lfsr_bit;
        s = "";
        for (int i = 0; i < lfsr.length; i++) {
            s = s + lfsr[i];
        }
        return lfsr_bit;

    }

    // simulates k steps of this LFSR and returns the k bits as a k-bit integer
    public int generate(int k) {
        // PUT YOUR CODE HERE
        int num = 0;
        for (int i = 0; i < k; i++) {
            int bit = step();
            num += bit * Math.pow(2, k - i - 1);
        }


        return num;
    }

    // tests this class by directly calling all instance methods
    public static void main(String[] args) {
        // PUT YOUR TEST CODE HERE
        LFSR lfsr2 = new LFSR("01101000010100010000", 17);
        StdOut.println(lfsr2);
        for (int i = 0; i < 10; i++) {
            int r = lfsr2.generate(5);
            StdOut.println(lfsr2 + " " + r);
        }


    }

}
