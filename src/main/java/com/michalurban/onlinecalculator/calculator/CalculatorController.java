package com.michalurban.onlinecalculator.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "")
public class CalculatorController {

    private CalculatorService service;

    public CalculatorController(CalculatorService calculatorService) {
        this.service = calculatorService;
    }

    @GetMapping
    public String displayCalculator() {
        return "calculator";
    }

    @PostMapping
    public String displayResult(HttpServletRequest request, Model model) {

        double number1 = Double.parseDouble(request.getParameter("first_number"));
        double number2 = Double.parseDouble(request.getParameter("second_number"));
        String operation = request.getParameter("operation");

        double result = service.calculate(number1, number2, operation);
        model.addAttribute("result", result);

        return "calculator";
    }
}
