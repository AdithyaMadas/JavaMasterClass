public class SpeedConverter {
    public static void main(String[] args) {
        printConversion(95.75);
        System.out.println(95.75*0.6213711922);
    }

    public static long toMilesPerHour(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            return -1l;
        }
        return (long) Math.round((kilometersPerHour + 0.025)* 0.6213711922);
    }

    public static void printConversion(double kilometersPerHour) {
        System.out.println(toMilesPerHour(kilometersPerHour) == -1l ? "Invalid Value" : kilometersPerHour + " km/h = " + toMilesPerHour(kilometersPerHour) + " mi/h");
    }
}