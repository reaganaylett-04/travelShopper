public class Flight {
    private String destination;
    private int cost;

    // Constructor
    public Flight(String destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }

    // Getters
    public String getDestination() {
        return destination;
    }

    public int getCost() {
        return cost;
    }
}
