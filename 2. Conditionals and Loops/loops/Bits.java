public class Bits {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        if (n < 0) {
            System.out.println("Illegal input");
            return;
        }
        int no_of_bits = 0;

        //  Loop to find the number of bits in n :-
        while (n != 0) {
            n /= 2;
            no_of_bits++;
        }
        System.out.println(no_of_bits);
    }
}
