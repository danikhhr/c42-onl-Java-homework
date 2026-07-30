package homeworkNumber14.RomeoAndJuliet;

import java.io.*;
import java.util.Scanner;

public class FileTextAnalyzer {
    public void readAndWrite() {
        String maxLengthWord = "";
        try(Scanner scanner = new Scanner(new File("src/homeworkNumber14/RomeoAndJuliet/RomeoAndJuliet.txt"));
            FileOutputStream fileOutputStream = new FileOutputStream("src/homeworkNumber14/RomeoAndJuliet/Result.txt")) {
            String word;
            while(scanner.hasNext()) {
                word = scanner.next();
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
