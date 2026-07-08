package homeworkNumber8;

public class Tiger extends Animal {
    @Override
    public void eat(String food) {
        if(food.equalsIgnoreCase("meat"))
            System.out.println("Tiger likes eat " + food.toLowerCase());
        else System.out.println("Tiger doesn't like eat " + food.toLowerCase());
    }

    @Override
    public void voice() {
        System.out.println("Tiger roars");
    }
}
