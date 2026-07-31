package homeworkNumber15;

import homeworkNumber15.Animals.Animals;
import homeworkNumber15.Student.Student;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //removeDuplicates();
        System.out.println("=".repeat(60));
        //createAnimals();
        System.out.println("=".repeat(60));
        createStudents();
        System.out.println("=".repeat(60));
    }

    public static void removeDuplicates() {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> result = new HashSet<>();
        System.out.println("Введите набор чисел в виде одной строки с клавиатуры. Например: \"1, 2, 3, " +
                "4, 4, 5\"");
        String[] numbers = scanner.nextLine().split("[,\\s]");
        for(String number : numbers) result.add(Integer.parseInt(number));

        result.forEach(num -> System.out.print(num + " "));
    }

    public static void createAnimals() {
        Animals animals = new Animals();
        animals.printAnimals();
        animals.addAnimal("Hedgehog");
        animals.removeAnimal();
        animals.printAnimals();
    }

    public static void createStudents() {
        Student student1 = new Student("Ivan", new int[] {2, 2, 3, 2}, 3, "3r4041");
        Student student2 = new Student("Vlad", new int[] {5, 5, 5, 5}, 1, "1k8974");
        Student student3 = new Student("Vika", new int[] {3, 3, 4, 2}, 1, "5g6543");
        Student student4 = new Student("Sonya", new int[] {4, 3, 4, 5}, 1, "4y3432");
        List<Student> studentList = new ArrayList<>(List.of(student1, student2, student3, student4));
        Student.processStudents(studentList);
        Student.printStudents(studentList, 2);
    }
}
