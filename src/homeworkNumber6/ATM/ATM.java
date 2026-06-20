package homeworkNumber6.ATM;

public class ATM {
    private int countBanknotes20;
    private int countBanknotes50;
    private int countBanknotes100;

    public ATM(int countBanknotes20, int countBanknotes50, int countBanknotes100) {
        this.countBanknotes20 = countBanknotes20;
        this.countBanknotes50 = countBanknotes50;
        this.countBanknotes100 = countBanknotes100;
    }

    public void deposit(int count20, int count50, int count100) {
        getSum(count20, count50, count100);

        countBanknotes20 += count20;
        countBanknotes50 += count50;
        countBanknotes100 += count100;

        System.out.println("            ПОПОЛНЕНИЕ ВЫПОЛНЕНО УСПЕШНО");
    }

    public boolean withdraw(int withdraw) {
        checkWithdraw(withdraw);


        for (int i100 = Math.min(withdraw / 100 , countBanknotes100); i100 >= 0; i100--) {
            int temp100 = withdraw - i100 * 100;

            for (int j50 = Math.min(temp100 / 50, countBanknotes50); j50 >= 0; j50--) {
               int temp50 = temp100  - j50 * 50;

                if(temp50 % 20 == 0){
                    int temp20 = temp50 / 20;
                    if(temp20 <= countBanknotes20){
                        countBanknotes50 -= j50;
                        countBanknotes20 -=  temp20;
                        countBanknotes100 -=  i100;

                        return true;
                    }
                }

            }


        }

       return false;
    }










    private int getSumBanknotes(){
        return countBanknotes20 * 20 + countBanknotes50 * 50 + countBanknotes100 * 100;
    }

    private void getSum(int countBanknotes20, int countBanknotes50, int countBanknotes100){
        if(countBanknotes20 == 0 || countBanknotes50 == 0 || countBanknotes100 == 0)
            throw new IllegalArgumentException("Операция не может быть произведена");
    }

    private void checkWithdraw(int input){
        if(input < 20 || input > getSumBanknotes()) throw new IllegalArgumentException("Операция не может быть произведена");
    }


    @Override
    public String toString() {
        return "========================================\n" +
                "            СОСТОЯНИЕ БАНКОМАТА\n" +
                "========================================\n" +
                String.format("Баланс: %d руб.%n", getSumBanknotes()) +
                "----------------------------------------\n" +
                String.format("Купюры 100: %d%n", countBanknotes100) +
                String.format("Купюры  50: %d%n", countBanknotes50) +
                String.format("Купюры  20: %d%n", countBanknotes20) +
                "========================================";
    }


}
