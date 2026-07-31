package homeworkNumber15.Animals;

import java.util.ArrayList;
import java.util.List;

public class Animals {
    private final List<String> animals = new ArrayList<>(List.of("Tiger","Cat", "Dog"));

    public void addAnimal(String name) {
        System.out.printf("Вы добавили %s в List\n", name);
        animals.addFirst(name);
    }

    public void removeAnimal() {
        if(!animals.isEmpty()){
            animals.removeLast();
            System.out.println("Вы удалили последний элемент из коллекции");
        } else System.out.println("Коллекция пуста, нечего удалять");
    }

    public void printAnimals() {
        if(!animals.isEmpty()) {
            for(String name : animals) {
                System.out.println(name);
            }
        } else System.out.println("Коллекция пуста");
    }
}
