public class NumberOfDaysInMonth {
    public static boolean isLeapYear(int year) {
        if (year <= 0) {
            return false;
        }
        if (year % 4 == 0) {
            return true;
        }
        return false;
    }

    public static int getDaysInMonth(int month, int year) {
        if (month > 12 || month < 1 || year < 0 || year > 9999) {
            return -1;
        }
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        } else if (month == 2) {
            if (isLeapYear(year))
                return 29;
            else
                return 28;
        }
        else
            return 30;
    }
}
