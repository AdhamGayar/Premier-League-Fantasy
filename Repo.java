import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public interface Repo {
     void readFromFile(String path) throws FileNotFoundException;
     void writeToFile(String path)throws FileNotFoundException;
}
