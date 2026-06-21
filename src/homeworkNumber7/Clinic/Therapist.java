package homeworkNumber7.Clinic;

public class Therapist extends Doctor {

    private Patient patient;

    @Override
    public void heal() {
        System.out.println("Терапевт назначает лечение");
    }

    public Therapist(Patient patient) {
        this.patient = patient;
    }

    public Therapist() {

    }

    public void makeConsultations(){
        int plan = patient.getTreatmentPlan();
        System.out.println("Пациент поступил с кодом " + plan);
        if (plan == 1){
            System.out.println("Отправляем к хирургу");
            patient.setDoctor(new Surgeon());
            new Surgeon().heal();

        } else if (plan == 2) {
            System.out.println("Отправляем к дантисту");
            new Dentist().heal();
            patient.setDoctor(new Dentist());
        } else {
            heal();
            patient.setDoctor(new Therapist());
        }
    }

    @Override
    public String toString() {
        return "Пациента обслужил терапевт";
    }

}
