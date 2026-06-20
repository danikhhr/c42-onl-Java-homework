package homeworkNumber6.CreditCard;

public class CreditCard {
    private final String accNumber;
    private int currentSum;

    public CreditCard(String accNumber, int currentSum) {
        this.accNumber = accNumber;
        checkInitialBalance(currentSum);
        this.currentSum = currentSum;
    }

    public void deposit(int deposit){
        toString();
        checkDeposit(deposit);
        currentSum += deposit;
        System.out.println("ПОПОЛНЕНИЕ ВЫПОЛНЕНО УСПЕШНО");
    }

    public void withdraw(int removeSum){
        toString();
        checkWithdraw(removeSum);
        currentSum -= removeSum;
        System.out.println("СНЯТИЕ ДЕНЕЖНЫХ СРЕДСТВ ВЫПОЛНЕНО УСПЕШНО");
    }

    @Override
    public String toString() {
        return "========================================\n" +
                "            СОСТОЯНИЕ БАНКОМАТА\n" +
                "========================================\n" +
                String.format("Баланс: %d руб.%n", currentSum) +
                "----------------------------------------\n" +
                String.format("Ваш лицевой счёт: %s%n", accNumber) +
                "========================================";
    }

    private void checkWithdraw(int withdraw){
        if(withdraw > currentSum || withdraw <= 0) throw new IllegalArgumentException("Операция не может быть произведена");
    }

    private void checkInitialBalance(int balance){
        if(balance < 0)  throw new IllegalArgumentException("Операция не может быть произведена");

    }

    private void checkDeposit(int deposit){
        if(deposit <= 0) throw new IllegalArgumentException("Операция не может быть произведена");
    }


}
