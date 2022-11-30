import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> list = generateRandomInts(20, 0, 20);
        System.out.println(list);

        removeEvens(list);
        System.out.println(list);
    }

    static List<Integer> generateRandomInts(int size, int origin, int bound) {
        Random random = new Random();
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < size; i++) {
            result.add(random.nextInt(origin, bound));
        }

        return result;
    }

    static void removeEvens(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }
    }
}