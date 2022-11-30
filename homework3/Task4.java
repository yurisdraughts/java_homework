import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        List<Integer> list1 = generateRandomInts(10, 0, 10);
        System.out.print("list1: ");
        System.out.println(list1);

        List<Integer> list2 = generateRandomInts(10, 0, 10);
        System.out.print("list2: ");
        System.out.println(list2);

        System.out.print("list1 - list2: ");
        System.out.println(difference(list1, list2));

        System.out.print("list2 - list1: ");
        System.out.println(difference(list2, list1));

        System.out.print("list1 ^ list2: ");
        System.out.println(symmDifference(list1, list2));
    }

    static List<Integer> generateRandomInts(int size, int origin, int bound) {
        Random random = new Random();
        List<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < size; i++) {
            result.add(random.nextInt(origin, bound));
        }

        return result;
    }

    static List<Integer> difference(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<Integer>(list1);
        
        for (int i = 0; i < result.size(); i++) {
            if (list2.indexOf(result.get(i)) != -1) {
                result.remove(i);
                i--;
            }
        }

        return result;
    }

    static List<Integer> symmDifference(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = difference(list1, list2);
        List<Integer> result2 = difference(list2, list1);

        result.addAll(result2);

        return result;
    }
}
