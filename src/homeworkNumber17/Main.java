package homeworkNumber17;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println(age());
        System.out.println("=".repeat(50));
        callPredicate( new int[]{-1, 2, 0, 3, -4, 1, 2});
        System.out.println("=".repeat(50));
        callFunction();
        System.out.println("=".repeat(50));
        callConsumer();
        System.out.println("=".repeat(50));
        System.out.println(callSupplier());
    }

    public static LocalDate age() {
        System.out.println("Введите свою дату рождения");
        String birthday = new Scanner(System.in).nextLine();
        return LocalDate.parse(birthday).plusYears(100);
    }

    public static void callPredicate(int[] numbers) {
        System.out.println("Положительные числа");
        Predicate<Integer> positive = x -> x > 0;
        for (int number : numbers) {
            if (positive.test(number)) System.out.print(number + "\t");
        }
        System.out.println();
    }

    public static Double callFunction() {
        System.out.println("Введите количество белорусских рублей в формате \"1000 BYN\" ");
        Function<String, Double> parse = x -> {
            String[] strings = x.split(" ");
            System.out.print(x + "\nв долларах: ");
            System.out.printf("%.2f USD\n", Double.parseDouble(strings[0]) / 2.9);
            return  Double.parseDouble(strings[0]);
        };
        return parse.apply(new Scanner(System.in).nextLine());
    }

    public static void callConsumer() {
        System.out.println("Введите количество белорусских рублей в формате \"1000 BYN\" ");
        Consumer<String> formatter = x -> {
            String[] strings = x.split(" ");
            System.out.print(x + "\nв долларах: ");
            System.out.printf("%.2f USD\n", Double.parseDouble(strings[0]) / 2.9);
        };

        formatter.accept(new Scanner(System.in).nextLine());
    }

    public static String callSupplier() {
        System.out.println("Введите строку для ее преобразования задом наперед");
        Supplier<String> res = () -> new StringBuilder(new Scanner(System.in).nextLine()).reverse().toString();
        return res.get();
    }
}
