public class NumberToWords {
    public static void main(String[] args) {
//        System.out.println(getDigitCount(123));
//        System.out.println(reverse(-123));
        numberToWords(123);
    }

    public static int getDigitCount(int a) {
        if (a < 0) {
            return -1;
        }
        if (a == 0) {
            return 1;
        }
        int res = 0;
        while (a != 0) {
            res++;
            a /= 10;
        }
        return res;
    }

    public static int reverse(int a) {
        boolean isNeg = a < 0 ? true : false;
        StringBuilder s = new StringBuilder(String.valueOf(Math.abs(a)));
        s.reverse();
        int i = Integer.parseInt(String.valueOf(s));
        if (isNeg) {
            i *= -1;
        }
        return i;
    }

    public static void numberToWords(int a) {
        String[] x = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        if (a == 0) {
            System.out.println("Zero");
            return;
        }
        int digCount = getDigitCount(a);
        while (digCount>0) {
            digCount--;
            System.out.println(x[(int) (a / Math.pow(10,digCount))]);
            a -= (int) (a / Math.pow(10, digCount)) * Math.pow(10, digCount);
        }
    }
}
