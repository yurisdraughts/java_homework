import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task1 {
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir").concat("/file1.txt"));

        try (BufferedReader bufReader = new BufferedReader(new FileReader(file))) {
            String line = bufReader.readLine();
            System.out.println(turnJSONIntoSQLRequest(line));
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static String turnJSONIntoSQLRequest(String JSON) {
        JSON = JSON.substring(1, JSON.length()-1); // убираем скобки { и }
        String[] items = JSON.split(", "); // разделяем на пары "ключ: значение"
        StringBuilder sqlRequest = new StringBuilder("SELECT * FROM students WHERE");

        boolean first = true;
        for (int i = 0; i < items.length; i++) {
            String[] pair = items[i].split(":"); // разбиваем каждую пару "ключ: значение"
            String value = pair[1];

            if (!value.equals("\"null\"")) {
                String key = pair[0].substring(1, pair[0].length()-1); // убираем кавычки вокруг ключа

                if (first) {
                    first = false;
                } else {
                    sqlRequest.append(" AND");
                } // если пара "ключ: значение" не первая, то соединяем с предыдущей с помощью AND

                sqlRequest
                    .append(" ")
                    .append(key)
                    .append(" = ")
                    .append(value);
            }
        }

        return sqlRequest.toString();
    }
}