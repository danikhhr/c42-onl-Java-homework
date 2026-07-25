package binaryCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите число для преобразования в двоичный код");
        int num = new Scanner(System.in).nextInt();
        System.out.println("-".repeat(60));
        System.out.println("Калькулятор, работающий с помощью массива");
        binaryCalculatorWithArray(num);
        System.out.println("-".repeat(60));
        System.out.println("Калькулятор, работающий с помощью рекурсии");
        System.out.print("Binary version:\t");
        binaryCalculatorWithRecursion(num);
        System.out.println();
        System.out.println("-".repeat(60));
        System.out.println("Калькулятор, работающий с помощью StringBuilder");
        binaryCalculatorWithStringBuilder(num);
    }

    public static void binaryCalculatorWithStringBuilder(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        while(num > 0) {
            stringBuilder.insert(0, num % 2);
            num /= 2;
        }
        System.out.printf("Binary version:\t%s", stringBuilder);
    }

    public static void binaryCalculatorWithArray(int num) {
        int length = 0;
        int temp = num;
        while(temp > 0) {
            length ++;
            temp /= 2;
        }
        int[] binaryNum = new int[length];
        for (int i = 0; i < length; i++) {
            binaryNum[length - 1 - i] = num % 2;
            num /= 2;
        }
        System.out.print("Binary version:\t");
        for (int i = 0; i < length; i++) {
            System.out.print(binaryNum[i]);
        }
        System.out.println();
    }

    public static void binaryCalculatorWithRecursion(int num) {
        if(num >= 2) {
            binaryCalculatorWithRecursion(num / 2);
        }
        System.out.print(num % 2);
    }
}
