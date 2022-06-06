JFLAGS = -g
JC = javac
JVM = java
.SUFFIXES: .java .class
.java.class:
		$(JC) $(JFLAGS) $*.java

CLASSES = \
		hotelreservation/type/RoomType.java \
        hotelreservation/model/Availability.java \
		hotelreservation/model/DateComparator.java \
		hotelreservation/model/Reservation.java \
		hotelreservation/model/Room.java \
        hotelreservation/Controller.java \
        Test.java 

MAIN = Test

default: classes

classes: $(CLASSES:.java=.class)

run: classes
		$(JVM) $(MAIN)

clean:
		$(RM) *.class
		$(RM) hotelreservation/*.class
		$(RM) hotelreservation/model/*.class
		$(RM) hotelreservation/type/*.class
