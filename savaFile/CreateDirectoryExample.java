import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class CreateDirectoryExample {
    public static void main(String[] args) {
        try {
            String content = Files.readString(Paths.get("example.txt"));
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
