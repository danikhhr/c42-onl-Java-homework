package GameGuessTheWord;


import java.util.Random;
import java.util.Scanner;

public class Game {
    private final int length = 20;
    private final Scanner scanner = new Scanner(System.in);
    private final String targetWord;
    private final String[] words;
    private int countAttempt = 5;
    private final StringBuilder stringBuilder;
    private final Random random = new Random();


    public Game() {
        words = inputWords();
        targetWord = getRandomWord();
        stringBuilder = new StringBuilder("-".repeat(targetWord.length()));
    }


    private String[] inputWords(){
        String[] words = new String[length];
        System.out.println("Введите 20 слов для игры угадай слово");
        for (int i = 0; i < length; i++) {
            words[i] = scanner.nextLine();
            System.out.printf("%d слово:%s\n", i + 1, words[i]);
        }
        return words;
    }

    private String getRandomWord(){

       return words[random.nextInt(length)];
    }


    public boolean start(){
        String input;
        System.out.println("------------------- ИГРА НАЧАЛАСЬ -------------------");
        System.out.println("Загадано слово из " + targetWord.length() + " букв");
        while (countAttempt > 0 && !isWordGuessed()) {

            System.out.println("ВВЕДИТЕ СЛОВО ИЛИ БУКВУ");
            input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Пустой ввод! Попробуйте ещё раз.");
                continue;
            }


            if(input.length() > 1){
                if(input.equalsIgnoreCase(targetWord)){
                    displayVictory();
                    return true;
                } else {
                    countAttempt--;
                    System.out.printf("ВЫ ВВЕЛИ НЕПРАВИЛЬНОЕ СЛОВО\nКОЛИЧЕСТВО ОСТАВШИХСЯ ПОПЫТОК:\t%d\n", countAttempt);
                }
            } else {
                    char guess = input.charAt(0);
                    boolean found = processGuess(guess);

                if (found) {
                    System.out.printf("Буква найдена!\nОсталось %d попыток\n", countAttempt);
                } else {
                    countAttempt--;
                    System.out.printf("Буква не найдена!\nОсталось %d попыток\n", countAttempt);

                }
                }

        }

        if (isWordGuessed()) {
            displayVictory();
        } else {
            displayDefeat();
        }

        return isWordGuessed();
    }


    private boolean processGuess(char guess){
        boolean found = false;

        for (int i = 0; i < targetWord.length(); i++) {
            if(Character.toLowerCase(guess) == Character.toLowerCase(stringBuilder.charAt(i))) {
                System.out.println("Вы уже вводили эту букву");
                return false;
            }

            if(Character.toLowerCase(guess) == Character.toLowerCase(targetWord.charAt(i))){
                stringBuilder.setCharAt(i, Character.toLowerCase(guess));
                found = true;
            }

        }

        if (found){
            System.out.println(stringBuilder);
        }

        return found;

    }

    private boolean isWordGuessed(){
        return stringBuilder.toString().equalsIgnoreCase(targetWord);
    }



    private void displayVictory() {
        System.out.println("------------------- ПОБЕДА -------------------");
        System.out.println("Поздравляю! Вы угадали слово: " + targetWord);
        System.out.println("----------------------------------------------");
    }

    private void displayDefeat() {
        System.out.println("------------------- ПОРАЖЕНИЕ -------------------");
        System.out.println("Вы не угадали слово: " + targetWord);
        System.out.println("----------------------------------------------");
    }


}
