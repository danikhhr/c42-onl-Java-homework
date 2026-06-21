package homeworkNumber7.Clinic;

public class Dentist extends Doctor{
    @Override
    public void heal() {
        System.out.println("Дантист лечит зубы");
    }

    @Override
    public String toString() {
        return "Пациента обслужил Дантист";
    }
}
