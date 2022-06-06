package hotelreservation.model;

import hotelreservation.type.*;
import java.util.*;
import java.lang.IllegalArgumentException;

public class Room {

    private String roomNumber;
    private RoomType roomType;

    public Room(String number, String t){
        this.roomNumber = number;
        this.roomType = RoomType.valueOf(t);
    }

    public String getRoomNumber(){
        return this.roomNumber;
    }

    public RoomType getRoomType(){
        return this.roomType;
    }

    public boolean compareRoomType(String tp){
        RoomType rType;
        try{
            rType = RoomType.valueOf(tp);
            return rType.equals(this.roomType);
        }catch(IllegalArgumentException e){
            System.out.println("Invalid Room Type: " + tp + ", Please re-enter");
            return false;
        }
    }
}