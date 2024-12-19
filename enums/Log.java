public enum Log {
    INFO {
        @Override
        public void log(String message) {
            System.out.println("INFO: " + message);
        }
    },
    WARN {
        @Override
        public void log(String message) {
            System.out.println("Logging WARN message:");
            System.out.println("WARN: " + message);
        }
    },
    ERR {
        @Override
        public void log(String message) {
            System.err.println("ERROR: " + message);
        }
    };

    public abstract void log(String message);

    public static void main(String[] args) {
        Log.INFO.log("Usb is connected");
        Log.WARN.log("Low disk space");
        Log.ERR.log("No keyboard found");
    }
}
