import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        List<Integer> list = generateRandomInts(10, 0, 100);
        System.out.println(list);

        List<Integer> result = mergeSort(list);
        System.out.println(result);
    }

    static List<Integer> mergeSort(List<Integer> originalList) {
        List<Integer> list = new ArrayList<Integer>(originalList);

        if (list.size() == 1) {
            return list;
        } else {
            List<Integer> list1 = mergeSort(list.subList(0, list.size() / 2));
            List<Integer> list2 = mergeSort(list.subList(list.size() / 2, list.size()));
            list.clear();

            int i1 = 0;
            int i2 = 0;
            while (list.size() < list1.size() + list2.size()) {

                if (i1 < list1.size() && i2 < list2.size()) {

                    if (list1.get(i1) < list2.get(i2)) {
                        list.add(list1.get(i1));
                        i1++;
                    } else {
                        list.add(list2.get(i2));
                        i2++;
                    }

                } else if (i1 == list1.size()) {
                    list.addAll(list2.subList(i2, list2.size()));
                } else {
                    list.addAll(list1.subList(i1, list1.size()));
                }
                
            }

            return list;
        }
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
