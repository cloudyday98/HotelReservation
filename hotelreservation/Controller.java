package hotelreservation;

import hotelreservation.model.*;
import hotelreservation.type.*;
import java.util.*;
import java.lang.IllegalArgumentException;

public class Controller{
    private HashMap<String, Room> rooms;
    private HashMap<String, ArrayList<Reservation>> reservations;

    public Controller(){
        this.rooms = new HashMap<String, Room>();
        this.reservations = new HashMap<String, ArrayList<Reservation>>();
    }

    public void addRoom(String num, String t){
        this.rooms.put(num, new Room(num, RoomType.valueOf(t)));
        this.reservations.put(num, new ArrayList<Reservation>());
    }

    public void printRooms(){
        for(String num : this.rooms.keySet()){
            System.out.println("Room: " + num + ", Type: " + this.rooms.get(num).getRoomType());
        }
    }

    public void printReservastionsByRoomNumber(String num){
        if (!this.reservations.containsKey(num)){
            System.out.println("Invalid room number, please re-enter");
        }
        else{
            for (Reservation r : this.reservations.get(num)){
                System.out.println("From: " + r.getCheckIn() + ", To: " + r.getCheckOut());
            }
        }
    }

    public void checkAvailability(String key, String start, String end){
        try{
            Integer.parseInt(key);
            checkAvailabilityByRoomNumber(key, start, end);
        }catch (NumberFormatException e) {
            checkAvailabilityByRoomType(key, start, end);
        }
    }

    public boolean checkAvailabilityByRoomNumber(String num, String start, String end){
        if (!this.reservations.containsKey(num)){
            System.out.println("Invalid room number, please re-enter");
            return false;
        }
        else{
            Availability a = new Availability(start, end);
            if (!a.isValid()){
                return false;
            }

            boolean available = true;
            for (Reservation r : this.reservations.get(num)){
                if (r.hasConflict(a)){
                    available = false;
                }
            }

            if(available){
                System.out.println("Room: " + num + " is avaible for the time period: " + a.getStartDate() + " to " + a.getEndDate());
                
            }
            else{
                System.out.println("Room: " + num + " is NOT avaible for the time period: " + a.getStartDate() + " to " + a.getEndDate());
            }

            return available;
        }
    }

    public void checkAvailabilityByRoomType(String rType, String start, String end)
    {
        RoomType _roomType;
        try{
             _roomType = RoomType.valueOf(rType);
        }catch(IllegalArgumentException e){
            System.out.println("Invalid Room Type: " + rType + ", Please re-enter");
            return;
        }
        

        for (Map.Entry pair : this.rooms.entrySet()) {
            String number = (String) pair.getKey();
            Room room = (Room) pair.getValue();

            if (room.getRoomType().equals(_roomType)){
                Availability a = new Availability(start, end);
                boolean available = true;

                for (Reservation r : this.reservations.get(number)){
                    if (r.hasConflict(a)){
                        available = false;
                        break;
                    }
                }

                if(available){
                    System.out.println("Room: " + number + " of Type: " + room.getRoomType() + " is avaible for the time period: " + a.getStartDate() + " to " + a.getEndDate());
                }
            }
        }
    }
    public void bookRoom(String num, String start, String end){
        if (!this.rooms.containsKey(num)){
            System.out.println("Invalid room number, please re-enter");
            return;
        }

        if (!checkAvailabilityByRoomNumber(num, start, end)){
            System.out.println("Room: " + num + " booking failed");
            return;
        }

        ArrayList<Reservation> res = this.reservations.get(num);
        res.add(new Reservation(start, end));
        this.reservations.put(num, res);
    }

    
}