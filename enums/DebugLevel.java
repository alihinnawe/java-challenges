import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static DebugLevel activeLevel = DebugLevel.ERROR;

    public static void main(String[] args) {
        File configFile = new File("config.ini");
        try (Scanner scanner = new Scanner(configFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }
                if (line.startsWith("debug.level")) {
                    String[] parts = line.split("=");
                    if (parts.length == 2) {
                        String level = parts[1].trim().toUpperCase();
                        activeLevel = DebugLevel.valueOf(level);
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Config file not found. Using default debug level: ERROR.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: Invalid debug level in config file. Using default debug level: ERROR.");
        }

        for (int i = 1; i <= 1000; i++) {
            log(DebugLevel.DEBUG, "Starting calculation for number: " + i);
            int steps = collatz(i);
            log(DebugLevel.INFO, "Collatz result for " + i + ": " + steps + " steps");
        }
    }

    private static void log(DebugLevel level, String message) {
        if (level.ordinal() >= activeLevel.ordinal()) {
            System.out.println("[" + level + "] " + message);
        }
    }

    private static int collatz(int n) {
        int steps = 0;
        while (n != 1) {
            log(DebugLevel.DEBUG, "Current value: " + n);
            if (n > Integer.MAX_VALUE / 3 && n % 2 != 0) {
                log(DebugLevel.WARN, "Warning: Potential overflow at " + n);
            }
            n = ((n % 2) == 0) ? n / 2 : 3 * n + 1;
            steps++;
        }
        return steps;
    }
}

enum DebugLevel {
    DEBUG,
    INFO,
    WARN,
    ERROR
}
