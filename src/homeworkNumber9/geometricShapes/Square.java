package homeworkNumber9.geometricShapes;

public class Square extends Shape {

    private final double width;
    private final double length;

    public Square(double width, double length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public double perimeterOfShape() {
        double perimeter = 2 * (width + length);
        System.out.printf("The perimeter of square is:\t%.2f\n%s\n", perimeter, "-".repeat(50));
        return perimeter;
    }

    @Override
    public void areaOfShape() {
        double area = width * length;
        System.out.printf("The area of square is:\t%.2f\n%s\n", area, "-".repeat(50));
    }
}
