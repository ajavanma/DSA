
// The Adapter pattern (wrapper) allows objects with incompatible interfaces to work together. 
// It acts as a bridge between two incompatible interfaces.
//
// a scenario where we have a UsbCable and a MicroUsbCable,
//  and we want the latter to be compatible with a UsbPort using an adapter.
//
// Explanation
// UsbCable (Target Interface): This is the target interface that the client expects or works with.
// MicroUsbCable (Adaptee Class): This represents the incompatible interface that needs adapting.
// MicroToUsbAdapter (Adapter Class): This class implements the UsbCable interface and contains a reference to a MicroUsbCable. 
//                                      It adapts the interface of MicroUsbCable to the UsbCable interface.
// UsbPort (Client Class): This class expects an object that implements the UsbCable interface to be plugged into it.
// The Adapter Pattern enables the MicroUsbCable to be used with the UsbPort through the MicroToUsbAdapter, demonstrating how
//  incompatible interfaces can be made to work together.
//

// Target Interface
interface UsbCable {
    void plugUsb();
}

// Adaptee Class
class MicroUsbCable {
    private boolean isPlugged = false;

    public void plugMicroUsb() {
        isPlugged = true;
        System.out.println("Micro USB Cable is plugged in.");
    }
}

// Adapter Class
class MicroToUsbAdapter implements UsbCable {
    private MicroUsbCable microUsbCable;

    public MicroToUsbAdapter(MicroUsbCable microUsbCable) {
        this.microUsbCable = microUsbCable;
    }

    @Override
    public void plugUsb() {
        microUsbCable.plugMicroUsb();
    }
}

// Client Class
class UsbPort {
    private boolean portAvailable = true;

    public void plug(UsbCable usbCable) {
        if (portAvailable) {
            usbCable.plugUsb();
            portAvailable = false;
            System.out.println("USB Cable is plugged into USB Port.");
        } else {
            System.out.println("USB Port is not available.");
        }
    }
}

// Usage
public class AdapterPatternDemo {
    public static void main(String[] args) {
        // Direct usage of UsbCable with UsbPort
        UsbCable usbCable = new UsbCable() {
            @Override
            public void plugUsb() {
                System.out.println("USB Cable is plugged in directly.");
            }
        };
        UsbPort usbPort1 = new UsbPort();
        usbPort1.plug(usbCable);

        // Using MicroUsbCable with UsbPort through an adapter
        MicroUsbCable microUsbCable = new MicroUsbCable();
        UsbPort usbPort2 = new UsbPort();
        MicroToUsbAdapter adapter = new MicroToUsbAdapter(microUsbCable);
        usbPort2.plug(adapter);
    }
}
