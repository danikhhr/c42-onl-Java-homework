public class Main {

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
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("a = 4 * (b + c - 1) / 2 = " + 4 * (b + c - 1) / 2);
        System.out.println("-".repeat(52));

    }

    public static void taskNum2() {
        int n = 25;
        System.out.println("n = " + n);
        System.out.println("sum = n / 10 + n % 10 = " + ( n / 10 + n % 10));
        System.out.println("-".repeat(52));

    }

    public static void taskNum3() {
        int n = 126;
        System.out.println("n = " + n);
        System.out.println("sum = n / 100 + n % 10 + n / 10 % 10 = " + (n / 100 + n % 10 + n / 10 % 10));
        System.out.println("-".repeat(52));

    }

    public static void taskNum4() {
        double n = 126.4;
        System.out.println("n = " + n);
        System.out.println("res = Math.round(n) = " + Math.round(n));
        System.out.println("-".repeat(52));

    }

    public static void taskNum5() {
        int q = 21, w = 8;
        int firstPart = 21 / 8;
        int secondPart = 21 % 8;

        System.out.println("q = " + 21);
        System.out.println("w = " + 8);
        System.out.println("res = " + firstPart + "." + secondPart);
        System.out.println("-".repeat(52));

    }

    public static void taskNum6() {
        int num1 = 5, num2 = 4, temp;
        temp = num1;
        num1 = num2;
        num2 = temp;

        System.out.println("num1 = " + 5);
        System.out.println("num2 = " + 4);
        System.out.printf("num1 = %d, num2 = %d\n", num1, num2);
        System.out.println("-".repeat(52));

    }


}
