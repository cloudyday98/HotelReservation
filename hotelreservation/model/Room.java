package hotelreservation.model;

import hotelreservation.type.*;
import java.util.*;

public class Room {

    private String roomNumber;
    private RoomType roomType;

    public Room(String number, RoomType t){
        this.roomNumber = number;
        this.roomType = t;
    }

    public String getRoomNumber(){
        return this.roomNumber;
    }

    public RoomType getRoomType(){
        return this.roomType;
    }
}