import java.util.*;

enum Log {
    INFO {
        public void log(String msg) {
            buf.add(msg);
            System.out.println("INFO: " + msg);
        }
    }, 
    WARN {
        public void log(String msg) {
            buf.add(msg);
            System.out.println("\u001B[33mWARN: " + msg + "\u001B[0m");
        }
    }, 
    ERR {
        public void log(String msg) {
            buf.add(msg);
            System.err.println("ERR: " + msg);
        }
    };

    // Buffer specific to each log type
    private List<String> buf = new ArrayList<>();

    // Abstract log method
    abstract public void log(String message); 

    // Method to display and clear the buffer
    public void showBuf() {
        for (String s : buf) {
            System.out.println(s);
        }
        buf.clear();
    }
}

public class EnumTestSW {
    public static void main(String[] args) {
        Log info = Log.INFO;
        Log warn = Log.WARN;
        Log err = Log.ERR;

        info.log("Battery charged");
        warn.log("Low disk space. 10%");
        err.log("Invalid email");

        info.log("Last workday of year");
        System.out.println("===");

        // Show buffer contents
        info.showBuf();

        // Create another instance of INFO and log a new message
        Log info2 = Log.INFO;
        info2.log("Temperature 8°C");
        info2.showBuf();
    }
}
