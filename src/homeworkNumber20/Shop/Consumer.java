package homeworkNumber20.Shop;

public class Consumer implements Runnable {
    private final Shop shop;

    public Consumer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String product = shop.sell();
                if(product == null) {
                    System.out.println("Покупатель завершил работу, покупать больше нечего");
                    break;
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Покупатель был прерван");
            }
        }
    }
}
