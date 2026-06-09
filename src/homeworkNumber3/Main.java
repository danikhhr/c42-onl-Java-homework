package homeworkNumber3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final String sep = "-".repeat(50);
    private static final long millis = 1000;

    public enum Temperature {
        WARM,
        COLD,
        NORMAL
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
        } else if (temperature <= -20) {
            return Temperature.COLD;
        } else {
            return Temperature.NORMAL;
        }
    }

    public static int[] getSquaresFrom10To20() {
        int[] numbers = new int[11];
        int num;
        for (int i = 0; i < numbers.length; i++) {
            num = 10 + i;
            numbers[i] = num * num;
        }
        return numbers;
    }

    public static int[] createArrayOfSevens() {
        int end = 98, step = 7;
        int length = end / step;
        int[] numbers = new int[length];
        int num = 7, count = 0;
        while (num <= end && count < length) {
            numbers[count] = num;
            count++;
            num += step;
        }
        return numbers;
    }

    public static int sumDigits(int num, Scanner scanner) {
        while (true){
           if(num > 1){
               return (int) ((num - 1) * ((double) num / 2));
           }
           else {
               System.out.println("Число должно быть больше 1, повторите попытку");
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
        int num = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 5 ; i++) {
            Thread.sleep(millis);
            if(i != 3 && i != 4){
                System.out.printf("задание номер %d:\nВведите целое число " +
                        "для задания номер %d\n", i, i);
                        num = readInt(scanner);
            } else {
                System.out.printf("задание номер %d:\n", i);
            }


            System.out.printf("Результат: %s\n%s\n", switch (i) {
                case 1 -> checkingEvenNumber(num);
                case 2 -> findTemperature(num);
                case 3 -> Arrays.toString(getSquaresFrom10To20());
                case 4 -> Arrays.toString(createArrayOfSevens());
                case 5 -> sumDigits(num, scanner);
                default -> throw new IllegalStateException("Unexpected value: " + i);
            }, sep);

        }
        scanner.close();
    }

}
