package homeworkNumber11;

import java.util.Arrays;
import java.util.Scanner;

public class homeworkNumber11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 3 строки");
        String[] lines = inputArrFromConsole(scanner);
        findShortestAndLongest( lines);
        System.out.println("-".repeat(50));
        sortByLength(lines);
        System.out.println("-".repeat(50));
        findShorterThanAverage(lines);
        System.out.println("-".repeat(50));
        findFirstWithUniqueChars(lines);
        System.out.println("-".repeat(50));
        duplicateEachCharacter(scanner);
        System.out.println("-".repeat(50));
        findPalindrome(scanner);
        System.out.println("-".repeat(50));
    }

    /// /////////////////ЗАДАНИЕ 1/////////////////////
    public static void findShortestAndLongest(String[] lines) {
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;
        String minLine = "";
        String maxLine = "";
        for (int i = 0; i < 3; i++) {
            int length = lines[i].length();
            if(minLength > length) {
                minLength = length;
                minLine = lines[i];
            }
            if(maxLength < length) {
                maxLength = length;
                maxLine = lines[i];
            }
        }
        System.out.printf("Самая длинная строка: %s\nЕе длина: %d\n" +
                "Самая короткая строка: %s\nЕе длина: %d\n", maxLine, maxLength, minLine, minLength);
    }

    /// /////////////////ЗАДАНИЕ 2/////////////////////
    public static void sortByLength(String[] lines) {
        String temp;
        for (int i = 0; i < lines.length - 1; i++) {
            for (int j = 0; j < lines.length - 1; j++) {
                if(lines[j].length() > lines[j + 1].length()) {
                    temp = lines[j];
                    lines[j] = lines[j + 1];
                    lines[j + 1] = temp;
                }
            }
        }
        System.out.println("Отсортированный массив:\t" + Arrays.toString(lines));
    }

    /// /////////////////ЗАДАНИЕ 3/////////////////////
    public static void findShorterThanAverage(String[] lines) {
        int averageLength = 0;
        for(String line : lines){
            averageLength += line.length();
        }
        double newLength = (double) averageLength / lines.length;
        for(String line : lines){
            if(newLength > line.length() ) {
                System.out.printf("Строка, длина которой меньше средней:\t%s\nДлина этой строки:\t%d\n",
                        line, line.length());
            }
        }
    }

    /// /////////////////ЗАДАНИЕ 4/////////////////////
    public static void findFirstWithUniqueChars(String[] lines) {
        for (String resLine : lines) {
            if(hasAllUniqueChars(resLine)) {
                System.out.println("Слово найдено!" + resLine);
                return;
            }
        }
            System.out.println("Слово не найдено");
    }

    /// /////////////////ЗАДАНИЕ 5/////////////////////
    public static void duplicateEachCharacter(Scanner scanner) {
        System.out.println("Введите произвольную строку");
        String line = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            stringBuilder.append(line.charAt(i)).append(line.charAt(i));
        }
        System.out.println("Новая задублированная строка: " + stringBuilder);
    }

    /// /////////////////ЗАДАНИЕ */////////////////////
    public static void findPalindrome(Scanner scanner) {
        System.out.println("Введите произвольную строку");
        String[] words =  scanner.nextLine().split(" ");
        int index;
        System.out.println("Введите номер числа для проверки на палиндром");
        while (true) {
            if (scanner.hasNextInt()) {
                index = scanner.nextInt();
                if (index >= 0 && index < words.length) break;
                System.out.println("Индекс вне диапазона. Попробуйте снова:");
            } else {
                System.out.println("Введите целое число:");
                scanner.next();
            }
        }
        String line = words[index];
        int right = line.length() - 1;
        int left = 0;
        while(right >= left) {
            if (Character.toLowerCase(line.charAt(right)) != Character.toLowerCase(line.charAt(left))) {
                System.out.println("Это не палиндром");
                return;
            }
            right--;
            left++;
        }
        System.out.println("Это слово палиндром!");
    }

    public static boolean hasAllUniqueChars(String str){
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(str.charAt(j))) return false;
            }
        }
        return true;
    }

    public static String[] inputArrFromConsole(Scanner scanner) {
        String[] arr = new String[3];
        while(true) {
            try {
                for (int i = 0; i < 3; i++) {
                    arr[i] = scanner.nextLine();
                }
                break;
            } catch (Exception e){
                System.out.println("Введено некорректное значение, повторите попытку");
            }
        }
        return arr;
    }
}
