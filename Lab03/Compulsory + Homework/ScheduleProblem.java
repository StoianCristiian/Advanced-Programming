import java.time.LocalTime;

public class ScheduleProblem
{
    public static void main(String[] args)
    {
        //create the airport
        Airport airport = new Airport("AEROPORT", 3);

        Aircraft airliner = new Airliner("airliner1", "Model3", "Tail1", 160);
        Aircraft freighter = new Freighter("freighter1", "Model2", "Tail2", 500);
        Aircraft drone = new Drone("drone1", "Model1", "Tail3", 50, 120);

        //set of flights
        Flight flight1 = new Flight("FL1", airliner, LocalTime.of(10, 0), LocalTime.of(10, 30));
        Flight flight3 = new Flight("FL3", drone, LocalTime.of(11, 0), LocalTime.of(11, 15));
        Flight flight2 = new Flight("FL2", freighter, LocalTime.of(10, 15), LocalTime.of(10, 45));
        Flight flight4 = new Flight("FL4", drone, LocalTime.of(10, 15), LocalTime.of(10, 40));

        airport.addFlight(flight1);
        airport.addFlight(flight2);
        airport.addFlight(flight3);
        airport.addFlight(flight4);

        airport.scheduleFlights();
        airport.printSchedule();
    }
}