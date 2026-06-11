package homeworkNumber4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final String rep = "-".repeat(70);

    public static void main(String[] args) {



        System.out.println("task number 1:");
        outputAndReverseOutput();
        System.out.printf("\n %s\n", rep);

        System.out.println("task number 2:");
        minMaxElement();
        System.out.printf("\n %s\n", rep);

        System.out.println("task number 3:");
        minMaxElementIndex();
        System.out.printf("\n %s\n", rep);

        System.out.println("task number 4:");
        countZeroElement();
        System.out.printf("\n %s\n", rep);

        System.out.println("task number 5:"); // warning
        reverseArray();
        System.out.printf("\n %s\n", rep);

        System.out.println("task number 6:\n");
        System.out.println(isIncreasingSequence());
        System.out.printf("\n %s\n", rep);

        //System.out.println("task number *:\n");
        //System.out.println(isIncreasingSequence());
       // System.out.printf("\n %s\n", rep);

    }

    public static void reverseArray(){
        int length = lengthArr();
        int[] num = chooseMethod(length);
        int swap;
        for (int i = 0, j = length - 1; i < j; i++, j--) {  // 0 1 2 3  -> 0
            swap = num[i];
            num[i] = num[j];
            num[j] = swap;
        }
        System.out.println(Arrays.toString(num));
    }

    public static boolean isIncreasingSequence(){
        int length = lengthArr();
        int[] num = chooseMethod(length);
        for (int i = 1; i < length; i++) {
            if (num[i] < num[i - 1]) return false;
        }

        return true;
    }

    public static void countZeroElement(){
        int length = lengthArr();
        int[] num = chooseMethod(length);
        int count = 0;
        for(int number : num){
            count += number == 0 ? 1 : 0;
        }
        System.out.println("COUNT ZERO ELEMENT: " + count);
    }

    public static void minMaxElementIndex(){
        int length = lengthArr();
        int[] num = chooseMethod(length);
        int minIndex = 0;
        int minNum = Integer.MAX_VALUE;
        int maxIndex = 0;
        int maxNum = Integer.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            if(minNum > num[i]){
                minNum = num[i];
                minIndex = i + 1;
            }
            if(maxNum < num[i]){
                maxNum = num[i];
                maxIndex = i + 1;
            }
        }

        System.out.print("\nMIN INDEX ELEMENT: " + minIndex);
        System.out.println("\nMAX INDEX ELEMENT: " + maxIndex);
    }

    public static void minMaxElement(){
        int length = lengthArr();
        int[] num = chooseMethod(length);
        Arrays.sort(num);
        System.out.print("\nMIN ELEMENT: " + num[0]);
        System.out.println("\nMAX ELEMENT: " + num[length - 1]);
    }

    public static void outputAndReverseOutput(){
        int length = lengthArr();
        int[] num = chooseMethod(length);
        System.out.println("\nOutput array");
        for (int i = 0; i < length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println("\nOutput reverse array");
        for (int i = length - 1; i >= 0; i--) {
            System.out.print(num[i] + " ");
        }

    }

    public static int[] chooseMethod(int length){
        System.out.println("choose a method for input\n" + "1. from the keyboard\n" +
                "2. random");

        int methodNum = correctInput(new Scanner(System.in));
        if (methodNum == 1)
            return Arrays.copyOf(keyboardInout(length), length);
        else if (methodNum == 2)
            return Arrays.copyOf(randomInput(length), length);
        else
           throw new IllegalArgumentException("invalid value");

    }

    public static int lengthArr(){
        System.out.println("Введите размер массива");
        return correctInput(new Scanner(System.in));

    }

    public static int[] randomInput(int length){
        Random random = new Random();
        int[] numbers = new int[length];
        System.out.printf("Заполнение массива длиной от 1 до %d рандомно\n", length);
        for (int i = 0; i < length; i++) {
            System.out.print(i + 1 + ":");
            numbers[i] = random.nextInt(1, 100);
            System.out.printf("%d\n", numbers[i]);
        }
        return numbers;
    }

    public static int[] keyboardInout(int length){
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[length];
        System.out.printf("Заполните массив длиной от 1 до %d\n", length);
        for (int i = 0; i < length; i++) {
            System.out.print(i + 1 + ":");
            numbers[i] = correctInput(scanner);
        }
        return numbers;
    }

    public static int correctInput(Scanner scanner){
        do {
            if(scanner.hasNextInt())
                return scanner.nextInt();
            System.out.println("invalid number, please try again");
            scanner.next();
        } while (true);
    }

}
