import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static DebugLevel activeLevel; // No initial value

    public static void main(String[] args) throws FileNotFoundException {
        // Read the debug level from the config file
        File configFile = new File("config.ini");
        Scanner scanner = new Scanner(configFile); // Throws FileNotFoundException if the file is not found

        boolean levelFound = false;
        while (scanner.hasNext()) {
            String line = scanner.nextLine().trim();
            System.out.println("line: > " + line); // Debugging: Print each line
            if (line.startsWith("debug.level=")) {
                String[] elements = line.split("=");
                if (elements.length == 2) {
                    String level = elements[1].trim().toUpperCase();
                    activeLevel = DebugLevel.valueOf(level); // Throws IllegalArgumentException if the level is invalid
                    levelFound = true;
                    break; // Exit the loop once the debug level is found
                }
            }
        }
        scanner.close(); // Explicitly close the Scanner

        // If the debug level was not found in the file, throw an exception
        if (!levelFound) {
            throw new IllegalArgumentException("Debug level not found in config file.");
        }

        // Perform Collatz calculations for numbers 1 to 1000
        for (int i = 1; i <= 1000; i++) {
            DebugLevel.DEBUG.log("Starting calculation for number: " + i);
            int steps = collatz(i);
            DebugLevel.INFO.log("Collatz result for " + i + ": " + steps + " steps");
        }
    }

    /**
     * Computes the number of steps required to reach 1 using the Collatz conjecture.
     *
     * @param n The starting number for the Collatz sequence.
     * @return The number of steps required to reach 1.
     */
    private static int collatz(int n) {
        int steps = 0;
        while (n != 1) {
            // Log DEBUG messages for each step
            DebugLevel.DEBUG.log("Current value: " + n);

            // Log WARN if n is divisible by 100
            if (n % 100 == 0) {
                DebugLevel.WARN.log("Warning: n is divisible by 100: " + n);
            }

            // Log INFO if n is divisible by 50
            if (n % 50 == 0) {
                DebugLevel.INFO.log("Info: n is divisible by 50: " + n);
            }

            // Apply the Collatz rule
            n = ((n % 2) == 0) ? n / 2 : 3 * n + 1;
            steps++;
        }
        return steps;
    }
}

/**
 * Enum representing different levels of logging.
 * Each level has a corresponding method to log messages with appropriate formatting.
 */
enum DebugLevel {
    DEBUG,  // Debug-level messages (most verbose)
    INFO,   // Informational messages
    WARN,   // Warning messages (highlighted in yellow)
    ERROR;  // Error messages (highlighted in red)

    /**
     * Logs a message with the appropriate formatting based on the log level.
     *
     * @param message The message to log.
     */
    public void log(String message) {
        switch (this) {
            case DEBUG:
                System.out.println("DEBUG: " + message); // Plain debug messages
                break;
            case INFO:
                System.out.println("INFO: " + message);   // Plain info messages
                break;
            case WARN:
                System.out.println("\u001B[33mWARN: " + message + "\u001B[0m"); // Yellow-colored warning messages
                break;
            case ERROR:
                System.err.println("ERROR: " + message); // Red-colored error messages (printed to stderr)
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
    }
}
