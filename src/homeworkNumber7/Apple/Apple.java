package homeworkNumber7.Apple;

public class Apple {
    private String color = "purple";

    public Apple(String color) {
        System.out.println("Цвет до изменения: " + this.color);
        this.color = color;
    }


    public String getColor() {
        System.out.print("Цвет после изменения: ");
        return color;
    }


}
