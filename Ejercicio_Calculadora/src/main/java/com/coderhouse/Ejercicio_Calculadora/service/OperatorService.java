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

    public Operator postAdditionOperator(Operator operator) throws Exception {

        int numero1 = operator.getFirstNumber();
        int numero2 = operator.getSecondNumber();
        int result = numero1 + numero2;

        operator.setResult(result);

        return operatorRepository.save(operator);
    }
}
