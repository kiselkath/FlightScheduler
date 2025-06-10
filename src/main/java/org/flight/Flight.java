package org.flight;

import java.time.*;

public class Flight {
    private String flightNumber;
    private LocalDateTime departureTime;
    private ZoneId departureZone;
    private FlightStatus status;
    private Duration flightDuration;
    private Duration delayDuration = Duration.ZERO;

    public Flight(String flightNumber, LocalDateTime departureTime, ZoneId departureZone,
                  FlightStatus status, Duration flightDuration) {
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.departureZone = departureZone;
        this.status = status;
        this.flightDuration = flightDuration;
    }

    public void setDelay(Duration delay) {
        this.delayDuration = delay;
        if (!delay.isZero()) {
            this.status = FlightStatus.DELAYED;
        }
    }

    public boolean isDeparted() {
        ZonedDateTime now = ZonedDateTime.now(departureZone);
        ZonedDateTime scheduledDeparture = departureTime.plus(delayDuration).atZone(departureZone);
        return now.isAfter(scheduledDeparture);
    }

    public void updateStatus() {
        ZonedDateTime now = ZonedDateTime.now(departureZone);
        ZonedDateTime departureWithDelay = departureTime.plus(delayDuration).atZone(departureZone);
        ZonedDateTime arrivalTime = departureWithDelay.plus(flightDuration);

        if (now.isBefore(departureWithDelay)) {
            status = delayDuration.isZero() ? FlightStatus.SCHEDULED : FlightStatus.DELAYED;
        } else if (now.isBefore(arrivalTime)) {
            status = FlightStatus.DEPARTED;
        } else {
            status = FlightStatus.ARRIVED;
        }
    }

    public void printFlightDetails() {
        updateStatus(); // Автоматически обновляем перед выводом
        System.out.println("Flight: " + flightNumber);
        System.out.println("Departs at: " + departureTime + " " + departureZone +
                (delayDuration.isZero() ? "" : " (Delayed by " + delayDuration.toMinutes() + " mins)"));
        System.out.println("Status: " + status);
    }
}
