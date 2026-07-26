package homeworkNumber13;

import homeworkNumber13.Login.Login;
import homeworkNumber13.Login.WrongLoginException;
import homeworkNumber13.Login.WrongPasswordException;
import homeworkNumber13.tryCatchFinally.TryCatchFinally;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        checkLogin();
        System.out.println("-".repeat(60));
        checkTryCatchFinally();
    }

    public static void checkLogin(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите логин");
        String login = scanner.nextLine();
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        System.out.println("Повторите пароль");
        String confirmPassword = scanner.nextLine();

        try {
            boolean res = Login.login(login, password, confirmPassword);
            System.out.printf("Результат:\t%b\nВы успешно зарегистрировались\n", res);
        } catch (WrongLoginException | WrongPasswordException e) {
            throw new RuntimeException(e);
        }
    }

    public static void checkTryCatchFinally() {
        TryCatchFinally check = new TryCatchFinally();
        check.realization();
    }
}
