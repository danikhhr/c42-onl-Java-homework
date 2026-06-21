package homeworkNumber7.Clinic;

public class Surgeon extends Doctor {
    @Override
    public void heal() {
        System.out.println("Хирург проводит операцию");
    }

    @Override
    public String toString() {
        return "Пациента обслужил Хирург";
    }
}
