public enum Log {
    INFO, WARN, ERR;

    public void log(String message) {
        switch (this) {
            case INFO -> System.out.println("INFO: " + message);
            case WARN -> {
                System.out.println("Logging WARN message:");
                System.out.println("WARN: " + message);
            }
            case ERR -> System.err.println("ERROR: " + message);
        }
    }

    public static void main(String[] args) {
        Log.INFO.log("Usb is connected");
        Log.WARN.log("Low disk space");
        Log.ERR.log("No keyboard found");
    }
}
