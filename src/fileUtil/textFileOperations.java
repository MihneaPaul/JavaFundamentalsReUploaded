package fileUtil;

import java.util.List;

/**
 * Created by Mihnea on 29.04.2017.
 */
public interface textFileOperations {

    List<String> readFile(String name);
    void writeFile(String filename, String content);
    void writeFile(String filename, List<String> content);
}
