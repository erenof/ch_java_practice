package com.coderhouse.Ejercicio_Calculadora.service;

import com.coderhouse.Ejercicio_Calculadora.model.Operator;
import com.coderhouse.Ejercicio_Calculadora.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperatorService {

    @Autowired
    private OperatorRepository operatorRepository;

    // Save operation
    public Operator postOperator(Operator operator) throws Exception {
        return operatorRepository.save(operator);
    }

    // Post Addition
    public Operator postAdditionOperator(Operator operator) throws Exception {

        double firstNumber = operator.getFirstNumber();
        double secondNumber = operator.getSecondNumber();
        double result = firstNumber + secondNumber;

        operator.setResult(result);

        return operatorRepository.save(operator);
    }

    // Post Subtraction
    public Operator postSubtractionOperator(Operator operator) throws Exception {

        double firstNumber = operator.getFirstNumber();
        double secondNumber = operator.getSecondNumber();
        double result = firstNumber - secondNumber;

        operator.setResult(result);

        return operatorRepository.save(operator);
    }

    // Post division
    public Operator postDivisionOperator(Operator operator) throws Exception {

        double firstNumber = operator.getFirstNumber();
        double secondNumber = operator.getSecondNumber();
        double result = firstNumber / secondNumber;

        operator.setResult(result);

        return  operatorRepository.save(operator);
    }

    // Post multiplication
    public Operator postMultiplicationOperator(Operator operator) throws Exception {

        double firstNumber = operator.getFirstNumber();
        double secondNumber = operator.getSecondNumber();
        double result = firstNumber * secondNumber;

        operator.setResult(result);

        return operatorRepository.save(operator);
    }
}
