public class FlourPacker {
    public static void main(String[] args) {
        canPack(1, 0, 4);
    }
    public static boolean canPack(int big, int small, int goal) {
        if (big < 0 || small < 0 || goal < 0) {
            return false;
        }
        if ((big * 5) + small < goal) {
            return false;
        } else if (((big * 5) + small > goal) && (goal % 5 > small)) {
            return false;
        }
        return true;
    }
}
