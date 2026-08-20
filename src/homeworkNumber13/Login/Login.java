package homeworkNumber13.Login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login {
    /*
   Создать класс, в котором будет статический метод. Этот метод принимает на вход три
    параметра: login, password, confirmPassword. Все поля имеют тип данных String. Длина
   login должна быть меньше 20 символов и не должен содержать пробелы. Если login не
   соответствует этим требованиям, необходимо выбросить WrongLoginException. Длина
   password должна быть меньше 20 символов, не должен содержать пробелом и должен
   содержать хотя бы одну цифру. Также password и confirmPassword должны быть равны.
   Если password не соответствует этим требованиям, необходимо выбросить
   WrongPasswordException. WrongPasswordException и WrongLoginException -
   пользовательские классы исключения с двумя конструкторами – один по умолчанию,
   второй принимает сообщение исключения и передает его в конструктор класса Exception.
   Метод возвращает true, если значения верны, false в противном случае
    */

    public Login() {
    }

    public static boolean login(String login, String password, String confirmPassword) throws WrongLoginException,
            WrongPasswordException {
        if(login.length() >= 20)
            throw new WrongLoginException("длина логина должна быть меньше 20 символов");

        if(login.contains(" "))
            throw new WrongLoginException("логин не должен содержать пробелы");

        if(password.length() >= 20)
            throw new WrongPasswordException("длина пароля должна быть меньше 20 символов");

        if(password.contains(" "))
            throw new WrongPasswordException("пароль не должен содержать пробелы");

        Pattern pattern = Pattern.compile(".[0-9]+.");
        Matcher passwordMatcher = pattern.matcher(password);
        if(!passwordMatcher.find())
            throw new WrongPasswordException("пароль должен содержать хотя бы одну цифру");

        if(!password.equals(confirmPassword))
            throw new WrongPasswordException("пароли должны быть равны");

        return true;
    }
}
