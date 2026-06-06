package homeworkNumber2;

public class Solution {
    public static void main(String[] args) {
        System.out.println("task number 1:");
        taskNum1();

        System.out.println("task number 2:");
        taskNum2();

        System.out.println("task number 3:");
        taskNum3();

        System.out.println("task number 4:");
        taskNum4();

        System.out.println("task number 5:");
        taskNum5();

        System.out.println("task number 6:");
        taskNum6();
    }

    public static void taskNum1() {
        int b = 5, c = 4;
        int a = 4 * (b + c - 1) / 2;

        System.out.printf("b = %d, c = %d\na = 4 * (b + c - 1) / 2 = %d\n%s\n",
                b, c, a, "-".repeat(50));
    }

    public static void taskNum2() {
        int n = 25;
        int sum = n / 10 + n % 10;

        System.out.printf("n = %d\nsum = n / 10 + n %% 10 = %d\n%s\n",
                n, sum, "-".repeat(50));
    }

    public static void taskNum3() {
        int n = 126;
        int sum = n / 100 + n % 10 + n / 10 % 10;

        System.out.printf("n = %d\nsum = n / 100 + n %% 10 + n / 10 %% 10 = %d\n%s\n",
                n, sum, "-".repeat(50));
    }

    public static void taskNum4() {
        double n = 126.4;
        long rounded = Math.round(n);

        System.out.printf("n = %.1f\nres = Math.round(n) = %d\n%s\n",
                n, rounded, "-".repeat(50));
    }

    public static void taskNum5() {
        int q = 21, w = 8;
        int firstPart = q / w;
        int secondPart = q % w;

        System.out.printf("q = %d, w = %d\nres = %d.%d\n%s\n",
                q, w, firstPart, secondPart, "-".repeat(50));
    }

    public static void taskNum6() {
        int num1 = 5, num2 = 4;

        System.out.printf("До swap: num1 = %d, num2 = %d\n", num1, num2);

        int temp = num1;
        num1 = num2;
        num2 = temp;

        System.out.printf("После swap: num1 = %d, num2 = %d\n%s\n", num1, num2, "-".repeat(50));
    }
}
