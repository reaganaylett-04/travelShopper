import java.util.*;

public class TravelOptimizer {
    private List<Flight> flights = new ArrayList<>();

    // Add a flight to the list
    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    // Calculate the maximum number of trips within the budget
    public List<String> findOptimalTrips(int budget, Set<String> mandatoryTrips) {
        List<String> selectedTrips = new ArrayList<>();
        int mandatoryCost = 0;

        // Include mandatory trips first
        for (String mandatory : mandatoryTrips) {
            boolean found = false;
            for (Flight flight : flights) {
                if (flight.getDestination().equalsIgnoreCase(mandatory)) {
                    selectedTrips.add(mandatory);
                    mandatoryCost += flight.getCost();
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new IllegalArgumentException("Mandatory trip " + mandatory + " is not available.");
            }
        }

        // Check if the mandatory trips exceed the budget
        if (mandatoryCost > budget) {
            throw new IllegalArgumentException("Budget is insufficient for mandatory trips.");
        }

        // Sort remaining flights by cost (ascending order)
        flights.sort(Comparator.comparingInt(Flight::getCost));

        // Add as many trips as possible within the remaining budget
        int remainingBudget = budget - mandatoryCost;
        for (Flight flight : flights) {
            if (remainingBudget >= flight.getCost() && !selectedTrips.contains(flight.getDestination())) {
                selectedTrips.add(flight.getDestination());
                remainingBudget -= flight.getCost();
            }
        }

        return selectedTrips;
    }
}
