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

    public static String taskNum1(int num) {
        return (num % 2 == 0) ? "число четное" : "число нечетное";
    }

    public static Temperature taskNum2(int temperature) {
        if (temperature > -5) {
            return Temperature.WARM;
        } else if (temperature <= -20) {
            return Temperature.COLD;
        } else {
            return Temperature.NORMAL;
        }
    }

    public static int[] taskNum3() {
        int[] numbers = new int[11];
        int num;
        for (int i = 0; i < numbers.length; i++) {
            num = 10 + i;
            numbers[i] = num * num;
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
        Scanner scanner = new Scanner(System.in);
        while (true){
           if(num > 1){
               scanner.close();
               return (int) ((num - 1) * ((double) num / 2));
           }
           else {
               System.out.println("Число должно быть больше 1, повторите попытку");
               num = readInt(scanner);
           }
        }



    }

    public static int readInt(Scanner scanner) {
        int num;
        while (true) {
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                break;
            } else {
                System.out.println("Ошибка! Введите правильное целое число.");
                scanner.next();

            }
        }




        return num;
    }

    public static void fullOutputData() throws InterruptedException {
        int num = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 5 ; i++) {
            Thread.sleep(millis);
            if(i != 3 && i != 4){
                System.out.printf("задание номер %d:\nВведите целое число " +
                        "для задания номер %d\n", i, i);
            } else {
                System.out.printf("задание номер %d:\n", i);
            }

            if(i != 3 && i != 4){
                num = readInt(scanner);
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
