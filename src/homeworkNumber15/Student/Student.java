package homeworkNumber15.Student;

import java.util.Arrays;
import java.util.List;

public class Student {
    private final String name;
    private int course;
    private final int[] marks;
    private final String group;

    public Student(String name, int[] marks, int course, String group) {
        this.name = name;
        this.marks = marks;
        this.course = course;
        this.group = group;
    }

    public static void processStudents(List<Student> students) {
        int averageMark;
        for (int i = 0; i < students.size();) {
            averageMark = 0;
            for(int mark : students.get(i).marks) {
                averageMark += mark;
            }
            averageMark = averageMark / students.get(i).marks.length;
            if(averageMark < 3) {
                students.remove(students.get(i));
            } else {
                students.get(i).course ++;
                i++;
            }
        }
    }

    public static void printStudents(List<Student> students, int course) {
        System.out.printf("На %d курсе обучаются следующие ученики:\n", course);
        for(Student student : students) {
            if(student.course == course) System.out.println(student.name);
        }
    }

    @Override
    public String toString() {
        return """
                Student {
                name: %s
                group: %s
                course: %d
                marks: %S%n
                """.formatted(name, group, course, Arrays.toString(marks));
    }
}
