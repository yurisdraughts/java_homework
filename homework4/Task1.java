import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        String[] array = new String[]{"one", "two", "three"};
        List<String> list = Arrays.asList(array);
        LinkedList<String> linkedList = new LinkedList<>(list);
        System.out.print(linkedList + "\n");

        reverseInPlace(linkedList);
        System.out.print(linkedList + "\n");

        LinkedList<String> newLinkedList = reverseAndReturn(linkedList);
        System.out.print(newLinkedList + "\n");
    }

    static <T> void reverseInPlace(LinkedList<T> linkedList) {
        for (int i = 0; i < linkedList.size()/2; i++) {
            T temp = linkedList.get(i);
            linkedList.set(i, linkedList.get(linkedList.size()-i-1));
            linkedList.set(linkedList.size()-i-1, temp);
        }
    }

    static <T> LinkedList<T> reverseAndReturn(LinkedList<T> linkedList) {
        LinkedList<T> result = new LinkedList<>();

        for (int i = linkedList.size()-1; i >= 0 ; i--) {
            result.add(linkedList.get(i));
        }

        return result;
    }
}