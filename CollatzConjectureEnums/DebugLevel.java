import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

enum DebugLevel {
    DEBUG,
    INFO,
    WARN,
    ERROR;

    private static DebugLevel activeLevel;

    public void log(String message) {
        switch (this) {
            case DEBUG:
                System.out.println("DEBUG: " + message);
                break;
            case INFO:
                System.out.println("INFO: " + message);
                break;
            case WARN:
                System.out.println("\u001B[33mWARN: " + message + "\u001B[0m");
                break;
            case ERROR:
                System.err.println("ERROR: " + message);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
    }

    public static void readConfig() throws FileNotFoundException {
        File configFile = new File("config.ini");
        Scanner scanner = new Scanner(configFile);

        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            System.out.println("line: > " + line);
            if (line.startsWith("debug.level=")) {
                String[] elements = line.split("=");
                if (elements.length == 2) {
                    String level = elements[1].trim().toUpperCase();
                    activeLevel = DebugLevel.valueOf(level);
                    break;
                }
            }
        }
        scanner.close();
    }

    private static int collatz(int n) {
        int steps = 0;
        while (n != 1) {
            DEBUG.log("Current value: " + n);
            if (n % 100 == 0) {
                WARN.log("Warning: n is divisible by 100: " + n);
            }
            if (n % 50 == 0) {
                INFO.log("Info: n is divisible by 50: " + n);
            }
            n = ((n % 2) == 0) ? n / 2 : 3 * n + 1;
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) throws FileNotFoundException {
        readConfig();
        for (int i = 1; i <= 1000; i++) {
            DEBUG.log("Starting calculation for number: " + i);
            int steps = collatz(i);
            INFO.log("Collatz result for " + i + ": " + steps + " steps");
        }
    }
}
