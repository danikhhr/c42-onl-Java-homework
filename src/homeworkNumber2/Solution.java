package homeworkNumber2;

public class Solution {

    public static final String sep = "-".repeat(50);

    public static void main(String[] args) {
        System.out.println("task number 1:");
        calculate();

        System.out.println("task number 2:");
        printSumOfTwoDigits();

        System.out.println("task number 3:");
        printSumOfThreeDigits();

        System.out.println("task number 4:");
        roundingNumber();

        System.out.println("task number 5:");
        printDivisionResult();

        System.out.println("task number 6:");
        swapNumbers();
    }

    public static void calculate() {
        int b = 5;
        int c = 4;
        int a = 4 * (b + c - 1) / 2;

        System.out.printf("b = %d, c = %d\na = 4 * (b + c - 1) / 2 = %d\n%s\n",
                b, c, a, sep);
    }

    public static void printSumOfTwoDigits() {
        int n = 25;
        int sum = n / 10 + n % 10;

        System.out.printf("n = %d\nsum = n / 10 + n %% 10 = %d\n%s\n",
                n, sum, sep);
    }

    public static void printSumOfThreeDigits() {
        int n = 126;
        int sum = n / 100 + n % 10 + n / 10 % 10;

        System.out.printf("n = %d\nsum = n / 100 + n %% 10 + n / 10 %% 10 = %d\n%s\n",
                n, sum, sep);
    }

    public static void roundingNumber() {
        double n = 126.4;
        long res = Math.round(n);

        System.out.printf("%.1f = Math.round(n) = %d\n%s\n",
                n, res, sep);
    }

    public static void printDivisionResult() {
        int q = 21;
        int w = 8;
        int firstPart = q / w;
        int secondPart = q % w;

        System.out.printf("q = %d, w = %d\nres = %d.%d\n%s\n",
                q, w, firstPart, secondPart, sep);
    }

    public static void swapNumbers() {
        int num1 = 5;
        int num2 = 4;

        System.out.printf("До swap: num1 = %d, num2 = %d\n", num1, num2);

        int temp = num1;
        num1 = num2;
        num2 = temp;

        System.out.printf("После swap: num1 = %d, num2 = %d\n%s\n", num1, num2, sep);
    }
}