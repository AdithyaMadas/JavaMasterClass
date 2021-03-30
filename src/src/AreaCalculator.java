public class AreaCalculator {
    public static void main(String[] args) {

    }

    public static double area(double a) {
        if (a < 0) {
            return -1;
        }
        return 3.141592653589793238 * a * a;
    }

    public static double area(double a, double b) {
        if (a < 0 || b < 0) {
            return -1;
        }
        return a * b;
    }
}
