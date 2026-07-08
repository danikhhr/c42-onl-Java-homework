package homeworkNumber8;

public class Rabbit extends Animal {
    @Override
    public void eat(String food) {
        if(food.equalsIgnoreCase("grass"))
            System.out.println("Rabbit likes eat " + food.toLowerCase());
        else System.out.println("Rabbit doesn't like eat " + food.toLowerCase());
    }

    @Override
    public void voice() {
        System.out.println("Rabbit makes sounds");
    }
}
