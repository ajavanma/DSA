// Facade Pattern provides a "simplified interface" to "a complex subsystem", making it easier to use. 
// This pattern introduces a facade class that encapsulates the subsystem and exposes a simpler interface to the client. 
// The facade handles the complexities of the subsystem and provides a cleaner API to the clients.
// 
// Scenario let's consider the Array class as part of a complex subsystem. 
// We'll create a facade that simplifies interactions with this subsystem, focusing on operations like adding and removing elements from the array.
//
// Explanation
// Array (Complex Subsystem): This class represents a complex system that manages a dynamic array,
//  including resizing the array when it's full and providing methods to add and remove elements.
// ArrayFacade (Facade Class): This class provides a simplified interface to the Array class, making it easier for clients to use the array.
//  It handles the complexity of managing the dynamic array and exposes simpler methods for adding, removing, and accessing elements.
// Usage: The FacadePatternDemo class demonstrates how to use the ArrayFacade to interact with the Array subsystem in a simpler way. 
// Clients don't need to worry about resizing the array or other internal details.
// The Facade Pattern in this example simplifies the interaction with the dynamic array, demonstrating how the pattern can make complex systems easier to 
//  use by providing a cleaner, more straightforward interface.
//

// Complex Subsystem
class Array {
    private int capacity = 2;
    private int length = 0;
    private int[] arr = new int[capacity]; // Array of capacity = 2

    public void pushback(int n) {
        if (length == capacity) {
            resize();
        }
        arr[length] = n;
        length++;
    }

    private void resize() {
        capacity = 2 * capacity;
        int[] newArr = new int[capacity];
        System.arraycopy(arr, 0, newArr, 0, length);
        arr = newArr;
    }

    public void popback() {
        if (length > 0) {
            length--;
        }
    }

    public int getLength() {
        return length;
    }

    public int get(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return arr[index];
    }
}

// Facade Class
class ArrayFacade {
    private Array array;

    public ArrayFacade() {
        this.array = new Array();
    }

    public void addElement(int element) {
        array.pushback(element);
    }

    public void removeLastElement() {
        array.popback();
    }

    public int getElement(int index) {
        return array.get(index);
    }

    public int getSize() {
        return array.getLength();
    }
}

// Usage
public class FacadePatternDemo {
    public static void main(String[] args) {
        ArrayFacade facade = new ArrayFacade();
        
        facade.addElement(1);
        facade.addElement(2);
        facade.addElement(3);
        
        System.out.println("Current Size: " + facade.getSize());
        
        facade.removeLastElement();
        
        System.out.println("Element at index 0: " + facade.getElement(0));
        System.out.println("New Size: " + facade.getSize());
    }
}
