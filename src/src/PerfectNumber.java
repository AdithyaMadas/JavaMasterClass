public class PerfectNumber {
    public static void main(String[] args) {
        System.out.println(isPerfectNumber(6));
    }
    public static boolean isPerfectNumber(int a) {
        if (a < 1) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i * 2 <= a; i++) {
            if (a % i == 0) {
                sum += i;
            }
        }
        boolean ans = sum == a ? true : false;
        return ans;
    }
}
