# Hotel Reservation

## To Build and Run the Project

To compile the project, run the following command:
```
make
```

To compile and run the project, run the following command:
```
make run
```

To clean up the project, run the following command:
```
make clean
```

## Available Functionalities
The *Hotel Reservation Utility* provides the following commands.

### List All Existing Rooms
The conmand list below takes 0 argument and return a list of the existing rooms.

```
list-rooms
```

### List All Reservations of a Given Room
The conmand list below takes 1 argument and returns a list of reservations of the existing rooms.
```
list-reservations ROOM_NUMBER
```

### Book A Room for a Given Time Period
The conmand list below takes 3 argument and returns a list of reservations of the existing rooms. The `START_DATE` and `END_DATE` arguments should take the form of `YYYY-MM-DD`. The `ROOM_NUMBER` and `ROOM_TYPE` can be acquired via the `list-rooms` command.
```
book ROOM_NUMBER START_DATE END_DATE
```

### Check the Availability of a Room for a Certain Time Period
The conmand list below takes 3 argument and returns the availability of the room during the given time period. The `START_DATE` and `END_DATE` arguments should take the form of `YYYY-MM-DD`.
```
check-available {ROOM_NUMBER|ROOM_TYPE} START_DATE END_DATE
```

### Exit the Program
The command below will terminate the program.
```
exit
```