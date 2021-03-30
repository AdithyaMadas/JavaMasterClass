public class LastDigitChecker {
    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(12,26,50));
    }
    public static boolean hasSameLastDigit(int a, int b, int c) {
        if (!isValid(a) || !isValid(b) || !isValid(c)) {
            return false;
        }
        return (a % 10 == b % 10)||(a % 10 == c % 10)||(b % 10 == c % 10);
    }

    public static boolean isValid(int a) {
        return a >= 10 && a <= 1000;
    }
}
