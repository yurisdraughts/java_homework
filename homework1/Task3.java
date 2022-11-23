// Реализовать простой калькулятор

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите арифметическое выражение, например, 1 + 2: ");
        String expression = scanner.nextLine();
        scanner.close();

        float result = calculator(expression);
        System.out.print(result);
    }

    public static float calculator(String expression) {
        Scanner scanner = new Scanner(expression);

        int num1 = scanner.nextInt();
        String operator = scanner.next();
        int num2 = scanner.nextInt();
        float result = 0.0f;
        
        scanner.close();

        if (operator.equals("+")) result = (float)(num1 + num2);
        else if (operator.equals("-")) result = (float)(num1 - num2);
        else if (operator.equals("*")) result = (float)(num1 * num2);
        else if (operator.equals("/")) result = (float) num1 / (float) num2;

        return result;
    }
}
