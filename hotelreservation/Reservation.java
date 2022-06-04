package hotelreservation;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Reservation{
    private Date checkIn;
    private Date checkOut;

    public Reservation(String start, String end){
        this.checkIn = parseDate(start);
        this.checkOut = parseDate(end);
    }

    public Date getCheckIn(){
        return this.checkIn;
    }

    public Date getCheckOut(){
        return this.checkOut;
    }

    public boolean hasConflict(Reservation res){
        return (this.checkIn.before(res.getCheckOut()) && this.checkIn.after(res.getCheckIn())) 
            || (this.checkOut.before(res.getCheckOut()) && this.checkOut.after(res.getCheckIn()))
            || (this.checkIn.after(res.getCheckIn()) && this.checkOut.before(res.getCheckOut()))
            || (this.checkOut.after(res.getCheckOut()) && this.checkIn.before(res.getCheckIn()));
    }

    public static Date parseDate(String date){
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        }
        catch (ParseException e){
            System.out.println("Uable to parse input " + date);
            return null;
        }
    }
}