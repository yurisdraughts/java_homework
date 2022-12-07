import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[] array = new int[] { 6, 5, 3, 1, 8, 7, 2, 4 };
        System.out.println(Arrays.toString(array));

        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    static void heapSort(int[] array) {
        int length = array.length;

        // превращаем массив в кучу (если i > length / 2 - 1, то индекс элемента
        // left > length, т.е. у всех последующих корней с индексом i не будет
        // дочерних элементов, и вызов ф-ции heapify не будет иметь смысла)
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, length, i);
        }

        // перемещаем самый большой элемент кучи в конец массива и превращаем в кучу
        // оставшийся участок массива; повторяем эту операцию для всех элементов массива
        for (int i = length - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    static void heapify(int[] array, int length, int root) {
        // описываем треугольник из индексов предполагаемого наибольшего
        // элемента (корня) и двух его дочерних элементов
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        // если какой-то из дочерних элементов существует и больше корня, присваиваем
        // его индекс индексу наибольшего элемента
        if (left < length && array[left] > array[largest]) {
            largest = left;
        }

        if (right < length && array[right] > array[largest]) {
            largest = right;
        }

        // если элементы должны быть переставлены, рекурсивно вызываем ф-цию для нового
        // корня -
        // бывшего наибольшего предполагаемого элемента
        if (largest != root) {
            int temp = array[root];
            array[root] = array[largest];
            array[largest] = temp;

            heapify(array, length, largest);
        }
    }
}
