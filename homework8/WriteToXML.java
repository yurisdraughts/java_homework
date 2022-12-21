import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

public class WriteToXML extends WriteToFile {

    @Override
    protected String format(Map<String, Float> studentInfo) {
        ArrayList<String> resultList = new ArrayList<>();
        for (Map.Entry<String, Float> entry : studentInfo.entrySet()) {
            resultList.add(
                    String.format(
                            Locale.US,
                            "\t<student>\n\t\t<name>%s</name>\n\t\t<grade>%.1f</grade>\n\t</student>",
                            entry.getKey(), entry.getValue()));
        }

        StringBuilder resultBuilder = new StringBuilder(
                "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n<students>\n");
        resultBuilder.append(String.join("\n", resultList));
        resultBuilder.append("\n</students>");
        return resultBuilder.toString();
    }

    @Override
    protected String getFileName() {
        return "students.xml";
    }

}
