/*
* Creational pattern that provides an interface for creating objects in a superclass but allows subclasses to alter the type of objects that will be created.
* Use when a class cannot anticipate the class of objects it needs to create.
*
* In the Factory Method pattern, we define an interface for creating an object but let subclasses decide which class to instantiate.

Factory Method
Intent: The Factory Method pattern is intended to define an interface for creating an object, but lets subclasses decide which class to instantiate.
 It lets a class defer instantiation to subclasses.
Usage: Use the Factory Method pattern when a class cannot anticipate the class of objects it needs to create beforehand or
 when a class wants its subclasses to specify the objects it creates.
Implementation: This pattern involves a creator (an interface or abstract class) and concrete classes which implement the factory method to create objects.
 The factory method is typically defined as an abstract method in the creator class, which is overridden by subclasses to instantiate a particular product.

Flexibility: The Factory Method pattern is more about creating a single product 
              but allowing for the flexibility of which specific implementation of the product to instantiate.

 */

// The Product interface
interface Car {
    void drive();
}

// Concrete Products
class SedanCar implements Car {
    @Override
    public void drive() {
        System.out.println("Driving a sedan car");
    }
}

class SUVCar implements Car {
    @Override
    public void drive() {
        System.out.println("Driving an SUV car");
    }
}

// The Creator abstract class
abstract class CarFactory {
    abstract Car createCar();
    
    Car orderCar() {
        Car car = createCar();
        // additional operations like driving
        car.drive();
        return car;
    }
}

// Concrete Creators
class SedanCarFactory extends CarFactory {
    @Override
    Car createCar() {
        return new SedanCar();
    }
}

class SUVCarFactory extends CarFactory {
    @Override
    Car createCar() {
        return new SUVCar();
    }
}

// Usage
public class FactoryMethodDemo {
    public static void main(String[] args) {
        CarFactory sedanFactory = new SedanCarFactory();
        Car sedan = sedanFactory.orderCar();
        
        CarFactory suvFactory = new SUVCarFactory();
        Car suv = suvFactory.orderCar();
    }
}
