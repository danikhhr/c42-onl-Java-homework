package homeworkNumber7;

import homeworkNumber7.Apple.Apple;

import homeworkNumber7.Clinic.Patient;
import homeworkNumber7.Clinic.Therapist;

public class Main {
    public static void main(String[] args) {
        System.out.println("////////////////////////ЗАДАНИЕ 1/////////////////////////");
        createClinic();
        System.out.println("-".repeat(70));
        System.out.println("////////////////////////ЗАДАНИЕ 2/////////////////////////");
        createApple();
    }


    public static void createClinic(){
        Patient patient = new Patient(2);
        System.out.println(patient);
        Therapist therapist = new Therapist(patient);
        therapist.makeConsultations();
        patient.getDoctor();
    }

    public static void createApple(){
        Apple apple = new Apple("red");
        System.out.println(apple.getColor());

    }
}
