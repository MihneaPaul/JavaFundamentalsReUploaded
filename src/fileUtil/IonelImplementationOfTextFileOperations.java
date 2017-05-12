package fileUtil;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;

/**
 * Created by Mihnea on 29.04.2017.
 */
public class IonelImplementationOfTextFileOperations implements textFileOperations {
    @Override
    public List<String> readFile(String name) {
        Path pathI = Paths.get(".", name);
        Charset charset = Charset.forName("UTF-8");
        List<String> lines = null;
        try {
            lines = Files.readAllLines(pathI, charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    @Override
    public void writeFile(String filename, String content) {
        Path path0 = Paths.get(".", filename);
        try {
            if (Files.exists(path0)) {
                Files.write(path0, content.getBytes(), StandardOpenOption.APPEND);
                System.out.println("e intrat pe append");
            } else {
                Files.write(path0, content.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeFile(String filename, List<String> content) {
        try{
            Path path0 = Paths.get(".",filename);
            if(Files.exists(path0)) {
                Files.write(path0,content,StandardOpenOption.APPEND);
            }else{
                Files.write(path0,content);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        IonelImplementationOfTextFileOperations a = new IonelImplementationOfTextFileOperations();
        a.writeFile("zoo.log", "Buna ce mai zici?");
    }
}
