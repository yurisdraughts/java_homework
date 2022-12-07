import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<String> listOfEmployees = new ArrayList<>();

        addEmployeeNames(listOfEmployees, new String[] {
                "Алёна", "Алёна", "Алёна", "Алёна",
                "Иван", "Иван", "Иван",
                "Пётр", "Пётр",
                "Антон"
        });

        System.out.println(howManyNames(listOfEmployees));
    }

    static HashMap<String, Integer> howManyNames(List<String> names) {
        HashMap<String, Integer> result = new HashMap<>();

        for (String name : names) {
            if (result.containsKey(name)) {
                result.replace(name, result.get(name) + 1);
            } else {
                result.put(name, 1);
            }
        }

        return result;
    }

    static void addEmployeeNames(List<String> listOfEmployees, String[] newEmployeeNames) {
        for (String name : newEmployeeNames) {
            listOfEmployees.add(name);
        }
    }
}
