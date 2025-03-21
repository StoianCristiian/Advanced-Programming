import java.time.LocalTime;
import java.util.*;

class Airport {
    private final String name;
    private final int numRunways;
    private final List<Flight> flights = new ArrayList<>();

    public Airport(String name, int numRunways)
    {
        this.name = name;
        this.numRunways = numRunways;
    }

    public void addFlight(Flight flight)
    {
        flights.add(flight);
    }

    //Assigning flights to runways by their LandingStart
    public void scheduleFlights()
    {
        //first we sort the flights by their LandingStart
        flights.sort(Comparator.comparing(Flight::getLandingStart));
        int[] runwayEndTime = new int[numRunways];

        for(Flight flight : flights)
        {
            LocalTime leaves = flight.getLandingStart();
            LocalTime landing = flight.getLandingEnd();
            for(int i = 0; i < numRunways; i++)
            {
                if(runwayEndTime[i]==0 || leaves.toSecondOfDay() >= runwayEndTime[i])
                {
                    flight.assignRunway(i);
                    runwayEndTime[i] = landing.toSecondOfDay();
                    break;
                }
            }
        }
    }

    public void printSchedule()
    {
        for(Flight flight : flights)
        {
            System.out.println("Flight " + flight.getFlightId() + " assigned to runway " + flight.getAssignedRunway());
        }
    }

    public String getName() { return this.name; }
}
