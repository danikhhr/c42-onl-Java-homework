package homeworkNumber6;

import homeworkNumber6.ATM.ATM;
import homeworkNumber6.CreditCard.CreditCard;

public class Main {

    public static void main(String[] args) {
       createCreditCard();
       createATM();
    }


    ////////////////////////ЗАДАНИЕ 1/////////////////////////
    public static void createCreditCard(){
        CreditCard creditCard1 = new CreditCard("qertwqd45sad", 500);
        CreditCard creditCard2 = new CreditCard("qertwqd233333333", 2000);
        CreditCard creditCard3 = new CreditCard("qe23132dadsqd", 3546);

        System.out.println("          ПЕРВАЯ БАНКОВСКАЯ КАРТА");
        System.out.println(creditCard1);
        creditCard1.deposit(2);
        System.out.println(creditCard1);
        System.out.println("           ВТОРАЯ БАНКОВСКАЯ КАРТА");
        System.out.println(creditCard2);
        creditCard2.deposit(785);
        System.out.println(creditCard2);
        System.out.println();
        System.out.println("           ТРЕТЬЯ БАНКОВСКАЯ КАРТА");
        System.out.println(creditCard3);
        creditCard3.withdraw(1325);
        System.out.println(creditCard3);

    }

    ////////////////////////ЗАДАНИЕ 2/////////////////////////
    public static void createATM(){
        ATM atm = new ATM(5, 5, 5);
        System.out.println(atm);
        atm.deposit(4, 3, 1);
        System.out.println(atm);
        atm.withdraw(1180);
        System.out.println(atm);
    }
}
