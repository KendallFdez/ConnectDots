package arduino;

import gnu.io.CommPortIdentifier;

public class SerialPortExample {
    public static void main(String[] args) {
        // Get available serial ports
        CommPortIdentifier portId;
        java.util.Enumeration<CommPortIdentifier> portEnum = CommPortIdentifier.getPortIdentifiers();
        while (portEnum.hasMoreElements()) {
            portId = portEnum.nextElement();
            System.out.println(portId.getName());
        }
    }
}