public class PlayingCat {
    public static boolean isCatPlaying(boolean s, int temp) {
        if (s && (temp > 24 && temp < 46)) {
            return true;
        }
        if (!s && (temp > 24 && temp < 36)) {
            return true;
        }
        return false;
    }
}
