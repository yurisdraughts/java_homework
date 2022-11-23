// Вывести все простые числа от 1 до 1000

public class Task2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++) {
            if (isPrime(i)) {
                System.out.print(String.valueOf(i).concat(" "));
            }
        }
    }

    public static boolean isPrime(int n) {
        boolean flag = true;

        for (int i = 2; i <= n/2; i++) {
            if (n % i == 0) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
