public class BarkingDog {

    public static boolean shouldWakeUp(boolean barking, int hour) {
        if (hour > 23 || hour < 0) {
            return false;
        }
        if (barking && (hour < 8 || hour > 22)) {
            return true;
        }
        return false;
    }
}
