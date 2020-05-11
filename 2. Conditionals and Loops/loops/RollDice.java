import java.util.Arrays;

public class RollDice {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int TOTAL_NO_OF_DICE = 10;
        int SIZE_OF_ARRAY = 60 - 10 + 1;
        int dice_sums[] = new int[SIZE_OF_ARRAY];   // By default initialised to 0
        Arrays.fill(dice_sums, 0);
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < TOTAL_NO_OF_DICE; j++) {
                double rand_no = Math.random();
                if (rand_no < 1.0 / 6) {
                    sum += 1;
                }
                else if (rand_no < 2.0 / 6) {
                    sum += 2;
                }
                else if (rand_no < 3.0 / 6) {
                    sum += 3;
                }
                else if (rand_no < 4.0 / 6) {
                    sum += 4;
                }
                else if (rand_no < 5.0 / 6) {
                    sum += 5;
                }
                else {
                    sum += 6;
                }
            }
            dice_sums[sum - 10]++;
        }

        for (int i = 0; i < SIZE_OF_ARRAY; i++) {
            System.out.print(i + 10 + ": ");
            for (int j = 0; j < dice_sums[i]; j++) {
                System.out.print("*");
            }
            System.out.printf("\n");
        }
    }
}
