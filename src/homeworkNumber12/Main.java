package homeworkNumber12;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        findAbbreviations(scanner);
        System.out.println("-".repeat(70));
        findSomeInformation(scanner);
    }

    public static void findAbbreviations(Scanner scanner) {
        Pattern pattern = Pattern.compile("\\b[A-Z]{2,6}\\b");
        System.out.println("Введите строку с аббревиатурами (от 2 до 6 прописных букв, без чисел):");
        Matcher matcher = pattern.matcher(scanner.nextLine());
        boolean found = false;
        while (matcher.find()) {
            System.out.println(matcher.group());
            found = true;
        }
        if (!found) {
            System.out.println("Аббревиатуры не были найдены");
        }
    }

    public static void findSomeInformation(Scanner scanner) {
        System.out.println("Введите строку, содержащую номер документа, телефон и/или email:");
        String line = scanner.nextLine();
        Pattern patternForDoc = Pattern.compile("\\b\\d{4}-\\d{4}-\\d{2}\\b");
        Pattern patternForPhoneNumber = Pattern.compile("\\+\\([1-9]\\d\\)\\d{7}");
        Pattern patternForEmail = Pattern.compile("\\b[\\w.-]+@[\\w-]+\\.\\w{2,}\\b");
        Matcher matcherDocuments = patternForDoc.matcher(line);
        Matcher matcherEmail = patternForEmail.matcher(line);
        Matcher matcherPhoneNumber = patternForPhoneNumber.matcher(line);
        findSingle("email", matcherEmail);
        while(matcherDocuments.find()) {
            System.out.println("document number: " + matcherDocuments.group());
        }
        findSingle("phone number", matcherPhoneNumber);
    }

    public static void findSingle(String name, Matcher matcher) {
        if(matcher.find()) System.out.println(name + ": " + matcher.group());
        else System.out.println(name + " не найден");
    }
}
