package homeworkNumber14.RomeoAndJuliet;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileTextAnalyzer {
    public void readAndWrite() {
        String maxLengthWord = "";
        try(Scanner scanner = new Scanner(new File("src/homeworkNumber14/RomeoAndJuliet/RomeoAndJuliet.txt"));
            FileOutputStream fileOutputStream = new FileOutputStream("src/homeworkNumber14/RomeoAndJuliet/Result.txt")) {
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine()).append(" ");
            }
            String word;
            Pattern pattern = Pattern.compile("\\b[A-Za-zА-Яа-я]+\\b");
            Matcher matcher = pattern.matcher(scanner.toString());;
            while(matcher.find()) {
                word = matcher.group();
                if(maxLengthWord.length() < word.length())
                    maxLengthWord = word;
            }
            fileOutputStream.write(maxLengthWord.getBytes());
            System.out.println("Слово записанное в другой файл:\t" + maxLengthWord);
        } catch (FileNotFoundException e) {
            System.out.println("Такого файла не существует");
        } catch (IOException e) {
            System.out.println("We got some unexpected exception: " + e.getMessage());
        }
    }
}
