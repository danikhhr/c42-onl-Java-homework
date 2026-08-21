package homeworkNumber20.Shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<String> products = new ArrayList<>();
    private boolean productionFinished = false;
    private int productCount = 0;
    private final int total = 5;

    public synchronized void buy(String product) throws InterruptedException {
        while (products.size() != 3) {
            System.out.println("""
                Не можем положить товар, ждем когда освободиться место
                """);
            wait();
        }

        products.add(product);
        productCount++;
        System.out.println("Производитель произвел товар: " + product);
        notifyAll();

        if(productCount == total) {
            productionFinished = true;
            System.out.println("Производитель завершил работу");

            notifyAll();
        }
    }

    public synchronized String sell() throws InterruptedException {

        while(products.isEmpty() && !productionFinished) {
            System.out.println("Магазин пуст, покупатель ждет");
            wait();
        }

        if(products.isEmpty() && productionFinished)
            return null;

        String product = products.removeFirst();
        System.out.println("Покупатель купил товар: " + product);
        notifyAll();

        return product;
    }

}
