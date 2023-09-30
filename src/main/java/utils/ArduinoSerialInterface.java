package utils;
import com.serialpundit.serial.SerialComManager;
import com.serialpundit.serial.SerialComManager.BAUDRATE;
import com.serialpundit.serial.SerialComManager.DATABITS;
import com.serialpundit.serial.SerialComManager.FLOWCONTROL;
import com.serialpundit.serial.SerialComManager.PARITY;
import com.serialpundit.serial.SerialComManager.STOPBITS;

public class ArduinoSerialInterface {
    public String data;

    private void setData(String data1){
        this.data = data1;
    }

    public static void main(String[] args) {
        try {
            SerialComManager scm = new SerialComManager();
            long handle = scm.openComPort("COM3", true, true, true);
            scm.configureComPortData(handle, DATABITS.DB_8, STOPBITS.SB_1, PARITY.P_NONE, BAUDRATE.B9600, 0);
            scm.configureComPortControl(handle, FLOWCONTROL.NONE, 'x', 'x', false, false);


            ArduinoSerialInterface serialInterface = new ArduinoSerialInterface();
            int var = 1;
            while (var==1) {
                String received = scm.readString(handle);
                System.out.println(received);
            }

                scm.closeComPort(handle);
            } catch(Exception e){
                e.printStackTrace();
            }
    }

    public boolean getS(){
        int dataValue = Integer.parseInt(data);
        return dataValue % 0b10 == 1;
    }

    public boolean getU(){
        int dataValue = Integer.parseInt(data);
        return (dataValue / 0b10) % 0b10 == 1;
    }

    public boolean getD(){
        int dataValue = Integer.parseInt(data);
        return (dataValue / 0b100) % 0b10 == 1;
    }

    public boolean getR(){
        int dataValue = Integer.parseInt(data);
        return (dataValue / 0b1000) % 0b10 == 1;
    }

    public boolean getL(){
        int dataValue = Integer.parseInt(data);
        return dataValue / 0b10000 == 1;
    }
}