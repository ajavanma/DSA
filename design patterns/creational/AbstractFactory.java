/*
    Abstract Factory
Intent: The Abstract Factory pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes.
Usage: Use the Abstract Factory when dealing with multiple families of products or when you want to provide a library of products without exposing the implementation logic.
Implementation: This pattern involves multiple factory methods, usually one for each type of product. It is typically implemented with an abstract factory interface that declares a set of methods for creating each product. Concrete factories implement this interface to create specific products of a particular variety.
Flexibility: The Abstract Factory pattern is about creating families of related or dependent objects without necessarily detailing their concrete classes. It is more complex and involves a higher level of abstraction compared to the Factory Method.

    * Creational pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes.
    * Use when you have interrelated products that need to be created together.
    
*/

// Car and CarAccessory are the product interfaces
interface Car {
    void drive();
}

interface CarAccessory {
    void use();
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

class SedanAccessory implements CarAccessory {
    @Override
    public void use() {
        System.out.println("Using sedan accessory");
    }
}

class SUVAccessory implements CarAccessory {
    @Override
    public void use() {
        System.out.println("Using SUV accessory");
    }
}

// The Abstract Factory
interface AbstractCarFactory {
    Car createCar();
    CarAccessory createAccessory();
}

// Concrete Factories
class SedanFactory implements AbstractCarFactory {
    @Override
    public Car createCar() {
        return new SedanCar();
    }

    @Override
    public CarAccessory createAccessory() {
        return new SedanAccessory();
    }
}

class SUVFactory implements AbstractCarFactory {
    @Override
    public Car createCar() {
        return new SUVCar();
    }

    @Override
    public CarAccessory createAccessory() {
        return new SUVAccessory();
    }
}

// Usage
public class AbstractFactory {
    public static void main(String[] args) {
        AbstractCarFactory sedanFactory = new SedanFactory();
        Car sedan = sedanFactory.createCar();
        CarAccessory sedanAccessory = sedanFactory.createAccessory();
        sedan.drive();
        sedanAccessory.use();

        AbstractCarFactory suvFactory = new SUVFactory();
        Car suv = suvFactory.createCar();
        CarAccessory suvAccessory = suvFactory.createAccessory();
        suv.drive();
        suvAccessory.use();
    }
}
