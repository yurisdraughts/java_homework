import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

public class WriteToText extends WriteToFile {

    @Override
    protected String format(Map<String, Float> studentInfo) {
        ArrayList<String> resultList = new ArrayList<>();
        for (Map.Entry<String, Float> entry : studentInfo.entrySet()) {
            resultList.add(
                    String.format(
                            Locale.US,
                            "%s=%.1f",
                            entry.getKey(), entry.getValue()));
        }

        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append(String.join("\n", resultList));
        return resultBuilder.toString();
    }

    @Override
    protected String getFileName() {
        return "students.txt";
    }

}
