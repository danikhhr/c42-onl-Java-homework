package homeworkNumber7.Clinic;

public class Patient {
    private int treatmentPlan;
    private Doctor doctor;

    public Patient(int treatmentPlan) {
        this.treatmentPlan = treatmentPlan;

    }

    public int getTreatmentPlan() {

        return treatmentPlan;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Doctor getDoctor() {
        System.out.println(doctor);
        return doctor;
    }

    @Override
    public String toString() {
        return "Пациент отправляется к терапевту";
    }
}
