# Hotel Reservation

The Hotel Reservation Utility provides the following commands.

### List All Rooms
The conmand list below takes 0 argument and return a list of the existing rooms.

```
list-room
```

### List All Reservation of a Given Room
The conmand list below takes 1 argument and returns a list of reservations of the existing rooms.
```
list-reservations ROOM_NUMBER
```

### Reserve A Room for a Given Time Period
The conmand list below takes 3 argument and returns a list of reservations of the existing rooms. The `START_DATE` and `END_DATE` arguments should take the form of `YYYY-MM-DD`.
```
reserve ROOM_NUMBER START_DATE END_DATE
```

### Check the Availability of a Room for a Certain Time Period
The conmand list below takes 3 argument and returns the availability of the room during the given time period. The `START_DATE` and `END_DATE` arguments should take the form of `YYYY-MM-DD`.
```
available ROOM_NUMBER START_DATE END_DATE
```

### Exit the Program
The command below will terminate the program.
```
esit
```