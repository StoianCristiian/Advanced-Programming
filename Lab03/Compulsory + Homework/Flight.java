import java.time.LocalTime;

class Flight
{
    private final String flightId;
    private final Aircraft aircraft;
    private final LocalTime landingStart;
    private final LocalTime landingEnd;
    private int assignedRunway = -1;

    public Flight(String flightId, Aircraft aircraft, LocalTime landingStart, LocalTime landingEnd)
    {
        this.flightId = flightId;
        this.aircraft = aircraft;
        this.landingStart = landingStart;
        this.landingEnd = landingEnd;
    }
    
    //Assigning a Flight to a runway
    public void assignRunway(int runway)
    {
        this.assignedRunway = runway;
    }

    //getters
    public int getRunway() { return this.assignedRunway; }
    public LocalTime getLandingStart() { return this.landingStart; }
    public LocalTime getLandingEnd() { return this.landingEnd; }
    public String getFlightId() { return this.flightId; }
    public int getAssignedRunway() { return this.assignedRunway; }
    public Aircraft getAircraftType() { return this.aircraft; }
}