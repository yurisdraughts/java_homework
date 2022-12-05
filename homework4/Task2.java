import java.util.Arrays;
import java.util.LinkedList;

public class Task2 {
    public static void main(String[] args) {
        LinkedList<String> llist = new LinkedList<>(Arrays.asList(new String[]{"one", "two", "three"}));
        System.out.println(llist);

        enque(llist, "four");
        System.out.println(llist);

        System.out.print(deque(llist) + " ");
        System.out.println(llist);

        System.out.print(first(llist) + " ");
        System.out.println(llist);
    }

    static <T> void enque(LinkedList<T> llist, T element) {
        llist.addLast(element);
    }

    static <T> T deque(LinkedList<T> llist) {
        return llist.removeFirst();
    }

    static <T> T first(LinkedList<T> llist) {
        return llist.get(0);
    }
}
