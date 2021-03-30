public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(81, 153));
    }
    public static int getGreatestCommonDivisor(int a, int b) {
        if (a < 10 || b < 10) {
            return -1;
        }
        if (a % b == 0) {
            return b;
        }
        if (b % a == 0) {
            return a;
        }
        int greater = a > b ? a : b;
        int smaller = a > b ? b : a;
        for (int i = smaller / 2; i > 0; i--) {
            if (greater % i == 0 && smaller % i == 0) {
                return i;
            }
        }
        return -1;
    }
}
