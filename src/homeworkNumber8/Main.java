package homeworkNumber8;

public class Main {

    public static String separator = "-".repeat(60);

    public static void main(String[] args) {
        animals();
    }

    public static void animals(){
        Animal animal = new Animal();
        Animal tiger = new Tiger();
        Animal rabbit = new Rabbit();
        Animal dog = Dog.createDog();
        animal.voice();
        animal.eat("strawberries");
        System.out.println(separator);
        rabbit.voice();
        rabbit.eat("gRass");
        System.out.println(separator);
        tiger.voice();
        tiger.eat("MEAT");
        System.out.println(separator);
        dog.voice();
        dog.eat("MEAT");
        System.out.println(separator);
    }
}
