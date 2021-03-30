import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SharedDigit {
    public static void main(String[] args) {
        System.out.println(hasSharedDigit(19, 99));
    }
    public static boolean hasSharedDigit(int a, int b) {
        if (a < 10 || a >= 100 || b < 10 || b >= 100) {
            return false;
        }
        Set x = new HashSet();
        char[] q = String.valueOf(a).toCharArray();
        for (char i : q) {
            x.add(i);
        }
        char[] w = String.valueOf(b).toCharArray();
        for (char o : w) {
            if (x.contains(o)) {
                return true;
            }
        }
        return false;
    }
}
