public class NumberPalindrome {
    public static void main(String[] args) {
        isPalindrome(11);
    }
    public static boolean isPalindrome(int a) {
        String x = String.valueOf(Math.abs(a));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x);
        stringBuilder.reverse();
        if (x.equalsIgnoreCase(stringBuilder.toString())) {
            return true;
        }
        return false;
    }
}
