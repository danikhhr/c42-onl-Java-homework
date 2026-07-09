package GameGuessTheWord;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        repeatGame();
    }

    private static void repeatGame() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while(true){
            Game game = new Game();
            game.run();
            System.out.println("Хотите начать заново: да/нет");
            String answer = scanner.nextLine();
            if(answer.equalsIgnoreCase("нет")){
                System.out.println("Прощайте, до свидания");
                break;
            }
        }
        scanner.close();
    }


}
