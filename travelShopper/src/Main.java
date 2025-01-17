import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TravelOptimizer optimizer = new TravelOptimizer();

        // Add flights from Madrid to European destinations
        optimizer.addFlight(new Flight("Dublin", 1000));
        optimizer.addFlight(new Flight("Prague", 150));
        optimizer.addFlight(new Flight("Budapest", 140));
        optimizer.addFlight(new Flight("Morocco", 100));
        optimizer.addFlight(new Flight("Ibiza", 80));
        optimizer.addFlight(new Flight("Seville", 50));
        optimizer.addFlight(new Flight("Switzerland", 200));
        optimizer.addFlight(new Flight("San Sebastian", 70));
        optimizer.addFlight(new Flight("Paris", 130));
        optimizer.addFlight(new Flight("Vienna", 160));
        optimizer.addFlight(new Flight("Florence", 170));
        optimizer.addFlight(new Flight("Amsterdam", 500));

        // Collect user input
        System.out.println("Welcome to the Madrid Travel Optimizer!");
        System.out.print("Enter your total budget: ");
        int budget = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter mandatory trips (separated by commas): ");
        String[] mandatoryTripsInput = scanner.nextLine().split(",");
        Set<String> mandatoryTrips = new HashSet<>();
        for (String trip : mandatoryTripsInput) {
            mandatoryTrips.add(trip.trim());
        }

        // Calculate optimal trips
        try {
            List<String> optimalTrips = optimizer.findOptimalTrips(budget, mandatoryTrips);
            System.out.println("\nOptimal trips within your budget:");
            System.out.println(optimalTrips);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
