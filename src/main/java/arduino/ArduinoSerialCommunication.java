package arduino;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.awt.*;

/**
 * Clase encargada de comnicar el arduino con java usa SerialPortEventListener para registrar eventos en el puerto del arduino
 */
public class ArduinoSerialCommunication implements SerialPortEventListener {
    private SerialPort serialPort;
    private Robot robot;

    /**
     * Metodo encargado de iniciar la comunicación serial,busca el puerto del arduino lo abre y le asigna parametros
     * además de asignar la clase para que registre eventos y notifique
     */
    public void initialize() {
        CommPortIdentifier portId = null;
        Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

        while (portEnum.hasMoreElements()) {
            CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
            if (currPortId.getName().equals("COM6")) { // Replace "COM3" with the correct port name
                portId = currPortId;
                break;
            }
        }

        if (portId == null) {
            System.out.println("Could not find COM port.");
            return;
        }

        try {
            serialPort = (SerialPort) portId.open(this.getClass().getName(), 2000);
            serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);


            serialPort.addEventListener(this);
            serialPort.notifyOnDataAvailable(true);

            System.out.println("Initialized serial communication.");
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    /**
     * Se encarga de cerrar la conexión serial
     */
    public synchronized void close() {
        if (serialPort != null) {
            serialPort.removeEventListener();
            serialPort.close();
        }
    }

    /**
     * Es el metodo que se encarga de recibir información de la conexion con el puerto en el arduino y realizar acciones en la informacion dada,
     * se llama por cada evento
     * @param event Un evento que se registra desde el arduino
     */
    @Override
    public synchronized void serialEvent(SerialPortEvent event) {

        if (event.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
            try {
                robot = new Robot();
                BufferedReader input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
                String inputLine = input.readLine();

                // Handle the input data
                if (inputLine.equals("U")) {
                    moveUp();
                } else if (inputLine.equals("D")) {
                    moveDown();
                } else if (inputLine.equals("R")) {
                    moveRight();
                } else if (inputLine.equals("L")) {
                    moveLeft();
                } else if (inputLine.equals("S")) {
                    select();
                }
            } catch (Exception e) {
                System.err.println(e.toString());
            }
        }
    }

    /**
     * Mueve la posicion del mouse segun ciertas cordenadas
     * @param deltaX Cordenada x
     * @param deltaY Cordenanda y
     */
    private void moveMouse(int deltaX, int deltaY) {
        Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
        int newX = (int) mouseLocation.getX() + deltaX;
        int newY = (int) mouseLocation.getY() + deltaY;
        robot.mouseMove(newX, newY);
    }

    /**
     * Se encarga de mover el mouse arriba
     */
    private void moveUp() {
        moveMouse(0,-10);
    }
    /**
     * Se encarga de mover el mouse abajo
     */
    private void moveDown() {
        moveMouse(0,10);
    }
    /**
     * Se encarga de mover el mouse a la derecha
     */
    private void moveRight() {
        moveMouse(10,0);
    }
    /**
     * Se encarga de mover el mouse a la izquierda
     */
    private void moveLeft() {
        moveMouse(-10,0);
    }
    /**
     * Se encarga de hacer click con el mouse
     */
    private void select() {
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    /**
     * Crea una instancia de la clase y la inicia en un thread,en caso de que se interrrumpa la cierra
     * @param args
     */
    public static void main(String[] args) {
        ArduinoSerialCommunication arduino = new ArduinoSerialCommunication();
        arduino.initialize();

        // Keep the program running until interrupted
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            arduino.close();
        }
    }
}