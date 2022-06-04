package hotelreservation;

import java.util.*;

public class Room {

    private String roomNumber;
    private PriorityQueue<Reservation> reservations;

    public Room(String number){
        this.roomNumber = number;
        this.reservations = new PriorityQueue<Reservation>(10, new DateComparator());
    }

    public String getRoomNumber(){
        return this.roomNumber;
    }

    public void addReservation(Reservation res){
        if (!this.checkAvailability(res)){
            System.out.println("Failed to reserve due to the conflict");
        }
        else{
            this.reservations.add(res);
            System.out.println("Reserved successfully");
        }
    }

    public boolean checkAvailability(Reservation res){
        for (Reservation r : this.reservations){
            if (r.hasConflict(res)){
                System.out.println("Has conflict with the existing reservation: " + r.getCheckIn() + " to " + r.getCheckOut());
                return false;
            }
        }
        return true;
    }

    public void printReservations(){
        System.out.println("Room " + this.roomNumber + " Reservations: ");
        for (Reservation r : this.reservations){
            System.out.println("From: " + r.getCheckIn() + ", To: " + r.getCheckOut());
        }
    }
}