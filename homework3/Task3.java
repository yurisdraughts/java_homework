import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        List<Integer> list = generateRandomInts(10, 0, 20);
        System.out.println(list);
        System.out.println(findProperties(list));
    }

    static Map<String, Number> findProperties(List<Integer> originalList) {
        Map<String, Number> result = new HashMap<String, Number>();
        List<Integer> list = new ArrayList<Integer>(originalList);
        list.sort(null);

        result.put("min", list.get(0));
        result.put("max", list.get(list.size() - 1));

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        result.put("average", (float) sum / (float) list.size());

        return result;
    }

    static List<Integer> generateRandomInts(int size, int origin, int bound) {
        Random random = new Random();
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < size; i++) {
            result.add(random.nextInt(origin, bound));
        }

        return result;
    }
}
