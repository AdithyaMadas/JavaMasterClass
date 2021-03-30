public class FactorPrinter {
    public static void printFactors(int a) {
        if (a < 1) {
            System.out.println("Invalid Value");
            return;
        }
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                System.out.println(i);
            }
        }
    }
}
