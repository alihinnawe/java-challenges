public enum Log1 {
    INFO, WARN, ERR;

    public void log(String message) {
        switch (this) {
            case INFO -> System.out.println("INFO: " + message); 
            case WARN -> System.out.println("\u001B[33mWARN: " + message + "\u001B[0m"); // Yellow
            case ERR -> System.err.println("ERR: " + message);  
        }
    }

    public static void main(String[] args) {
        Log1.INFO.log("Usb is connected");
        Log1.WARN.log("Usb might be unstable");
        Log1.ERR.log("Usb connection failed");
    }
}
