package homeworkNumber9.Cloaneble;

public class Dog implements Cloneable{

    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "name: " + name
                + "\n\tage: " + age;
    }

    @Override
    public Dog clone() {
        try {
            return (Dog) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
