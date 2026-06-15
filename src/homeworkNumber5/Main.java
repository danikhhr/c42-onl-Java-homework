package homeworkNumber5;

import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final String separator = "-".repeat(50);
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {

        System.out.println("task number 1:");
        addValueToArrayAndFindSum();

        System.out.println("task number 2:");
        createChessBoard();

        System.out.println("task number *:");
        createAndPrintSnakeArray();


        scanner.close();
    }

    public static void createAndPrintSnakeArray(){
        int rows = lengthArr("Enter rows:");
        int cols = lengthArr("Enter cols:");
        int[][] arr = new int[rows][cols];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0){
                for (int j = 0; j < cols; j++) {
                    arr[i][j] = num;
                    num++;
                }
            } else {
                for (int j = cols - 1; j >= 0 ; j--) {
                    arr[i][j] = num;
                    num++;
                }
            }

        }
        printArray(arr);
    }

    public static void printArray(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println(separator);
    }

    public static void printArray(String[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println(separator);
    }

    public static void createChessBoard(){
        String[][] chessBoard = new String[8][8];
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
               chessBoard[i][j] = (i + j) % 2 == 0 ? "W" : "B";

            }
        }
        printArray(chessBoard);
    }

    public static void addValueToArrayAndFindSum(){
        int res = 0;
        int rows = lengthArr("Enter rows:");
        int cols = lengthArr("Enter cols:");
        int[][] arr = randomInput(rows, cols);

        System.out.println("Array before addition: \n");
        printArray(arr);

        System.out.println("Enter the number to be added to each array element: \n");
        int addNumber = correctInput();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] += addNumber;
                res += arr[i][j];
            }
        }

        System.out.println("Array after addition: \n");
        printArray(arr);
        System.out.println("Sum of numbers:\t" + res + "\n" + separator);
    }

    public static int[][] randomInput(int rows, int cols){
        int[][] arr = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = random.nextInt(1, 100);
            }
        }
        return arr;
    }

    public static int lengthArr(String message){
        System.out.println(message);
        int length = correctInput();
        while (length <= 0){
            System.out.println("Please enter a positive number");
            length = correctInput();
        }

        return length;
    }


    public static int correctInput(){
        while(true){
            if(scanner.hasNextInt()){
                return scanner.nextInt();
            }
            System.out.println("Invalid value, please try again");
            scanner.next();
        }
    }
}
