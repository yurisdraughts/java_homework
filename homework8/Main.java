import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<String, Float> studentInfo = new TreeMap<>();
        studentInfo.put("Иван Иванов", 4.8f);
        studentInfo.put("Мария Кузнецова", 5.0f);
        studentInfo.put("Степан Кузьмин", 3.6f);

        WriteToFile jSONWriter = new WriteToJSON();
        jSONWriter.write(studentInfo);

        WriteToFile textWriter = new WriteToText();
        textWriter.write(studentInfo);

        WriteToFile xMLWriter = new WriteToXML();
        xMLWriter.write(studentInfo);
    }
}
