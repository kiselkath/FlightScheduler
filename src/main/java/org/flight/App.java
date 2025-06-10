import org.flight.Flight;
import org.flight.FlightStatus;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class App {
    public static void main(String[] args) {
        Flight flight = new Flight(
                "XY123",
                LocalDateTime.of(2025, 6, 10, 14, 50),
                ZoneId.of("Europe/Berlin"),
                FlightStatus.SCHEDULED
        );

        flight.printFlightDetails();
    }
}
