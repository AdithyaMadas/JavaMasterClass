import java.util.Scanner;

public class InputCalculator {
    public static void inputThenPrintSumAndAverage() {
        Scanner sc = new Scanner(System.in);
        int sum = 0, dig = 0;
        while (sc.hasNextInt()) {
            sum += sc.nextInt();
            dig++;
        }
        if (dig == 0) {
            System.out.println("SUM = " + sum + " AVG = " + dig);
            return;
        }
        System.out.println("SUM = "+sum+" AVG = "+Math.round(sum/(double)dig));
        sc.close();
    }

    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }
}
