package com.coderhouse.Ejercicio_Calculadora.controller;

import com.coderhouse.Ejercicio_Calculadora.model.Operator;
import com.coderhouse.Ejercicio_Calculadora.repository.OperatorRepository;
import com.coderhouse.Ejercicio_Calculadora.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/calculator")
public class OperatorController {

    @Autowired
    private OperatorRepository operatorRepository;

    @Autowired
    private OperatorService operatorService;

    @GetMapping(path = "/operators")
    public List getOperators(){
        return operatorRepository.findAll();
    }

    // Addition, pasando los parametros por el json
    @PostMapping(path = "/operators/addition")
    public Operator postAdditionOperator(@RequestBody Operator operator) throws Exception {
        return operatorService.postAdditionOperator(operator);
    }

    // Subtraction, pasando parametros por el json
    @PostMapping(path = "operators/subtraction")
    public Operator postSubtractionOperator(@RequestBody Operator operator) throws Exception {
        return operatorService.postSubtractionOperator(operator);
    }

    // Division
    @PostMapping(path = "operators/division")
    public Operator postDivisionOperator(@RequestBody Operator operator) throws Exception {
        return operatorService.postDivisionOperator(operator);
    }

    // Multiplication
    @PostMapping(path = "operators/multiplication")
    public Operator postMultiplicationOperator(@RequestBody Operator operator) throws Exception {
        return operatorService.postMultiplicationOperator(operator);
    }

    // Get operation by id
    @GetMapping(path = "/operators/{id}")
    public Operator getOperatorById(@PathVariable int id){
        return operatorRepository.findById(id).orElse(null);
    }

    // Delete operation by id
    @DeleteMapping(path = "/operators/{id}")
    public void deleteOperatorById(@PathVariable int id){
        operatorRepository.deleteById(id);
    }
}
