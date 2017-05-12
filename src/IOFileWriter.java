import java.io.*;

/**
 * Created by Mihnea on 04.05.2017.
 */
public class IOFileWriter {
    public static void main(String[] args) throws IOException {
        File source = new File("source.log");
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(source)))) {
            out.println("This is a newly created file containing text.");
            out.println("Hello.");
        }
    }
}
