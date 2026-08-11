package LiveBinaryCalculator;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static StringBuilder stringBuilder = new StringBuilder();
    private static String textToOutput;
    public static void main(String[] args) {
        int choice;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            run(scanner);
            System.out.print("""
                    Хотите ввести другое десятичное число?
                    1 — да;
                    2 — нет.
                    """);
            choice = correctInputNumber(scanner);
            if(choice == 2) {
                System.out.print("""
                        Все результаты сохранены в файле conversion_history.txt.
                        Работа программы завершена.
                        """);
                break;
            }
        }
    }

    public static void run(Scanner scanner) {
        System.out.print("""
                Выберите способ перевода:
                1 — с использованием массива;
                2 — с использованием рекурсии.
                Введите номер варианта:
                """);
        System.out.println("=".repeat(60));
        int choice = correctInputChoice(scanner);
        System.out.print("""
                Введите десятичное число:
                """);
        System.out.println("=".repeat(60));
        int number = correctInputNumber(scanner);
        if (choice == 1) {
            printInformation(number, "массива", binaryCalculatorWithArray(number));
            writeToFile(textToOutput);
        } else {
            printInformation(number, "рекурсии", binaryCalculatorWithRecursion(number));
            writeToFile(textToOutput);
        }
        System.out.println("=".repeat(60));
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
            stringBuilder.append(num).append(" / 2 = ").append(num / 2).append(", остаток ").append(num % 2).append("\n");
            values[length - 1 - i] = num % 2;
            num /= 2;
        }
        for(int el : values) {
            res = res * 10 + el;
        }
        return res;
    }

    public static int binaryCalculatorWithRecursion(int num) {
        stringBuilder.append(num).append(" / 2 = ").append(num / 2).append(", остаток ").append(num % 2).append("\n");
        if (num <= 1) {
            return num;
        }
        return num % 2 + 10 * binaryCalculatorWithRecursion(num / 2);
    }

    public static int correctInputNumber(Scanner scanner) {
        int number;
        while (true) {
            try {
                number = scanner.nextInt();
                if(number > 0 ) return number;
                else System.out.println("Введено отрицательное значение повторите попытку");
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
                else System.out.println("Введено некорректное значение повторите попытку");
            } catch (InputMismatchException e) {
                System.out.println("Введено нечисловое значение повторите попытку");
                scanner.next();
            }
        }
    }

    public static void printInformation(int number, String operation, int result) {
        textToOutput = """
                Исходное число: %d
                Способ перевода: с использованием %s
                
                Процесс перевода:
                %s
                
                Остатки в обратном порядке: %d
                Двоичное значение числа %d: %d
                """.formatted(number, operation, stringBuilder.toString(), result, number, result);
        System.out.println(textToOutput);
    }

    public static void writeToFile(String text) {
        try(FileWriter fileWriter = new FileWriter("src/LiveBinaryCalculator/conversion_history.txt", true)) {
             fileWriter.write(text);
             fileWriter.write("=".repeat(60));
             fileWriter.write("\n");
        } catch (FileNotFoundException e) {
            System.out.println("file not exist");
        } catch (IOException e) {
            System.out.print("""
                    Файл не был записан по непонятным причинам
                    """);
        } finally {
            stringBuilder = new StringBuilder();
        }
    }
}
