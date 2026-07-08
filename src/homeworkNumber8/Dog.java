package homeworkNumber8;

public class Dog extends Animal{

    private Dog() {
    }

    @Override
    public void eat(String food) {
        if(food.equalsIgnoreCase("meat"))
        System.out.println("Dog likes eat " + food.toLowerCase());
        else System.out.println("Dog doesn't like eat " + food.toLowerCase());
    }

    @Override
    public void voice() {
        System.out.println("Dog barks");
    }

    public static Dog createDog(){
        return new Dog();
    }

}
