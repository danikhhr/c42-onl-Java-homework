package homeworkNumber9.geometricShapes;

public class Triangle extends Shape {
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double perimeterOfShape() {
        double perimeter = sideA + sideB + sideC;
        System.out.printf("The perimeter of triangle is:\t%.2f\n%s\n",
                perimeter, "-".repeat(50));
        return perimeter;
    }

    @Override
    public void areaOfShape() {
        double semiPerimeter = (sideA + sideB + sideC) / 2.0;
        double area = Math.sqrt(semiPerimeter * (semiPerimeter - sideA) *
                (semiPerimeter - sideB) * (semiPerimeter - sideC));
        System.out.printf("The area of triangle is:\t%.2f\n%s\n",
                area, "-".repeat(50));
    }
}