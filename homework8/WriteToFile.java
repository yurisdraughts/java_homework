import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public abstract class WriteToFile {

    protected abstract String format(Map<String, Float> studentInfo);
    protected abstract String getFileName();

    public void write(Map<String, Float> studentInfo) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(getFileName()));
            writer.write(format(studentInfo)); // <- our abstract method
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

}