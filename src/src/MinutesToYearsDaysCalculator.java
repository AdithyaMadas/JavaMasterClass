public class MinutesToYearsDaysCalculator {
    public static void main(String[] args) {
        printYearsAndDays(561600);
    }
    public static void printYearsAndDays(long m) {
        System.out.println(m<0?"Invalid Value":(m + " min = " + m / (60 * 24 * 365) + " y and " + (m % (60 * 24 * 365))/(60 * 24) + " d"));
    }
}
