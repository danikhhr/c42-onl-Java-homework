package homeworkNumber10;

import homeworkNumber10.User.*;
import homeworkNumber10.userSystem.UserSystem;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        createUserSystem();
        createShallowUser();
        createDeepUser();
    }

    public static void createUserSystem() {
        UserSystem userSystem = new UserSystem("Ivan", "qwerty32");
        UserSystem userSystem1 = new UserSystem("Ivan", "qwerty32");
        UserSystem userSystem2 = new UserSystem("Ivan", "qwerty32");
        UserSystem[] systems = new UserSystem[] {userSystem, userSystem1, userSystem2};
        System.out.print("Some information:\n");
        System.out.println("-".repeat(50));
        for(UserSystem system : systems) {
            System.out.println(system);
            System.out.println("hashCode(): " + system.hashCode());
            System.out.println("-".repeat(50));
        }
        System.out.println("Равны ли обьекты между собой:\n");
        System.out.println(userSystem.equals(userSystem1));
        System.out.println(userSystem.equals(userSystem2));
        System.out.println(userSystem1.equals(userSystem2));
        System.out.println("-".repeat(50));
    }

    public static void createShallowUser() throws CloneNotSupportedException {
        System.out.println("Поверхностное клонирование:");
        System.out.println("До изменения");
        User1 user = new User1("Ivan", 14, new Owner("Oleg"));
        User1 cloneUser = (User1) user.clone();
        System.out.println("Оригинал:\n\t" + user);
        System.out.println("-".repeat(50));
        System.out.println("Копия:\n\t" + cloneUser);
        cloneUser.setId(56);
        cloneUser.setUserName("Sveta");
        System.out.println("-".repeat(50));
        System.out.println("-".repeat(50));
        System.out.println("После изменения");
        cloneUser.getUser().setUserName("Kristina");
        System.out.println("Оригинал:\n\t" + user);
        System.out.println("-".repeat(50));
        System.out.println("Копия:\n\t" + cloneUser);
    }

    public static void createDeepUser() throws CloneNotSupportedException {
        System.out.println("Глубокое клонирование:");
        System.out.println("До изменения");
        User2 user = new User2("Ivan", 14, new Owner("Oleg"));
        User2 cloneUser = user.clone();
        System.out.println("Оригинал:\n\t" + user);
        System.out.println("-".repeat(50));
        System.out.println("Копия:\n\t" + cloneUser);
        cloneUser.setId(56);
        cloneUser.setUserName("Sveta");
        System.out.println("-".repeat(50));
        System.out.println("-".repeat(50));
        System.out.println("После изменения");
        cloneUser.getUser().setUserName("Kristina");
        System.out.println("Оригинал:\n\t" + user);
        System.out.println("-".repeat(50));
        System.out.println("Копия:\n\t" + cloneUser);
    }
}
