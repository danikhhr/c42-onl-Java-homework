package homeworkNumber14.Documents;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentsAnalyzer {
    public void analyzeDocuments() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь к файлу");
        File file = new File(scanner.nextLine());
        try(Scanner scannerInput = new Scanner(file);
            FileOutputStream validDoc = new FileOutputStream("src/homeworkNumber14/Documents/ValidDocuments");
            FileOutputStream invalidDoc = new FileOutputStream("src/homeworkNumber14/Documents/InvalidDocuments.txt")) {
            Pattern pattern = Pattern.compile("^(docnum[a-zA-Z0-9]{9}|contract[a-zA-Z0-9]{7})$");
            Matcher matcher;
            while (scannerInput.hasNext()) {
                String doc = scannerInput.nextLine();
                matcher = pattern.matcher(doc);
                if (matcher.matches()) {
                    doc = matcher.group();
                    validDoc.write((doc + "\n").getBytes());
                    System.out.printf("Документ %s является валидным и записан в файл: \"ValidDocuments\"\n", doc);
                } else {
                    invalidDoc.write((doc + "\n").getBytes());
                    messageAboutInvalidDoc(doc);
                    System.out.printf("Документ %s записан в файл: \"InvalidDocuments\"\n", doc);
                }
            }
        }  catch (FileNotFoundException e) {
            System.out.println("Такого файла не существует");
        } catch (IOException e) {
            System.out.println("We got some unexpected exception: " + e.getMessage());
        }
    }

    public void messageAboutInvalidDoc(String doc) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(doc);
        if (doc.length() != 15) {
            System.out.printf("Документ %s является не валидным так как длина документа не равна 15 символам\n", doc);
        } else if (!doc.startsWith("docnum") && !doc.startsWith("contract"))
            System.out.printf("Документ %s является не валидным так как документ" +
                    " не начинается с docnum/contract\n", doc);
        else if (matcher.find())
            System.out.printf("Документ %s является не валидным так как содержит служебные символы\n", doc);
    }
}
