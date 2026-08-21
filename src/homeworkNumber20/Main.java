package homeworkNumber20;

import homeworkNumber20.Shop.Consumer;
import homeworkNumber20.Shop.Producer;
import homeworkNumber20.Shop.Shop;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        printMaxAndMin(findMaxAndMinWithThreads());
        System.out.println("=".repeat(60));
        sortNumbersWithThreads();
    }

    public static void printMaxAndMin(String[] res) {
        System.out.println("""
                        Максимальный элемент в массиве:
                        """ + res[0]);
        System.out.println("""
                        Минимальный элемент в массиве:
                        """ + res[1]);
    }

    public static String[] findMaxAndMinWithThreads() {
        System.out.println("Заполните целочисленный массив");
        String[] numbers = new Scanner(System.in).nextLine().split("\\W+");
        String[] res = new String[2];
        int[] arr = new int[numbers.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }

        Thread searchMaxNumThread = new Thread(() -> {
                res[0] = String.valueOf(Arrays.stream(arr)
                        .max().orElse(0));
            }
        );

        Thread searchMinNumThread = new Thread(() -> {
                System.out.println("""
                        Минимальный элемент в массиве:
                        """ + Arrays.stream(arr)
                        .min().orElse(0));
        });
        searchMinNumThread.start();
        searchMaxNumThread.start();
        return res;
    }

    public static void sortNumbersWithThreads() {
        System.out.println("Заполните целочисленный массив для сортировки");
        String[] numbers = new Scanner(System.in).nextLine().split("\\W+");

        int[] arr = new int[numbers.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }

        Thread bubbleSortThread = new Thread(() -> {
            int temp;
            int[] bubbleArr = Arrays.copyOf(arr, arr.length);
            for (int i = 0; i < bubbleArr.length - 1; i++) {
                for (int j = 0; j < bubbleArr.length - 1 - i; j++) {
                    if(bubbleArr[j] > bubbleArr[j + 1]) {
                        temp = bubbleArr[j];
                        bubbleArr[j] = bubbleArr[j + 1];
                        bubbleArr[j + 1] = temp;
                    }
                }
            }
            System.out.println("Bubble sort:");
            Arrays.stream(bubbleArr)
                    .forEach(el -> System.out.print(el + "\t"));
            System.out.println("=".repeat(50));
        });

        Thread selectionSortThread = new Thread(() -> {
            int[] selectionArr = Arrays.copyOf(arr, arr.length);
            for (int i = 0; i < selectionArr.length; i++) {
                int min = selectionArr[i];
                for (int j = i + 1; j < selectionArr.length; j++) {
                    if(min > selectionArr[j]) {
                        min = selectionArr[j];
                    }
                }
                selectionArr[i] = min;
            }
            System.out.println("Selection sort:");
            Arrays.stream(selectionArr)
                    .forEach(el -> System.out.println(el + "\t"));
            System.out.println("=".repeat(50));
        });

        Thread insertionSortThread = new Thread(() -> {
            int[] insertionArr = Arrays.copyOf(arr, arr.length);
            for (int i = 0; i < insertionArr.length; i++) {
                int current = insertionArr[i];
                int j = i;
                while (j > 0 && arr[j - 1] > current) {
                    insertionArr[j] = insertionArr[j - 1];
                    j--;
                }
                arr[j] = current;
            }
            System.out.println("Insertion sort:");
            Arrays.stream(insertionArr)
                    .forEach(el -> System.out.println(el + "\t"));
            System.out.println("=".repeat(50));
        });
        try {
            bubbleSortThread.start();
            bubbleSortThread.join();
            selectionSortThread.start();
            selectionSortThread.join();
            insertionSortThread.start();
            insertionSortThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createShop() throws InterruptedException {
        System.out.println("Магазин открыт!");
        System.out.println("Условия:");
        System.out.println("- Производитель создает 5 товаров");
        System.out.println("- Покупатель покупает 5 товаров");
        System.out.println("- В магазине может быть не более 3 товаров");
        System.out.println("═══════════════════════════════════════════\n");

        Shop store = new Shop();


        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);


        Thread producerThread = new Thread(producer, "Producer-Thread");
        Thread consumerThread = new Thread(consumer, "Consumer-Thread");


        producerThread.start();
        consumerThread.start();


        producerThread.join();
        consumerThread.join();


    }

}
