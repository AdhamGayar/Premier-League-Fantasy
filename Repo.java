import java.io.FileNotFoundException;

public interface Repo {
     void readFromFile(String path) throws FileNotFoundException;
     void writeToFile(String path)throws FileNotFoundException;
}
