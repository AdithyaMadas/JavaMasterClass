public class FirstLastDigitSum {
    public static int sumFirstAndLastDigit(int a) {
        if (a < 0) {
            return -1;
        }
        char[] x = String.valueOf(a).toCharArray();
        return Integer.parseInt(String.valueOf(x[0])) + Integer.parseInt(String.valueOf(x[x.length - 1]));

    }
}
