public class EvenDigitSum {
    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(123456789));
    }
    public static int getEvenDigitSum(int a) {
        if (a < 0) {
            return -1;
        }
        int result = 0;
        char[] x = String.valueOf(a).toCharArray();
        for (char i : x) {
            if (Integer.parseInt(String.valueOf(i)) % 2 == 0) {
                result += Integer.parseInt(String.valueOf(i));
            }
        }
        return result;
    }

}
