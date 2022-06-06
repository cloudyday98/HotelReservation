package hotelreservation.model;

import java.util.*;

public class DateComparator implements Comparator<Reservation> {
    @Override
    public int compare(Reservation a, Reservation b) {
        if (a.getCheckIn().after(b.getCheckOut())){
            return 1;
        }

        if (a.getCheckOut().before(b.getCheckIn())){
            return -1;
        }

        return 0;
    }
}