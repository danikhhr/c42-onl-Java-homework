package LifeBinaryCalculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true) {
            System.out.println("""
                Выберите способ перевода:
                1 — с использованием массива;
                2 — с использованием рекурсии.
                Введите номер варианта:
                """);
            Scanner scanner = new Scanner(System.in);
            int choice = correctInputChoice(scanner);
            System.out.println("=".repeat(60));
            System.out.println("""
                Введите десятичное число:
                """);
            System.out.println("=".repeat(60));
            int number = correctInputNumber(scanner);
            if (choice == 1) {
                String text = """
                    Исходное десятичное число: %d
                    Способ перевода: с использованием массива
                    Процесс перевода: %d
                    """.formatted(number,  binaryCalculatorWithArray(number));
                System.out.println(text);
                System.out.println();
                writeToFile(text);
            } else {
                String text = """
                    Исходное десятичное число: %d
                    Способ перевода: с использованием рекурсии
                    Процесс перевода: %d
                    """.formatted(number, binaryCalculatorWithRecursion(number));
                System.out.println(text);
                System.out.println();
                writeToFile(text);
            }
            System.out.println("=".repeat(60));
            System.out.println("""
                    Хотите ввести еще одно число:
                    1 - да;
                    2 - нет;
                    """);
            choice = correctInputNumber(scanner);
            if(choice == 2) {
                System.out.println("""
                        Все результаты сохранены в файле conversion_history.txt.
                        Работа программы завершена.
                        """);
                break;
            }
        }

    }

    public static int binaryCalculatorWithArray(int num) {
        int length = 0;
        int temp = num;
        int res = 0;
        while (temp > 0) {
            length++;
            temp /= 2;
        }
        int[] values = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.println(num + " / 2 = " + num / 2  + ", остаток " + num % 2 );
            values[length - 1 - i] = num % 2;
            num /= 2;
        }

        for(int el : values) {
            res = res * 10 + el;
        }
        return res;
    }

    public static int binaryCalculatorWithRecursion(int num) {
        System.out.println(num + " / 2 = " + num / 2 + ", остаток " + num % 2);
        if (num <= 1) {
            return num;
        }
        return num % 2 + 10 * binaryCalculatorWithRecursion(num / 2);
    }

    public static int correctInputNumber(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Введено некорректное значение повторите попытку");
                scanner.next();
            }

        }
    }

    public static int correctInputChoice(Scanner scanner) {
        int choice;
        while (true) {
            try {
                choice = scanner.nextInt();
                if(choice == 1 || choice == 2 )
                    return choice;
                else System.out.println("Введено некорректное значение повторите попытку");;
            } catch (InputMismatchException e) {
                System.out.println("Введено некорректное значение повторите попытку");
                scanner.next();
            }

        }
    }

    public static void writeToFile(String text) {
        try {
            Files.writeString(Path.of("src/LifeBinaryCalculator/conversion_history.txt"), text);
        } catch (FileNotFoundException e) {
            System.out.println("file not exist");
        } catch (IOException e) {
            System.out.println("smth wrong");;
        }
    }
}
