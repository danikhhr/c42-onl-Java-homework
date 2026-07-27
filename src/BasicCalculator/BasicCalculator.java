package BasicCalculator;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicCalculator extends ConsoleColors {
    public void start(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(BRIGHT_BLUE + "Welcome to CALCULATOR.");
        System.out.print(BRIGHT_BLUE + "Please, enter an expression and I will calculate: ");
        System.out.println("If you want to close calculator write in console \"close\"");
        while(true) {
            String expression = correctExpression(scanner);
            String[] operators = expression.split("^\\s*-?[0-9]+$");
            String[] variables = expression.split("^\\s*-?[-+*/]+$");
            //  13 + 5 - 1 * 3 / 2 = 13 + 5 - 3 / 2 = 13 + 5 - 1,5
            multiplicationAndDivision(operators, variables);
            additionAndSubtraction(operators, variables);
            /// ////////////////////////////////
        }


    }

    private void multiplicationAndDivision(String[] operators, String[] variables) {
        BigInteger temp;
        for (int i = 0; i < operators.length; i++) {
            if(operators[i].equals("*")) {
                BigInteger rightNumber = BigInteger.valueOf(Integer.parseInt(variables[i + 1]));
                BigInteger leftNumber = BigInteger.valueOf(Integer.parseInt(variables[i]));
                variables[i] = String.valueOf(rightNumber.multiply(leftNumber));
                /// /////////////////////////
            }

        }
    }

    private void additionAndSubtraction(String[] operators, String[] variables) {
        BigInteger temp;
        for (int i = 0; i < operators.length; i++) {
            if(operators[i].equals("-")) {
                BigInteger rightNumber = BigInteger.valueOf(Integer.parseInt(variables[i + 1]));
                BigInteger leftNumber = BigInteger.valueOf(Integer.parseInt(variables[i]));
                variables[i] = String.valueOf(leftNumber.subtract(rightNumber));
                /// /////////////////////////
            } else if(operators[i].equals("+")) {
                BigInteger rightNumber = BigInteger.valueOf(Integer.parseInt(variables[i + 1]));
                BigInteger leftNumber = BigInteger.valueOf(Integer.parseInt(variables[i]));
                variables[i] = String.valueOf(rightNumber.add(leftNumber));
                /// /////////////////////////
            }
        }
    }

    private String correctExpression(Scanner scanner){
        String expression = scanner.nextLine();
        Pattern pattern = Pattern.compile("^\\s*-?[0-9]+\\s*[-+*/]\\s*-?[0-9]+\\s*$");
        Matcher matcherExpression = pattern.matcher(expression);
        if(expression.equals("close")) closeCalculator();
        while(true) {
            if(!expression.isEmpty() && matcherExpression.find()) {
                return expression;
            }
            System.out.println("Incorrect expression, please try again");
            scanner.next();
        }
    }

    private void closeCalculator() {
        System.out.println("See you later");
        System.exit(0);
    }

}
