package hotelreservation.model;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Availability{
    private Date startDate;
    private Date endDate;
    private boolean validity;

    public Availability(String start, String end){
        this.startDate = parseDate(start);
        this.endDate = parseDate(end);
        this.validity = true;
        if (this.startDate.after(this.endDate)){
            System.out.println("Invalid Check-in and Check-out Time");
            this.validity = false;
        }
    }

    public Date getStartDate(){
        return this.startDate;
    }

    public Date getEndDate(){
        return this.endDate;
    }

    public boolean isValid(){
        return this.validity;
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