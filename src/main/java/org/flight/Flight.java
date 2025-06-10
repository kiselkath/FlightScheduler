package org.flight;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Flight {
    private String flightNumber;
    private LocalDateTime departureTime;
    private ZoneId departureZone;
    private FlightStatus status;


    public Flight(String flightNumber, LocalDateTime departureTime, ZoneId departureZone, FlightStatus status) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.departureZone = departureZone;
        this.status = status;
    }

    public boolean isDeparted() {
        ZonedDateTime now = ZonedDateTime.now(departureZone);
        ZonedDateTime departureDateTime = departureTime.atZone(departureZone);
        return now.isAfter(departureDateTime);
    }

    public void printFlightDetails() {
        // Status update
        if (isDeparted() && status == FlightStatus.SCHEDULED) {
            status = FlightStatus.DEPARTED;
        }

        System.out.println("Flight: " + flightNumber);
        System.out.println("Departs at: " + departureTime + " " + departureZone);
        System.out.println("Status: " + status);
    }
}
