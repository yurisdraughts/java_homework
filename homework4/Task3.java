import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Task3 {
    public static void main(String[] args) {
        System.out.printf("%.1f\n", calculate("5 4 3 - +")); // 6
        System.out.printf("%.1f\n", calculate("1 2 + 4 * 3 +")); // 15
        System.out.printf("%.1f\n", calculate("3 4 2 * 1 5 - / +")); // 1
    }

    static float calculate(String input) {
        Stack<String> elements = new Stack<String>();

        List<String> operators = Arrays.asList(new String[]{"+", "-", "*", "/"});

        for (String element : input.split(" ")) {

            if (operators.contains(element)) {
                float b = Float.parseFloat(elements.pop());
                float a = Float.parseFloat(elements.pop());

                if (element.equals("+")) {
                    elements.push(String.valueOf(a + b));
                } else if (element.equals("-")) {
                    elements.push(String.valueOf(a - b));
                } else if (element.equals("*")) {
                    elements.push(String.valueOf(a * b));
                } else {
                    elements.push(String.valueOf(a / b));
                }
            } else {
                elements.push(element);
            }

        }

        return Float.parseFloat(elements.pop());
    }
}
