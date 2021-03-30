public class DecimalComparator {
    public static void main(String[] args) {
        System.out.println(areEqualByThreeDecimalPlaces(3.174, 3.175));
    }

    public static boolean areEqualByThreeDecimalPlaces(double a, double b) {
        a = a * 1000;
        b = b * 1000;
        int a1 = (int) a;
        int b1 = (int) b;
        if (a1 == b1) {
            return true;
        }
        return false;
    }
}
