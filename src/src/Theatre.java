import java.util.*;

public class Theatre {
    private final String name;
    private List<Seat> seatList = new ArrayList<>();

    public Theatre(String name, int numRows, int seatsPerRow) {
        this.name = name;
        int lastRow = 'A' + (numRows - 1);
        for (int rowNum = 'A'; rowNum <= lastRow; rowNum++) {
            for (int seatNo = 1; seatNo <= seatsPerRow; seatNo++) {
                Seat seat = new Seat((char) rowNum + String.format("%02d", seatNo));
                seatList.add(seat);
            }
        }
    }

    public String getName() {
        return name;
    }

/*    public boolean reserveSeatBinary(String seatNum) {
        Seat reservedSeat = new Seat(seatNum);
        int found = Collections.binarySearch(seatList, reservedSeat, null);
        if (found >= 0) {
            return seatList.get(found).reserve();
        } else {
            System.out.println("Seat not found");
            return false;
        }
    }*/

    public boolean reserveSeatBinary(String seatNum) {
        int low = 0;
        int high = seatList.size()-1;

        while (low <= high) {
            System.out.print(".");
            int mid = (low + high) >>> 1;
            Seat midVal = seatList.get(mid);
            int cmp = midVal.getSeatName().compareTo(seatNum);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return seatList.get(mid).reserve(); // key found
        }
        System.out.println("Seat not found!");
        return false;
    }


    public boolean reserveSeat(String seatNum) {
        Seat reservedSeat = null;
        for (Seat s : seatList) {
            System.out.print(".");
            if (s.getSeatName().equals(seatNum)) {
                reservedSeat = s;
                break;
            }
        }
        if (reservedSeat == null) {
            System.out.println("There's no such seat");
            return false;
        }
        return reservedSeat.reserve();
    }

    public void getSeats() {
        for (Seat s : seatList) {
            System.out.println(s);
        }
    }

    private class Seat implements Comparable<Seat> {

        private final String seatNo;
        private boolean isReserved;

        public Seat(String seatNo) {
            this.seatNo = seatNo;
        }

        public boolean reserve() {
            if (isReserved) {
                System.out.println("This seat is already reserved!");
                return false;
            } else {
                isReserved = true;
                System.out.println("Seat: " + seatNo + " is reserved");
                return true;
            }
        }

        public String getSeatName() {
            return seatNo;
        }

        public boolean cancel() {
            if (isReserved) {
                isReserved = false;
                System.out.println("Reservation Canceled");
                return true;
            } else {
                System.out.println("Reserve seat before cancelling");
                return false;
            }
        }

        @Override
        public String toString() {
            return seatNo;
        }

        @Override
        public int compareTo(Seat o) {
            return seatNo.compareToIgnoreCase(o.getSeatName());
        }
    }

}
