package homeworkNumber20.Shop;

public class Producer implements Runnable{
    private final Shop shop;

    public Producer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                String product = "Product" + i;
                shop.buy(product);
            }
            Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Производитель был прерван");
            }
        }
    }

