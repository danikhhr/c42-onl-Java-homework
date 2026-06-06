package homeworkNumber3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final String sep = "-".repeat(50);

    public static void main(String[] args) throws InterruptedException {
        fullOutputData();
    }

    public static String taskNum1(int num) {
        return (num % 2 == 0) ? "число четное" : "число не четное";
    }

    public static String taskNum2(int temperature) {
        if (temperature > -5) {
            return "Warm";
        } else if (temperature <= -20) {
            return "Cold";
        } else {
            return "Normal";
        }
    }

    public static int[] taskNum3() {
        int[] numbers = new int[11];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (10 + i) * (10 + i);
        }
        return numbers;
    }

    public static int[] taskNum4() {
        int[] numbers = new int[14];
        int num = 7, count = 0;
        while (num <= 98 && count < 14) {
            numbers[count] = num;
            count++;
            num += 7;
        }
        return numbers;
    }

    public static int taskNum5(int num) {
        return (int) ((num - 1) * ((double) num / 2));
    }

    public static int exception(Scanner scanner) {
        int num;
        while (true) {
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                break;
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next();
            }
        }
        return num;
    }

    public static void fullOutputData() throws InterruptedException {
        int num = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 5 ; i++) {
            Thread.sleep(1500);
            if(i != 3 && i != 4){
                System.out.printf("задание номер %d:\nВведите целое число " +
                        "для задания номер %d\n", i, i);
            } else {
                System.out.printf("задание номер %d:\n", i);
            }

            if(i != 3 && i != 4){
                num = exception(scanner);
            }


            System.out.printf("Результат: %s\n%s\n", switch (i) {
                case 1 -> taskNum1(num);
                case 2 -> taskNum2(num);
                case 3 -> Arrays.toString(taskNum3());
                case 4 -> Arrays.toString(taskNum4());
                case 5 -> taskNum5(num);
                default -> throw new IllegalStateException("Unexpected value: " + i);
            }, sep);

        }
        scanner.close();
    }

}
