package homeworkNumber9.geometricShapes;

public class Circle extends Shape{

    private final double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    @Override
    public double perimeterOfShape(){
        double perimeter = 2 * 3.14 * radius;
        System.out.printf("The perimeter of circle is:\t%.2f\n%s\n", perimeter, "-".repeat(50));
        return perimeter;
    }

    @Override
    public void areaOfShape(){
        double area = 3.14 * radius * radius;
        System.out.printf("The area of circle is:\t%.2f\n%s\n", area, "-".repeat(50));
    }

}
