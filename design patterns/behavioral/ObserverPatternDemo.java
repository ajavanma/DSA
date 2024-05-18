// used in oop and distributed systems
/*
 * Behavioral pattern that allows one object to notify other objects about changes in its state.
 * Use when changes to the state of one object require changing other objects, and the actual set of objects is unknown beforehand or changes dynamically.
 * 
 * The Observer pattern is a behavioral design pattern that defines a one-to-many dependency between objects so that when one object changes state,
 *  all its dependents are notified and updated automatically. This pattern is particularly useful for implementing distributed event handling systems,
 *   where the subject (the object being observed) sends notifications to its observers (the dependent objects) without needing to know who these observers are.
 * Essentially, the Observer pattern promotes loose coupling between the subject and its observers.
 */

// example


 /* 
 * Observer Pattern Analogy
 Imagine a weather station (the subject) that tracks weather data (temperature, humidity, pressure, etc.).
 There are multiple display elements (observers) such as a current conditions display, a statistics display, and a forecast display that show this 
 data in different formats. Whenever the weather station updates its measurements, all the display elements automatically update their displays with the new data.
  Here, the weather station doesn't need to know about the details of each display element; it just notifies them of changes.

  In this example, WeatherData is the subject that maintains a list of observers (CurrentConditionsDisplay, etc.) that implement the Observer interface.
   When WeatherData receives new measurements, it notifies all registered observers by calling notifyObservers(), which in turn calls update() on each observer. 
   This mechanism allows for the weather data to be displayed in different formats by separate display elements without tightly coupling the subject to its observers.

 * 
 */

 import java.util.ArrayList;
 import java.util.List;
 
 // Subject interface
 interface Subject {
     void registerObserver(Observer o);
     void removeObserver(Observer o);
     void notifyObservers();
 }
 
 // Observer interface
 interface Observer {
     void update(float temp, float humidity, float pressure);
 }
 
 // Concrete Subject
 class WeatherData implements Subject {
     private List<Observer> observers;
     private float temperature;
     private float humidity;
     private float pressure;
 
     public WeatherData() {
         observers = new ArrayList<>();
     }
 
     @Override
     public void registerObserver(Observer o) {
         observers.add(o);
     }
 
     @Override
     public void removeObserver(Observer o) {
         observers.remove(o);
     }
 
     @Override
     public void notifyObservers() {
         for (Observer observer : observers) {
             observer.update(temperature, humidity, pressure);
         }
     }
 
     // Method to update measurements
     public void setMeasurements(float temperature, float humidity, float pressure) {
         this.temperature = temperature;
         this.humidity = humidity;
         this.pressure = pressure;
         notifyObservers();
     }
 }
 
 // Concrete Observer
 class CurrentConditionsDisplay implements Observer {
     private float temperature;
     private float humidity;
 
     @Override
     public void update(float temp, float humidity, float pressure) {
         this.temperature = temp;
         this.humidity = humidity;
         display();
     }
 
     public void display() {
         System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
     }
 }
 
 // Usage
 public class ObserverPatternDemo {
     public static void main(String[] args) {
         WeatherData weatherData = new WeatherData();
         CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();
 
         weatherData.registerObserver(currentDisplay);
 
         // Simulate new weather measurements
         weatherData.setMeasurements(80, 65, 30.4f);
         weatherData.setMeasurements(82, 70, 29.2f);
     }
 }
 