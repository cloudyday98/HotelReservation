import hotelreservation.*;
import java.util.*;

public class Test {
    public static void main(String[] args){
        HashMap<String, Room> rooms = new  HashMap<String, Room>();
        rooms.put("1001", new Room("1001"));
        rooms.put("1002", new Room("1002"));
        rooms.put("2001", new Room("2001"));

        Scanner scn = new Scanner(System.in);
        while (true){
            System.out.println("Enter Command: ");

            String[] cmds = scn.nextLine().split(" ");

            if (cmds.length < 1){
                System.out.println("Invalid command, please re-enter");
            }

            if (cmds[0].equals("list-room")){
                for(String r : rooms.keySet()){
                    System.out.println("room " + r);
                }
            }

            else if (cmds[0].equals("list-reservation")){
                if (cmds.length < 2){
                    System.out.println("Invalid command, expecting 1 argument but got " + (cmds.length - 1));
                    continue;
                }
                String roomNumber = cmds[1];
                if (!rooms.containsKey(roomNumber)){
                    System.out.println("Invalid room number, please re-enter");
                }
                else{
                    rooms.get(roomNumber).printReservations();
                }
            }

            else if (cmds[0].equals("reserve")){
                if (cmds.length < 4){
                    System.out.println("Invalid command, expecting 3 argument but got " + (cmds.length - 1));
                    continue;
                }

                String roomNumber = cmds[1];
                String startDate = cmds[2];
                String endDate = cmds[3];

                if (!rooms.containsKey(roomNumber)){
                    System.out.println("Invalid room number, please re-enter");
                    continue;
                }

                Room room = rooms.get(roomNumber);
                room.addReservation(new Reservation(startDate, endDate));
                rooms.put(roomNumber, room);
            }

            else if (cmds[0].equals("available")){
                if (cmds.length < 4){
                    System.out.println("Invalid command, expecting 3 argument but got " + (cmds.length - 1));
                    continue;
                }

                String roomNumber = cmds[1];
                String startDate = cmds[2];
                String endDate = cmds[3];

                Reservation res = new Reservation(startDate, endDate);

                boolean result = rooms.get(roomNumber).checkAvailability(res);
                if (result){
                    System.out.println("Room is available for the given time period");
                }
                else{
                    System.out.println("Room is NOT available for the given time period");
                }
            }

            else if (cmds[0].equals("exit")){
                return;
            }

            else{
                 System.out.println("Invalid command, please re-enter");
            }

        }
    }
}
