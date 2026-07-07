package GameTicTacToe;

import java.util.Random;
import java.util.Scanner;

public class Game {
   private final char[][] board = new char[3][3];
   private final Random random = new Random();
   private int currentPlayer;
   private final Scanner scanner = new Scanner(System.in);
   private final String separator = "-".repeat(60);

    public Game() {
        initialization();
        currentPlayer = chooseFirstPlayer();
    }

    private void initialization(){
       for (int i = 0; i < board.length; i++) {
           for (int j = 0; j < board[i].length; j++) {
               board[i][j] = '-';
           }
       }
   }

   private int chooseFirstPlayer(){
       return currentPlayer = random.nextInt(2);
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

    public boolean run() throws InterruptedException {
        char humanSymbol;
        char aiSymbol;
        if(currentPlayer == 0){
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

        System.out.println("Поле до начала игры:");
        printBoard();
        System.out.println(separator);

        while (hasEmptyCells()){
            if (currentPlayer == 0) {
                System.out.println("Ваш ход");
                inputFromConsole(humanSymbol);
            } else {
                Thread.sleep(500);
                System.out.println("Ход искусственного интеллекта");
                inputFromAi(aiSymbol);
            }

            printBoard();
            System.out.println(separator);
            currentPlayer = Math.abs(currentPlayer - 1);

            if(checkWin(humanSymbol)){
                displayVictoryHuman(humanSymbol);
                return true;
            } else if(checkWin(aiSymbol)) {
                displayVictoryAi(aiSymbol);
                return false;
            }

        }
        displayDraw();

        return false;
    }

    private void inputFromAi(char symbol){
        int x;
        int y;
        while(true){
            x = random.nextInt(3);
            y = random.nextInt(3);
            if(board[x][y] == '-') {
                board[x][y] = symbol;
                return;
            }

        }
    }


    private void inputFromConsole(char symbol){
        int x;
        int y;
        while(true){
            String input = scanner.nextLine().trim();
            String[] coordinates = input.split("[, ]+");
            if(coordinates.length < 2) {
                System.out.println("Ошибка! Введите два числа через пробел или запятую");
                continue;
            }

            try {
                x = Integer.parseInt(coordinates[0]);
                y = Integer.parseInt(coordinates[1]);
            } catch (Exception e) {
                System.out.println("Ошибка! Введите числа.");
                continue;
            }

            if(x > 2 || x < 0 || y > 2 || y < 0) {
                System.out.println("Ошибка! Введите координаты правильного диапазона");
                continue;
            }

            if(board[x][y] == '-') {
                board[x][y] = symbol;
                return;
            }
            System.out.println("Это место уже занято, выберете другое место");

        }
    }


    private void printBoard(){
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + "\t");
            }
            System.out.println();
        }
    }

    private boolean hasEmptyCells(){
        for (char[] chars : board) {
            for (char aChar : chars) {
                if (aChar == '-') return true;
            }
        }
        return false;
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
