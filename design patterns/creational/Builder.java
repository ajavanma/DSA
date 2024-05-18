/*
 * The Builder pattern is a creational design pattern that allows for the construction of complex objects step by step. (piece by piece)
 * The Builder pattern is particularly useful when an object needs to be created with many optional components or configurations.
 * 
 * let's consider a scenario where we want to build a custom car with various features such as a choice of engine, color, wheels, and navigation system.
 */

// The Product class
class Car {
    private String engine;
    private String color;
    private int wheels;
    private boolean hasNavigationSystem;

    // Private constructor to enforce the use of the Builder
    private Car(Builder builder) {
        this.engine = builder.engine;
        this.color = builder.color;
        this.wheels = builder.wheels;
        this.hasNavigationSystem = builder.hasNavigationSystem;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", color='" + color + '\'' +
                ", wheels=" + wheels +
                ", hasNavigationSystem=" + hasNavigationSystem +
                '}';
    }

    // Static Builder class
    static class Builder {
        private String engine;
        private String color;
        private int wheels;
        private boolean hasNavigationSystem;

        public Builder engine(String engine) {
            this.engine = engine;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder wheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        public Builder navigationSystem(boolean hasNavigationSystem) {
            this.hasNavigationSystem = hasNavigationSystem;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}

// Usage
public class BuilderDemo {
    public static void main(String[] args) {
        Car car = new Car.Builder()                         // we can chain them, since each has reference to builder
                .engine("V8")
                .color("Red")
                .wheels(4)
                .navigationSystem(true)
                .build();

        System.out.println(car);
    }
}
