// Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число больше 0: ");
        int n = scanner.nextInt();
        scanner.close();

        int triangleNumber = triangleNumber(n);
        int triangleNumber2 = triangleNumber2(n);
        int factorial = factorial(n);
        
        System.out.print("n-ое треугольное число: ");
        System.out.println(String.valueOf(triangleNumber));

        System.out.print("n-ое треугольное число (2-й метод): ");
        System.out.println(String.valueOf(triangleNumber2));

        System.out.print("Факториал n: ");
        System.out.println(String.valueOf(factorial));
    }

    public static int triangleNumber(int n) {
        int result = 0;

        for (int i = 1; i <= n; i++) {
            result += i;
        }

        return result;
    }

    public static int triangleNumber2(int n) {
        return ((n * (n+1)) / 2);
    }

    public static int factorial(int n) {
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }
}