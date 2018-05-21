package com.michalurban.onlinecalculator.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double calculate(double number1, double number2, String operator) {

        switch (operator) {
            case "+":
                return number1 + number2;
            case "-":
                return number1 - number2;
            case "*":
                return number1 * number2;
            default:
                return number1 / number2;
        }
    }
}
