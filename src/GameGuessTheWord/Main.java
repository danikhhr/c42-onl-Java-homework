package GameGuessTheWord;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){

            Game game = new Game();
            game.start();

            System.out.print("\nХотите начать заново? (да/нет): ");
            String answer = scanner.nextLine().trim();

            if (answer.equalsIgnoreCase("нет")) {
                System.out.println("Прощайте, до свидания!");
                break;
            }

        }

        scanner.close();
    }
}
