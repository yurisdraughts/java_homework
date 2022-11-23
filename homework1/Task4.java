// Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например 1? + ?5 = 69. Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.

// решение только для случая, когда q, w < 100 и у q пропущена 2-я цифра, а у w - 1-я (т.е. как в примере)

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(
                "Задайте уравнение: ");
        String expression = scanner.nextLine();
        scanner.close();

        Scanner scanner2 = new Scanner(expression).useDelimiter("[^0-9]+");
        int q = scanner2.nextInt();
        int w = scanner2.nextInt();
        int e = scanner2.nextInt();
        scanner2.close();

        boolean flag = false;
        int i = 0;
        int j = 1;
        loops: for (i = 0; i <= 9; i++) {
            for (j = 1; j <= 9; j++) {
                if ((q * 10 + i) + (j * 10 + w) == e) {
                    flag = true;
                    break loops;
                }
            }
        }

        if (flag == true) {
            System.out.printf("%d%d + %d%d = %d", q, i, j, w, e);
        } else {
            System.out.print("Решений нет.");
        }
        
    }
}
