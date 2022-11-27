import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Task2 {
    public static void main(String[] args) {
        int[] array = {1,2,3,0,5,8,1,2,3,7};
        int[] newArray = bubbleSort(array);

        for (int i = 0; i < newArray.length; i++) {
            if (i != newArray.length-1) System.out.printf("%d, ", newArray[i]);
            else System.out.println(newArray[i]);
        }
    }

    public static int[] bubbleSort(int[] array) {
        Logger logger = Logger.getLogger(Task2.class.getName());
        FileHandler fh;

        try {
            fh = new FileHandler(System.getProperty("user.dir").concat("/task2.log"));
            logger.addHandler(fh);

            SimpleFormatter sf = new SimpleFormatter();
            fh.setFormatter(sf);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        boolean done = false;
        int count = 0;
        while (!done) {
            done = true;

            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    done = false;

                    int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                }
            }

            count++;
            logger.log(Level.INFO, new StringBuilder("Итерация №").append(count).toString());
        }

        return array;
    }
}
