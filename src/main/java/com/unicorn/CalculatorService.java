package com.unicorn;

import java.net.StandardSocketOptions;

public class CalculatorService {

    private Calculator calculator;

    public CalculatorService(Calculator calculator) {
        this.calculator = calculator;
    }

    public int execute(String operation, int a, int b) {

        switch(operation) {
            case "add":
                return calculator.add(a, b);

            case "subtract":
                return calculator.subtract(a, b);

            case "multiply":
                return calculator.multiply(a, b);

            case "divide":
                return calculator.divide(a, b);

            default:
                throw new IllegalArgumentException();
        }
    }

    // vararg
    public int execute(String operation, int a, int... b) {
        if ("add".equals(operation)) {
            return calculator.add(a, b);
        }
        throw new IllegalArgumentException();
    }

    // smoke test
    public static void main(String[] args) {

        CalculatorService cs = new CalculatorService(new Calculator());

        System.out.println(cs.execute("add", 1, 13));
        System.out.println(cs.execute("divide",1, 2));
        System.out.println(cs.execute("subtract", 10, 2));
        System.out.println(cs.execute("multiply", 10, 2));
    }
}


