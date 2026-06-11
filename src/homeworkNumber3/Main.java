package homeworkNumber3;

import java.util.Scanner;

public class Main {

    private static final String sep = "-".repeat(50);
    private static final long millis = 1000;

    public enum Temperature {
        WARM,
        NORMAL,
        COLD
    }

    public static void main(String[] args) throws InterruptedException {
        fullOutputData();
    }

    public static String checkingEvenNumber(int num) {
        return (num % 2 == 0) ? "число четное" : "число нечетное";
    }

    public static Temperature findTemperature(int temperature) {
        if (temperature > -5) {
            return Temperature.WARM;
        } else if (temperature >= -20) {
            return Temperature.NORMAL;
        } else {
            return Temperature.COLD;
        }
    }

    public static void printSquaresFrom10To20() {
        for (int i = 10; i <= 20; i++) {
            System.out.print((i * i) + " ");
        }
        System.out.println();
    }

    public static void printArrayOfSevens() {
        int num = 7;
        while (num <= 98) {
            System.out.print(num + " ");
            num += 7;
        }
        System.out.println();
    }

    public static int sumDigits(int num, Scanner scanner) {
        while (true) {
            if (num > 0) {
                return (int) ((num - 1) * (double) num / 2);
            } else {
                System.out.println("Число должно быть больше 0, повторите попытку");
                num = readInt(scanner);
            }
        }
    }

    public static int readInt(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Ошибка! Введите правильное целое число.");
                scanner.next();
            }
        }
    }

    public static void fullOutputData() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        // Задание 1
        System.out.printf("задание номер 1:\nВведите целое число для задания номер 1\n");
        int num1 = readInt(scanner);
        System.out.printf("Результат: %s\n%s\n", checkingEvenNumber(num1), sep);

        Thread.sleep(millis);

        // Задание 2
        System.out.printf("задание номер 2:\nВведите температуру для задания номер 2\n");
        int temp = readInt(scanner);
        System.out.printf("Результат: %s\n%s\n", findTemperature(temp), sep);

        Thread.sleep(millis);

        // Задание 3
        System.out.printf("задание номер 3:\nРезультат: ");
        printSquaresFrom10To20();
        System.out.print(sep + "\n");

        Thread.sleep(millis);

        // Задание 4
        System.out.printf("задание номер 4:\nРезультат: ");
        printArrayOfSevens();
        System.out.print(sep + "\n");

        Thread.sleep(millis);

        // Задание 5
        System.out.printf("задание номер 5:\nВведите целое положительное число для задания номер 5\n");
        int num5 = readInt(scanner);
        System.out.printf("Результат: %d\n%s\n", sumDigits(num5, scanner), sep);

        scanner.close();
    }
}