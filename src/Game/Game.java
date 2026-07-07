package Game;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    private final char[][] board = new char[3][3];
    private final Random random = new Random();
    private char humanSymbol;
    private char aiSymbol;
    private int current;
    private final String separator = "-".repeat(60);


    private void initialization() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = '-';
            }
        }
    }

    public Game() {
        initialization();
        choosePlayer();
    }

    private void printBoard(){
        for(char[] chars : board) {
            for(char el : chars){
                System.out.print(el + "\t");
            }
            System.out.println();
        }
    }

    private void choosePlayer(){
        current = random.nextInt(2);
    }

    private boolean checkWin(char symbol) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) return true;
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) return true;
        }

        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) return true;
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) return true;

        return false;
    }


    public boolean run() {
        System.out.println("Поле до начала игры:");
        printBoard();

        if(current == 0){
            humanSymbol = 'X';
            aiSymbol = 'O';
            System.out.println("Вы ходите первым\nВаш символ:\t" + humanSymbol);
            System.out.println(separator);
        } else {
            humanSymbol = 'O';
            aiSymbol = 'X';
            System.out.println("Вы ходите вторым\nВаш символ:\t" + humanSymbol);
            System.out.println(separator);
        }


        while(isBoredFull()) {
            if(current == 0){
                System.out.println("Ваш ход");
                correctInputFromConsole(humanSymbol);
            } else {
                System.out.println("Ходит компьютер");
                inputFromAi(aiSymbol);
            }

            printBoard();

            if(checkWin(humanSymbol)) {
                displayVictoryHuman(humanSymbol);
                return true;
            } else if (checkWin(aiSymbol)) {
                displayVictoryAi(aiSymbol);
                return false;
            }


            current = Math.abs(current - 1);
        }



        displayDraw();
       return false;


    }


    private boolean isBoredFull(){
        for(char[] chars : board) {
            for(char el : chars){
                if(el == '-') return true;
            }
        }
        return false;
    }


    private void inputFromAi(char symbol){
        int x;
        int y;
        while (true){
            x = random.nextInt(3);
            y = random.nextInt(3);
            if(board[x][y] == '-'){
                board[x][y] = symbol;
                return;
            }
        }
    }


    private void correctInputFromConsole(char symbol){

        int x;
        int y;
        while(true){
            String line = scanner.nextLine().trim();
            String[] coordinates = line.split("[, ]+");
            try {
                 x = Integer.parseInt(coordinates[0]);
                 y = Integer.parseInt(coordinates[1]);
            } catch (Exception e) {
                System.out.println("Ошибка");
                continue;
            }

            if(x > 2 || x < 0 || y < 0 || y > 2) {
                System.out.println("Ошибка");
                continue;
            }

            if(board[x][y] == '-'){
                board[x][y] = symbol;
                return;
            }
            System.out.println("Эта строка уже существует, повторите попытку");
        }
    }

    private void displayVictoryHuman(char symbol) {
        System.out.println("-------------------------- ПОБЕДА --------------------------");
        System.out.println(" Поздравляю! Вы победили!" + " Ваш символ\t" + symbol);
        System.out.println("------------------------------------------------------------");
    }

    private void displayVictoryAi(char symbol) {
        System.out.println("------------------------ ПОРАЖЕНИЕ -------------------------");
        System.out.println(" Искусственный интеллект победил!" + " Его символ\t" + symbol);
        System.out.println("------------------------------------------------------------");
    }

    private void displayDraw() {
        System.out.println("-------------------------- НИЧЬЯ ---------------------------");
        System.out.println("Ничья");
        System.out.println("------------------------------------------------------------");
    }



}
