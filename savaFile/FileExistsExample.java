import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileExistsExample {
    public static void main(String[] args) {
        Path path = Paths.get("example.txt");
        boolean exists = Files.exists(path);
        System.out.println("File exists: " + exists);
    }
}
