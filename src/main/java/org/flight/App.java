package org.flight;

import org.flight.Flight;
import org.flight.FlightStatus;

import java.time.*;

public class App {
    public static void main(String[] args) {
        Flight flight = new Flight(
                "XY123",
                LocalDateTime.of(2025, 6, 11, 17, 0),
                ZoneId.of("Europe/London"),
                FlightStatus.SCHEDULED,
                Duration.ofHours(2)
        );

        // Задержка на 30 минут
        flight.setDelay(Duration.ofMinutes(30));

        flight.printFlightDetails();
    }
}
