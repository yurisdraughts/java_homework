import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir").concat("/file3.txt"));

        try (BufferedReader bufReader = new BufferedReader(new FileReader(file))) {
            String line = bufReader.readLine();
            String[] result = destructureJSON(line);

            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static String[] destructureJSON(String JSON) {
        JSON = JSON.substring(1, JSON.length() - 1); // убираем скобки [ и ] вокруг массива
        String[] entries = JSON.split(", "); // разделяем на элементы массива
        String[] resultDraft = new String[entries.length];

        for (int i = 0; i < entries.length; i++) {
            entries[i] = entries[i].substring(1, entries[i].length() - 1); // убираем скобки { и } вокруг объекта
            String[] pairs = entries[i].split(","); // разделяем на пары "ключ:значение"

            StringBuilder student = new StringBuilder("Студент ");
            StringBuilder grade = new StringBuilder(" получил ");
            StringBuilder subject = new StringBuilder(" по предмету ");
            int fields = 0;

            for (int j = 0; j < pairs.length; j++) {
                String[] keyValue = pairs[j].split(":");

                if (keyValue[0].equals("\"фамилия\"")) {
                    student.append(keyValue[1].substring(1, keyValue[1].length() - 1));
                    fields++;
                } else if (keyValue[0].equals("\"оценка\"")) {
                    grade.append(keyValue[1].substring(1, keyValue[1].length() - 1));
                    fields++;
                } else if (keyValue[0].equals("\"предмет\"")) {
                    subject.append(keyValue[1].substring(1, keyValue[1].length() - 1));
                    fields++;
                }
            }

            // если все 3 поля присутствуют, добавляем элемент в массив
            if (fields < 3)
                continue;
            else
                resultDraft[i] = student.append(grade.toString()).append(subject.toString()).append(".").toString();
        }

        // убираем все null, который могут оказаться в результате
        List<String> values = new ArrayList<String>();
        for (String entry : resultDraft) {
            if (entry != null) {
                values.add(entry);
            }
        }
        String[] result = values.toArray(new String[values.size()]);

        return result;
    }
}
