/*
 * 
 * The Strategy pattern is a behavioral design pattern that enables selecting an algorithm's runtime behavior from a family of algorithms. 
 * It encapsulates each algorithm in separate classes, allowing for the interchangeability of behaviors without altering the client's code.
 *  This pattern is particularly useful when a class behavior or its algorithm needs to be selected at runtime.
 *  A common analogy to explain the Strategy pattern is different modes of transportation to an airport.

Analogy: Modes of Transportation to an Airport
    Imagine you need to choose the best way to get to the airport. The decision on which mode of transportation to use (e.g., car, bus, or bicycle) depends on 
    various factors like time, cost, or personal preference. Each transportation mode can be seen as a strategy for achieving the goal of reaching the airport.
 
 * How It Works
    TransportationStrategy: The strategy interface that all concrete strategies implement. Each strategy provides a different way to go to the airport.
    CarStrategy, BusStrategy, BicycleStrategy: Concrete implementations of the strategy interface. Each encapsulates a specific way to get to the airport.
    Traveler: The context class that uses a TransportationStrategy. It can change its strategy depending on the circumstances, 
     like changing from a car to a bus or bicycle.
 */

// Strategy Interface
interface TransportationStrategy {
    void goToAirport();
}

// Concrete Strategies
class CarStrategy implements TransportationStrategy {
    @Override
    public void goToAirport() {
        System.out.println("Going to the airport by car.");
    }
}

class BusStrategy implements TransportationStrategy {
    @Override
    public void goToAirport() {
        System.out.println("Going to the airport by bus.");
    }
}

class BicycleStrategy implements TransportationStrategy {
    @Override
    public void goToAirport() {
        System.out.println("Going to the airport by bicycle.");
    }
}

// Context
class Traveler {
    private TransportationStrategy strategy;

    public Traveler(TransportationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(TransportationStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.goToAirport();
    }
}

// Usage
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Traveler traveler = new Traveler(new CarStrategy());
        traveler.executeStrategy(); // Output: Going to the airport by car.

        traveler.setStrategy(new BusStrategy());
        traveler.executeStrategy(); // Output: Going to the airport by bus.

        traveler.setStrategy(new BicycleStrategy());
        traveler.executeStrategy(); // Output: Going to the airport by bicycle.
    }
}
