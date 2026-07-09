package GameGuessTheWord;


import java.util.Random;
import java.util.Scanner;

public class Game {

    private String[] initialization(int length, Scanner scanner){
        String[] words = new String[length];
        System.out.println("Введите 20 слов для игры угадай слово");
        for (int i = 0; i < length; i++) {
            words[i] = scanner.nextLine();
            System.out.printf("%d слово:%s\n", i + 1, words[i]);
        }
        return words;
    }

    private String getRandomWord(String[] words, int length){
        Random random = new Random();
        return words[random.nextInt(length)];
    }

    public boolean run(){
        String input;
        int length = 5;
        int countAttempt = 5;
        Scanner scanner = new Scanner(System.in);
        String[] words = initialization(length, scanner);
        String targetWord = getRandomWord(words, length);
        StringBuilder stringBuilder = new StringBuilder("-".repeat(targetWord.length()));

        System.out.println("------------------- ИГРА НАЧАЛАСЬ -------------------");
        System.out.println("Загадано слово из " + targetWord.length() + " букв");

        while (countAttempt > 0 && !isWordGuessed(targetWord, stringBuilder)) {
            System.out.println("ВВЕДИТЕ СЛОВО ИЛИ БУКВУ");
            input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Пустой ввод! Попробуйте ещё раз.");
                continue;
            }


            if(input.length() > 1){
                if(input.equalsIgnoreCase(targetWord)){
                    displayVictory(targetWord);
                    return true;
                } else {
                    countAttempt--;
                    System.out.printf("ВЫ ВВЕЛИ НЕПРАВИЛЬНОЕ СЛОВО\nКОЛИЧЕСТВО ОСТАВШИХСЯ ПОПЫТОК:\t%d\n", countAttempt);
                }
            } else {
                    char guess = input.charAt(0);
                    boolean found = processGuess(guess, targetWord, stringBuilder);

                if (found) {
                    System.out.printf("Буква найдена!\nОсталось %d попыток\n", countAttempt);
                } else {
                    countAttempt--;
                    System.out.printf("Буква не найдена!\nОсталось %d попыток\n", countAttempt);

                }
                }

        }

        if (isWordGuessed(targetWord, stringBuilder)) {
            displayVictory(targetWord);
        } else {
            displayDefeat(targetWord);
        }

        return isWordGuessed(targetWord, stringBuilder);
    }


    private boolean processGuess(char guess, String targetWord, StringBuilder stringBuilder){
        boolean found = false;

        for (int i = 0; i < targetWord.length(); i++) {
            if(Character.toLowerCase(guess) == Character.toLowerCase(stringBuilder.charAt(i))) {
                System.out.println("Вы уже вводили эту букву");
                return false;
            }

            if(Character.toLowerCase(guess) == Character.toLowerCase(targetWord.charAt(i))){
                stringBuilder.setCharAt(i, targetWord.charAt(i));
                found = true;
            }

        }

        if (found){
            System.out.println(stringBuilder);
        }

        return found;

    }

    private boolean isWordGuessed(String targetWord, StringBuilder stringBuilder){
        return stringBuilder.toString().equalsIgnoreCase(targetWord);
    }



    private void displayVictory(String targetWord) {
        System.out.println("------------------- ПОБЕДА -------------------");
        System.out.println("Поздравляю! Вы угадали слово: " + targetWord);
        System.out.println("----------------------------------------------");
    }

    private void displayDefeat(String targetWord) {
        System.out.println("------------------- ПОРАЖЕНИЕ -------------------");
        System.out.println("Вы не угадали слово: " + targetWord);
        System.out.println("----------------------------------------------");
    }


}
