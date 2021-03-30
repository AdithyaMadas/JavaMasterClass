package JavaNIOReadWrite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Path path = FileSystems.getDefault().getPath("data.txt");
            Files.write(path, "Line 1\nLine 2\nLine 3\nLine 4".getBytes(StandardCharsets.UTF_8), StandardOpenOption.TRUNCATE_EXISTING);
            Files.write(path, "\nLine 5".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            List<String> lines = Files.readAllLines(path);
            for (String l : lines) {
                System.out.println(l);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
