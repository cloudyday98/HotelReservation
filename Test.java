import hotelreservation.*;
import hotelreservation.model.*;
import hotelreservation.type.*;
import java.util.*;
import java.io.*;  

public class Test {
    public static void main(String[] args){

        Controller ctl = initializeController("sample_input/small.csv");

        Scanner scn = new Scanner(System.in);
        while (true){
            System.out.println("Enter Command: ");
            String[] cmds = scn.nextLine().split(" ");

            if (cmds.length < 1){
                System.out.println("Invalid command, please re-enter");
            }

            else if (cmds[0].equals("list-rooms")){
                ctl.printRooms();
            }

            else if (cmds[0].equals("list-reservations")){
                if (cmds.length < 2){
                    System.out.println("Invalid command, expecting 1 argument but got " + (cmds.length - 1));
                    continue;
                }
                ctl.printReservastionsByRoomNumber(cmds[1]);
            }

            else if (cmds[0].equals("check-available")){
                if (cmds.length < 4){
                    System.out.println("Invalid command, expecting 3 argument but got " + (cmds.length - 1));
                    continue;
                }
                ctl.checkAvailability(cmds[1], cmds[2], cmds[3]);
            }


            else if (cmds[0].equals("book")){
                if (cmds.length < 4){
                    System.out.println("Invalid command, expecting 3 argument but got " + (cmds.length - 1));
                    continue;
                }
                ctl.bookRoom(cmds[1], cmds[2], cmds[3]);
            }


            else if (cmds[0].equals("exit")){
                return;
            }

            else{
                 System.out.println("Invalid command, please re-enter");
            }

        }
    }

    public static Controller initializeController(String path){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));  
            Controller controller = new Controller();
            String line;
            while ((line = reader.readLine()) != null){
                String[] roomInfo = line.split(",");
                controller.addRoom(roomInfo[0], roomInfo[1]);
            }
            return controller;
        }
        catch (IOException e)   
        {  
            e.printStackTrace();
            return new Controller();
        }  
    }
}
