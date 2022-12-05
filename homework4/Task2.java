import java.util.Arrays;
import java.util.LinkedList;

public class Task2 {
    public static void main(String[] args) {
        LinkedList<String> llist = new LinkedList<>(Arrays.asList(new String[]{"one", "two", "three"}));
        System.out.println(llist);

        enqueue(llist, "four");
        System.out.println(llist);

        System.out.print(dequeue(llist) + " ");
        System.out.println(llist);

        System.out.print(first(llist) + " ");
        System.out.println(llist);
    }

    static <T> void enqueue(LinkedList<T> llist, T element) {
        llist.addLast(element);
    }

    static <T> T dequeue(LinkedList<T> llist) {
        return llist.removeFirst();
    }

    static <T> T first(LinkedList<T> llist) {
        return llist.get(0);
    }
}
