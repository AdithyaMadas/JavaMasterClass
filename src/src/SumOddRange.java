public class SumOddRange {
    public static boolean isOdd(int a) {
        if (a < 0) {
            return false;
        }
        return a % 2 == 1;
    }

    public static int sumOdd(int start, int end) {
        if (start < 0 || end < 0 || start > end) {
            return -1;
        }
        if (isOdd(start) && isOdd(end)) {
            int res = 0;
            for (int i = start; i <= end; i += 2) {
                res += i;
            }
            return res;
        }
        if (!isOdd(start) && isOdd(end)) {
            int res = 0;
            for (int i = start+1; i <= end; i += 2) {
                res += i;
            }
            return res;
        }
        if (isOdd(start) && !isOdd(end)) {
            int res = 0;
            for (int i = start; i <= end-1; i += 2) {
                res += i;
            }
            return res;
        }
        if (!isOdd(start) && !isOdd(end)) {
            int res = 0;
            for (int i = start+1; i <= end-1; i += 2) {
                res += i;
            }
            return res;
        }
        return 0;
    }
}
