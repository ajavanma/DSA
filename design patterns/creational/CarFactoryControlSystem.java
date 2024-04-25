/*
 * 
 * The Singleton Design Pattern ensures that a class has only one instance and provides a global point of access to that instance. 
 * It's commonly used in scenarios where a "single point of control" is needed over a resource or service
 *  (eg. control state of the application = "shared source of truth")
 * 
 * 
    * Implementation: 
        Typically implemented by creating a class with a method that creates a new instance of the class if one does not exist. 
        If an instance already exists, it returns a reference to that object.
    * Key Components:
    * Private constructor to restrict instantiation of the class from other classes.
    * Private static variable of the same class that is the only instance of the class.
    * Public static method that returns the instance of the class, this is the global access point for the outer world to get the instance of the singleton class.
 * 
 * maintaining a single copy of the application state
 * 
 */

public class Singleton {
    private static Singleton instance;        // static instance variable
    
    private Singleton() {} // Private constructor
    
    public static Singleton getInstance() {   // if there is no instance of it, instantiate it
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

// example





//
// example
// car factory control system
// This control system might manage production quotas, track inventory levels, or handle other operational details that should be consistently managed through a single point of reference.

public class CarFactoryControlSystem {
    // The sole instance of the class
    private static CarFactoryControlSystem instance;
    
    // Private constructor to prevent instantiation from outside the class
    private CarFactoryControlSystem() {
        // Initialization code here
    }
    
    // Public static method to get the instance of the class
    public static synchronized CarFactoryControlSystem getInstance() {
        if (instance == null) {
            instance = new CarFactoryControlSystem();
        }
        return instance;
    }
    
    // Methods to manage the factory operations
    public void monitorProduction() {
        // Monitor production implementation
        System.out.println("Monitoring car production...");
    }
    
    // Add other factory control methods here
}

// Usage
public class SingletonDemo {
    public static void main(String[] args) {
        CarFactoryControlSystem controlSystem1 = CarFactoryControlSystem.getInstance();
        controlSystem1.monitorProduction();
        
        CarFactoryControlSystem controlSystem2 = CarFactoryControlSystem.getInstance();
        controlSystem2.monitorProduction();
        
        // controlSystem1 and controlSystem2 refer to the same instance
        System.out.println(controlSystem1 == controlSystem2); // This will print "true"
    }
}

