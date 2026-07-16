package homeworkNumber9;

import homeworkNumber9.Cloaneble.Dog;
import homeworkNumber9.geometricShapes.*;
import homeworkNumber9.workingPositions.*;

public class Main {

    private static final String separator = "-".repeat(50);

    public static void main(String[] args) {
        workingPositions();
        shapes();
        cloneAble();
    }

    public static void workingPositions(){
        Director director = new Director();
        Accountant accountant = new Accountant();
        Worker worker = new Worker();
        System.out.println("                    WORKING POSITIONS");
        System.out.println(separator);
        director.printPositionName();
        System.out.println(separator);
        accountant.printPositionName();
        System.out.println(separator);
        worker.printPositionName();
        System.out.println(separator);
        System.out.println();
        System.out.println();
    }

    public static void shapes(){
        double resPerimeter = 0;
        System.out.println(separator);
        System.out.println("                      SHAPES");
        System.out.println(separator);
        Shape[] shapes = {new Triangle(4, 5, 3), new Circle(6), new Square(6, 12),
                new Triangle(2, 2, 2), new Circle(5)};
        for (Shape shape : shapes) {
            shape.areaOfShape();
            resPerimeter += shape.perimeterOfShape();
        }
        System.out.println("Сумма периметра всех фигур: " + resPerimeter);
    }

    public static void cloneAble(){
        System.out.println(separator);
        System.out.println("          INTERFACE-MARKER CLONEABLE");
        System.out.println(separator);
        Dog dog = new Dog("Sharik", 5);
        System.out.println("Оригинал:\n\t" + dog);
        Dog dog1 = dog.clone();
        System.out.println("Клон:\n\t" + dog1);
        System.out.println(separator);
        dog1.setAge(6);
        dog1.setName("Baton");
        System.out.println("После изменения клона");
        System.out.println(separator);
        System.out.println("Оригинал:\n\t" + dog);
        System.out.println("Клон:\n\t" + dog1);
    }
}
